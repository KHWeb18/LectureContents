// 받은 값을 동기 처리하여 todoItem에 넣어줌
// 받은 값을 DB에 저장해주어야 함
export default {
  todoItems: [],
  editingId: 0,
  nextTodoId: 1,
  filter: null,
  //몬스터
  monsterElements: [],
  nextMonsterId: 1,
  // 스프링과 랜덤 데이터 통신
  randomFromSpring: 0,
  // 게시판
  boards: [],
  board: null,
  // 상품
  products: [],
  product: null,
  // 몬스터북
  monsters: [],
  monster: null,
  // 던전
  dungeons: [],
  // 성적관리
  students: [],
  // 크롤링
  lists: [],
  session: [],

  //로그인 연습
  allUsers:[
    {id: 1, name: 'cholong', email: 'cholong@gmail.com', password: "1111"},
    {id: 2, name: 'rara', email: 'rara@gmail.com', password: "1111"}
  ],
  isLogin: false,
  isLoginError: false,
  // 서버에서 보내준 유저 정보
  userInfo: null,
  // 파이썬 기반 크롤링
  pyLists: []
}