<template>
  <div align="center">
  <member-register-form @submit="onSubmit"/>
  </div>
</template>

<script>

import MemberRegisterForm from "../components/homework/MemberRegisterForm";
import axios from "axios";

export default {
  name: "MemberRegisterPage",
  components: {
    MemberRegisterForm
  },
  methods: {
    onSubmit (payload) {
      const { email, password, name } = payload
      axios.post('http://localhost:7777/vuemember/register', { email, password, name })
      .then(res => {
        alert('가입 성공! - ' + res)
      })
      .catch(res => {
        alert(res.response.data.message)
      })
    }
  }
}
</script>

<style scoped>


</style>