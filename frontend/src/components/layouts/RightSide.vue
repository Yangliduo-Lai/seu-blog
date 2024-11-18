<script setup lang="ts">
</script>

<template>
  <div class="right-side">
    <div class="search-bar">
      <el-input v-model="input" style="width: 98%; height: 30px" placeholder="Search..." />
    </div>
    <div class="recent-updates">
      <h3>Recently Updated</h3>
      <ul>
        <li><a href="#ambiguity-in-template-parameters">Ambiguity in template parameters</a></li>
        <li><a href="#concept-template-parameters">Concept template parameters</a></li>
        <li><a href="#declarations-using-concepts">Declarations using Concepts</a></li>
        <li><a href="#things-can-do-with-concepts">Things can do with Concepts</a></li>
      </ul>
    </div>
    <div class="trending-tags">
      <h3>Trending Tags</h3>
      <div class="flex gap-2">
        <el-tag type="primary">Tag 1</el-tag>
        <el-tag type="success">Tag 2</el-tag>
        <el-tag type="info">Tag 3</el-tag>
        <el-tag type="warning">Tag 4</el-tag>
        <el-tag type="danger">Tag 5</el-tag>
      </div>
    </div>
  </div>
</template>

<style scoped>
.right-side {
  width: 20%;
  padding: 20px;
  box-sizing: border-box;
  background: #f9f9f9; /* 轻微灰色背景提升对比 */
  box-shadow: 0 2px 10px rgba(0,0,0,0.1); /* 轻微阴影增加立体感 */
}

.right-side .search-bar {
  padding: 29px 0;
  margin-bottom: 20px; /* 增加与下方内容的间距 */
}

.right-side h3 {
  margin-bottom: 10px; /* 标题下方留出更多空间 */
  color: #333; /* 标题颜色深化 */
  font-size: 16px; /* 增大标题字体大小 */
  text-align: left;
}

.right-side .recent-updates {
  color: gray;
}

.right-side ul {
  padding: 0px 5px;
  margin: 0;
  font-size: 14px;
  text-align: left;
  color: gray;
}

.right-side li {
  padding: 5px 0; /* 为列表项添加垂直填充 */
  border-bottom: 1px solid #ddd; /* 列表项之间添加分隔线 */
}

.right-side li:last-child {
  border-bottom: none; /* 移除最后一项的分隔线 */
}

.trending-tags .tags span {
  background-color: #e0e0e0; /* 标签背景色 */
  color: #333; /* 标签文字颜色 */
  padding: 5px 10px;
  margin-right: 5px; /* 标签间横向间距 */
  border-radius: 5px; /* 标签圆角 */
  display: inline-block;
  cursor: pointer; /* 鼠标悬停手型光标 */
}

.trending-tags .flex.gap-2 {
  display: flex;
  flex-wrap: wrap;
}
</style>