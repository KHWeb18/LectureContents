//라우터 : 경로 설정해주는거

import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import RegisterPage from '../views/RegisterPage.vue'
import LoginPage from '../views/LoginPage.vue'

// member
import MemberListPage from '@/views/MemberListPage.vue'
import MemberReadPage from '@/views/MemberReadPage.vue'
import MemberModifyPage from '@/views/MemberModifyPage.vue'

//news
import DaumNewsCrawlerPage from '@/views/DaumNewsCrawlerPage.vue'


import InfoPage from '@/views/InfoPage.vue'

import Test from '@/views/Test.vue'

import CovidCrawlerPage from '@/views/CovidCrawlerPage.vue'


import SessionLoginPage from '@/views/SessionLoginPage.vue'
import AccountRegisterPage from '@/views/AccountRegisterPage.vue'
import VuetifyMemberLoginPage from '@/views/VuetifyMemberLoginPage.vue'



Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/register',
    name: 'RegisterPage',
    component: RegisterPage
  },
  {
    path: '/login',
    name: 'LoginPage',
    component: LoginPage
  },
  {
    path: '/member',
    name: 'MemberListPage',
    components: {
      default: MemberListPage
    }
  },
  {
    path: '/member/:memberNo',
    name: 'MemberReadPage',
    components: {
      default: MemberReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/member/:memberNo/edit',
    name: 'MemberModifyPage',
    components: {
      default: MemberModifyPage
    },
    props: {
      // 라우팅 파라미터를 props에 자동으로 설정하게 서포트함
      default: true
    }
  },
  {
    path: '/daumNewsCrawler',
    name: 'DaumNewsCrawlerPage',
    components: {
      default: DaumNewsCrawlerPage
    }
  },
  {
    path: '/infoPage',
    name: 'InfoPage',
    components: {
      default: InfoPage
    }
  },

  {
    path: '/test',
    name: 'Test',
    components: {
      default: Test
    }
  },


  {
    path: '/covidtest',
    name: 'CovidCrawlerPage',
    components: {
      default: CovidCrawlerPage
    }
  },

  {
    path: '/sessionLogin',
    name: 'SessionLoginPage',
    components: {
      default: SessionLoginPage
    }
  },
  {
    path: '/accountRegister',
    name: 'AccountRegisterPage',
    components: {
      default: AccountRegisterPage
    }
  },
  {
    path: '/vuetifyMemberLoginPage',
    name: 'VuetifyMemberLoginPage',
    components: {
      default: VuetifyMemberLoginPage
    }
  },

  


  

  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router