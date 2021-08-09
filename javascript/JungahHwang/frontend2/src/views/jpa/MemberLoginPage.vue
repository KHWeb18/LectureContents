<template>
  <div>
    <div align="center">
      <h2>로그인</h2>
    </div>
    <member-login @submit="onSubmit"></member-login>
  </div>
</template>

<script>
import MemberLogin from '@/components/jpa/MemberLogin'
import axios from 'axios'

export default {
  name: 'MemberLoginPage',
  components: {
    MemberLogin
  },
  methods: {
    onSubmit (payload) {
      const { id, pw } = payload
      axios.post('http://localhost:7777/jpamember/login', { id, pw, auth: null }).then(() => {
        alert('로그인이 완료되었습니다!')
      }).catch(res => {
        alert(res.response.data.message)
      })
    }
  }
}
</script>