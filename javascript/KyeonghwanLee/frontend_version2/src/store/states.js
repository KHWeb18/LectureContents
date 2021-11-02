export default {
    // TODO
    todoItems: [],
    editingId: 0,
    nextTodoId: 1,
    filter: null,
    // 몬스터
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
    // 판타지 온라인
    monsters: [],
    monster: null,
    //랜덤 던전
    dungeons: [],
    // 성적 관리
    students: [],
    // 크롤링
    lists: []
}
// vue는 데이터를 중앙관리한다.
// 얘가 중앙이야
// 휘발성 메모리
// state가 critical sectino