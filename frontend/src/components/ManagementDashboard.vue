<!-- 管理员界面 -->

<template>
    <div class="management-dashboard">
      <div class="sidebar">
        <h2>投诉列表</h2>
        <ul>
          <li
            v-for="complaint in complaints"
            :key="complaint.id"
            :class="{ active: selectedComplaint?.id === complaint.id }"
            @click="selectComplaint(complaint)"
          >
            投诉ID: {{ complaint.id }} - 用户ID: {{ complaint.userId }}
          </li>
        </ul>
      </div>
      <div class="details">
        <div v-if="selectedComplaint">
          <h2>投诉详情</h2>
          <p><strong>投诉内容:</strong> {{ selectedComplaint.content }}</p>
          <p><strong>时间:</strong> {{ selectedComplaint.time }}</p>
  
          <h3>文章详情</h3>
          <div v-if="article">
            <p><strong>文章ID:</strong> {{ article.id }}</p>
            <p><strong>标题:</strong> {{ article.title }}</p>
            <p><strong>内容:</strong></p>
            <p>{{ article.content }}</p>
            <button class="danger" @click="deleteArticle">删除文章</button>
          </div>
  
          <h3>用户详情</h3>
          <div v-if="user">
            <p><strong>用户ID:</strong> {{ user.id }}</p>
            <p><strong>用户名:</strong> {{ user.name }}</p>
            <p><strong>邮箱:</strong> {{ user.email }}</p>
            <button class="danger" @click="banUser">封禁用户</button>
          </div>
        </div>
        <div v-else>
          <p>请选择一个投诉以查看详情。</p>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        // 静态投诉列表数据
        complaints: [
          { id: 1, userId: 101, articleId: 201, content: '不当内容', time: '2024-12-01' },
          { id: 2, userId: 102, articleId: 202, content: '侵权内容', time: '2024-12-02' },
          { id: 3, userId: 103, articleId: 203, content: '垃圾广告', time: '2024-12-03' },
        ],
        // 当前选中的投诉
        selectedComplaint: null,
        // 静态文章数据
        articles: {
          201: { id: 201, title: '文章标题1', content: '这是文章1的内容。' },
          202: { id: 202, title: '文章标题2', content: '这是文章2的内容。' },
          203: { id: 203, title: '文章标题3', content: '这是文章3的内容。' },
        },
        // 静态用户数据
        users: {
          101: { id: 101, name: '用户1', email: 'user1@example.com' },
          102: { id: 102, name: '用户2', email: 'user2@example.com' },
          103: { id: 103, name: '用户3', email: 'user3@example.com' },
        },
        // 当前文章和用户
        article: null,
        user: null,
      };
    },
    methods: {
      selectComplaint(complaint) {
        this.selectedComplaint = complaint;
  
        // 从静态数据中加载文章和用户
        this.article = this.articles[complaint.articleId];
        this.user = this.users[complaint.userId];
      },
      deleteArticle() {
        if (confirm('确定删除这篇文章吗？')) {
          alert(`文章 "${this.article.title}" 已删除`);
          this.article = null;
        }
      },
      banUser() {
        if (confirm('确定封禁该用户吗？')) {
          alert(`用户 "${this.user.name}" 已封禁`);
          this.user = null;
        }
      },
    },
  };
  </script>
  
  <style scoped>
  .management-dashboard {
    display: flex;
    height: 100vh;
  }
  .sidebar {
    width: 30%;
    border-right: 1px solid #ddd;
    padding: 20px;
    overflow-y: auto;
  }
  .details {
    flex: 1;
    padding: 20px;
    overflow-y: auto;
  }
  ul {
    list-style: none;
    padding: 0;
  }
  li {
    padding: 10px;
    border-bottom: 1px solid #eee;
    cursor: pointer;
  }
  li.active {
    background-color: #f0f0f0;
  }
  .danger {
    background-color: red;
    color: white;
    border: none;
    padding: 10px 15px;
    margin: 10px 0;
    cursor: pointer;
  }
  </style>
  