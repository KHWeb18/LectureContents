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
import DungeonListPage from '../views/DungeonListpage.vue'

// 삼각형
import OnlyVuePage from '../views/OnlyVuePage.vue'
import SpringInterconnectionPage from '../views/SpringInterconnectionPage.vue'

//성적관리
import ScoreManagerPage from '../views/ScoreManagerPage.vue';

//다음 크롤링
import DaumNewsCrawlerPage from '@/views/DaumNewsCrawlerPage.vue'

//slot
import UnNamedSlotTestPage from '@/views/UnNamedSlotTestPage.vue'
import NamedSlotTestPage from '@/views/NamedSlotTestPage'
import ScopedSlotTestPage from '@/views/ScopedSlotTestPage'
import RecentSlotTestPage from '@/views/RecentSlotTestPage'

//Materialize
import MaterializeTestPage from '@/views/MaterializeTestPage'
import MaterialGridTestPage from '@/views/MaterialGridTestPage'
import vuetifyAllInoneTestPage from '@/views/vuetifyAllInoneTestPage'


import VuetifyMemberRegisterPage from '@/views/VuetifyMemberRegisterPage'

// coverflow
import CoverflowTestPage from '@/views/CoverflowTestPage.vue'

// AwesomeSwireper
import AwesomeSwiper from '@/views/AwesomeSwiper'

import CalendarTestPage from '@/views/CalendarTestPage'

//JPA
import MemberJoinColumTestPage from '@/views/MemberJoinColumTestPage';

import LoginPage from '@/views/LoginTest';


import FileUploadPage from '@/views/FileUploadPage';



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
    path: '/only-vue-page',
    name: 'OnlyVuePage',
    components: {
      default: OnlyVuePage
    }
  },
  {
    path: '/Spring-inter-connection-page',
    name: 'SpringInterconnectionPage',
    components: {
      default: SpringInterconnectionPage
    }
  },
  {
    path: '/score-manager-page',
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
    path: '/unnamed-slot-test-page',
    name: 'UnNamedSlotTestPage',
    components: {
      default: UnNamedSlotTestPage
    }
  },
  {
    path: '/named-slot-test-page',
    name: 'NamedSlotTestPage',
    components: {
      default: NamedSlotTestPage
    }
  },
  {
    path: '/scoped-slot',
    name: 'ScopedSlotTestPage',
    components: {
      default: ScopedSlotTestPage
    }
  },
  {
    path: '/vSlot',
    name: 'RecentSlotTestPage',
    component: RecentSlotTestPage
  },
  {
    path: '/materialize-test',
    name: 'MaterializeTestPage',
    component: MaterializeTestPage
  },
  {
    path: '/material-gridSystem',
    name: 'MaterialGridTestPage',
    component: MaterialGridTestPage
  },
  {
    path: '/vutify-page',
    name: 'vuetifyAllInoneTestPage',
    component: vuetifyAllInoneTestPage
  },
  {
    path: '/vutify-member-register',
    name: 'JPAmemberRegister',
    component: VuetifyMemberRegisterPage
  },
  {
    path: '/coverflowTest',
    name: 'CoverflowTestPage',
    components: {
      default: CoverflowTestPage
    }
  },
  {
    path: '/awesomSwiperTest',
    name: 'AwesomeSwiper',
    components: {
      default: AwesomeSwiper
    }
  },
  {
    path: '/calendar-test-page',
    name: 'CalendarTestPage',
    components: {
      default: CalendarTestPage
    }
  },
  {
    path: '/member-join-column-test-page',
    name: 'MemberJoinColumTestPage',
    components: {
      default: MemberJoinColumTestPage
    }
  },
  {
    path: '/login-Page',
    name: 'LoginPage',
    components: {
      default: LoginPage
    }
  },
  {
    path: '/file-upload-page',
    name: 'FileUploadPage',
    components: {
      default: FileUploadPage
    }
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router