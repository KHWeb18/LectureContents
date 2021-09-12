import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/views/home/Home'
import Test from '@/views/Test'
import ListTest from '@/views/ListTest'

import Record from '@/views/record/Record'

import Challenge from '@/views/challenge/Challenge'

import Recommend from '@/views/recommend/Recommend'
import AddRecommend from '@/views/recommend/AddRecommend'
import ReadRecommend from '@/views/recommend/ReadRecommend'
import ModifyRecommend from '@/views/recommend/ModifyRecommend'

import Together from '@/views/together/Together'
import AddTogether from '@/views/together/AddTogether'
import ReadTogether from '@/views/together/ReadTogether'
import ModifyTogether from '@/views/together/ModifyTogether'

import Map from '@/views/map/Map'

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
    component: Recommend,
  },
  {
    path: '/recommend/register',
    name: 'AddRecommend',
    component: AddRecommend
  },
  {
    path: '/recommend/read',
    name: 'ReadRecommend',
    component: ReadRecommend,
  },
  {
    path: '/recommend/modify',
    name: 'ModifyRecommend',
    component: ModifyRecommend,
  },
  {
    path: '/together',
    name: 'Together',
    component: Together
  },
  {
    path: '/together/register',
    name: 'AddTogether',
    component: AddTogether
  },
  {
    path: '/together/read',
    name: 'ReadTogether',
    component: ReadTogether,
  },
  {
    path: '/together/modify',
    name: 'ModifyTogether',
    component: ModifyTogether,
  },
  {
    path: '/map',
    name: 'Map',
    component: Map
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
