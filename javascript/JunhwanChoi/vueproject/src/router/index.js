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

//예약시스템
import Appointment from '@/views/Appointment.vue'

import CovidCrawlerPage from '@/views/CovidCrawlerPage.vue'

//로그인
import SessionLoginPage from '@/views/SessionLoginPage.vue'
import AccountRegisterPage from '@/views/AccountRegisterPage.vue'

//코로나 정보페이지
import InfoCovid from '@/views/InfoCovid.vue'
import InfoCovidCnt from '@/views/InfoCovidCnt.vue'
import InfoActive from '@/views/InfoActive.vue'
import InfoNews from '@/views/InfoNews.vue'


//// board
import BoardListPage from '@/views/BoardListPage.vue'
import BoardRegisterPage from '@/views/BoardRegisterPage.vue'
import BoardReadPage from '@/views/BoardReadPage.vue'
import BoardModifyPage from '@/views/BoardModifyPage.vue'

//백신정보
import VaccineInfo from '@/views/VaccineInfo.vue'



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
    path: '/appointment',
    name: 'Appointment',
    components: {
      default: Appointment
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
    path: '/infoCovid',
    name: 'InfoCovid',
    components: {
      default: InfoCovid
    }
  },
  {
    path: '/infoCovidCnt',
    name: 'InfoCovidCnt',
    components: {
      default: InfoCovidCnt
    }
  },
  {
    path: '/infoNews',
    name: 'InfoNews',
    components: {
      default: InfoNews
    }
  },
  {
    path: '/infoActive',
    name: 'InfoActive',
    components: {
      default: InfoActive
    }
  },

  //vaccine board
  {
    path: '/board',
    name: 'BoardListPage',
    components: {
      default: BoardListPage
    }
  },
  {
    path: '/board/create',
    name: 'BoardRegisterPage',
    components: {
      default: BoardRegisterPage
    }
  },
  {
    path: '/board/:boardNo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/board/:boardNo/edit',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    },
    props: {
      // 라우팅 파라미터를 props에 자동으로 설정하게 서포트함
      default: true
    }
  },

  {
    path: '/vaccineInfo',
    name: 'VaccineInfo',
    components: {
      default: VaccineInfo
    }
  },
  

  

  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router