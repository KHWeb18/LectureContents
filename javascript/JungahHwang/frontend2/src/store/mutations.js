// mutation: 동기 처리를 하기 때문에 데이터 무결성이 보장
// (동기처리만 하면 되는 것은 mutation만 작성, 비동기처리도 해야하는 것은 action까지 작성)

import {
// Todo
  ADD_TODO,
  REMOVE_TODO,
  EDIT_TODO,
  SET_EDITING_ID,
  RESET_EDITING_ID,
  CLEAR_ALL,
  TOGGLE_TODO_STATUS,

// Monster
  ADD_MONSTER,
  DEATH,
  ADD_MANY_MONSTER,
  FETCH_MONSTER_LIST,
  FETCH_MONSTER,
  ALLOC_RANDOM_DUNGEON,

// Spring
  SUCCESS_GEN_RAND_NUM,
  FAIL_GEN_RAND_NUM,

// Board
  FETCH_BOARD_LIST,
  FETCH_BOARD,

// Product
  FETCH_PRODUCT_LIST,
  FETCH_PRODUCT,

// Quiz
  FETCH_STUDENT_SCORE,
  CALC_MEAN,

// Crawling
  CRAWL_START

} from './mutation-types'

export default {
// Todo
  [ADD_TODO] (state, payload) {
    const { content } = payload
    // false: todo를 실행하지 않았으므로 초기값은 false, todo를 하고 체크하면 true가 되도록
    // 받은 값을 todoItem에 저장
    state.todoItems.push({ id: state.nextTodoId, content, done: false })
    state.nextTodoId++
  },
  [REMOVE_TODO] (state, id) {
    const targetIndex = state.todoItems.findIndex(v => v.id === id)
    state.todoItems.splice(targetIndex, 1)
  },
  [EDIT_TODO] (state, payload) {
    const { id, content } = payload
    const targetIndex = state.todoItems.findIndex(v => v.id === id)
    const targetTodoItem = state.todoItems[targetIndex]
    state.todoItems.splice(targetIndex, 1, {...targetTodoItem, content})
  },
  [SET_EDITING_ID] (state, id) {
    state.editingId = id
  },
  [RESET_EDITING_ID] (state) {
    state.editingId = 0
  },
  [CLEAR_ALL] (state) {
    state.todoItems = []
  },
  [TOGGLE_TODO_STATUS] (state, id) {
    // 현재 todoItems 배열에 id로 들어온 todoItem을 찾음(id값을 비교하고 해당하는 todoItem을 찾음)
    const filtered = state.todoItems.filter(todoItem => {
      return todoItem.id === id
    })
    // json형식의 데이터를 상세하게 볼 수 있음
    console.log('filtered: ' + JSON.stringify(filtered))

    filtered.forEach(todoItem => {
      todoItem.done = !todoItem.done
    })
  },

// Monster
  [ADD_MONSTER] (state, payload) {
    const { name } = payload
    state.monsterElements.push({ monsterId: state.nextMonsterId, name })
    state.nextMonsterId++
  },
  [DEATH] (state, monsterId) {
    const targetIndex = state.monsterElements.findIndex(v => v.monsterId === monsterId)
    state.monsterElements.splice(targetIndex, 1)
  },
  [ADD_MANY_MONSTER] (state, payload) {
    for (var i = 0; i < payload.length; i++) {
      state.monsterElements.push(payload[i])
      state.nextMonsterId++
    }
  },
  [FETCH_MONSTER_LIST] (state, monsters) {
    state.monsters = monsters
  },
  [FETCH_MONSTER] (state, monster) {
    state.monster = monster
  },
  [ALLOC_RANDOM_DUNGEON] (state, dungeons) {
    state.dungeons = dungeons
  },

// Spring
  [SUCCESS_GEN_RAND_NUM] (state, payload) {
    console.log('payload: ' + payload)
    state.randomFromSpring = payload
  },
  [FAIL_GEN_RAND_NUM] () {
    console.log('통신에러!')
  },
  
// Board
  [FETCH_BOARD_LIST] (state, boards) {
    state.boards = boards
  },
  [FETCH_BOARD] (state, board) {
    state.board = board
  },

// Product
  [FETCH_PRODUCT_LIST] (state, products) {
    state.products = products
  },
  [FETCH_PRODUCT] (state, product) {
    state.product = product
  },

// Quiz
  [FETCH_STUDENT_SCORE] (state, students) {
    state.students = students
  },
  [CALC_MEAN] (state) {
    state.mean = 0
    var tmp = 0
    var len = state.students.length

    for (var i = 0; i < len; i++) {
        tmp += state.students[i].score
    }

    state.mean = tmp / len
  },

// Crawling
  [CRAWL_START] (state, payload) {
    state.lists = payload
  }
}