<template>
  <div align="center">
    <board-read v-if="board" :board="board"/>
    <p v-else style="color: white">로딩중......</p>
    
    <div class="button" >
  <v-btn elevation="2">
    <router-link :to="{ name: 'BoardModifyPage', params: { boardNo }}"  style="color: black;">
      게시물 수정
    </router-link><br>
  </v-btn>
    <v-btn elevation="2">
    <button @click="onDelete"  style="color: black;">삭제</button>
    </v-btn>

      <v-btn elevation="2">
    <router-link :to="{ name: 'BoardListPage' }" style="color: black;"> 게시물 보기 </router-link>
      </v-btn>
    </div>
  </div>
</template>

<script>

import BoardRead from "@/components/board/BoardRead.vue";
import { mapState, mapActions } from "vuex";
import axios from 'axios';

export default {
  name: "BoardReadPage",
  props: {
    boardNo: {
      type: String,
      required: true,
    },
  },
  components: {
    BoardRead,
  },
  computed: {
    ...mapState(["board"]),
  },
  created() {
    this.fetchBoard(this.boardNo).catch((err) => {
      alert(err.response.data.message);
      this.$router.push();
    });
  },
  methods: {
    ...mapActions(["fetchBoard"]),
    onDelete() {
        const{ boardNo } = this.board
        axios.delete(`http://localhost:1111/vueboard/${boardNo}`)
        .then(() => {
            alert('삭제 성공!')
            this.$router.push({ name: 'BoardListPage' })
        })
        .catch(err => {
            alert(err.response.data.message)
        })
    },
  },
};
</script>

<style scoped>
.button{color: black; margin: 10px; }
.button button{margin-left: 15px; margin-right: 15px; text-align: center;}

</style>