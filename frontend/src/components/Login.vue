<template>
  <div class="login-container">
    <h1>SEU-BLOG</h1>
    <form @submit.prevent="onSubmit">
      <div class="form-group">
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="credentials.username" required>
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="credentials.password" required>
      </div>
      <div class="button-container">
        <button type="submit">{{ isLogin ? 'Login' : 'Register' }}</button>
        <button type="button" @click="goToRegister">Register</button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from 'axios'; 
import { useRouter } from 'vue-router'; 
import { ElMessage } from 'element-plus'; 
import { ref,onMounted} from "vue";
import { useAuthStore } from '~/stores/auth'; // 引入 Pinia store
import axiosInstance from '~/utils/axiosInstance';

export default {
  name: 'AuthForm',
  setup() {
    const credentials = ref({
      username: '',
      password: ''
    });
    const isLogin = ref(true);
    const router = useRouter();
    const authStore = useAuthStore();

    async function onSubmit() {
      try {
        const formData = new URLSearchParams();
        formData.append('username', credentials.value.username);
        formData.append('password', credentials.value.password);

        const response = await axiosInstance.post('user/accountlogin', formData, {
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
          }
        });

        const { code, message, data } = response.data;

        if (code === 0) {
          const parsedData = JSON.parse(data); // 将 JSON 字符串转换为对象
          const { role, token } = parsedData;

          // 登录成功处理
          authStore.login({ username: credentials.value.username, roles: [role] });
          localStorage.setItem('token', token); // 存储 token
          router.push('/home');
          ElMessage({ message: 'Login successful!', type: 'success' });
        } else {
          // 错误处理...
          switch (message) {
            case "用户名错误":
              ElMessage.error('Error: Username is incorrect.');
              break;
            case "密码错误":
              ElMessage.error('Error: Password is incorrect.');
              break;
            case "login.password: 需要匹配正则表达式\"^\\S{5,16}$\"":
              ElMessage.error('Error: Password format is incorrect.');
              break;
            default:
              ElMessage.error(`An error occurred: ${message}`);
              break;
          }
        }
      } catch (error) {
        console.error('Error during login:', error);
        ElMessage.error('An unexpected error occurred, please try again.');
      }
    }

    const goToRegister = () => {
      router.push('/register');
    };

    return {
      credentials,
      onSubmit,
      isLogin,
      goToRegister
    };
  }
};
</script>

<style scoped>
.login-container {
  max-width: 320px;  /* Slightly wider for better spacing */
  margin: 40px auto; /* Increased margin for better vertical spacing */
  padding: 30px; /* More padding for a better layout */
  border: 1px solid #ccc; /* Subtle border */
  border-radius: 8px; /* Rounded corners for modern look */
  box-shadow: 0 4px 8px rgba(0,0,0,0.1); /* Soft shadow for depth */
  background-color: #fff; /* Background color for contrast */
  text-align: left; /* Align text to the left for a more standard form appearance */
}

.form-group {
  margin-bottom: 20px; /* Slightly larger margin for better separation */
}

input[type="text"],
input[type="password"] {
  width: 100%;
  padding: 10px; /* Increased padding for better interaction area */
  margin-top: 5px;
  border: 1px solid #ddd; /* Subtle border */
  border-radius: 4px; /* Rounded edges */
  box-shadow: inset 0 1px 3px rgba(0,0,0,0.06); /* Inset shadow for an inner glow */
}

input[type="text"]:focus,
input[type="password"]:focus {
  border-color: #0056b3; /* Highlight focus with a color */
  box-shadow: inset 0 1px 3px rgba(0,0,0,0.1), 0 0 8px rgba(0,95,175,0.25); /* More prominent shadow on focus */
}

.button-container {
  display: flex;
  justify-content: space-between; /* 按钮之间留有空间 */
}

button {
  width: 48%; /* 减少宽度以适应并排布局，留出一点空间 */
  padding: 12px;
  background-color: #007BFF;
  border-radius: 5px;
  color: white;
  cursor: pointer;
  transition: background-color 0.3s;
}

button:hover, button:focus {
  background-color: #0056b3;
}
</style>