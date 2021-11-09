<template>
  <div align="center">
    <h2>게시판 읽기</h2>
    <board-read v-if="board" :board="board"></board-read>
    <p v-else>로딩중..</p>
    <router-link :to="{ name: 'BoardModifyPage', params: { boardNo }}">
      게시물 수정
    </router-link>
    <button @click="onDelete">삭제</button>
    <router-link :to="{ name: 'BoardListPage'}">
      게시물 보기
    </router-link>
  </div>
</template>


<script>
import axios from 'axios'
import BoardRead from '@/components/board/BoardRead'
import { mapState, mapActions } from 'vuex'

export default {
  name: 'BoardReadPage',
  props: {
    boardNo: {
      type: String,
      required: true
    }
  },
  components: {
    BoardRead
  },
  computed: {
    ...mapState(['board'])
  },
  created () {
    this.fetchBoard(this.boardNo).catch(err => {
      alert(err.response.data.message)
      this.$router.push()
    })
  },
  methods: {
    ...mapActions(['fetchBoard']),
    onDelete () {
      const { boardNo } = this.board
      axios.delete(`http://localhost:7777/vueboard/${boardNo}`).then(() => {
        alert('삭제되었습니다')
        this.$router.push({ name: 'BoardListPage' })
      }).catch(err => {
        alert(err.response.data.message)
      })
    }
  }

}
</script>
