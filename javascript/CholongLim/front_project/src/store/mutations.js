import {
   // 게시판
   FETCH_BOARD_LIST,
   FETCH_BOARD,
   // 로그인 로그아웃
   FETCH_LOGOUT
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
  [FETCH_LOGOUT] (state, logout) {
    state.logout = logout
  }
}