<template>
  <div>
    <router-link :to="{ name: 'MemberLoginPage' }" 
      class="nav-link" 
      active-class="active">Login
    </router-link>
    <h2 align="center">회원가입</h2>
    <member-join-column @submit="onSubmit"></member-join-column>
    <v-spacer></v-spacer>
    <v-container>
      <v-btn tile color="teal" @click="onJPATest">
        <v-icon left>ads_click</v-icon> 클릭!!
      </v-btn>
    </v-container>
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
    },
    onJPATest () {
      axios.post('http://localhost:7777/jpamember/jpql', { id: null, pw: null, auth: null }).then(() => {
        alert('테스트 성공!')
      }).catch(res => {
        alert(res.response.data.message)
      })
    }
  }
}
</script>