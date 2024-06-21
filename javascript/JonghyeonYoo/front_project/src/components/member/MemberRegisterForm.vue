<template>
  <v-container>
    <form @submit.prevent="onSubmit">
      <div class="signup-form">
        <h1>회원 가입</h1>
        <div class="row">
           <v-btn elevation="2">
          <v-radio-group v-model="radioGroup" row>
            <v-radio v-for="kinds in kindsOfMember" :key="kinds" :label="`${kinds}`"></v-radio>
          </v-radio-group>
           </v-btn>
        </div>
          <div class="input-area">
            <v-text-field class="pl-3 pr-3" v-model="userId" :rules="userIdRules" required 
            label="ID" type="text" prepend-icon="mdi-account">
            </v-text-field>
          </div>

          <div class="input-area">
            <v-text-field class="pl-3 pr-3" v-model="password" :rules="passwordRules" required 
            label="PASSWORD" type="password" prepend-icon="mdi-lock">
            </v-text-field>
          </div>

          <div class="input-area">
            <v-text-field class="pl-3 pr-3" v-model="name" :rules="nameRules" required 
            label="NAME" type="text" prepend-icon="mdi-face">
            </v-text-field>
          </div>

          <div class="input-area">
            <v-text-field class="pl-3 pr-3" v-model="phoneNumber" :rules="phoneNumberRules" required 
            label="PHONE NUMBER" type="text" prepend-icon="mdi-phone"></v-text-field>
          </div>

          <div class="input-area">
            <v-text-field class="pl-3 pr-3" v-model="dateOfBirth" :rules="dateOfBirthRules" required 
            label="Date Of Birth" type="text" prepend-icon="mdi-cake-variant"></v-text-field>
          </div>

          <div class="input-area">
            <v-text-field class="pl-3 pr-3" v-model="email" :rules="emailRules" required 
            label="Email" type="email" prepend-icon="mdi-email"></v-text-field>
          </div>

          <div class="btn-area">
            <button type="submit">회원 가입</button>
              <button type="button" onclick="location.href='MainHome'">취소</button>
          </div>
      </div>
    </form>

  </v-container>
</template>

<script>

import { mapState } from 'vuex'

export default {
  name: "MemberJoinColumnTestForm",
  data() {
    return {
      radioGroup: 1,
      kindsOfMember: ["개인", "사업자"],
      userId: "",
      password: "",
      name: "",
      email: "",
      phoneNumber: "",
      dateOfBirth: "",
    };
  },
      computed: {
        ...mapState ([
            'userIdRules',
            'passwordRules',
            'nameRules',
            'emailRules',
            'phoneNumberRules',
            'dateOfBirthRules'
        ])
    },
  methods: {
   
    onSubmit() {
      const {
        userId,
        password,
        name,
        email,
        phoneNumber,
        dateOfBirth,
        radioGroup,
      } = this;
      const auth = radioGroup == 0 ? "개인" : "사업자";
      this.$emit("submit", {
        userId,
        password,
        name,
        email,
        phoneNumber,
        dateOfBirth,
        auth,
      });
    },
  },
};
</script>

<style scoped>

.signup-form {
  position: relative;
  z-index: 2;
  position: absolute;
  top: 10%;
  left: 50%;
  margin-left: -150px;
  margin-top: -80px;
  display: center;
  justify-content: center;
  align-items: center;
}
.signup-form h1 {
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
  color: white;
  outline: none;
}
.input-area label {
  position: absolute;
  left: 10px;
  top: 15px;
  font-size: 18px;
  color: #999;
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

.btn-area button {
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
.input-area button{
    width: 20%;
  height: 30px;
  background: #166cea;
  color: #fff;
  font-size: 15px;
  border: none;
  border-radius: 25px;
  margin-top: 10px;
  cursor: pointer;
}
</style>