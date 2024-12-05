<template>
    <div class="archives-container">
      <h1>Archives</h1>
      <ul class="timeline">
        <li v-for="item in archiveItems" :key="item.id">
          <time>{{ item.date }}</time>
          <a :href="item.link">{{ item.title }}</a>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        archiveItems: [
          { id: 1, title: 'Ambiguity in template parameters', date: '2024-10-10', link: '#' },
          { id: 2, title: 'Concept template parameters', date: '2024-10-08', link: '#' },
          { id: 3, title: 'Declarations using Concepts', date: '2024-10-07', link: '#' },
          { id: 4, title: 'Things can do with Concepts', date: '2024-10-06', link: '#' }
        ]
      };
    }
  }
  </script>
  
  <style scoped>
  .archives-container {
    margin: 20px;
    padding: 20px;
  }
  
  .timeline {
    list-style: none;
    position: relative;
    padding-left: 20px;
  }
  
  .timeline::before {
    content: '';
    position: absolute;
    left: 0;
    top: 0;
    bottom: 0;
    width: 2px;
    background: #ccc;
  }
  
  li {
    margin-bottom: 10px;
    padding-left: 20px;
  }
  
  time {
    display: block;
    font-size: 12px;
    color: #666;
  }
  
  a {
    color: #4A90E2;
    text-decoration: none;
    font-size: 16px;
  }
  
  a:hover {
    text-decoration: underline;
  }
  </style>
  