<template>

  <div align="center">
    

    <review-register-form @submit="onSubmit" />
  </div>
</template>

<script>
import ReviewRegisterForm from '@/components/review/ReviewRegisterForm.vue'
import axios from "axios";

export default {
  name: "ReviewRegisterPage",
  components: {
    ReviewRegisterForm,
  },
  methods: {
    onSubmit(payload) {
        const {content, writer} = payload
        axios.post('http://localhost:1111/review/register', { writer, content})
        .then(res => {
            alert('등록 성공~!' + res)
           console.log('게시물 번호: ', + res.data.reviewNo.toString())
           this.$router.push({
                name: 'ReviewListPage',
                // params: { reviewNo: res.data.boardNo.toString()}
            })
           
        })
        .catch(res => {
            alert(res.reponse.data.message)
        })
    },
  },
};
</script>