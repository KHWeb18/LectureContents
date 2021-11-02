<template>
  <form @submit.prevent="onSubmit"> 
    <p>아이디와 비밀번호를 입력하세요</p>
    <table>
      <tr>
        <td>id</td>
        <td><input type="text" v-model="id"></td>
      </tr>
      <tr>
        <td>password</td>
        <td><input type="password" v-model="pw"></td>
      </tr>
    </table>
    <button type="submit">로그인</button>
  </form>
</template>


<script>
export default {
  name: 'LoginForm',
  data () {
    return {
      id: null,
      pw: null
    }
  },
  methods: {
    onSubmit () {
      const { id, pw } = this
      this.$emit('submit', { id, pw })
    }
  }
}
</script>