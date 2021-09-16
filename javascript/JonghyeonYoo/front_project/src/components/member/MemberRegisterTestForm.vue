<template>
  <v-container>
    <form @submit.prevent="onSubmit">
      <h3>회원 가입 양식</h3>
      <div class="row">
        <v-radio-group v-model="radioGroup" row>
          <v-radio
            v-for="kinds in kindsOfMember"
            :key="kinds"
            :label="`${kinds}`"
          >
          </v-radio>
        </v-radio-group>
      </div>
      <table>
        <tr>
          <td>아이디</td>
          <td><input type="text" v-model="userId" /></td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td><input type="password" v-model="password" /></td>
        </tr>
        <tr>
          <td>이름</td>
          <td><input type="text" v-model="name" /></td>
        </tr>
        <tr>
          <td>생년월일</td>
          <td><input type="text" v-model="dateOfBirth" /></td>
        </tr>
        <tr>
          <td>이메일</td>
          <td><input type="text" id="zipcode" v-model="email" /></td>
        </tr>
        <tr>
          <td>핸드폰번호</td>
          <td><input type="text" v-model="phoneNumber" /></td>
        </tr>
      </table>

      <div>
        <button type="submit">등록</button>
        <router-link :to="{ name: 'MainHome' }"> 취소 </router-link>
      </div>
    </form>
  </v-container>
</template>

<script>
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