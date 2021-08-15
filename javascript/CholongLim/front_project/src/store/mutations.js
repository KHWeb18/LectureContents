import {
   // 게시판
   FETCH_BOARD_LIST,
   FETCH_BOARD,
   // 로그인 로그아웃
   LOGIN,
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
  // 로그인
  [LOGIN] (state) {
      state.isLogin = false
    
  },
    // 크롤링
  [CRAWL_START] (state, payload) {
    state.lists = payload
  }
}