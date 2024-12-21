<template>
    <div>
      <el-card v-for="(comment, index) in comments" :key="index" style="margin-bottom: 10px;">
        <div slot="header" class="clearfix">
          <span>{{ comment.username }}</span>
          <span style="float: right; color: #666;">{{ comment.time }}</span>
        </div>
        <p>{{ comment.content }}</p>
        <!-- 显示子评论数量和 View Replies 按钮 -->
        <div v-if="comment.comments && comment.comments.length > 0" class="reply-actions">
          <el-button @click="toggleReplies(comment)" type="text">{{ comment.showReplies ? 'Hide' : 'View' }} {{ comment.comments.length }} replies</el-button>
        </div>
        <!-- 条件性渲染子评论 -->
        <transition name="fade">
          <div v-if="comment.showReplies" class="replies-container">
            <CommentSection :comments="comment.comments" />
          </div>
        </transition>
        <!-- 追评按钮 -->
        <div class="reply-actions">
          <el-button @click="toggleReplyForm(comment)" type="text">Reply</el-button>
        </div>
        <!-- 条件性渲染追评表单 -->
        <div v-if="comment.showReplyForm" class="reply-form">
          <el-input 
            v-model="comment.replyContent"
            type="textarea" 
            placeholder="Write a reply..." 
            rows="3"
            @keyup.enter="submitReply(comment)"
            style="width: 100%;"
          ></el-input>
          <!-- 新增 div 包裹提交按钮以实现右对齐 -->
          <div class="submit-reply-container">
            <el-button @click="submitReply(comment)" type="primary">Submit Reply</el-button>
          </div>
        </div>
      </el-card>
    </div>
  </template>
  
  <script>
  export default {
    props: ['comments'],
    methods: {
      toggleReplies(comment) {
        // 切换当前评论的 showReplies 属性
        if (comment.showReplies === undefined) {
          comment.showReplies = true;
        } else {
          comment.showReplies = !comment.showReplies;
        }
      },
      toggleReplyForm(comment) {
        // 切换当前评论的 showReplyForm 属性
        if (comment.showReplyForm === undefined) {
          comment.showReplyForm = true;
        } else {
          comment.showReplyForm = !comment.showReplyForm;
        }
      },
      submitReply(comment) {
        if (!comment.replyContent.trim()) {
          alert('Please enter a reply.');
          return;
        }
  
        const currentTime = new Date().toISOString().split('T')[0];
  
        // 添加新回复到当前评论的子评论列表中
        if (!comment.comments) {
          comment.comments = [];
        }
        comment.comments.push({
          username: 'Guest', // 这里可以根据实际情况设置用户名
          time: currentTime,
          content: comment.replyContent,
          showReplyForm: false, // 初始化为空，用于子评论表单
          replyContent: '', // 初始化为空，用于子评论表单
          comments: [], // 初始化空数组，用于存储子评论
          showReplies: false // 子评论默认是隐藏的
        });
  
        // 清空输入框并隐藏表单
        comment.replyContent = '';
        comment.showReplyForm = false;
  
        // 提示用户成功提交
        alert('Your reply has been submitted!');
      }
    }
  };
  </script>
  
  <style scoped>
  .reply-actions {
    padding: 5px;
    text-align: right;
  }
  
  .reply-form {
    padding: 10px;
    border-top: 1px solid #ddd;
    width: 100%; /* 设置为100%以匹配父容器 */
  }
  
  .replies-container {
    margin-top: 10px;
    padding: 8px; /* 减少内边距 */
    background-color: #f9fafc;
    border-radius: 4px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  }
  
  /* 新增：用于限制子评论内容的高度 */
  .replies-container .el-card {
    margin-bottom: 8px; /* 减少评论之间的间距 */
  }
  
  .replies-container .el-card__body {
    padding: 8px; /* 减少子评论内容的内边距 */
  }
  
  .replies-container p {
    font-size: 14px; /* 减小字体大小 */
    line-height: 1.4; /* 减小行高 */
  }
  
  .el-card__body {
    padding: 10px; /* 调整内边距 */
  }
  
  .el-card__header {
    padding: 5px 10px; /* 调整内边距 */
  }
  
  /* 简单的淡入淡出效果 */
  .fade-enter-active, .fade-leave-active {
    transition: opacity 0.5s;
  }
  .fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
    opacity: 0;
  }
  
  /* 新增样式：使提交按钮右对齐 */
  .submit-reply-container {
    text-align: right; /* 将内容右对齐 */
    margin-top: 10px; /* 根据需要调整顶部间距 */
  }
  </style>