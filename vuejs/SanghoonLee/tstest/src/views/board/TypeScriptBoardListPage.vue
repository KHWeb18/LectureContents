<template>
  <div align="center">
    <h2>Board(게시판) 리스팅</h2>
    <!-- <router-link :to="{ name: BoardRegisterPage }">글쓰기</router-link> -->
    <board-list :boards="boards"/>
  </div>
</template>

<script lang="ts">
  import { Component, Vue } from 'vue-property-decorator'
  import { State, Action } from 'vuex-class'
  // npm install vuex-class --save-dev
  import BoardList from '@/components/board/BoardList.vue'
  import { Board } from '@/store'

  @Component({
    components: {
      BoardList
    }
  })

  export default class TypeScriptBoardListPage extends Vue {
    @State readonly boards!: Board[]

    @Action readonly fetchBoardList: any

    created () {
      this.fetchBoardList()
    }
  }
</script>