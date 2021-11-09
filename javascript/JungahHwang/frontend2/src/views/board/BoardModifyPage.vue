<template>
  <div align="center">
    <h2>게시물 수정</h2>
    <board-modify-form v-if="board" :board="board" @submit="onSubmit"></board-modify-form>
    <p v-else>로딩중..</p>
  </div>
</template>


<script>
import axios from 'axios'
import BoardModifyForm from '@/components/board/BoardModifyForm'
import { mapActions, mapState } from 'vuex'

export default {
  name: 'BoardModifyPage',
  components: {
    BoardModifyForm
  },
  props: {
    boardNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['board'])
  },
  methods: {
    ...mapActions(['fetchBoard']),
    onSubmit (payload) {
      const { title, content } = payload
      axios.put(`http://localhost:7777/vueboard/${this.boardNo}`, { title, content }).then(res => {
        alert('수정이 완료되었습니다')
        // router.push: router-link :to 와 같은 역할
        this.$router.push({
          name: 'BoardReadPage',
          params: { boardNo: res.data.boardNo.toString() }
        })
      }).catch(err => {
        alert(err.response.data.message)
      })
    }
  },
  created () {
    this.fetchBoard(this.boardNo).catch(err => {
      alert(err.response.data.message)
      this.$router.back()
    })
  }
}
</script>