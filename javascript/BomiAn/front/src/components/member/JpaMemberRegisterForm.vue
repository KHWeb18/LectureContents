<template>
  <v-container>
   <form @submit.prevent="onMemberSubmit">
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
            <router-link :to="{ name: 'MemberListPage' }">
                취소
            </router-link>
        </div>
    </form>
  </v-container>
</template>

<script>
export default {
    name: 'MemberRegisterForm',
    data () {
        return {
            id: '',
            pw: ''
        }
    },
    methods: {
        onMemberSubmit () {
            const { id, pw } = this
            this.$emit('submit', { id, pw })
            this.id = '';
            this.pw = '';
        }
    }
}
</script>
