<template>
  <form @submit.prevent="onSubmit">
    <table border="1">
      <tr>
        <td>No</td>   
        <td><input type="text" :value="board.boardNo" disabled/></td> 
      </tr>
      <tr>
        <td>등록일자</td>   
        <td><input type="text" :value="board.regDate" disabled/></td> 
      </tr>
      <tr>
        <td>제목</td>   
        <td><input type="text" v-model="title"/></td> 
      </tr>
      <tr>
        <td>작성자</td>
        <td><input type="text" v-model="writer"/></td>       
      </tr>
      <tr>
        <td>내용</td>
        <td><textarea v-model="content"/></td>
      </tr>
    </table>
    <div>
      <button type="submit">수정</button>
      <router-link :to="{ name: 'BoardReadPage', params: { boardNo: board.boardNo} }">취소</router-link>
    </div>
  </form>
</template>


<script lang="ts">
  import { Board } from '@/store'
  import { Component, Emit, Vue, Prop } from 'vue-property-decorator'

  @Component
  export default class BoardRegister extends Vue {
    @Prop() board!: Board

    /* eslint-disable @typescript-eslint/no-inferrable-types */
    title: string = ''
    writer: string = ''
    content: string = ''

    created () {
      this.title = this.board.title
      this.writer = this.board.writer
      this.content = this.board.content
    }

    @Emit('submit')
    onSubmit () {
      return this.board
    }
  }
</script> 