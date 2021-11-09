// state: 실제 데이터를 중앙관리!, critical section임
// DB연동을 해주어야 함
export default {
// Todo
  todoItems: [],
  editingId: 0,
  nextTodoId: 1,
  filter: null,

// Monster
  monsterElements: [],
  nextMonsterId: 1,
  monsters: [],
  monster: null,
  dungeons: [],

// Spring
  randomFromSpring: 0,

// Board
  boards: [],
  board: null,

// Product
  products: [],
  product: null,

// Quiz
  students: [],

// Crawling
  lists: []
}