<template>
  <div align="center">
    <h2>게시물 수정하기</h2>
    <board-modify-form v-if="board" :board="board" @submit="onSubmit"/>
    <p v-else>로딩중 ... </p>
  </div>
</template>

<script lang="ts">
  import { Component, Vue, Prop } from 'vue-property-decorator'
  import { State, Action } from 'vuex-class'
  import BoardModifyForm from '@/components/board/BoardModifyForm.vue'
  import AxiosService from '@/service'
  import { Board } from '@/store'

  @Component({
    components: {
      BoardModifyForm
    }
  })

  export default class BoardModifyPage extends Vue {
    @Prop() boardNo!: number

    @State readonly board!: Board

    @Action readonly fetchBoard: any

    created () {
      this.fetchBoard(this.boardNo)
        .catch((err: any) => {
          alert(err.response.data.message)
          this.$router.back()
        })
    }
    onSubmit (payload: Board) {
      const { boardNo } = this.board
      AxiosService.instance.post(`/board/modify`, payload)
        .then ((res) => {
          alert('수정 완료!')
          this.$router.push({ name: 'BoardReadPage', params: { boardNo: res.data.toString() } })
        })
        .catch ((err) => {
          alert(err.response.data.message)
        })
    }
  }
</script>