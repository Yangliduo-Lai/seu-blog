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

<template>
  <!-- 面包屑 -->
  <div class="el-breadcrumb">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">home</el-breadcrumb-item>
      <el-breadcrumb-item>temp</el-breadcrumb-item>
    </el-breadcrumb>
  </div>

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

<style>

/* 面包屑 */
.el-breadcrumb {
  margin-left: 20px;
}

/* blog */
.blog-content {
  height: calc(100vh - 100px); /* 减去头部和一些可能的边距 */
  overflow-y: auto; /* 启用垂直滚动条 */
  margin: 20px;
  padding-right: 15px; /* 为滚动条留出空间 */
}

.post-card {
  margin-bottom: 20px; /* 每篇文章下方留出空间 */
  border: 1px solid #ccc; /* 文章边框 */
  transition: box-shadow .3s; /* 添加动画效果 */
}

.post-card:hover {
  box-shadow: 0 2px 12px rgba(0,0,0,.1); /* 鼠标悬停时的阴影效果 */
}

</style>
