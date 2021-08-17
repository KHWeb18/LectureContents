import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Test from '@/views/Test'

import Signup from '@/views/member/Signup'
import Login from '@/views/member/Login'
import Record from '@/views/Record'
import Challenge from '@/views/Challenge'
import Recommend from '@/views/Recommend'
import Together from '@/views/Together'
import Chatting from '@/views/Chatting'

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
    path: '/test',
    name: 'Test',
    component: Test
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
    path: '/chatting',
    name: 'Chatting',
    component: Chatting
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
