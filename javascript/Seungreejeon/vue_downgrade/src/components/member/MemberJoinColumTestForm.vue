<template>
  <v-container>
    <form @submit.prevent="onSubmit">
      <h3>회원가입 양식</h3>

      <v-container class="mr-0">
        <v-radio-group v-model="radioGroup" row>
          <v-radio
            v-for="kinds in kindsOfMember"
            :key="kinds"
            :label="`${kinds}`"
          >
          </v-radio>
        </v-radio-group>
      </v-container>
      <table>
        <tr>
          <th>아이디</th>
          <th><input type="text" v-model="userId" /></th>
        </tr>
        <tr>
          <td>pw</td>
          <td><input type="password" v-model="password" /></td>
        </tr>
      </table>

      <div>
        <button type="submit">등록</button>
        <router-link :to="{ name: 'Home' }"> 취소 </router-link>
      </div>
    </form>
  </v-container>
</template>

<script>
export default {
  name: "VuetifyMemberRegisterForm",
  data() {
    return {
      kindsOfMember: ["개인", "사업자"],
      userId: "",
      password: "",
      radioGroup: 1,
    };
  },
  methods: {
    onSubmit() {
      const { userId, password, radioGroup } = this;
      const auth = radioGroup == 0 ? "개인" : "사업자";
      this.$emit("submit", { userId, password, auth });
      this.userId = "";
      this.password = "";
    },
    // changeStatus() {
    //     this.checkIndividual = !this.checkIndividual
    //     this.checkBusiness = !this.checkBusiness
    // }
  },
};
</script>
<style scoped>
th {
  width: 150px;
  text-align: right;
}
td {
  text-align: right;
}
.row {
  text-align: right;
}
</style>