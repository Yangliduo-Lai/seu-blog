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
      <el-sub-menu index="1">
        <template #title>
          <el-icon><house /></el-icon>
          <h4>HOME</h4>
        </template>
        <el-menu-item-group>
          <template #title><span>Test</span></template>
          <el-menu-item index="1-1">item one</el-menu-item>
          <el-menu-item index="1-2">item two</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="Group Two">
          <el-menu-item index="1-3">item three</el-menu-item>
        </el-menu-item-group>
        <el-sub-menu index="1-4">
          <template #title><span>item four</span></template>
          <el-menu-item index="1-4-1">item one</el-menu-item>
        </el-sub-menu>
      </el-sub-menu>

      <!--分类-->
      <el-menu-item index="2">
        <el-icon><MessageBox /></el-icon>
        <h4>CATEGORIES</h4>
      </el-menu-item>

      <!-- tags -->
      <el-menu-item index="3">
        <el-icon><PriceTag /></el-icon>
        <h4>TAGS</h4>
      </el-menu-item>

      <!-- archives -->
      <el-menu-item index="4">
        <el-icon><TakeawayBox /></el-icon>
        <h4>ARCHIVES</h4>
      </el-menu-item>

      <!-- about -->
      <el-menu-item index="5">
        <el-icon><More /></el-icon>
        <h4>ABOUT</h4>
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
}

/* 菜单 */
.el-sidebar .menu {
}
.el-sidebar .menu-icons{
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  width: 100%;
  bottom: 0;
  position: absolute;
  left: 0;
  padding: 10px 0px;
  background-color: white;
}
.el-sidebar .menu-icons .github {
  margin-right: 20px;
}
.el-sidebar .menu-icons .email {
  margin-right: 20px;
}

/* 个人资料 */
.menu-profile {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 20px;
}
.menu-profile .user-name {
  padding: 10px;
}

/* 图标和文本的一般样式调整 */
.icon-home span {
  vertical-align: middle; /* 对齐文本 */
}

/* 用户名样式，确认已经足够突出 */
.menu-profile .user-name {
  font-weight: bold;
  font-size: larger; /* 根据需要调整字体大小 */
}

</style>