import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

// test
import VuetifyAllInOneTestPage from '@/views/VuetifyAllInOneTestPage.vue'

// 메인홈
import MainPage from '@/views/main/MainPage.vue'

// 가입
import MembershipRegisterPage from '@/views/membership/MembershipRegisterPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/vuetifyTest',
    name: 'VuetifyAllInOneTestPage',
    components: {
      default: VuetifyAllInOneTestPage
    }
  },
  {
    path: '/todaysHans/signUp',
    name: 'MembershipRegisterPage',
    components: {
      default: MembershipRegisterPage
    }
  },
  {
    path: '/todaysHans',
    name: 'MainPage',
    components: {
      default: MainPage
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
