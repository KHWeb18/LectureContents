<template>
  <div id="board">
    <h2>Vue + Spring 게시판</h2>
    <router-link :to="{ name: 'BoardRegisterPage'}">
      게시물 작성
    </router-link>
    <!-- : v-bind -->
    <board-list :boards="boards"></board-list>
  </div>
</template>


<script>
import BoardList from '@/components/board/BoardList'
import { mapActions, mapState } from 'vuex'

export default {
  name: 'BoardListPage',
  components: {
    BoardList
  },
  computed: {
    ...mapState(['boards'])
  },
  mounted () {
    this.fetchBoardList()
  },
  methods: {
    ...mapActions(['fetchBoardList'])
  }

}
</script>
