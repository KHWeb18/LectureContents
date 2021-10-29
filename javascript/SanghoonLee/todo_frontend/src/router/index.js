import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Test from '../views/Test.vue'
import Todo from '../views/Todo.vue'
import Homework from '../views/Homework.vue'

// board
import BoardListPage from '@/views/BoardListPage.vue'
import BoardRegisterPage from '@/views/BoardRegisterPage.vue'
import BoardReadPage from '@/views/BoardReadPage.vue'
import BoardModifyPage from '@/views/BoardModifyPage.vue'

// game
import GameMemberRegisterPage from '@/views/GameMemberRegisterPage.vue'

// 삼목
import Concave from '@/views/Concave.vue'

// product
import ProductListPage from '@/views/ProductListPage.vue'
import ProductRegisterPage from '@/views/ProductRegisterPage.vue'
import ProductReadPage from '@/views/ProductReadPage.vue'
import ProductModifyPage from '@/views/ProductModifyPage.vue'

// monster
import MonsterListPage from '@/views/MonsterListPage.vue'
import MonsterRegisterPage from '@/views/MonsterRegisterPage.vue'
import MonsterReadPage from '@/views/MonsterReadPage.vue'
import MonsterModifyPage from '@/views/MonsterModifyPage.vue'

// EventBus
import EventBusTestPage from '@/views/EventBusTestPage.vue'

// 던전
import DungeonListPage from '@/views/DungeonListPage.vue'

// 성적 관리
import ScoreManagerPage from '@/views/ScoreManagerPage.vue'

// OnlyVuePage
import OnlyVuePage from '@/views/OnlyVuePage.vue'
// + Spring
import SpringInterconnectionPage from '@/views/SpringInterconnectionPage.vue'

// 크롤링
import DaumNewsCrawlerPage from '@/views/DaumNewsCrawlerPage.vue'

// Slot
import UnNamedSlotTestPage from '@/views/UnNamedSlotTestPage.vue'
import NamedSlotTestPage from '@/views/NamedSlotTestPage.vue'
import ScopedSlotTestPage from '@/views/ScopedSlotTestPage.vue'
import RecentSlotTestPage from '@/views/RecentSlotTestPage.vue'

// Materialize
import MaterializeTestPage from '@/views/MaterializeTestPage.vue'
import MaterializeGridTestPage from '@/views/MaterializeGridTestPage.vue'
import VuetifyAllInOneTestPage from '@/views/VuetifyAllInOneTestPage.vue'

// coverflow
import CoverflowTestPage from '@/views/CoverflowTestPage.vue'

// vue-awesome-swiper
import AwesomeSwiperTestPage from '@/views/AwesomeSwiperTestPage.vue'

// Likes Facebook
// import LikesFacebookPage from '@/views/LikesFacebookPage.vue'

// Image Gallery
import ImageGalleryTestPage from '@/views/ImageGalleryTestPage.vue'

// Calendar
import CalendarTestPage from '@/views/CalendarTestPage.vue'

// JPA Test Page
import VuetifyMemberRegisterPage from '@/views/VuetifyMemberRegisterPage.vue'
import MemberJoinColumnTestPage from '@/views/MemberJoinColumnTestPage.vue'
import VuetifyMemberLoginPage from '@/views/VuetifyMemberLoginPage.vue'

import SessionLoginPage from '@/views/SessionLoginPage.vue'
import AccountRegisterPage from '@/views/AccountRegisterPage.vue'

// File Upload
import FileUploadPage from '@/views/FileUploadPage.vue'

// Image Test
import ImgTestPage from '@/views/ImgTestPage.vue'

// Python Login Test
import PythonLoginTestPage from '@/views/PythonLoginTestPage.vue'

// Kakao Login
import KakaoLoginPage from '@/views/KakaoLoginPage.vue'

// Order Test
import OrderTestPage from '@/views/OrderTestPage.vue'

import KakaoAuthPage from '@/views/KakaoAuthPage.vue'

// Python Crawl Test
import PythonCrawlTestPage from '@/views/PythonCrawlTestPage.vue'

