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

import UnNameSlotTestPage from '@/views/UnNameSlotTestPage.vue'

import NameSlotTestPage from '@/views/NameSlotTestPage.vue'
import ScopedSlotTestPage from '@/views/ScopedSlotTestPage.vue'
import RecentSlotTestPage from '@/views/RecentSlotTestPage.vue'


import MeterializeTestPage from '@/views/MeterializeTestPage.vue'
import MeterializeGridTestPage from '@/views/MeterializeGridTestPage.vue'

import VuetifyAllInOneTestPage from '@/views/VuetifyAllInOneTestPage.vue'

import VueJpaMemberPage from '@/views/VueJpaMemberPage.vue'

import CoverflowTestPage from '@/views/CoverflowTestPage.vue'

import AwesomeSwiperTestPage from '@/views/AwesomeSwiperTestPage.vue'


import ImageGalleryTestPage from '@/views/ImageGalleryTestPage.vue'

import CalendarTestPage from '@/views/CalendarTestPage.vue'

import MemberJoinColumnTestPage from '@/views/MemberJoinColumnTestPage.vue'

import VuetifyMemberRegisterPage from '@/views/VuetifyMemberRegisterPage.vue'

import VuetifyMemberLoginPage from '@/views/VuetifyMemberLoginPage.vue'


import SwiperTest from '@/views/SwiperTest.vue'

import FileUploadPage from '@/views/FileUploadPage.vue'

//python 

import PythonLoginTestPage from '@/views/PythonLoginTestPage.vue'
import KakaoLoginPage from '@/views/KakaoLoginPage.vue'

import OrderTestPage from '@/views/OrderTestPage.vue'








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
    path: '/unNameSlotTest',
    name: 'UnNameSlotTestPage',
    components: {
      default: UnNameSlotTestPage
    }
  },
  {
    path: '/nameSlotTest',
    name: 'NameSlotTestPage',
    components: {
      default: NameSlotTestPage
    }
  },
  {
    path: '/scopedSlotTest',
    name: 'ScopedSlotTestPage',
    components: {
      default: ScopedSlotTestPage
    }
  },
  {
    path: '/vslot',
    name: 'RecentSlotTestPage',
    components: {
      default: RecentSlotTestPage
    }
  },
  {
    path: '/meterializeTestPage',
    name: 'MeterializeTestPage',
    components: {
      default: MeterializeTestPage
    }
  },
  {
    path: '/meterializeGridTestPage',
    name: 'MeterializeGridTestPage',
    components: {
      default: MeterializeGridTestPage
    }
  },
  {
    path: '/vuetifyAllInOneTestPage',
    name: 'VuetifyAllInOneTestPage',
    components: {
      default: VuetifyAllInOneTestPage
    }
  },

  {
    path: '/vuemember/create',
    name: 'VueJpaMemberPage',
    components: {
      default: VueJpaMemberPage
    }
  },

  {
    path: '/coverFlowTestPage',
    name: 'CoverflowTestPage',
    components: {
      default: CoverflowTestPage
    }
  },
  {
    path: '/awesomeSwiperTestPage',
    name: 'AwesomeSwiperTestPage',
    components: {
      default: AwesomeSwiperTestPage
    }
  },
  

  
  {
    path: '/imageGalleryTestPage',
    name: 'ImageGalleryTestPage',
    components: {
      default: ImageGalleryTestPage
    }
  },
  {
    path: '/calendarTestPage',
    name: 'CalendarTestPage',
    components: {
      default: CalendarTestPage
    }
  },

  {
    path: '/memberJoinColumnTestPage',
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
    path: '/vuetifyMemberRegister',
    name: 'VuetifyMemberRegisterPage',
    components: {
      default: VuetifyMemberRegisterPage
    }
  },
  {
    path: '/swiperTest',
    name: 'SwiperTest',
    components: {
      default: SwiperTest
    }
  },

  {
    path: '/fileUploadPage',
    name: 'FileUploadPage',
    components: {
      default: FileUploadPage
    }
  },
  
  //python

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
  


  



  
  


  
  

  

  
  
  
  
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router