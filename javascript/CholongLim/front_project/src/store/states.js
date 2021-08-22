// 받은 값을 동기 처리하여 todoItem에 넣어줌
// 받은 값을 DB에 저장해주어야 함
export default {
  // 게시판
  boards: [],
  board: null,
  // 회원 관리
  members: [],
  member: null,
  //
  search:[],
  // 로그인
  memberRequest: null,
  isLogin: false,
  isLoginError: false,
  userInfo: null,
    // 크롤링
  lists: []
}