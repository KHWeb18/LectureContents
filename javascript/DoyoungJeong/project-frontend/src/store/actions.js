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

import axios from 'axios'

export default {

    fetchConcert({ commit }, num) {
        return axios.get(`http://localhost:8888/concert/${num}`)
            .then((res) => {
                commit(FETCH_CONCERT, res.data)
            })
            .catch(err => {
                alert(err.response.data.message)
            })
    },

    fetchMemberList({ commit }) {
        return axios.get('http://localhost:8888/member/list')
            .then((res) => {
                commit(FETCH_MEMBER_LIST, res.data)
            })
    },

    fetchMember({ commit }, memberNo) {
        return axios.get(`http://localhost:8888/member/read/${memberNo}`)
            .then((res) => {
                commit(FETCH_MEMBER, res.data)
                //alert(JSON.stringify(res.data))
            })
    },

    async crawlFind({ commit }, keyword) {
        axios.get(`http://localhost:8888/${keyword}`)
            .then(({ data }) => {
                commit(CRAWL_FIND, data)

                
            })
    },
    
    fetchLikedList({ commit }, payload) { //한 회원의 좋아요한 공연 리스트 뽑아오기
       
        const memberNo = payload

        return axios.put(`http://localhost:8888/concert/likedList/${ memberNo }`)
            .then((res) => {
                commit(FETCH_LIKED_LIST, res.data)
            })
    },

    fetchLikedOrNot({ commit }, payload) {
        //console.log("payload: " + payload)

        const likedOrNotCheckNums = payload //const로 꼭 받는 쪽과 이름을 같게 해줘야한다!

        //console.log(likedOrNotCheckNums)

        return axios.put('http://localhost:8888/member/fetchLikedOrNot', { likedOrNotCheckNums })
            .then((res) => {
                commit(FETCH_LIKED_OR_NOT, res.data)
                //console.log("This page's likedOrNot is: " + res.data)
            })
    },

    fetchBoardList({ commit }) {
        return axios.get('http://localhost:8888/board/list')
            .then((res) => {
                commit(FETCH_BOARD_LIST, res.data)
            })
    },

    fetchBoard({ commit }, num) {

        const boardNo = num
        //console.log('boardNo' + boardNo)

        return axios.get(`http://localhost:8888/board/read/${ boardNo }`)
            .then((res) => {
                commit(FETCH_BOARD, res.data)
            })
    },

    fetchReplyList({ commit }, num) {

        const boardNo = num
        //console.log('boardNo' + boardNo)

        return axios.get(`http://localhost:8888/board/replyList/${ boardNo }`)
            .then((res) => {
                commit(FETCH_REPLY_LIST, res.data)
            })
    },

    fetchAlreadyDecidePrefOrNot({ commit }, num) {
        
        return axios.get(`http://localhost:8888/member/taste/alreadyDecidePref/${ num }`)
            .then(res => {
                commit(FETCH_DECIDE_OR_NOT, res.data)
            })
    },

    fetchTaste({ commit }, num) {

        return axios.get(`http://localhost:8888/member/taste/getTaste/${ num }`)
            .then(res => {
                commit(FETCH_TASTE, res.data)
                //alert('res.data:' + JSON.stringify(res.data))
            })
    },

    fetchUserName({ commit }, num) {
        return axios.get(`http://localhost:8888/member/concertRegister/getName/${ num }`)
            .then(res => {
                commit(FETCH_USER_NAME, res.data)
            })
    },

    fetchConcertRequestList({ commit }) {
        return axios.get('http://localhost:8888/member/concertRegister/getConcertRequestList')
            .then(res => {
                commit(FETCH_CONCERT_REQUEST_LIST, res.data)
            })
    },
    
    fetchConcertRequest({ commit }, num) {
        return axios.get(`http://localhost:8888/member/concertRegister/getConcertRequest/${ num }`)
            .then(res => {
                commit(FETCH_CONCERT_REQUEST, res.data)
                //alert(JSON.stringify(res.data))
            })
    },

    fetchMyRequestList({ commit }, num) {
        return axios.get(`http://localhost:8888/member/concertRegister/getMyRequestList/${ num }`)
            .then(res => {
                commit(FETCH_MY_REQUEST_LIST, res.data)
                //alert(JSON.stringify(res.data))
            })
    },

    fetchBookedOrNot({ commit }, payload) {
        //console.log("payload: " + payload)

        const likedOrNotCheckNums = payload // ** 원래 변수명을 bookedOrNotCheckNums라고 해줘야하지만 스프핑을 바꿔줘야해서 그냥 likedOrNotCheckNums로 간다.

        //alert(JSON.stringify({ likedOrNotCheckNums }))

        return axios.post('http://localhost:8888/concert/fetchBookedOrNot', { likedOrNotCheckNums })
            .then((res) => {
                commit(FETCH_BOOKED_OR_NOT, res.data)
                //console.log("This page's likedOrNot is: " + res.data)
            })
    },

    fetchBookedList({ commit }, num) {
        return axios.get(`http://localhost:8888/concert/fetchBookedList/${ num }`)
            .then(res => {
                commit(FETCH_BOOKED_LIST, res.data)
                //alert(JSON.stringify(res.data))
            })
    },

    fetchBookedConcert({ commit }, num) {
        return axios.get(`http://localhost:8888/concert/fetchBookedConcert/${ num }`)
            .then(res => {
                commit(FETCH_BOOKED_CONCERT, res.data)
                //alert(JSON.stringify(res.data))
            })
    }
}