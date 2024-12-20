<template>
  <div class="blog-editor-container">
    <h2>Create New Blog</h2>
    <form @submit.prevent="submitBlog">
      <div class="form-group">
        <label for="title">Title:</label>
        <input type="text" id="title" v-model="title" placeholder="Enter blog title" required />
      </div>
      <div class="form-group">
        <label for="content">Content:</label>
        <quill-editor ref="myQuillEditor" v-model:content="content" content-type="html"></quill-editor>
      </div>
      <!-- 添加状态选择 -->
      <div class="form-group">
        <label for="status">Status:</label>
        <select id="status" v-model="status" required>
          <option value="published">Published</option>
          <option value="draft">Draft</option>
        </select>
      </div>
      <button type="submit">Submit Blog</button>
    </form>
  </div>
</template>
  
<script>
import { QuillEditor } from '@vueup/vue-quill';
import '@vueup/vue-quill/dist/vue-quill.snow.css';

export default {
  components: {
    QuillEditor
  },
  data() {
    return {
      title: '',
      content: '',
      status: 'draft' // 默认设置为草稿
    };
  },
  methods: {
    submitBlog() {
      if (!this.title.trim() || !this.content.trim()) {
        alert('Please fill in all fields.');
        return;
      }

      // 模拟提交操作，打印出收集到的数据
      const blogData = {
        title: this.title,
        content: this.content,
        status: this.status // 包含状态
      };

      console.log('Blog Data to be submitted:', blogData);

      // 清空表单
      this.title = '';
      this.content = '';
      this.status = 'draft'; // 重置状态为默认值

      alert('Blog data collected successfully!');
    }
  }
};
</script>
  
<style scoped>
.blog-editor-container {
  max-width: 800px;
  margin: 40px auto;
  padding: 30px;
  background: #fff;
  box-shadow: 0 4px 10px rgba(0,0,0,0.1);
  border-radius: 8px;
  display: flex;
  flex-direction: column;
  height: calc(100vh - 160px); /* Adjust to fit your layout */
}

/* Add this class to center the h2 element */
h2 {
  text-align: center; /* Center the text horizontally */
  margin-bottom: 20px; /* Space between title and form */
}

.form-group {
  margin-bottom: 20px;
  flex: 0 0 auto; /* Ensure form groups do not stretch */
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
  flex: 1 1 auto; /* Allow the editor to expand */
  min-height: 600px; /* Increase the minimum height */
  border: 1px solid #ccc;
  border-radius: 4px;
  overflow-y: auto; /* Ensure content is scrollable */
}

button {
  display: block; /* 将按钮设为块级元素 */
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
</style>