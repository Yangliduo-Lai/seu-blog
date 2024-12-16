// stores/user.ts
import { defineStore } from 'pinia';
import axiosInstance from '~/utils/axiosInstance';

export const useUserStore = defineStore('user', {
  state: () => ({
    userInfo: {
      userid: null,
      username: 'Guest',
      email: '',
      role: '',
      createdTime: '',
      updatedTime: '',
      avatar: null,
      nickname: '',
      signature: 'Please login to view more information'
    }
  }),
  actions: {
    async fetchUserInfo() {
      try {
        const res = await axiosInstance.get('user/info');
        if (res.data.code === 0) {
          this.userInfo = { ...res.data.data, userid: res.data.data.userid };
        } else {
          console.error("Error fetching user info:", res.data.message);
        }
      } catch (error) {
        console.error("Error fetching user info:", error);
      }
    },
    updateUserInfo(userInfo: { userid: null; username: string; email: string; role: string; createdTime: string; updatedTime: string; avatar: null; nickname: string; signature: string; }) {
      this.userInfo = { ...this.userInfo, ...userInfo };
    }
  }
});