import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

// 게시판
import NoticeBoardListPage from '@/views/board/notice/BoardListPage.vue'
import NoticeBoardRegisterPage from '@/views/board/notice/BoardRegisterPage.vue'
import NoticeBoardReadPage from '@/views/board/notice/BoardReadPage.vue'
import NoticeBoardModifyPage from '@/views/board/notice/BoardModifyPage.vue'


// 첫화면
import MainPage from '@/views/MainPage.vue'


//temp
import VuetifyAllOneTestPage from '@/views/VuetifyAllOneTestPage.vue'



Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/noticeBoard',
    name: 'NoticeBoardListPage',
    components: {
      default: NoticeBoardListPage
    }
  },
  {
    path: '/noticeBoard/create',
    name: 'NoticeBoardRegisterPage',
    components: {
      default: NoticeBoardRegisterPage
    }
  },
  {
    path: '/noticeBoard/:boardNo',
    name: 'NoticeBoardReadPage',
    components: {
      default: NoticeBoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/noticeBoard/:boardNo/edit',
    name: 'NoticeBoardModifyPage',
    components: {
      default: NoticeBoardModifyPage
    },
    props: {
      // 라우팅 파라미터를 props에 자동으로 설정하게 서포트함
      default: true
    }
  },
  {
    path: '/vuetifyAllOne',
    name: 'VuetifyAllOneTestPage',
    components: {
      default: VuetifyAllOneTestPage
    }
  },
  {
    path: '/mainPage',
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