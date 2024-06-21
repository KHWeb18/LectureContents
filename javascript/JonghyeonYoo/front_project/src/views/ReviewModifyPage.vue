<template>
  <div align="center">

    <review-modify-form v-if="review" :review="review" @submit="onSubmit" />
    <p v-else>로딩중....</p>
  </div>
</template>

<script>
import ReviewModifyForm from "@/components/review/ReviewModifyForm";
import { mapState, mapActions } from "vuex";
import axios from "axios";

export default {
  name: "ReviewModifyPage",
  components: {
    ReviewModifyForm,
  },
  props: {
    reviewNo: {
      type: String,
      required: true,
    },
  },
    computed: {
      ...mapState(['review'])
  },
  methods: {
      ...mapActions(['fetchReview']),
      onSubmit (payload) {
          const {  content } = payload
          axios.put(`http://localhost:1111/review/${this.reviewNo}`, { content})
          .then(res => {
              alert('수정 성공!')
            this.$router.push({
                name: 'ReviewReadPage',
                params: { reviewNo: res.data.reviewNo.toString()}
            })
          })
          .catch(err => {
              alert(err.reponse.data.message)
          })
      }
  },
  created () {
      this.fetchReview(this.reviewNo)
      .catch(err => {
          alert(err.reponse.data.message)
          this.$router.back()
      })
  },
};
</script>