import axios from 'axios';

const axiosInstance = axios.create({
  baseURL: 'api', // 替换为您的API基础URL
});

// 添加请求拦截器
axiosInstance.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('token');
    if (token) {
      config.headers.Authorization = `${token}`;
    }
    return config;
  },
  (error) => Promise.reject(error)
);

export default axiosInstance;

