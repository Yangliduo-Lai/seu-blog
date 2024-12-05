<template>
  <el-config-provider namespace="ep">
    <div id="app">
      
      <!-- 导航区 -->
      <div class="base-side"><BaseSide /></div>

      <!-- 展示区 -->
      <div class="main-content">
        <RouterView></RouterView>
      </div>
      
      <!-- 右侧边栏 -->
      <div class="right-side"><RightSide /></div>

    </div>
  </el-config-provider>
</template>

<script setup name="App">
  import { RouterView,RouterLink } from 'vue-router'
  import BaseSide from './components/layouts/BaseSide.vue';
  import RightSide from './components/layouts/RightSide.vue';
</script>

<style>
#app {
  display: flex;  /* Using flexbox for layout */
  height: 100vh;  /* Full viewport height */
  width: 100%;  /* Full viewport width */
  overflow: hidden;  /* Hide overflow to maintain layout integrity */
  background: #f9f9f9;  /* Light background for the entire app */
  color: #333;  /* Default text color */
}

.base-side .right-side {
  width: 20%;  /* Both sidebars take up 20% of the viewport width */
  height: 100vh;  /* Full height to match the viewport */
  background-color: #fff;  /* White background for sidebars */
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);  /* Subtle shadow for depth */
  overflow-y: auto;  /* Allow scrolling within sidebars */
}

.main-content {
  flex-grow: 1;  /* Allows the main content to fill the remaining space */
  height: 100vh;
  margin-left: 19%;
  margin-right: 19%;
  overflow-y: auto;  /* Allow scrolling within the main content area */
  padding: 20px;  /* Spacing inside the main content area for padding */
  border-left: 1px solid #ccc;  /* Subtle border to separate from the base-side */
  border-right: 1px solid #ccc;  /* Subtle border to separate from the right-side */
}

.right-side {
  border-right: none;
}
</style>
