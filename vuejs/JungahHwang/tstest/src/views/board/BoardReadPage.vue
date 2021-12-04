<template>
  <div align="center">
    <h2>게시물 보기</h2>
    <board-read v-if="board" :board="board"/>
    <router-link :to="{ name: 'BoardModifyPage' }">수정</router-link>
    <router-link :to="{ name: 'BoardListPage' }">목록보기</router-link>
    <button @click="onDelete">삭제</button>
  </div>
</template>


<script lang="ts">
  import { Component, Vue, Prop } from 'vue-property-decorator'
  import { State, Action } from 'vuex-class'
  import BoardRead from '@/components/board/BoardRead.vue'
  import { Board } from '@/store'
  import AxiosService from '@/service'

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
    }

    onDelete() {
      AxiosService.instance.delete(`/board/${this.boardNo}`)
      .then(() => {
        alert('게시글이 삭제되었습니다.')

        this.$router.push({
          name: 'BoardListPage'
        })
      })
    }
  }
</script>

