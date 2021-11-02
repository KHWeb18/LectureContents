<template>
  <div align="center">
    <h2>회원가입</h2>
    <monster-signup-form @submit="onSubmit"></monster-signup-form>
  </div>
</template>


<script>
import axios from 'axios'

import MonsterSignupForm from '@/components/monster/MonsterSignupForm'

export default {
  name: 'MonsterSignupPage',
  components: {
    MonsterSignupForm
  },
  methods: {
    onSubmit (payload) {
      const { id, pw } = payload
      axios.post('http://localhost:7777/vuegame/signup', { id, pw }).then(res => {
        alert('등록성공!' + res)
       }).catch(res => {
        alert(res.response.data.message)
      })
    }
  }
}
</script>