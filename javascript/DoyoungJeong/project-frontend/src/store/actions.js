import {
    FETCH_CONCERT,
    FETCH_MEMBER_LIST,
    CRAWL_FIND,
    FETCH_LIKED_LIST,
    FETCH_LIKED_OR_NOT

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
        console.log("payload: " + payload)

        const likedOrNotCheckNums = payload //const로 꼭 받는 쪽과 이름을 같게 해줘야한다!

        console.log(likedOrNotCheckNums)

        return axios.put('http://localhost:8888/member/fetchLikedOrNot', { likedOrNotCheckNums })
            .then((res) => {
                commit(FETCH_LIKED_OR_NOT, res.data)
                console.log("This page's likedOrNot is: " + res.data)
            })
    }
}