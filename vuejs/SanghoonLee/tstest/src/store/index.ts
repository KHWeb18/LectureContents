import Vue from 'vue'
import Vuex, { StoreOptions } from 'vuex'
import AxiosService from '@/service'
import {
  FETCH_BOARD_LIST,
  FETCH_BOARD
} from './mutation-types'

Vue.use(Vuex)

export interface Board {
  boardNo: number
  title: string
  writer: string
  content: string
  regDate: string
}

interface BoardState {
  boards: Board[]
  board: Board
}

const store: StoreOptions<BoardState> = {
  state: {
    boards: [],
    board: { boardNo: 0, title: '', writer: '', content: '', regDate: '' }
  },
  mutations: {
    [FETCH_BOARD_LIST] (state, boards: Board[]) {
      state.boards = boards
    },
    [FETCH_BOARD] (state, board: Board) {
      state.board = board
    }
  },
  actions: {
    fetchBoardList({ commit }) {
      return AxiosService.instance.get('/board/lists')
        .then((res) => {
          commit(FETCH_BOARD_LIST, res.data)
        })
    },
    fetchBoard({ commit }, boardNo: number) {
      return AxiosService.instance.get(`/board/${boardNo}`)
        .then((res) => {
          commit(FETCH_BOARD, res.data)
        })
    }
  },
  modules: {
  }
}

export default new Vuex.Store(store)