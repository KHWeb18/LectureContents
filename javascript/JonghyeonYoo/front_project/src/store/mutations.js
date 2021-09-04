import{
    // 게시판
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    // 크롤링
    CRAWL_START
} from './mutation-types'


export default{
        // 게시판
    [FETCH_BOARD_LIST] (state, boards) {
        state.boards = boards;
    },
    [FETCH_BOARD] (state, board) {
        state.board = board
    },
 
            // 크롤링
        
            [CRAWL_START] (state, payload) {
                state.lists = payload
            },
    loginSuccess(state) {
        state.isLogin = true
        state.isLoginError = false
    },
    loginError(state) {
        state.isLogin = false
        state.isLoginError = true
    }
}
