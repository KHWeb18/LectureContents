import {
   // 게시판
   FETCH_BOARD_LIST,
   FETCH_BOARD,
   // 회원관리
   FETCH_MEMBER_LIST,
   FETCH_MEMBER,
   // 로그인 로그아웃
   LOGIN_SUCCESS,
   LOGIN_ERROR,
   LOGOUT,
     // 크롤링
  CRAWL_START
} from './mutation-types'

// 여기는 동기 처리를 하기 때문에 데이터 무결성이 보장됨
export default {
  // 게시판
  [FETCH_BOARD_LIST] (state, boards) {
    state.boards = boards;
  },
  [FETCH_BOARD] (state, board) {
    state.board = board
  },
    // 관리자 로그인 로그아웃
  [LOGIN_SUCCESS] (state, payload) {
    state.isManagerLogin = true
    state.isManagerLoginError = false
    state.userInfo = payload
  },
  // 로그인 실패했을때
  [LOGIN_ERROR] (state){
    state.isManagerLogin = false
    state.isManagerLoginError = true
  },
  // 로그아웃
  [LOGOUT] (state) {
    state.isManagerLogin = false
    state.isManagerLoginError = false
    state.userInfo = null
  },
  // 회원 관리
  [FETCH_MEMBER_LIST] (state, members) {
    state.members = members;
  },
  [FETCH_MEMBER] (state, member) {
    state.member = member
  },

  // 로그인이 성공했을 때,
  [LOGIN_SUCCESS] (state, payload) {
    state.isLogin = true
    state.isLoginError = false
    state.userInfo = payload
  },
  // 로그인 실패했을때
  [LOGIN_ERROR] (state){
    state.isLogin = false
    state.isLoginError = true
  },
  // 로그아웃
  [LOGOUT] (state) {
    state.isLogin = false
    state.isLoginError = false
    state.userInfo = null
  },
    // 크롤링
  [CRAWL_START] (state, payload) {
    state.lists = payload
  }
}