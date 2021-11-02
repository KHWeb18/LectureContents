<template>
  <div align="center">
    <h2>게시물 작성</h2>
    <board-register-form @submit="onSubmit"></board-register-form>
  </div>
</template>


<script>
import axios from 'axios'

import BoardRegisterForm from '@/components/board/BoardRegisterForm.vue'

export default {
  name: 'BoardRegisterPage',
  components: {
    BoardRegisterForm
  },
  methods: {
    onSubmit (payload) {
      const { title, writer, content } = payload
      axios.post('http://localhost:7777/vueboard/register', { title, writer, content }).then(() => {
        alert('등록이 완료되었습니다')
        this.$router.push({
          name: 'BoardListPage',
        })
      }).catch(res => {
        alert(res.response.data.message)
      })
    }
  }
}
</script>