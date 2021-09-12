import {
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,

    // 크롤링
    CRAWL_START,

    COVID_CRAWL_START,

    // 세션
    FETCH_SESSION,

    //게시판
    FETCH_BOARD_LIST,
    FETCH_BOARD,

} from './mutation-types'

import axios from 'axios'

export default {

    fetchMemberList ({ commit }) {
        return axios.get('http://localhost:3647/project/lists')
                .then((res) => {
                    commit(FETCH_MEMBER_LIST, res.data)
                })
    },
    fetchMember ({ commit }, memberNo) {
        return axios.get(`http://localhost:3647/project/${memberNo}`)
                .then((res) => {
                    commit(FETCH_MEMBER, res.data)
                })
    },

    // 크롤링
    async crawlFind ({ commit }, category) {
        axios.get('http://localhost:3647/' + `${category}`)
                .then(({ data }) => {
                    commit(CRAWL_START, data)

                    // if (window.location.pathname !== '/daumNewsCrawler') {
                    //     router.push('/daumNewsCrawler')
                    // }
                })
    },

    // 크롤링
    async covidCrawlFind ({ commit }, covidcategory) {
        axios.get('http://localhost:3647/covidtest/' + `${covidcategory}`)
                .then(({ data }) => {
                    commit(COVID_CRAWL_START, data)

                    // if (window.location.pathname !== '/daumNewsCrawler') {
                    //     router.push('/daumNewsCrawler')
                    // }
                })
    },
    // Session
    fetchSession ({ commit }) {
        commit(FETCH_SESSION)
    },

    // 게시판
    fetchBoardList ({ commit }) {
        return axios.get('http://localhost:3647/vueboard/lists')
                .then((res) => {
                    commit(FETCH_BOARD_LIST, res.data)
                })
    },
    fetchBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:3647/vueboard/${boardNo}`)
                .then((res) => {
                    commit(FETCH_BOARD, res.data)
                })
    },

    // 예약
    fetchBookList ({ commit }) {
        return axios.get('http://localhost:3647/book/lists')
                .then((res) => {
                    commit(FETCH_BOARD_LIST, res.data)
                })
    },
    fetchBook ({ commit }, bookNo) {
        return axios.get(`http://localhost:3647/book/${bookNo}`)
                .then((res) => {
                    commit(FETCH_BOARD, res.data)
                })
    },
}