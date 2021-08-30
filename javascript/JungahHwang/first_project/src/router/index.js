import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Test from '@/views/Test'
import ListTest from '@/views/ListTest'

import Record from '@/views/Record'
import Challenge from '@/views/Challenge'
import Recommend from '@/views/recommend/Recommend'
import AddRecommend from '@/views/recommend/AddRecommend'
import ReadRecommend from '@/views/recommend/ReadRecommend'
import ModifyRecommend from '@/views/recommend/ModifyRecommend'
import Together from '@/views/Together'
import Chatting from '@/views/Chatting'

import Mypage from '@/views/member/Mypage'

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
    path: '/listTest',
    name: 'ListTest',
    component: ListTest
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
    path: '/recommend/register',
    name: 'AddRecommend',
    component: AddRecommend
  },
  {
    path: '/recommend/read/:boardNo',
    name: 'ReadRecommend',
    component: ReadRecommend
  },
  {
    path: '/recommend/modify/:boardNo',
    name: 'ModifyRecommend',
    component: ModifyRecommend
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
  {
    path: '/mypage',
    name: 'Mypage',
    component: Mypage
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
