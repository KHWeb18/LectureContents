import { 
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,

    // 크롤링
    CRAWL_START,

    COVID_CRAWL_START,


     // 세션
     //FETCH_SESSION
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


}