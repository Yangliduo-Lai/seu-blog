<template>
  <el-menu
    default-active="1"
    class="el-sidebar"
    :collapse="isCollapse"
    @open="handleOpen"
    @close="handleClose"
  >
    <!-- 个人资料 -->
    <div class="menu-profile">
      <!-- 头像 -->
      <el-avatar src="" size="large">U</el-avatar>
      <!-- 用户名 -->
      <el-text class="user-name" size="large" tag="b">C++ Blog</el-text>
      <!-- 个性签名 -->
      <el-text class="tagline" size="small">Just a blog about C++</el-text>
    </div>

    <div class="menu">
      <!-- Menu图标 -->
      <el-menu-item index="1">
       <el-icon><house /></el-icon>
       <RouterLink to="/home">HOME</RouterLink>
      </el-menu-item>

      <!--分类-->
      <el-menu-item index="2">
        <el-icon><MessageBox /></el-icon>
        <RouterLink to="/categories">CATEGORIES</RouterLink>
      </el-menu-item>

      <!-- tags -->
      <el-menu-item index="3">
        <el-icon><PriceTag /></el-icon>
        <RouterLink to="/tags">TAGS</RouterLink>
      </el-menu-item>

      <!-- archives -->
      <el-menu-item index="4">
        <el-icon><TakeawayBox /></el-icon>
        <RouterLink to="/archives">ARCHIVES</RouterLink>
      </el-menu-item>

      <!-- about -->
      <el-menu-item index="5">
        <el-icon><More /></el-icon>
        <RouterLink to="/about">ABOUT</RouterLink>
      </el-menu-item>

      <!-- 最下面的三个图标 -->
      <div class="menu-icons">
        <div class="github">
          <el-icon :size="25"><Stopwatch /></el-icon>
        </div>
        <div class="email">
          <el-icon :size="25"><Message /></el-icon>
        </div>
        <div class="wifi">
          <el-icon :size="25"><Eleme /></el-icon>
        </div>
      </div>

    </div>
  </el-menu>
</template>

<script lang="ts" setup>
import { ref } from "vue";
import { RouterLink } from 'vue-router'
import {
  Location,
  Document,
  Menu as IconMenu,
  Setting,
} from "@element-plus/icons-vue";

const isCollapse = ref(true);
const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath);
};
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath);
};
</script>

<style>
.el-sidebar {
  width: 20%;
  height: 100vh;
  overflow: auto;
  position: fixed;
  left: 0;
  top: 0;
}

/* 个人资料 */
.menu-profile {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 20px;
  border-bottom: 1px solid #efefef;
}

.menu-profile .user-name,
.menu-profile .tagline {
  padding: 10px 0;
}

.menu-profile .user-name {
  font-weight: bold;
  font-size: 20px;
  color: #333;
}

.menu-profile .tagline {
  font-size: 14px;
  color: #666
}

/* 菜单 */
.el-sidebar .menu {
  padding: 20px 0;
}

.el-sidebar .menu-icons{
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  width: 20%;
  position: fixed;
  bottom: 0;
  padding: 10px 0px;
  background-color: #f9f9f9;
}

.el-sidebar .menu-icons div {
  cursor: pointer;
}

.el-sidebar a {
  text-decoration: none;
  color: #333;
}

/* 修正图标大小和边距 */
.el-sidebar .menu-icons .github,
.el-sidebar .menu-icons .email,
.el-sidebar .menu-icons .wifi {
  flex: 1;
  text-align: center; /* 图标居中显示 */
}
</style>