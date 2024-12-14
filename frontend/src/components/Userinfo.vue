<template>
    <div class="user-profile-container">
      <div class="user-profile">
        <div class="profile-section user-info">
          <img :src="avatarSrc" alt="User Avatar" class="avatar" />
          <h3>{{ userInfo.nickname || userInfo.username }}</h3>
          <p><i class="fas fa-envelope"></i> {{ userInfo.email }}</p>
          <p><i class="fas fa-briefcase"></i> {{ userInfo.role }}</p>
          <p v-if="userInfo.location"><i class="fas fa-map-marker-alt"></i> {{ userInfo.location }}</p>
          <p v-if="userInfo.signature">{{ userInfo.signature }}</p>
        </div>
        <div class="profile-section user-settings">
          <form @submit.prevent="saveUserInfo">
            <div class="form-group">
              <label for="username">* 姓名</label>
              <input type="text" id="username" v-model="userInfo.username" required />
            </div>
            <div class="form-group">
              <label for="email">* 邮箱</label>
              <input type="email" id="email" v-model="userInfo.email" required />
            </div>
            <div class="form-group">
              <label for="role">职位</label>
              <input type="text" id="role" v-model="userInfo.role" />
            </div>
            <div class="form-group">
              <label for="location">地址</label>
              <input type="text" id="location" v-model="userInfo.location" />
            </div>
            <div class="form-group">
              <label for="signature">签名</label>
              <textarea id="signature" v-model="userInfo.signature"></textarea>
            </div>
            <div class="form-group">
              <button type="reset" class="reset-btn">重置</button>
              <button type="submit" class="save-btn">保存</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </template>
  
  <script lang="ts" setup>
  import { ref, onMounted,watch} from 'vue';
  import axios from 'axios';
  import avatar from '@assets/avatar.png';
  import { useAuthStore } from '~/stores/auth';
  
  const authStore = useAuthStore();
  const userInfo = ref({
    username: '',
    email: '',
    role: '',
    createdTime: '',
    updatedTime: '',
    avatar: null,
    nickname: null,
    location: null,
    signature: ''
  });
  
  // 将导入的图片路径赋值给响应式变量
  const avatarSrc = ref(avatar);
  
  // 获取用户信息
  const fetchUserInfo = async () => {
    try {
      if (authStore.isAuthenticated) {
        let res = await axios.get('http://127.0.0.1:4523/m2/5596245-5274544-default/244580038');
        if (res.data.code === 0) {
          userInfo.value = res.data.data;
          // 如果有头像URL，更新avatarSrc
          if (res.data.data.avatar) {
            avatarSrc.value = res.data.data.avatar;
          }
        } else {
          console.error("Error fetching user info:", res.data.message);
        }
      }
    } catch (error) {
      console.error("Error fetching user info:", error);
    }
  };
  
  // 保存用户信息
  const saveUserInfo = async () => {
    try {
      // 在这里放置实际的保存逻辑，例如发送POST请求更新用户信息
      console.log('Saving user info:', userInfo.value);
      alert('用户信息已保存！');
    } catch (error) {
      console.error("Error saving user info:", error);
    }
  };
  
  // 当组件首次加载时调用 fetchUserInfo
  onMounted(() => {
    fetchUserInfo();
  });
  
  // 监听认证状态变化
  watch(() => authStore.isAuthenticated, async (newVal) => {
    if (newVal) {
      await fetchUserInfo();
    }
  });
  </script>
  
  <style scoped>
  /* 保留原有样式 */
  .user-profile-container {
    max-width: 800px; /* 设置最大宽度 */
    margin: 0 auto; /* 确保容器水平居中 */
    padding: 20px;
  }
  
  .user-profile {
    display: flex;
    justify-content: space-between; /* 左右部分之间留有空间 */
    align-items: center; /* 垂直居中 */
    background: #fff;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
    padding: 20px;
  }
  
  .profile-section {
    flex: 1;
    padding: 10px;
    box-sizing: border-box;
  }
  
  .user-info {
    text-align: center;
  }
  
  .user-info .avatar {
    width: 100px;
    height: 100px;
    border-radius: 50%;
    margin-bottom: 10px;
  }
  
  .user-info h3 {
    margin: 0;
    font-size: 20px;
  }
  
  .user-info p {
    margin: 5px 0;
  }
  
  .user-settings {
    padding-left: 20px; /* 调整左右两边之间的间距 */
  }
  
  .form-group {
    margin-bottom: 10px;
  }
  
  label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
  }
  
  input,
  textarea {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    transition: border-color 0.3s;
  }
  
  input:focus,
  textarea:focus {
    border-color: #2a6fbd;
    outline: none;
  }
  
  .reset-btn,
  .save-btn {
    padding: 8px 15px;
    margin-right: 10px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  
  .reset-btn {
    background-color: #f0f0f0;
    color: #333;
  }
  
  .save-btn {
    background-color: #2a6fbd;
    color: #fff;
  }
  
  .save-btn:hover {
    background-color: #1e57a9;
  }
  </style>