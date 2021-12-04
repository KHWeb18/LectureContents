<template>
  <v-container>
    <form @submit.prevent="onSubmit">
      <h3>회원가입 양식</h3>
      <div class="row">
        <v-radio-group v-model="radioGroup" row>
          <v-radio v-for="kinds in kindsOfMember" :key="kinds" :label="`${kinds}`"></v-radio> 
        </v-radio-group>
      </div>
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
        <button type="submit">등록</button>
      </div>
    </form>
  </v-container>
</template>


<script>
export default {
  name: 'MemberJoinColumn',
  data () {
    return {
      radioGroup: 1,
      kindsOfMember: [ '개인', '사업자' ],
      id: null, 
      pw: null
    }
  },
  methods: {
    onSubmit () {
      const { id, pw, radioGroup } = this
      const auth = radioGroup == 0 ? '개인' : '사업자'
      this.$emit('submit', { id, pw, auth })
    },
  }
}
</script>