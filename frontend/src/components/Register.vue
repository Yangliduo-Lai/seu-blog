<template>
  <div class="register-container">
    <h1>SEU-BLOG</h1>
    <form @submit.prevent="onSubmit">
      <div class="form-group">
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="credentials.username" required>
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="credentials.password" required>
        <p v-if="passwordError" class="error">{{ passwordError }}</p>
      </div>
      <div class="form-group">
        <label for="confirm-password">Confirm Password:</label>
        <input type="password" id="confirm-password" v-model="credentials.confirmPassword" required>
        <p v-if="confirmPasswordError" class="error">{{ confirmPasswordError }}</p>
      </div>
      <div class="button-container">
        <button type="submit">Register</button>
      </div>
    </form>
  </div>
</template>

<script>
import { reactive, ref } from 'vue';
import axios from 'axios'; 
import { useRouter } from 'vue-router'; 
import { ElMessage } from 'element-plus'; 

export default {
  name: 'RegisterForm',
  setup() {
    const credentials = reactive({
      username: '',
      password: '',
      confirmPassword: ''
    });
    const isLogin = ref(false); // 默认为注册模式
    const router = useRouter();
    const passwordError = ref('');
    const confirmPasswordError = ref('');

    function toggleMode() {
      router.push('/login'); // 跳转到登录页面
    }


    function validateConfirmPassword() {
      if (credentials.password !== credentials.confirmPassword) {
        ElMessage.error("Passwords do not match");
        return false;
      }
      confirmPasswordError.value = '';
      return true;
    }

    async function onSubmit() {
      if (!validateConfirmPassword()) {
        return;
      }

      try {
        const formData = new URLSearchParams();
        formData.append('username', credentials.username);
        formData.append('password', credentials.password);

        const response = await axios.post('/api/user/register', formData, {
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
          }
        });

        const { code, message, token } = response.data;

        if (code === 0) { 
          localStorage.setItem('authToken', token); // 存储token
          router.push('/home');
          ElMessage({ message: 'Registration successful!', type: 'success' }); // 成功提示
        } else {
          switch(message){
            case "register.password: 需要匹配正则表达式\"^\\S{5,16}$\"":
            ElMessage.error('Error: Password format is incorrect.');
            break;
            case "register.password: 需要匹配正则表达式\"^\\S{5,16}$\", register.username: 需要匹配正则表达式\"^\\S{5,16}$\"":
            ElMessage.error('Error: Password and username format is incorrect.');
            break;
            case "register.username: 需要匹配正则表达式\"^\\S{5,16}$\", register.password: 需要匹配正则表达式\"^\\S{5,16}$\"":
            ElMessage.error('Error: Password and username format is incorrect.');
            break;
            default:
            ElMessage.error(`An error occurred during registration: ${message}`);
           break;
        }
      }
      } catch (error) {
        console.error('Error during registration:', error);
        ElMessage.error('An unexpected error occurred, please try again.');
      }
    }

    return {
      credentials,
      onSubmit,
      isLogin,
      toggleMode,
      passwordError,
      confirmPasswordError
    };
  }
};
</script>

<style scoped>
.register-container {
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
  justify-content: center; /* 水平居中对齐 */
  margin-top: 20px; /* 可选：增加顶部间距以改善布局 */
}

button {
  width: 100%; /* 让按钮占据整个宽度 */
  padding: 12px;
  background-color: #007BFF;
  border-radius: 5px;
  color: white;
  cursor: pointer;
  transition: background-color 0.3s;
  box-sizing: border-box; /* 确保内边距和边框包含在元素的总宽度和高度之内 */
}

button:hover, button:focus {
  background-color: #0056b3;
}

.error {
  color: red;
  font-size: 0.875rem;
  margin-top: 0.25rem;
}
</style>