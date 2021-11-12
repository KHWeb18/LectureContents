import Vue from 'vue'
import VueRouter, { RouteConfig } from 'vue-router'
import Home from '../views/Home.vue'
import TsTest from '../views/TsTest.vue'
import TypeScriptBoardListPage from '@/views/board/TypeScriptBoardListPage.vue'

Vue.use(VueRouter)

const routes: Array<RouteConfig> = [
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
    path: '/tstest',
    name: 'TsTest',
    component: TsTest
  },
  {
    path: '/board/list',
    name: 'TypeScriptBoardListPage',
    components: {
      default: TypeScriptBoardListPage
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router