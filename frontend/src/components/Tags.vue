<template>
    <div class="tags-container">
      <h2>Tags</h2>
      <div class="tags">
        <span class="tag" v-for="tag in tags" :key="tag.id">
          {{ tag.name }}
        </span>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        tags: [
          { id: 1, name: 'cpp' },
          { id: 2, name: 'template' },
          { id: 3, name: 'concept' }
        ]
      };
    }
  }
  </script>
  
  <style scoped>
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
  