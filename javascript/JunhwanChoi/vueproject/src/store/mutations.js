import { 
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,

    // 크롤링
    CRAWL_START,

    COVID_CRAWL_START,


     // 세션
     //FETCH_SESSION,


     // 게시판
    FETCH_BOARD_LIST,
    FETCH_BOARD,

    // 게시판
    FETCH_BOOK_LIST,
    FETCH_BOOK,
} from './mutation-types'

export default {
    // 게시판
    [FETCH_MEMBER_LIST] (state, members) {
        state.members = members;
    },
    [FETCH_MEMBER] (state, member) {
        state.member = member
    },

    [CRAWL_START] (state, payload) {
        state.lists = payload
    },

     [COVID_CRAWL_START] (state, payload) {
        state.covidlists = payload
    },

    // [FETCH_SESSION] (state) {
    //     state.session = this.$cookies.get(userSession)
    // },

    // 게시판
    [FETCH_BOARD_LIST] (state, boards) {
        state.boards = boards;
    },
    [FETCH_BOARD] (state, board) {
        state.board = board
    },

    // 게시판
    [FETCH_BOOK_LIST] (state, books) {
        state.books = books;
    },
    [FETCH_BOOK] (state, book) {
        state.book = book
    },



}