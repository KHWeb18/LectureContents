<template>
  <div>
    <h2 align="center">회원가입</h2>
    <member-join-column @submit="onSubmit"></member-join-column>
  </div>
</template>


<script>
import MemberJoinColumn from '@/components/jpa/MemberJoinColumn'
import axios from 'axios'

export default {
  name: 'MemberJoinColumnPage',
  components: {
    MemberJoinColumn
  },
  methods: {
    onSubmit (payload) {
      const { id, pw, auth } = payload
      axios.post('http://localhost:7777/jpamember/register', { id, pw, auth }).then(() => {
        console.log('id: ' + id + ', pw: ' + pw + ', auth: ' + auth)
        alert('회원가입이 완료되었습니다!')
       }).catch(res => {
        alert(res.response.data.message)
      })
    }
  }
}
</script>