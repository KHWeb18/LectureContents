<template>
  <div align="center">
    <h2>게시물 상세 보기</h2>
    <board-read v-if="board" :board="board"/>
    <p v-else>로딩중 ...</p>
    <router-link :to="{ name: 'BoardModifyPage' }">게시물 수정</router-link>
    <button @click="onDelete">삭제</button>
    <router-link :to="{ name: 'TypeScriptBoardListPage' }">목록보기</router-link>
  </div>
</template>

<script lang="ts">
  import { Component, Vue, Prop } from 'vue-property-decorator'
  import { State, Action } from 'vuex-class'
  import BoardRead from '@/components/board/BoardRead.vue'
  import AxiosService from '@/service'
  import { Board } from '@/store'

  @Component({
    components: {
      BoardRead
    }
  })

  export default class BoardReadPage extends Vue {
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
    onDelete () {
      const { boardNo } = this.board
      AxiosService.instance.delete(`/board/${boardNo}`)
        .then ((res) => {
          alert('삭제 완료!')
          this.$router.push({ name: 'TypeScriptBoardListPage' })
        })
        .catch ((err) => {
          alert(err.response.data.message)
        })
    }
  }
</script>