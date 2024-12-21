<template>
  <div class="blog-content">
    <el-card
        v-for="post in posts"
        :key="post.blogId"
        class="post-card"
        :body-style="{ padding: '20px' }"
    >
      <h2>{{ post.title }}</h2>
      <p>{{ post.concepts }}...</p>
      <el-button type="text" @click="goToBlog(post.blogId)">Read More</el-button>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { ElMessage } from "element-plus";
import { useRouter } from 'vue-router';
import axios from 'axios';
import axiosInstance from '~/utils/axiosInstance';
interface BlogPost {
  blogId: number;
  title: string;
  concepts:string;
  content: string;
  authorId: number;
  views: number;
  status: string;
  createdTime: string;
  updatedTime: string;
  tagId: number;
}

const router = useRouter();
const goToBlog = () => {
  router.push('/blog');
}
// const goToBlog = (id: number) => {
//   router.push(`/blog/${id}`);
// };

defineProps<{ msg: string }>();

const count = ref(0);
const input = ref("element-plus");

const curDate = ref("");

const toast = () => {
  ElMessage.success("Hello");
};

const value1 = ref(true);

const posts = ref<BlogPost[]>([]);

const fetchBlogPosts = async () => {
  try {
    const response = await axiosInstance.get<{ code: number; message: string; data: { total: number; items: BlogPost[] } }>('blog/page', {
      params: {
        pageNum: 1,
        pageSize: 999
      }
    });
    // 假设API返回的数据结构如你所描述
    if (response.data.code === 0 && response.data.data.items) {
      posts.value = response.data.data.items;
    }
  } catch (error) {
    console.error('Error fetching blog posts:', error);
  }
};

onMounted(() => {
  fetchBlogPosts();
});
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



