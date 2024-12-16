// stores/auth.ts
import { defineStore } from 'pinia';

interface AuthState {
  isAuthenticated: boolean;
  userRoles: string[];
  username: string;
  token?: string; // 添加 token 属性
}

interface LoginPayload {
  username: string;
  roles: string[];
}

export const useAuthStore = defineStore('auth', {
  state: (): AuthState => ({
    isAuthenticated: false,
    userRoles: [],
    username: '',
    token: undefined // 初始化为空
  }),
  actions: {
    login({ username, roles }: LoginPayload): void {
      this.isAuthenticated = true;
      this.userRoles = roles;
      this.username = username;
      // 如果有 token，这里可以设置 token
      // 注意：实际项目中应避免直接在 store 中操作 localStorage，应该通过服务或工具函数来管理
      if (this.token) {
        localStorage.setItem('token', this.token);
      }
    },
    logout() {
      this.isAuthenticated = false;
      this.userRoles = [];
      // 清除可能存在的本地存储或会话信息
      localStorage.removeItem('token'); // 如果使用了 token 存储
      sessionStorage.clear(); // 清除 session 存储
    }
  }
});