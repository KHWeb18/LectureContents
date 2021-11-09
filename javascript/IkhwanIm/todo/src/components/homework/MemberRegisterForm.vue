<template>
    <form class="box" method="post" @submit.prevent="onSubmit">
      <h1>회원 가입</h1>
      <h3>이메일 아이디</h3>
      <input type="text" name="" placeholder="이메일 입력" v-model="email">
      <h3>비밀번호</h3>
      <input type="password" name="" placeholder="비밀번호" v-model="password">
      <h3>이름</h3>
      <input type="text" name="" placeholder="이름" v-model="name"><br>
    <button type="submit" id="btnRegister">가입하기</button>
    <router-link :to="{ name: 'Homework' }">
      취소
    </router-link>
  </form>
</template>

<script>
export default {
  name: "MemberRegisterForm",
  data() {
    return {
      email: '',
      password: '',
      name: '',
    }
  },
  methods: {
    onSubmit () {
      const { email, password, name } = this
      this.$emit('submit', { email, password, name })
    }
  }
}
</script>

<style scoped>
body{
  margin: 0;
  padding: 0;
}

h1{
  margin-top: 20px;
}

.box{
  max-width: 500px;
  width: 50%;
  display: block;
}

.box input{
  margin-top: 20px;
  border: 0;
  background: none;
  display: block;
  margin: 20px auto;
  text-align: center;
  border: 2px solid #3498db;
  padding: 14px 10px;
  width: 350px;
  outline: none;
  color: white;
}
.box h3 {
  margin-top: 20px;
  margin-left: 80px;
  text-align: left;

}

.box button{
  margin: 20px;
  text-decoration: none;
  font-weight: 600;
  font-size: 3rem;
  border: 2px solid #3498db;
  background: #3498db;
}

#btnRegister {

}
</style>