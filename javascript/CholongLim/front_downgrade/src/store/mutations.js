import {
  ADD_TODO, 
  EDIT_TODO,
  REMOVE_TODO,
  SET_EDITTING_ID,
  RESET_EDITTING_ID,
  CLEAR_ALL,
  TOGGLE_TODO_STATUS,
  // 몬스터
  ADD_MONSTER,
  ADD_MANY_MONSTER,
  DEATH,
  // 스프링 랜덤 데이터 통신
  SUCCESS_GEN_RAND_NUM,
  FAIL_GEN_RAND_NUM,
  // 게시판
  FETCH_BOARD_LIST,
  FETCH_BOARD,
  // 상품
  FETCH_PRODUCT_LIST,
  FETCH_PRODUCT,
  // 몬스터북
  FETCH_MONSTER_LIST,
  FETCH_MONSTER,
  // Dungeon
  ALLOC_RANDOM_DUNGEON,
  // 성적 관리
  SCORE_MANAGEMENT,
  // 크롤링
  CRAWL_START
} from './mutation-types'

// 여기는 동기 처리를 하기 때문에 데이터 무결성이 보장됨
export default {
  [ADD_TODO] (state, payload) {
    const { content } = payload
    state.todoItems.push({ id: state.nextTodoId, content, done: false })
    state.nextTodoId++
  },
  [REMOVE_TODO] (state, id) {
    const targetIndex = state.todoItems.findIndex(v => v.id === id)
    state.todoItems.splice(targetIndex,1)
  },
  [EDIT_TODO] (state, payload) {
    const { id, content } = payload
    const targetIndex = state.todoItems.findIndex(v => v.id === id)
    const targetTodoItem = state.todoItems[targetIndex]
    state.todoItems.splice(targetIndex, 1, { ...targetTodoItem, content })
  },
  [SET_EDITTING_ID] (state, id) {
    state.editingId = id
  },
  [RESET_EDITTING_ID] (state) {
    state.editingId = 0
  },
  [CLEAR_ALL] (state) {
    state.todoItems = []
  },
  [TOGGLE_TODO_STATUS] (state, id) {
    // 현재 todoItems 배열에서 id로 들어온 todoItem을 찾는다.
    const filtered = state.todoItems.filter(todoItem => {
      return todoItem.id === id
    })

    console.log('filtered: ' + JSON.stringify(filtered))

    filtered.forEach(todoItem => {
      todoItem.done = !todoItem.done
    })
  },
  // 판타지 온라인
  [ADD_MONSTER] (state, payload) {
    const { name } = payload
    state.monsterElements.push({ monsterId:state.nextMonsterId, name })
    state.nextMonsterId++
  },
  [ADD_MANY_MONSTER] (state, payload) {
    for(var i =0; i< payload.length; i++){
      state.monsterElements.push(payload[i])
      state.nextMonsterId++
    }
  },
  [DEATH] (state, monsterId) {
    const targetIndex = state.monsterElements.findIndex(v => v.monsterId === monsterId)
    state.monsterElements.splice(targetIndex, 1)
  },
  // 스프링 랜덤 데이터 통신
  [SUCCESS_GEN_RAND_NUM] (state, payload) {
    console.log('payload = ' + payload)
    state.randomFromSpring = payload
  },
  [FAIL_GEN_RAND_NUM] () {
    console.log('통신 에러!')
  },
// 게시판
  [FETCH_BOARD_LIST] (state, boards) {
    state.boards = boards;
  },
  [FETCH_BOARD] (state, board) {
    state.board = board
  },
  // 상품
  [FETCH_PRODUCT_LIST] (state, products) {
    state.products = products;
  },
  [FETCH_PRODUCT] (state, product) {
    state.product = product
  },
  // 몬스터북
  [FETCH_MONSTER_LIST] (state, monsters) {
    state.monsters = monsters;
  },
  [FETCH_MONSTER] (state, monster) {
    state.monster = monster
  },
  [ALLOC_RANDOM_DUNGEON] (state, dungeons) {
    state.dungeons = dungeons
  },
    // 성적 관리
  [SCORE_MANAGEMENT] (state, students) {
    state.students = students
  },
  // 크롤링
  [CRAWL_START] (state, payload) {
    state.lists = payload
  }
}