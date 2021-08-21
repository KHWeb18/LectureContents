import {
    FETCH_CONCERT,
    FETCH_MEMBER_LIST,
    
    CRAWL_FIND,

    FETCH_LIKED_LIST,
    FETCH_LIKED_OR_NOT
    
} from './mutation-types'

export default {
    [FETCH_CONCERT] (state, concert) {
        state.concert = concert
    },
    [FETCH_MEMBER_LIST] (state, members) {
        state.members = members
    },

    [CRAWL_FIND] (state, payload) {
        state.newsList = payload
    },

    [FETCH_LIKED_LIST] (state, payload) {
        state.likedList = payload
    },

    [FETCH_LIKED_OR_NOT] (state, payload) {
        state.notLikedYet = payload
    }
}