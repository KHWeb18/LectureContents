import {
   FETCH_BOARD_LIST,
   FETCH_BOARD,
   FETCH_AUTH_LIST,
   FETCH_DATES_LIST,
   FETCH_BOOK_LIST,
   FETCH_BOOK,
   FETCH_MEMBER_LIST,
   FETCH_MEMBER,
   FETCH_USER_LIST,
   FETCH_USER,
   LOGIN_SUCCESS,
   LOGIN_ERROR,
   LOGOUT,
  CRAWL_START
} from './mutation-types'

export default {
  // 게시판
  [FETCH_BOARD_LIST] (state, boards) {
    state.boards = boards;
  },
  [FETCH_BOARD] (state, board) {
    state.board = board
  },
  [FETCH_DATES_LIST] (state, dates) {
    state.dates = dates;
  },
  [FETCH_AUTH_LIST] (state, auths) {
    state.auths = auths;
  },
  [FETCH_BOOK_LIST] (state, books) {
    state.books = books;
  },
  [FETCH_BOOK] (state, book) {
    state.book = book
  },
  [FETCH_USER_LIST] (state, users) {
    state.users = users;
  },
  [FETCH_USER] (state, user) {
    state.user = user
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
    state.session = null
  },
    // 크롤링
  [CRAWL_START] (state, payload) {
    state.lists = payload
  }
}