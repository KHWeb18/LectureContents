<template>
  <div>
    <h2>{{ msg }}</h2>
    <router-link class="registerBtn" :to="{ name: 'MemberRegisterPage' }">
      회원가입 하기
    </router-link>
  </div>
</template>

<script>

export default {
  data() {
    return {
      msg: '판타지 온라인에 접속한것을 환영합니다'
    }
  }
}

</script>

<style scoped>

div {
  background-color: #77cce3;
  height: 60px;
}

h2 {
  padding: 15px;
}

.registerBtn {
  position: absolute;
  top: 5px;
  right: 5%;
  text-decoration: none;
  color: #0b6a33;
  font-weight: 600;
}

</style>