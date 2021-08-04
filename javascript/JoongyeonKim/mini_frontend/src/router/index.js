import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

//board
//@는 src폴더를 의미한다
import BoardListPage from '@/views/board/BoardListPage.vue'
import BoardRegisterPage from '@/views/board/BoardRegisterPage.vue'
import BoardReadPage from '@/views/board/BoardReadPage.vue'
import BoardModifyPage from '@/views/board/BoardModifyPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
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
      // 라우팅 파리미터를 props에 자동으로 설정하게 서포트함
      default: true
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
