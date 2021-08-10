import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import Signup from '@/views/member/Signup'
import Login from '@/views/member/Login'
import Record from '@/views/Record'
import Challenge from '@/views/Challenge'
import Recommend from '@/views/Recommend'
import Together from '@/views/Together'
import Talk from '@/views/Talk'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/signup',
    name: 'Signup',
    component: Signup
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/record',
    name: 'Record',
    component: Record
  },
  {
    path: '/challenge',
    name: 'Challenge',
    component: Challenge
  },
  {
    path: '/recommend',
    name: 'Recommend',
    component: Recommend
  },
  {
    path: '/together',
    name: 'Together',
    component: Together
  },
  {
    path: '/talk',
    name: 'Talk',
    component: Talk
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
