<template>
  <div class="blog-editor-container">
    <h2>Create New Blog</h2>
    <form @submit.prevent="submitBlog">
      <!-- 现有的表单元素 -->
      <div class="form-group">
        <label for="title">Title:</label>
        <input type="text" id="title" v-model="title" placeholder="Enter blog title" required />
      </div>
      <div class="form-group">
        <label for="concepts">Concepts:</label>
        <quill-editor ref="myQuillEditorConcepts" v-model:content="concepts" content-type="html"></quill-editor>
      </div>
      <div class="form-group">
        <label for="content">Content:</label>
        <quill-editor ref="myQuillEditor" v-model:content="content" content-type="html"></quill-editor>
      </div>
      <div class="form-group">
        <label for="status">Status:</label>
        <select id="status" v-model="status" required>
          <option value="published">Published</option>
          <option value="draft">Draft</option>
        </select>
      </div>

      <!-- 新增的标签选择器和创建新标签的输入框 -->
      <div class="form-group">
        <label>Select Tag or Create New:</label>
        <div class="tag-selection">
          <select id="tags" v-model="selectedTagId" required>
            <option value="" disabled>Select a tag</option>
            <option v-for="tag in tags" :key="tag.tagId" :value="tag.tagId">{{ tag.tagName }}</option>
          </select>
          <div class="add-tag-form">
            <input type="text" v-model="newTagName" placeholder="Enter new tag name" />
            <button @click.stop="createNewTag" :disabled="!newTagName.trim()">Add Tag</button>
          </div>
        </div>
      </div>

      <button type="submit">Submit Blog</button>
    </form>
  </div>
</template>

<script>
import { QuillEditor } from '@vueup/vue-quill';
import '@vueup/vue-quill/dist/vue-quill.snow.css';
import axiosInstance from '~/utils/axiosInstance';

export default {
  components: {
    QuillEditor
  },
  data() {
    return {
      title: '',
      concepts: '', // 添加了摘要字段
      content: '',
      status: 'draft', // 默认设置为草稿
      tags: [], // 存储从接口获取到的所有标签
      selectedTagId: '', // 用户选择的标签ID
      newTagName: '' // 用户输入的新标签名称
    };
  },
  async created() {
    try {
      const response = await axiosInstance.get('tag/list');
      const result = response.data;
      if (result.code === 0) { // 假设0表示成功
        this.tags = result.data.map(item => ({
          tagId: item.tagId,
          tagName: item.tagName
        }));
      } else {
        console.error('Failed to load tags:', result.message);
        alert('Failed to load tags: ' + result.message);
      }
    } catch (error) {
      console.error('Failed to fetch tags:', error);
      alert('Failed to fetch tags: ' + error.toString());
    }
  },
  methods: {
    stripOuterPTags(content) {
      if (typeof content !== 'string') return content;
      return content.replace(/^<p>(.*)<\/p>$/s, '$1');
    },

    submitBlog() {
    if (!this.title.trim() || !this.content.trim()) {
      alert('Please fill in all fields.');
      return;
    }

    if (!this.selectedTagId) {
      alert('Please select a tag.');
      return;
    }

    // 处理内容和摘要中的最外层 <p> 标签
    let processedContent = this.stripOuterPTags(this.content);
    let processedConcepts = this.stripOuterPTags(this.concepts);

    const blogData = {
      title: this.title,
      concepts: processedConcepts,
      content: processedContent,
      status: this.status,
      tagId: this.selectedTagId
    };

    axiosInstance.post('blog/save', blogData)
      .then(response => {
        console.log('Blog saved successfully:', response.data);
        alert('Blog saved successfully!');
        this.title = '';
        this.concepts = '';
        this.content = '';
        this.status = 'draft';
        this.selectedTagId = '';
      })
      .catch(error => {
        console.error('Error saving blog:', error);
        alert('An error occurred while saving the blog.');
      });
  },

    async createNewTag() {
      try {
        const response = await axiosInstance.post('tag/add', { tagName: this.newTagName });
        const result = response.data;
        if (result.code === 0) { // 假设0表示成功
          let newTagItem;
          if (result.data) {
            newTagItem = {
              tagId: result.data.tagId,
              tagName: result.data.tagName
            };
          } else {
            const lastTagId = this.tags.length > 0 ? Math.max(...this.tags.map(tag => tag.tagId)) : 0;
            newTagItem = {
              tagId: lastTagId + 1,
              tagName: this.newTagName
            };
          }
          this.tags.push(newTagItem);
          this.newTagName = '';
          alert('Tag added successfully!');
        } else {
          console.error('Failed to add tag:', result.message);
          alert('Failed to add tag: ' + result.message);
        }
      } catch (error) {
        console.error('Failed to add tag:', error);
        alert('Failed to add tag: ' + error.toString());
      }
    }
  }
};
</script>

<style scoped>
/* 样式部分 */
.blog-editor-container {
  max-width: 800px;
  margin: 40px auto;
  padding: 30px;
  background: #fff;
  box-shadow: 0 4px 10px rgba(0,0,0,0.1);
  border-radius: 8px;
  display: flex;
  flex-direction: column;
}

h2 {
  text-align: center;
  margin-bottom: 20px;
}

.form-group {
  margin-bottom: 20px;
}

.form-group label {
  display: block;
  font-size: 18px;
  color: #333;
  margin-bottom: 10px;
}

.form-group input[type="text"],
.form-group select {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  outline: none;
  transition: border-color 0.3s;
}

.form-group input[type="text"]:focus,
.form-group select:focus {
  border-color: #2a6fbd;
}

.quill-editor {
  min-height: 600px;
  border: 1px solid #ccc;
  border-radius: 4px;
  overflow-y: auto;
}

button {
  display: block;
  margin-left: auto;
  padding: 12px 24px;
  border: none;
  background-color: #2a6fbd;
  color: white;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s;
}

button:hover {
  background-color: #235c91;
}

/* 新增标签选择器和创建新标签的输入框样式 */
.tag-selection {
  display: flex;
  align-items: center;
}

.add-tag-form {
  display: flex;
  align-items: center;
  margin-left: 10px;
}

.add-tag-form input {
  padding: 8px 12px;
  width: 150px; /* Adjusted width */
  border: 1px solid #ccc;
  border-radius: 4px 0 0 4px; /* Rounded only on the left side */
  outline: none;
  height: 20px;
  transition: border-color 0.3s;
}

.add-tag-form input:focus {
  border-color: #2a6fbd;
}

.add-tag-form button {
  margin-left: 8px;
  padding: 8px 10px;
  border: none;
  background-color: #2a6fbd;
  color: white;
  border-radius: 0 4px 4px 0; /* Rounded only on the right side */
  cursor: pointer;
  transition: background-color 0.3s;
}

.add-tag-form button:hover {
  background-color: #235c91;
}

.add-tag-form button:disabled {
  background-color: #ccc;
  cursor: not-allowed;
}
</style>