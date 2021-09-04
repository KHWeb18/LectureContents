<template>
  <div align="center">

    <board-modify-form v-if="board" :board="board" @submit="onSubmit" />
    <p v-else>로딩중....</p>
  </div>
</template>

<script>
import BoardModifyForm from "@/components/board/BoardModifyForm";
import { mapState, mapActions } from "vuex";
import axios from "axios";

export default {
  name: "BoardModifyPage",
  components: {
    BoardModifyForm,
  },
  props: {
    boardNo: {
      type: String,
      required: true,
    },
  },
    computed: {
      ...mapState(['board'])
  },
  methods: {
      ...mapActions(['fetchBoard']),
      onSubmit (payload) {
          const { title, content } = payload
          axios.put(`http://localhost:1111/vueboard/${this.boardNo}`, {title, content})
          .then(res => {
              alert('수정 성공!')
            this.$router.push({
                name: 'BoardReadPage',
                params: { boardNo: res.data.boardNo.toString()}
            })
          })
          .catch(err => {
              alert(err.reponse.data.message)
          })
      }
  },
  created () {
      this.fetchBoard(this.boardNo)
      .catch(err => {
          alert(err.reponse.data.message)
          this.$router.back()
      })
  },
};
</script>