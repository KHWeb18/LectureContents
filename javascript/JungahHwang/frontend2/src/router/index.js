import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Test from '../views/Test.vue'
import Todo from '../views/Todo.vue'
import Monster from '@/views/monster/Monster.vue'

// Reference
import Reference from '@/views/reference/Reference'
import CoverFlowPage from '@/views/reference/CoverFlowPage'
import AwesomeSwiperPage from '@/views/reference/AwesomeSwiperPage'
import ImageGalleryPage from '@/views/reference/ImageGalleryPage'
import CalendarPage from '@/views/reference/CalendarPage'
import FileUploadPage from '@/views/reference/FileUploadPage'

// Quiz
import Quiz from '@/views/quiz/Quiz'
import StudentScorePage from '@/views/quiz/StudentScorePage'
import TriangleVuePage from '@/views/quiz/TriangleVuePage'
import TriangleSpringPage from '@/views/quiz/TriangleSpringPage'
import MemberJpaPage from '@/views/quiz/MemberJpaPage'

// Monster
import MonsterSignupPage from '@/views/monster/MonsterSignupPage'
import MonsterCreatePage from '@/views/monster/MonsterCreatePage'
import MonsterGuidePage from '@/views/monster/MonsterGuidePage'
import MonsterReadPage from '@/views/monster/MonsterReadPage'
import MonsterModifyPage from '@/views/monster/MonsterModifyPage'
import MonsterDungeonPage from '@/views/monster/MonsterDungeonPage'

// Board
import BoardListPage from '@/views/board/BoardListPage.vue'
import BoardRegisterPage from '@/views/board/BoardRegisterPage.vue'
import BoardReadPage from '@/views/board/BoardReadPage'
import BoardModifyPage from '@/views/board/BoardModifyPage'

// Product
import ProductListPage from '@/views/product/ProductListPage'
import ProductRegisterPage from '@/views/product/ProductRegisterPage'
import ProductReadPage from '@/views/product/ProductReadPage'
import ProductModifyPage from '@/views/product/ProductModifyPage'

// 삼목
import Concave from '@/views/lecture/Concave'

// EventBus
import EventBusTestPage from '@/views/lecture/EventBusTestPage'

// Crawling
import DaumNewsCrawlerPage from '@/views/jpa/DaumNewsCrawlerPage'

// Slot
import Slot from '@/views/slot/Slot'
import UnNamedSlotPage from '@/views/slot/UnNamedSlotPage'
import NamedSlotPage from '@/views/slot/NamedSlotPage'
import ScopedSlotPage from '@/views/slot/ScopedSlotPage'
import RecentSlotPage from '@/views/slot/RecentSlotPage'

// Materialize
import MaterializePage from '@/views/materialize/MaterializePage'
import MaterialGridPage from '@/views/materialize/MaterialGridPage'

// Vuetify
import VuetifyPage from '@/views/vuetify/VuetifyPage'

// Join Column / Secuity
import MemberJoinColumnPage from '@/views/jpa/MemberJoinColumnPage'
import MemberLoginPage from '@/views/jpa/MemberLoginPage'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    // path: 실제 url 맵핑 경로
    path: '/test',
    // 보편적으로 name과 component는 같은 이름을 사용,
    // 눈에 보여질 페이지가 배치(보통 views 폴더에 생성)
    name: 'Test',
    component: Test
  },

// Reference
  {
    path: '/reference',
    name: 'Reference',
    component: Reference
  },
  {
    path: '/reference/coverflow',
    name: 'CoverFlowPage',
    component: CoverFlowPage
  },
  {
    path: '/reference/awesomeSwiper',
    name: 'AwesomeSwiperPage',
    component: AwesomeSwiperPage
  },
  {
    path: '/reference/imageGallery',
    name: 'ImageGalleryPage',
    component: ImageGalleryPage
  },
  {
    path: '/reference/calendar',
    name: 'CalendarPage',
    component: CalendarPage
  },
  {
    path: '/reference/fileUpload',
    name: 'FileUploadPage',
    component: FileUploadPage
  },

  // Quiz 
  {
    path: '/quiz',
    name: 'Quiz',
    component: Quiz
  },
  {
    path: '/quiz/stuent',
    name: 'StudentScorePage',
    component: StudentScorePage
  },
  {
    path: '/quiz/triangleVue',
    name: 'TriangleVuePage',
    component: TriangleVuePage
  },
  {
    path: '/quiz/triangleSpring',
    name: 'TriangleSpringPage',
    component: TriangleSpringPage
  },
  {
    path: '/quiz/member',
    name: 'MemberJpaPage',
    component: MemberJpaPage
  },
    
// Todo
  {
    path: '/todo',
    name: 'Todo',
    component: Todo
  },

// Monster
  {
    path: '/monster',
    name: 'Monster',
    component: Monster
  },
  {
    path: '/monster/signup',
    name: 'MonsterSignupPage',
    components: {
      default: MonsterSignupPage
    }
  },
  {
    path: '/monster/create',
    name: 'MonsterCreatePage',
    components: {
      default: MonsterCreatePage
    }
  },
  {
    path: '/monster/guide',
    name: 'MonsterGuidePage',
    components: {
      default: MonsterGuidePage
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
    path: '/dungeon',
    name: 'MonsterDungeonPage',
    components: {
      default: MonsterDungeonPage
    }
  },

// Board
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
    // 라우터 파라미터를 props에 자동으로 설정하게 서포트
    props: {
      default: true
    } 
  },

// Product
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

// 삼목
  {
    path: '/concave',
    name: 'Concave',
    components: {
      default: Concave
    }
  },

// EventBus
  {
    path: '/eventbus',
    name: 'EventBusTestPage',
    components: {
      default: EventBusTestPage
    }
  },

// Crawling
  {
    path: '/daumNewsCrawler',
    name: 'DaumNewsCrawlerPage',
    components: {
      default: DaumNewsCrawlerPage
    }
  },

// Slot
  {
    path: '/slot',
    name: 'Slot',
    components: {
      default: Slot
    }
  },
  {
    path: '/slot/unNamed',
    name: 'UnNamedSlotPage',
    components: {
      default: UnNamedSlotPage
    }
  },
  {
    path: '/slot/named',
    name: 'NamedSlotPage',
    components: {
      default: NamedSlotPage
    }
  },
  {
    path: '/slot/scoped',
    name: 'ScopedSlotPage',
    components: {
      default: ScopedSlotPage
    }
  },
  {
    path: '/slot/v',
    name: 'RecentSlotPage',
    components: {
      default: RecentSlotPage
    }
  },

// Materialize
  {
    path: '/material',
    name: 'MaterializePage',
    components: {
      default: MaterializePage
    }
  },
  {
    path: '/material/grid',
    name: 'MaterialGridPage',
    components: {
      default: MaterialGridPage
    }
  },

// Vuetify
  {
    path: '/vuetify',
    name: 'VuetifyPage',
    components: {
      default: VuetifyPage
    }
  },

// Join Column / Security
  {
    path: '/joinColumn',
    name: 'MemberJoinColumnPage',
    components: {
      default: MemberJoinColumnPage
    }
  },
  {
    path: '/joinColumn/login',
    name: 'MemberLoginPage',
    components: {
      default: MemberLoginPage
    }
  },
  
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
