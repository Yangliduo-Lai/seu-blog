<template>
  <div class="tags-container">
    <h2>Tags</h2>
    <div class="tags">
      <span v-if="tags.length" class="tag" v-for="tag in tags" :key="tag.tagId">
        {{ tag.tagName }}
      </span>
      <p v-else>No tags available.</p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tags: []
    };
  },
  async created() {
    try {
      const response = await fetch('http://127.0.0.1:4523/m1/5596245-5274544-default/blog/list');
      const result = await response.json();
      if (result.code === 0) { // 假设0表示成功
        this.tags = result.data.map(item => ({
          tagId: item.tagId,
          tagName: item.tagName
        }));
        console.log('Loaded tags:', this.tags); // Debugging line
      } else {
        console.error('Failed to load tags:', result.message);
      }
    } catch (error) {
      console.error('Failed to fetch tags:', error);
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

h2 {
  font-size: 24px;
  color: #333;
  padding-bottom: 5px;
  margin-bottom: 20px;
  border-bottom: 2px solid #ddd;
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
</style>