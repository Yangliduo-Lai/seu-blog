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
      <h2 class="post-section-title">Contents</h2>
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
      <!-- 新增的全局评论表单，现在放在了评论显示的上方 -->
      <div class="comment-form">
        <el-tabs type="border-card">
          <el-tab-pane label="Write">
            <el-input 
              v-model="newCommentContent"
              type="textarea" 
              placeholder="Sign in to comment" 
              rows="4"
            ></el-input>
          </el-tab-pane>
          <el-tab-pane label="Preview">
            <p v-if="newCommentContent">{{ newCommentContent }}</p>
            <p v-else>No content to preview.</p>
          </el-tab-pane>
        </el-tabs>
        <div class="comment-actions">
          <el-button @click="submitNewComment" type="primary">Submit Comment</el-button>
        </div>
      </div>
      <h3>{{ post.comments.length }} comments</h3>
      <CommentSection :comments="post.comments" />
    </div>
  </div>
</template>

<script>
import CommentSection from './subpages/CommentSection.vue';
export default {
  name: 'Blog',
  components: {
    CommentSection
  },
  data() {
    return {
      post: {
        title: '解决C++模板参数中的二义性问题',
        postedDate: '2024/10/10',
        updatedDate: '2024/11/15',
        author: 'FeignClaims',
        concepts: '在C++中，模板是一种强大的工具，它允许我们编写泛型代码。然而，当我们尝试定义多个模板函数或类时，可能会遇到二义性问题。本文将探讨如何通过使用SFINAE（替换失败不是错误）和其他技术来解决这些问题。',
        content: '模板参数二义性问题是C++程序员在设计复杂模板系统时常常遇到的问题之一。本文将详细介绍几种方法，包括但不限于使用`enable_if`、`void_t`以及C++20引入的概念（concepts），来有效地处理和避免二义性。同时，还将讨论实际案例，并给出完整的代码示例帮助理解这些解决方案的应用场景。',
        tags: ['cpp', 'semantics', 'template', 'SFINAE', 'C++20'],
        reactions: 42,
        comments: [
          {
            username: 'CodeLover',
            time: '2024/10/12',
            content: '非常感谢这篇文章！之前对模板参数二义性一直不太明白，现在终于搞清楚了。期待更多这样的深度解析！',
            comments: [
              {
                username: 'Guest',
                time: '2024/10/13',
                content: '我也觉得这篇文章很好，学到了很多新东西！'
              },
              {
                username: 'AnotherGuest',
                time: '2024/10/14',
                content: '同感，文章非常详细，解决了我的疑问。'
              }
            ]
          },
          {
            username: 'TemplateFan',
            time: '2024/10/14',
            content: '文章非常详细，尤其是提供的代码例子特别有帮助。强烈推荐给所有学习C++的同学！',
            comments: [
              {
                username: 'Student',
                time: '2024/10/15',
                content: '我是一个学生，确实感觉这篇文章对我的学习很有帮助。'
              }
            ]
          },
          {
            username: 'CPPNewbie',
            time: '2024/10/16',
            content: '初学者一枚，看完之后感觉对模板的理解又深了一层。继续加油！'
          },
          {
            username: 'TechGeek',
            time: '2024/10/18',
            content: '文章不仅解决了我的疑问，还启发了我对未来项目的思考。真是受益匪浅！'
          },
          {
            username: 'SeniorDev',
            time: '2024/10/20',
            content: '对于有一定经验的开发者来说，这篇文章提供了很多实用的技术细节。值得反复阅读和实践。',
            comments: [
              {
                username: 'JuniorDev',
                time: '2024/10/21',
                content: '作为初级开发者，我觉得这篇文章为我指明了前进的方向。'
              }
            ]
          }
        ]
      },
      newCommentContent: '' // 全局评论输入框绑定的数据属性
    };
  },
  methods: {
    submitNewComment() {
      if (!this.newCommentContent.trim()) {
        alert('Please enter a comment.');
        return;
      }

      const currentTime = new Date().toISOString().split('T')[0];

      this.post.comments.push({
        username: 'Guest', // 这里可以根据实际情况设置用户名
        time: currentTime,
        content: this.newCommentContent,
        replyContent: '', // 初始化为空，用于子评论表单
        comments: [] // 初始化空数组，用于存储子评论
      });

      this.newCommentContent = ''; // 清空输入框
      alert('Your comment has been submitted!');
    }
  }
};
</script>

<style scoped>
/* 样式部分 */
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
  color: #333; /* 更深的颜色强调标题 */
}

.post-content p {
  line-height: 1.7; /* 增加行高，使文本更易读 */
  font-size: 16px; /* 稍大的字体 */
  color: #444; /* 更柔和的文字颜色 */
  margin-bottom: 20px; /* 段落间的间距 */
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

.post-license,
.post-share {
  font-size: 12px;
  color: #666;
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