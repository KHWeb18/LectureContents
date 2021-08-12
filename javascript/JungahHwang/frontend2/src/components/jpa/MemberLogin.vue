<template>
  <v-container>
    <form @submit.prevent="onSubmit">
      <table>
        <tr>
          <td>아이디</td>
          <td><input type="text" v-model="id"></td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td><input type="password" v-model="pw"></td>
        </tr>
      </table>
      <div>
        <button type="submit">로그인</button>
        <router-link :to="{ name: 'Home'}">
          취소
        </router-link>
      </div>
    </form>
  </v-container>
</template>

<script>
import axios from 'axios'

export default {
  name: 'MemberLogin',
  data () {
    return {
      id: '',
      pw: ''
    }
  },
  methods: {
    onSubmit () {
      const { id, pw } = this
      this.$emit('submit', { id, pw })
    },
    showSession () {
      axios.post('http://localhost:7777/jpamember/needSession').then(res => {
        if (res.data == true) {
          alert('세션 정보 유지: ' + res.data)
        } else {
          alert('세션 정보 없음: ' + res.data)
        }
      }).catch (res => {
        alert(res.response.data)
      })
    },
    removeSession () {
      axios.post('http://localhost:7777/jpamember/removeSession')
    }
  }
}
</script>