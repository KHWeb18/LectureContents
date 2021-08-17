import {
   // 게시판
   FETCH_BOARD_LIST,
   FETCH_BOARD,
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