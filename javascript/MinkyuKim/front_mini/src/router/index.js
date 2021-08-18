import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import VuetifyMemberLoginPage from '@/views/VuetifyMemberLoginPage.vue'
import VuetifyMemberRegisterPage from '@/views/VuetifyMemberRegisterPage.vue'
import MemberRegisterPage from '@/views/MemberRegisterPage.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/memberLogin',
    name: 'VuetifyMemberLoginPage',
    components: {
      default: VuetifyMemberLoginPage
    }
  },
  {
    path: '/memberRegiser',
    name: 'VuetifyMemberRegisterPage',
    components: {
      default: VuetifyMemberRegisterPage
    }
  },
  {
    path: '/memberRegiserTest',
    name: 'MemberRegisterPage',
    components: {
      default: MemberRegisterPage
    }
  }
  
]


const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router