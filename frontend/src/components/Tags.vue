<template>
  <div class="tags-container">
    <div class="header">
      <h2>Tags</h2>
      <div class="add-tag-form">
        <input type="text" v-model="newTag" placeholder="Enter new tag name" />
        <button @click="addTag">Add Tag</button>
      </div>
    </div>
    <div class="tags">
      <span v-if="tags.length" class="tag" v-for="tag in tags" :key="tag.tagId">
        {{ tag.tagName }}
      </span>
      <p v-else>No tags available.</p>
    </div>
  </div>
</template>

<script>
import axiosInstance from '~/utils/axiosInstance';
import { useUserStore } from "~/stores/user";

export default {
  data() {
    return {
      tags: [],
      newTag: ''
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
    async addTag() {
      if (!this.newTag.trim()) {
        alert('Please enter a valid tag name.');
        return;
      }

      try {
        const response = await axiosInstance.post('tag/add', { tagName: this.newTag });
        const result = response.data;
        if (result.code === 0) { // 假设0表示成功
          // 如果 data 为 null，我们手动创建一个新的 tag 对象
          let newTagItem;
          if (result.data) {
            newTagItem = {
              tagId: result.data.tagId,
              tagName: result.data.tagName
            };
          } else {
            // 手动分配一个临时的 tagId，这里假设最后一个 tagId 加 1
            const lastTagId = this.tags.length > 0 ? Math.max(...this.tags.map(tag => tag.tagId)) : 0;
            newTagItem = {
              tagId: lastTagId + 1,
              tagName: this.newTag
            };
          }
          this.tags.push(newTagItem);
          this.newTag = '';
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
/* 样式部分保持不变 */
.tags-container {
  margin: 20px;
  padding: 0 20px 20px 20px;
  background: #fff;
  box-shadow: 0 4px 10px rgba(0,0,0,0.1);
}

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

h2 {
  font-size: 24px;
  color: #333;
  margin-bottom: 20px;
  border-bottom: 2px solid #ddd;
  padding-bottom: 5px;
}

.tags {
  display: flex;
  flex-wrap: wrap;
  gap: 10px;
  list-style-type: none;
}

.tag {
  padding: 5px 10px;
  background-color: #f0f0f0;
  border-radius: 20px;
  border: 1px solid #e0e0e0;
  font-size: 14px;
  color: #333;
  transition: background-color 0.3s, color 0.3s;
}

.tag:hover {
  background-color: #e0e0e0;
  color: #2a6fbd;
}

.add-tag-form {
  display: flex;
  align-items: center;
}

.add-tag-form input {
  padding: 8px 12px;
  width: 200px;
  border: 1px solid #ccc;
  border-radius: 4px;
  outline: none;
  transition: border-color 0.3s;
}

.add-tag-form input:focus {
  border-color: #2a6fbd;
}

.add-tag-form button {
  padding: 8px 16px;
  border: none;
  background-color: #2a6fbd;
  color: white;
  border-radius: 4px;
  cursor: pointer;
  margin-left: 10px;
  transition: background-color 0.3s;
}

.add-tag-form button:hover {
  background-color: #235c91;
}
</style>



