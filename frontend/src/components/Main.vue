<template>
  <div class="blog-content">
    <el-card
        v-for="post in posts"
        :key="post.id"
        class="post-card"
        :body-style="{ padding: '20px' }"
    >
      <h2>{{ post.title }}</h2>
      <p>{{ post.excerpt }}</p>
      <el-button type="text" :to="post.link">Read More</el-button>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { ref } from "vue";
import { ElMessage } from "element-plus";

defineProps<{ msg: string }>();

const count = ref(0);
const input = ref("element-plus");

const curDate = ref("");

const toast = () => {
  ElMessage.success("Hello");
};

const value1 = ref(true);

// 模拟博客文章数据
const posts = ref([
  { id: 1, title: "Ambiguity in template parameters", excerpt: "C++ has had three kinds of template parameters since basically always: type template parameters (the vast majority), non-type template parameters (sometimes called value template parameters...)", link: "#" },
  { id: 2, title: "Concept template parameters", excerpt: "I thought I’d put a post together with some examples, as a way to work towards motivation for a language change.", link: "#" },
  { id: 3, title: "Declarations using Concepts", excerpt: "One of my all-time favorite C++ talks is Ben Deane's 'Using Types Effectively' from CppCon 2016. I like it for a lot of reasons, but for the purposes of this post - I really like the game Ben plays (starting at...", link: "#" },
  { id: 4, title: "Things can do with Concepts", excerpt: "You probably see where I’m going with this. All of these concepts are the same - or least they could be the same if we could factor out what constraint we’re performing on the value type of the...", link: "#" }
]);
</script>

<style>
/* blog */
.blog-content {
  height: calc(100vh - 68px); /* 减去顶部导航栏或任何固定高度的区域 */
  overflow-y: auto; /* 启用垂直滚动条 */
  padding: 0 20px; /* 左右内边距，更好地利用空间 */
}

.post-card {
  margin-bottom: 20px; /* 每篇文章下方留出空间 */
  border: 1px solid #e0e0e0; /* 更细微的边框颜色 */
  transition: box-shadow .3s, transform .3s; /* 添加阴影和轻微放大的动画效果 */
  cursor: pointer; /* 增加指针，提示可交互 */
  background-color: #fff; /* 设置背景色提高读取舒适度 */
}

.post-card:hover {
  box-shadow: 0 4px 20px rgba(0,0,0,.1); /* 鼠标悬停时的阴影效果更显著 */
  transform: translateY(-2px); /* 轻微上移，增加动态效果 */
}

h2, p {
  margin-left: 20px; /* 增加左侧内边距，与卡片边缘有更好的间距 */
}

h2 {
  margin-top: 0; /* 减少标题上方的边距 */
  color: #333; /* 文章标题的颜色 */
}

p {
  color: #666; /* 文章摘要的颜色，略淡以区分标题 */
  font-size: 14px; /* 设置合适的字体大小提高可读性 */
}

.el-button {
  margin-left: 20px; /* 统一左侧边距 */
  color: #4A90E2; /* 按钮颜色与主题保持一致 */
}

.el-button:hover {
  color: #2a6fbd; /* 悬停时按钮颜色加深 */
}

</style>
