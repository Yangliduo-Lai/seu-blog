<template>
  <div class="login-container">
    <h1>Login</h1>
    <form @submit.prevent="login">
      <div class="form-group">
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="credentials.username" required>
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="credentials.password" required>
      </div>
      <button type="submit">Login</button>
    </form>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  name: 'Login',
  setup() {
    const credentials = ref({
      username: '',
      password: ''
    });

    function login() {
      alert(`Username: ${credentials.value.username}\nPassword: ${credentials.value.password}`);
      // 实际应用中，这里应该发送请求到服务器
    }

    return {
      credentials,
      login
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

button {
  width: 100%;
  padding: 12px; /* Comfortable padding */
  background-color: #007BFF; /* Primary button color */
  border-radius: 5px; /* Rounded corners */
  color: white;
  cursor: pointer;
  transition: background-color 0.3s; /* Smooth transition for hover effect */
}

button:hover, button:focus {
  background-color: #0056b3; /* Darker shade on hover and focus */
}
</style>
