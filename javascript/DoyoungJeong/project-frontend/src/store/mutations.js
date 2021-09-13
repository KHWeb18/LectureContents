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
    FETCH_TASTE,
    
    FETCH_USER_NAME,

    FETCH_CONCERT_REQUEST_LIST,
    FETCH_CONCERT_REQUEST,
    FETCH_MY_REQUEST_LIST,

    FETCH_BOOKED_OR_NOT,
    FETCH_BOOKED_LIST,
    FETCH_BOOKED_CONCERT

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
    },

    [FETCH_USER_NAME] (state, payload) {
        state.userName = payload
    },

    [FETCH_CONCERT_REQUEST_LIST] (state, payload) {
        state.concertRequestList = payload
    },

    [FETCH_CONCERT_REQUEST] (state, payload) {
        state.concertRequest = payload
    },

    [FETCH_MY_REQUEST_LIST] (state, payload) {
        state.myRequestList = payload
    },

    [FETCH_BOOKED_OR_NOT] (state, payload) {
        state.notBookedYet = payload
    },

    [FETCH_BOOKED_LIST] (state, payload) {
        state.bookedList = payload
    },

    [FETCH_BOOKED_CONCERT] (state, payload) {
        state.bookedConcert = payload
    }
}