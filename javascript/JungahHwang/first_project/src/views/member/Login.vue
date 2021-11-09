<template>
  <div>
    <h3>로그인</h3>
    <login-form @submit="onSubmit"></login-form>
  </div>
</template>


<script>
import LoginForm from '@/components/member/LoginForm'

export default {
  name: 'Login',
  components: {
    LoginForm
  }
}
</script>