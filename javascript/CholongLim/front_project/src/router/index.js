import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

// 메인홈
import MainPage from '@/views/main/MainPage.vue'

// 로그인
import CinzelMemberLogin from '@/views/member/CinzelMemberLogin.vue'
import MyPage from '@/views/member/MyPage.vue'
// 마이페이지
import UserList from '@/views/member/UserList.vue'
import UserReadPage from '@/views/member/UserReadPage.vue'
import UserModifyPage from '@/views/member/UserModifyPage.vue'
import MyReservation from '@/views/member/MyReservation.vue'
import ReservationReadPage from '@/views/member/ReservationReadPage.vue'


// 관리자
import MemberListPage from '@/views/manager/MemberListPage.vue'
import MemberReadPage from '@/views/manager/MemberReadPage.vue'
import MemberModifyPage from '@/views/manager/MemberModifyPage.vue'
import BookingListPage from '@/views/manager/BookingListPage.vue'
import BookingReadPage from '@/views/manager/BookingReadPage.vue'



// 회원가입
import CinzelMemberRegister from '@/views/member/CinzelMemberRegister.vue'

//카테고리
import About from '@/views/category/About.vue'
import Tour from '@/views/category/Tour.vue'
import Reservation from '@/views/category/Reservation.vue'

// 크롤링
import TourCrawlerPage from '@/views/TourCrawlerPage.vue'

// board
import BoardListPage from '@/views/category/board/BoardListPage.vue'
import BoardRegisterPage from '@/views/category/board/BoardRegisterPage.vue'
import BoardReadPage from '@/views/category/board/BoardReadPage.vue'
import BoardModifyPage from '@/views/category/board/BoardModifyPage.vue'


// room
import SelectRoom from '@/views/category/rooms/SelectRoom.vue'
import Room201 from '@/views/category/rooms/Room201.vue'
import Room202 from '@/views/category/rooms/Room202.vue'
import Room301 from '@/views/category/rooms/Room301.vue'
import Room302 from '@/views/category/rooms/Room302.vue'

// 예약하기
import Book2 from '@/views/Book2.vue'




import test from '@/views/test.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/test',
    name: 'test',
    component: test
  },
  {
    path: '/mypage',
    name: 'MyPage',
    components: {
      default: MyPage
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
  // 마이페이지
  {
    path: '/userList',
    name: 'UserList',
    components: {
      default: UserList
    }
  },
  {
    path: '/myReservation',
    name: 'MyReservation',
    components: {
      default: MyReservation
    }
  },
  {
    path: '/book/:bookNo',
    name: 'ReservationReadPage',
    components: {
      default: ReservationReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/member/:memberNo/editpage',
    name: 'UserModifyPage',
    components: {
      default: UserModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/member/:memberNo',
    name: 'UserReadPage',
    components: {
      default: UserReadPage
    },
    props: {
      default: true
    }
  },
  // 관리자
  {
    path: '/memberList',
    name: 'MemberListPage',
    components: {
      default: MemberListPage
    }
  },
  {
    path: '/bookingList',
    name: 'BookingListPage',
    components: {
      default: BookingListPage
    }
  },
  {
    path: '/room/:bookNo',
    name: 'BookingReadPage',
    components: {
      default: BookingReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/manager/member/:memberNo',
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
    path: '/rooms',
    name: 'SelectRoom',
    components: {
      default: SelectRoom
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
    path: '/book2',
    name: 'Book2',
    components: {
      default: Book2
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
