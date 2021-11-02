import {
    // 게시판
    FETCH_BOARD_LIST,
    FETCH_BOARD
} from './mutation-types'

import axios from 'axios'
// import router from '../router'

// 보통 action에서 처리하는 것은 비동기 처리를 함
export default {
    // 게시판
    fetchBoardList ({ commit }) {
        return axios.get('http://localhost:7777/noticeboard/lists')
                .then((res) => {
                    commit(FETCH_BOARD_LIST, res.data)
                })
    },
    fetchBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/noticeboard/${boardNo}`)
                .then((res) => {
                    commit(FETCH_BOARD, res.data)
                })
    }
}