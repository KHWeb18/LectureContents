import {
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,

    // 크롤링
    CRAWL_START
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
    }
}