// WebGLTestPage
import WebGLTestPage from '@/views/WebGLTestPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/test',
    name: 'Test',
    component: Test
  },
  {
    path: '/todo',
    name: 'Todo',
    component: Todo
  },
  {
    path: '/homework',
    name: 'Homework',
    component: Homework
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
      // 라우팅 파라미터를 props에 자동으로 설정하게 서포트함
      default: true
    }
  },
  {
    path: '/member/create',
    name: 'GameMemberRegisterPage',
    components: {
      default: GameMemberRegisterPage
    }
  },
  {
    path: '/concave',
    name: 'Concave',
    components: {
      default: Concave
    }
  },
  {
    path: '/product',
    name: 'ProductListPage',
    components: {
      default: ProductListPage
    }
  },
  {
    path: '/product/create',
    name: 'ProductRegisterPage',
    components: {
      default: ProductRegisterPage
    }
  },
  {
    path: '/product/:productNo',
    name: 'ProductReadPage',
    components: {
      default: ProductReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/product/:productNo/edit',
    name: 'ProductModifyPage',
    components: {
      default: ProductModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/monster',
    name: 'MonsterListPage',
    components: {
      default: MonsterListPage
    }
  },
  {
    path: '/monster/create',
    name: 'MonsterRegisterPage',
    components: {
      default: MonsterRegisterPage
    }
  },
  {
    path: '/monster/:monsterNo',
    name: 'MonsterReadPage',
    components: {
      default: MonsterReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/monster/:monsterNo/edit',
    name: 'MonsterModifyPage',
    components: {
      default: MonsterModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/eventbusTest',
    name: 'EventBusTestPage',
    components: {
      default: EventBusTestPage
    }
  },
  {
    path: '/dungeon',
    name: 'DungeonListPage',
    components: {
      default: DungeonListPage
    }
  },
  {
    path: '/onlyvuepage',
    name: 'OnlyVuePage',
    components: {
      default: OnlyVuePage
    }
  },
  {
    path: '/springintercon',
    name: 'SpringInterconnectionPage',
    components: {
      default: SpringInterconnectionPage
    }
  },
  {
    path: '/scoreManager',
    name: 'ScoreManagerPage',
    components: {
      default: ScoreManagerPage
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
    path: '/unNamedSlot',
    name: 'UnNamedSlotTestPage',
    components: {
      default: UnNamedSlotTestPage
    }
  },
  {
    path: '/namedSlot',
    name: 'NamedSlotTestPage',
    components: {
      default: NamedSlotTestPage
    }
  },
  {
    path: '/scopedSlot',
    name: 'ScopedSlotTestPage',
    components: {
      default: ScopedSlotTestPage
    }
  },
  {
    path: '/vSlot',
    name: 'RecentSlotTestPage',
    components: {
      default: RecentSlotTestPage
    }
  },
  {
    path: '/materialize',
    name: 'MaterializeTestPage',
    components: {
      default: MaterializeTestPage
    }
  },
  {
    path: '/materializeGrid',
    name: 'MaterializeGridTestPage',
    components: {
      default: MaterializeGridTestPage
    }
  },
  {
    path: '/vuetifyTest',
    name: 'VuetifyAllInOneTestPage',
    components: {
      default: VuetifyAllInOneTestPage
    }
  },
  {
    path: '/vuetifyMemberRegister',
    name: 'VuetifyMemberRegisterPage',
    components: {
      default: VuetifyMemberRegisterPage
    }
  },
  {
    path: '/coverflowTest',
    name: 'CoverflowTestPage',
    components: {
      default: CoverflowTestPage
    }
  },
  {
    path: '/awesomeSwiperTest',
    name: 'AwesomeSwiperTestPage',
    components: {
      default: AwesomeSwiperTestPage
    }
  },
  {
    path: '/imageGallery',
    name: 'ImageGalleryTestPage',
    components: {
      default: ImageGalleryTestPage
    }
  },
  {
    path: '/calendar',
    name: 'CalendarTestPage',
    components: {
      default: CalendarTestPage
    }
  },
  {
    path: '/memberJoinColumn',
    name: 'MemberJoinColumnTestPage',
    components: {
      default: MemberJoinColumnTestPage
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
    path: '/fileUpload',
    name: 'FileUploadPage',
    components: {
      default: FileUploadPage
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
    path: '/imgTest',
    name: 'ImgTestPage',
    components: {
      default: ImgTestPage
    }
  },
  {
    path: '/pyLogin',
    name: 'PythonLoginTestPage',
    components: {
      default: PythonLoginTestPage
    }
  },
  {
    path: '/kakaoLogin',
    name: 'KakaoLoginPage',
    components: {
      default: KakaoLoginPage
    }
  },
  {
    path: '/orderTestPage',
    name: 'OrderTestPage',
    components: {
      default: OrderTestPage
    }
  },
  {
    path: '/kakaoAuthPage',
    name: 'KakaoAuthPage',
    components: {
      default: KakaoAuthPage
    }
  },
  {
    path: '/pythonCrawlTestPage',
    name: 'PythonCrawlTestPage',
    components: {
      default: PythonCrawlTestPage
    }
  },
  {
    path: '/WebGLTestPage',
    name: 'WebGLTestPage',
    components: {
      default: WebGLTestPage
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
