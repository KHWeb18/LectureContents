<template>
  <div>
    <table border="1">
      <tr>
        <th align="center" width="80">No</th>
        <th align="center" width="320">제목</th>
        <th align="center" width="100">작성자</th>
        <th align="center" width="180">등록일자</th>
      </tr>

      <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
        <td colspan="4">
          어떤 데이터도 없습니다!
        </td>
      </tr>

      <tr v-else v-for="board in boards" :key="board.boardNo">
        <td align="center">{{ board.boardNo }}</td>
        <td align="center">{{ board.title }}</td>
        <!-- <td align="center">{{ board.title }}</td> -->
        <td align="center">{{ board.writer }}</td>
        <td align="center">{{ board.regDate }}</td>
      </tr>
    </table>
  </div>
</template>

<script lang="ts">
  import { Component, Prop, Vue } from 'vue-property-decorator'
  import { Board } from '@/store'

  @Component
  export default class BoardList extends Vue {
    @Prop() private boards!: Board[]
  }
</script>