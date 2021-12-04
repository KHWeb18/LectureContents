<template>
  <form @submit.prevent="onSubmit">
    <table border="1">
      <tr>
        <td>No</td>   
        <td><input type="text" :value="board.boardNo" readonly/></td> 
      </tr>
      <tr>
        <td>등록일자</td>   
        <td><input type="text" :value="board.regDate" readonly/></td> 
      </tr>
      <tr>
        <td>제목</td>   
        <td><input type="text" :value="board.title" readonly/></td> 
      </tr>
      <tr>
        <td>작성자</td>
        <td><input type="text" :value="board.writer" readonly/></td>       
      </tr>
      <tr>
        <td>내용</td>
        <td><textarea :value="board.content" readonly/></td>
      </tr>
    </table>
  </form>
</template>


<script lang="ts">
  import { Component, Emit, Vue, Prop } from 'vue-property-decorator'

  @Component
  export default class BoardRegister extends Vue {
    @Prop() board!: any
    
    /* eslint-disable @typescript-eslint/no-inferrable-types */
    title: string = ''
    writer: string = ''
    content: string = ''

    @Emit('submit')
    onSubmit () {
      const { title, writer, content } = this
      return { title, writer, content }
    }
  }
</script> 