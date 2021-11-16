<template>
  <form @submit.prevent="onSubmit">
    <table>
      <tr>
        <td>No</td>
        <td><input type="text" :value="board.boardNo" disabled></td>
      </tr>
      <tr>
        <td>등록일자</td>
        <td><input type="text" :value="board.regDate" disabled></td>
      </tr>
      <tr>
        <td>제목</td>
        <td><input type="text" v-model="board.title"/></td>
      </tr>
      <tr>
        <td>작성자</td>
        <td><input type="text" v-model="board.writer" disabled/></td>
      </tr>
      <tr>
        <td>내용</td>
        <td><textarea v-model="board.content"/></td>
      </tr>
    </table>

    <div>
      <button type="submit">수정</button>
      <router-link :to="{ name: 'BoardReadPage', params: { boardNo: board.boardNo.toString() } }">취소</router-link>
    </div>
  </form>
</template>

<script lang="ts">
  import { Component, Prop, Emit, Vue } from 'vue-property-decorator'
  import { Board } from '@/store'

  @Component
  export default class BoardRead extends Vue {
    @Prop() board!: Board

    /* eslint-disable @typescript-eslint/no-inferrable-types */
    title: string = ''
    content: string = ''

    created () {
      this.title = this.board.title
      this.content = this.board.content
    }

    @Emit('submit')
    onSubmit () {
      return this.board
    }
  }
</script>