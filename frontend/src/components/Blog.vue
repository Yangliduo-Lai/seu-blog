<template>
    <div class="blog-post">
      <div class="post-header">
        <h1 class="post-title">{{ post.title }}</h1>
        <div class="post-meta">
          <span>Posted {{ post.postedDate }} • Updated {{ post.updatedDate }}</span>
          <span>By {{ post.author }}</span>
          <span class="read-time">1 min read</span>
        </div>
      </div>
      <div class="post-content">
        <h2 class="post-section-title">Concepts</h2>
        <p>{{ post.concepts }}</p>
        <h2 class="post-section-title">Putting it all together</h2>
        <p>{{ post.content }}</p>
      </div>
      <div class="post-tags">
        <el-tag v-for="tag in post.tags" :key="tag" type="info">{{ tag }}</el-tag>
      </div>
      <div class="post-footer">
        <div class="post-license">
          This post is licensed under CC BY 4.0 by the author.
        </div>
        <div class="post-share">
          Share:
          <i class="el-icon-share"></i>
        </div>
      </div>
      <div class="further-reading">
        <h3>Further Reading</h3>
        <el-row :gutter="20">
          <el-col :span="8" v-for="reading in post.furtherReading" :key="reading.title">
            <el-card :body-style="{ padding: '20px' }">
              <div slot="header" class="clearfix">
                <span>{{ reading.date }}</span>
              </div>
              <h4>{{ reading.title }}</h4>
              <p>{{ reading.description }}</p>
            </el-card>
          </el-col>
        </el-row>
      </div>
      <div class="post-reactions">
        <el-row :gutter="20">
          <el-col :span="24">
            <div class="reactions">
              <i class="el-icon-star-on"></i>
              <span>42 reactions</span>
            </div>
          </el-col>
        </el-row>
      </div>
      <div class="comments">
        <h3>0 comments</h3>
        <p>powered by Giscus</p>
        <el-card>
          <div class="comment-form">
            <el-tabs type="border-card">
              <el-tab-pane label="Write">
                <el-input type="textarea" placeholder="Sign in to comment"></el-input>
              </el-tab-pane>
              <el-tab-pane label="Preview">
                <el-input type="textarea" placeholder="Preview"></el-input>
              </el-tab-pane>
            </el-tabs>
            <div class="comment-actions">
              <el-button type="primary">Sign in with GitHub</el-button>
            </div>
          </div>
        </el-card>
      </div>
    </div>
  </template>
  
  <script>

  
  export default {
    name: 'Blog',
    data() {
      return {
        post: {
          title: 'Ambiguity in template parameters',
          postedDate: '2024/10/10',
          updatedDate: '2024/10/10',
          author: 'FeignClaims',
          concepts: 'content...',
          content: 'content...',
          tags: ['cpp', 'semantics', 'template'],
          furtherReading: [
            {
              date: '2024/09/08',
              title: 'Concept template para...',
              description: 'I thought I’d put a post together with some examples, as a way to'
            },
            {
              date: '2024/09/07',
              title: 'Declarations using Con...',
              description: 'One of my all-time favorite C++ talks is Ben Deane’s Using Types'
            },
            {
              date: '2024/09/06',
              title: 'Things can do with Con...',
              description: 'You probably see where I’m going with this. All of these concepts are'
            }
          ]
        }
      };
    },
    created() {
      // 组件创建时的初始化逻辑
    },
    methods: {
      // 定义方法
    }
  };
  </script>
  
  <style scoped>
  /* 样式部分保持不变 */
  .blog-post {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
  }
  
  .post-header {
    margin-bottom: 20px;
  }
  
  .post-title {
    font-size: 24px;
    margin-bottom: 10px;
  }
  
  .post-meta {
    font-size: 12px;
    color: #666;
  }
  
  .read-time {
    float: right;
  }
  
  .post-content {
    margin-bottom: 20px;
  }
  
  .post-section-title {
    font-size: 18px;
    margin-bottom: 10px;
  }
  
  .post-tags {
    margin-bottom: 20px;
  }
  
  .post-footer {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
  }
  
  .post-license {
    font-size: 12px;
    color: #666;
  }
  
  .post-share {
    font-size: 12px;
    color: #666;
  }
  
  .further-reading {
    margin-bottom: 20px;
  }
  
  .reactions {
    display: flex;
    align-items: center;
  }
  
  .comments {
    margin-bottom: 20px;
  }
  
  .comment-form {
    padding: 20px;
  }
  
  .comment-actions {
    text-align: right;
  }
  </style>