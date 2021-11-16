<template>
  <div>
    <table border="1">
      <tr>
        <td>No</td>
        <td><input type="text" :value="board.boardNo" readonly></td>
        <td>등록일자</td>
        <td><input type="text" :value="board.regDate" readonly></td>
        <td>제목</td>
        <td><input type="text" :value="board.title" readonly/></td>
        <td>작성자</td>
        <td><input type="text" :value="board.writer" readonly/></td>
        <td>내용</td>
        <td><textarea :value="board.content" readonly/></td>
      </tr>
    </table>
  </div>
</template>

<script lang="ts">
  import { Component, Prop, Vue } from 'vue-property-decorator'
  import { Board } from '@/store'

  @Component
  export default class BoardRead extends Vue {
    @Prop() board!: Board
  }
</script>