import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import VuetifyMemberRegisterPage from '@/views/member/VuetifyMemberRegisterPage.vue'
import VuetifyMemberLoginPage from '@/views/member/VuetifyMemberLoginPage.vue'
import MemberJoinColumnTestPage from '@/views/member/MemberJoinColumnTestPage.vue'

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
    path: '/memberRegister',
    name: 'VuetifyMemberRegisterPage',
    components: {
      default: VuetifyMemberRegisterPage
    }
  },
  {
    path: '/memberLogin',
    name: 'VuetifyMemberLoginPage',
    components: {
      default: VuetifyMemberLoginPage
    }
  },
  {
    path: '/MemberjoinColumnTestPage',
    name: 'MemberJoinColumnTestPage',
    components: {
      default: MemberJoinColumnTestPage
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
