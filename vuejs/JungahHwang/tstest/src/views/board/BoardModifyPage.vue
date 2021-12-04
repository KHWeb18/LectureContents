<template>
  <div align="center">
    <h2>게시물 수정하기</h2>
    <board-modify :board="board" @submit="onSubmit"/>
  </div>
</template>


<script lang="ts">
  import { Component, Vue, Prop } from 'vue-property-decorator'
  import { State, Action } from 'vuex-class'
  import BoardModify from '@/components/board/BoardModify.vue'
  import { Board } from '@/store'
  import AxiosService from '@/service'

  @Component({
    components: {
      BoardModify
    }
  })

  export default class BoardReadPage extends Vue {
    @Prop() boardNo!: number

    @State readonly board!: Board

    @Action readonly fetchBoard: any

    created () {
      this.fetchBoard(this.boardNo)
    }

   onSubmit(payload: Board) {
      AxiosService.instance.post(`/board/modify`, payload)
      .then(res => {
        alert('게시글이 수정되었습니다.')

        this.$router.push({
          name: 'BoardReadPage',
          params: { boardNo: res.data }
        })
      })
    }
  }
</script>

