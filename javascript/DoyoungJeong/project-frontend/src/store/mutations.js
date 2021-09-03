import {
    FETCH_CONCERT,

    FETCH_MEMBER_LIST,
    FETCH_MEMBER,
    
    CRAWL_FIND,

    FETCH_LIKED_LIST,
    FETCH_LIKED_OR_NOT,

    FETCH_BOARD_LIST,
    FETCH_BOARD,

    FETCH_REPLY_LIST,

    FETCH_DECIDE_OR_NOT,
    FETCH_TASTE

    
} from './mutation-types'

export default {
    [FETCH_CONCERT] (state, concert) {
        state.concert = concert
    },
    
    [FETCH_MEMBER_LIST] (state, members) {
        state.members = members
    },

    [FETCH_MEMBER] (state, member) {
        state.member = member
    },

    [CRAWL_FIND] (state, payload) {
        state.newsList = payload
    },

    [FETCH_LIKED_LIST] (state, payload) {
        state.likedList = payload
    },

    [FETCH_LIKED_OR_NOT] (state, payload) {
        state.notLikedYet = payload
    },

    [FETCH_BOARD_LIST] (state, payload) {
        state.boards = payload
    },

    [FETCH_BOARD] (state, payload) {
        state.board = payload
    },

    [FETCH_REPLY_LIST] (state, payload) {
        state.replyList = payload
    },

    [FETCH_DECIDE_OR_NOT] (state, payload) {
        state.notDecidedYet = payload
    },

    [FETCH_TASTE] (state, payload) {
        state.taste = payload
    }
}