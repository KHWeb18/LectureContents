<template>
  <div align="center">
    <review-read v-if="review" :review="review"/>
    <p v-else style="color: white">로딩중......</p>
    
    <div class="button">
  <v-btn elevation="2">
    <router-link :to="{ name: 'ReviewModifyPage', params: { reviewNo }}" style="color: black;">
      게시물 수정
    </router-link><br>
  </v-btn>
    <v-btn elevation="2">
    <button @click="onDelete" style="color: black;">삭제</button>
    </v-btn>

      <v-btn elevation="2">
        <button onclick="history.back()">이전페이지</button>

      </v-btn>
    </div>
  </div>
</template>

<script>

import ReviewRead from "@/components/review/ReviewRead.vue";
import { mapState, mapActions } from "vuex";
import axios from 'axios';
// import Footer from './Footer.vue';

export default {
  name: "ReviewReadPage",
  props: {
    reviewNo: {
      type: String,
      required: true,
    },
  },
  components: {
    ReviewRead
   // Footer,
  },
  computed: {
    ...mapState(["review"]),
  },
  created() {
    this.fetchReview(this.reviewNo).catch((err) => {
      alert(err.response.data.message);
      this.$router.push();
    });
  },
  methods: {
    ...mapActions(["fetchReview"]),
    onDelete() {
        const{ reviewNo } = this.review
        axios.delete(`http://localhost:1111/review/${reviewNo}`)
        .then(() => {
            alert('삭제 성공!')
            this.$router.push({ name: 'ReviewListPage' })
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