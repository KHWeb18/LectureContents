import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

// 메인홈
import MainPage from '@/views/main/MainPage.vue'

// 로그인
import CinzelMemberLogin from '@/views/member/CinzelMemberLogin.vue'
import MyPage from '@/views/member/MyPage.vue'
import ManagerLogin from '@/views/ManagerLogin.vue'

// 회원가입
import CinzelMemberRegister from '@/views/member/CinzelMemberRegister.vue'

//카테고리
import About from '@/views/category/About.vue'
import Tour from '@/views/category/Tour.vue'
import Reservation from '@/views/category/Reservation.vue'

// 크롤링
import TourCrawlerPage from '@/views/TourCrawlerPage.vue'

// board
// import Board from '@/views/category/board/Board.vue'
import BoardListPage from '@/views/category/board/BoardListPage.vue'
import BoardRegisterPage from '@/views/category/board/BoardRegisterPage.vue'
import BoardReadPage from '@/views/category/board/BoardReadPage.vue'
import BoardModifyPage from '@/views/category/board/BoardModifyPage.vue'


// room
import Room201 from '@/views/category/rooms/Room201.vue'
import Room202 from '@/views/category/rooms/Room202.vue'
import Room301 from '@/views/category/rooms/Room301.vue'
import Room302 from '@/views/category/rooms/Room302.vue'

// 예약하기
import Book from '@/views/Book.vue'
import CompletePayment from '@/views/CompletePayment.vue' 

// 관리자 페이지
import administratorPage from '@/views/administratorPage.vue'


  


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/administrator',
    name: 'administratorPage',
    components: {
      default: administratorPage
    }
  },
  {
    path: '/tourCrawler',
    name: 'TourCrawlerPage',
    components: {
      default: TourCrawlerPage
    }
  },
  {
    path: '/cinzel',
    name: 'MainPage',
    components: {
      default: MainPage
    }
  },
  {
    path: '/login',
    name: 'CinzelMemberLogin',
    components: {
      default: CinzelMemberLogin
    }
  },
  {
    path: '/managerLogin',
    name: 'ManagerLogin',
    components: {
      default: ManagerLogin
    }
  },
  {
    path: '/myPage/:memberNo',
    name: 'MyPage',
    components: {
      default: MyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/memberRegister',
    name: 'CinzelMemberRegister',
    components: {
      default: CinzelMemberRegister
    }
  },
  {
    path: '/about',
    name: 'About',
    components: {
      default: About
    }
  },
  {
    path: '/room301',
    name: 'Room301',
    components: {
      default: Room301
    }
  },
  {
    path: '/room302',
    name: 'Room302',
    components: {
      default: Room302
    }
  },
  {
    path: '/room201',
    name: 'Room201',
    components: {
      default: Room201
    }
  },
  {
    path: '/room202',
    name: 'Room202',
    components: {
      default: Room202
    }
  },
  {
    path: '/tour',
    name: 'Tour',
    components: {
      default: Tour
    }
  },
  {
    path: '/reservation',
    name: 'Reservation',
    components: {
      default: Reservation
    }
  },
  // {
  //   path: '/board',
  //   name: 'Board',
  //   components: {
  //     default: Board
  //   }
  // },
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
      default: true
    }
  },
  {
    path: '/book',
    name: 'Book',
    components: {
      default: Book
    }
  },
  {
    path: '/completePayment',
    name: 'CompletePayment',
    components: {
      default: CompletePayment
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
