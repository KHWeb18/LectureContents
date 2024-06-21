<template>
  <div class="app">
    <v-container>
      <form @submit.prevent="onSubmit">
        <div class="login-form">
          <h1>LOGIN</h1>

          <div class="input-area">
            <v-text-field

              v-model="id"
              required
              label="USER ID"
              type="text"
            >
            </v-text-field>
          </div>
          <div class="input-area">
            <v-text-field
 
              v-model="pw"
              required
              label="PASSWORD"
              type="password"
            >
            </v-text-field>
          </div>

          <div class="btn-area">
            <v-btn color="blue" block large type="submit"> 로그인 </v-btn>
            <v-btn
              color="blue"
              block
              large
              onclick="location.href='MemberRegister'"
            >
              회원가입
            </v-btn>
          </div>
        </div>
      </form>
    </v-container>
  </div>
</template>

<script>


export default {
  name: "MemberLoginForm",
  data() {
    return {
      id: "",
      pw: "",

      isError: false,
      loginSuccess: false,
    };
  },
methods: {
    onSubmit() {
      const { id, pw } = this;
      this.$emit("submit", { id, pw });
    },
}
};
</script>

<style scoped>

.login-form {
  position: relative;
  z-index: 2;
  position: absolute;
  top: 25%;
  left: 50%;
  margin-left: -150px;
  margin-top: -80px;
  display: center;
  justify-content: center;
  align-items: center;
}
.login-form h1 {
  margin-top: 100px;
  font-size: 32px;
  color: white;
  text-align: center;
  margin-bottom: 60px;
}
.input-area {
  width: 400px;
  text-align: center;
  position: relative;
  margin-top: 20px;
}
.input-area first-child {
  margin-top: 0;
}
.input-area input {
  width: 100%;
  padding: 20px 10px 10px;
  background-color: transparent;
  border: none;
  border-bottom: 1px solid #999;
  font-size: 19px;
  color: #fff;
  outline: none;
}
.input-area label {
  position: absolute;
  left: 10px;
  top: 15px;
  font-size: 18px;
  color: rgb(112, 105, 105);
  transition: top 0.5s ease;
}
.input-area input:focus + label,
.input-area input:valid + label {
  top: 0;
  font-size: 13px;
  color: #166cea;
}

.btn-area {
  margin-top: 30px;
}
.btn-area .v-btn {
  width: 100%;
  height: 50px;
  background: #166cea;
  color: #fff;
  font-size: 20px;
  border: none;
  border-radius: 25px;
  margin-top: 10px;
  cursor: pointer;
}

.caption {
  margin-top: 20px;
  text-align: center;
}
.caption a {
  color: white;
}
</style>