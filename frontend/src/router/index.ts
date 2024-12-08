import { createRouter,createWebHistory } from 'vue-router'

import Home from '../components/Main.vue'
import Login from '../components/Login.vue'
import Categories from '../components/Categories.vue'
import Tags from '../components/Tags.vue'
import Archives from '../components/Archives.vue'
import About from '../components/About.vue'
import Blog from '../components/Blog.vue'
import ManagementDashboard from '~/components/ManagementDashboard.vue'


// 创建路由器
const router = createRouter({
  history:createWebHistory(), // 路由器的工作模式
  routes:[
    {
      path:'/home',
      component:Home
    },
    {
      path:'/login',
      component:Login
    },
    {
      path:'/categories',
      component:Categories
    },
    {
      path:'/tags',
      component:Tags
    },
    {
      path:'/archives',
      component:Archives
    },
    {
      path:'/about',
      component:About
    },
    {
      path:'/blog',
      component:Blog
    },
    {
      path:'/management',
      component:ManagementDashboard
    }
  ]
})

export default router