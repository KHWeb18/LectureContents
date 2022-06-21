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
import ProductListPage from '@/views/product/ProductListPage.vue'
import ProductRegisterPage from '@/views/product/ProductRegisterPage.vue'
import ProductReadPage from '@/views/product/ProductReadPage.vue'
import ProductModifyPage from '@/views/product/ProductModifyPage.vue'

//monster
import MonsterListPage from '@/views/monster/MonsterListPage.vue'
import MonsterRegisterPage from '@/views/monster/MonsterRegisterPage.vue'
import MonsterReadPage from '@/views/monster/MonsterReadPage.vue'
import MonsterModifyPage from '@/views/monster/MonsterModifyPage.vue'

// EventBus
import EventBusTestPage from '@/views/eventbus/EventBusTestPage.vue'
// 던전
import DungeonListPage from '@/views/DungeonListPage.vue'

// 삼각형넓이구하기
import TriangleAreaPage from '@/views/area/TriangleAreaPage.vue'
import TriangleAreaPageSpring from '@/views/area/TriangleAreaPageSpring.vue'
import OnlyVuePage from '@/views/area/OnlyVuePage.vue'
import SpringInterconnectionPage from '@/views/area/SpringInterconnectionPage.vue'

// 성적관리 페이지

import ScoreManagerPage from '@/views/score/ScoreManagerPage.vue'

// 크롤링
import DaumNewsCrawlerPage from '@/views/crawler/DaumNewsCrawlerPage.vue'

// Slot
import UnNamedSlotTestPage from '@/views/slot/UnNamedSlotTestPage.vue'
import NamedSlotTestPage from '@/views/slot/NamedSlotTestPage.vue'
import ScopedSlotTestPage from '@/views/slot/ScopedSlotTestPage.vue'
import RecentSlotTestPage from '@/views/slot/RecentSlotTestPage.vue'

// Materialize
import MaterializeTestPage from '@/views/materialize/MaterializeTestPage.vue'
import MaterializeGridTestPage from '@/views/materialize/MaterializeGridTestPage.vue'
import VuetifyAllInOneTestPage from '@/views/materialize/VuetifyAllInOneTestPage.vue'

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
    path: '/triangle',
    name: 'TriangleAreaPage',
    components: {
      default: TriangleAreaPage
    }
  },
  {
    path: '/triangleSpring',
    name: 'TriangleAreaPageSpring',
    components: {
      default: TriangleAreaPageSpring
    }
  },
  {
    path: '/onlyVue',
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
    path: '/materializegrid',
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
]
const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router