<template>
  <el-config-provider namespace="ep">
    <div id="app">
      <BaseSide /> <!-- 左侧边栏 -->
      <div class="main-content" w="full" py="4">
        <HelloWorld msg="Hello Vue 3 + Element Plus + Vite" />
      </div>
      <RightSide /> <!-- 使用右侧边栏组件 -->
    </div>
  </el-config-provider>
</template>

<style>
#app {
  height: 100vh;
  display: flex;
  text-align: center;
  color: var(--ep-text-color-primary);
}

.main-container {
  display: flex;
  flex: 1;
  width: 100%;
}

.right-side {
  margin-right: 0px;
}
</style>
