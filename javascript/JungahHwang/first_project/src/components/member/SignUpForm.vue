<template>
  <form @submit.prevent="onSubmit">
    <p>아래 정보를 입력하세요.</p>
    <table border="1">
        <tr>
          <td>id</td>
          <td><input type="text" v-model="id"></td>
        </tr>
        <tr>
          <td>password</td>
          <td><input type="password" v-model="pw"></td>
        </tr>
        <tr>
          <td>name</td>
          <td><input type="text" v-model="name"></td>
        </tr>
        <tr>
          <td>gender</td>
          <td><input type="text" v-model="gender"></td>
        </tr>
        <tr>
          <td>birth</td>
          <td><input type="text" v-model="birth"></td>
        </tr>
        <tr>
          <td>e-mali</td>
          <td><input type="text" v-model="email"></td>
        </tr>
        <tr>
          <td>phone</td>
          <td><input type="text" v-model="tel"></td>
        </tr>
        <tr>
          <td>address</td>
          <td><textarea cols="20" rows="5" v-model="addr"></textarea></td>
        </tr>
    </table>
    <div>
      <button type="submit">등록</button>
    </div>
  </form>
</template>


<script>
export default {
  name: 'SignUpForm',
  data () {
    return {
      id: null,
      pw: null,
      name: null,
      gender: null,
      birth: null,
      email: '@naver.com',
      tel: '010-',
      addr: null
    }
  },
  methods: {
    onSubmit () {
      const { id, pw, name, gender, birth, email, tel, addr } = this
      this.$emit('submit', { id, pw, name, gender, birth, email, tel, addr })
    }
  }
}
</script>