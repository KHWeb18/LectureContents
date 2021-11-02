import { 
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,

    // 크롤링
    CRAWL_START
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
    }
}