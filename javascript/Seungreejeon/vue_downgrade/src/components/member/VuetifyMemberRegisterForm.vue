<template>
<v-container>
    <form @submit.prevent="onSubmit">
        <h3>회원가입 양식</h3>
        <table>
            <tr>
                <th>아이디</th>
                <th><input type="text" v-model="id"></th>
            </tr>
            <tr>
                <td>pw</td>
                <td><input type="password" v-model="pw"></td>
            </tr>
        </table>

        <div>
            <button type="submit">등록</button>
            <router-link :to="{ name: 'Home' }">
                취소
            </router-link>
        </div>
    </form>
    </v-container>
</template>

<script>
export default {
    name: 'VuetifyMemberRegisterForm',
    data () {
        return {
            id: '',
            pw: '',
        }
    },
    methods: {
        onSubmit () {
            const { id, pw } = this
            this.$emit('submit', { id, pw })
            this.id = ''
            this.pw = ''
        }
    }
}
</script>
<style scoped>
th {
    width: 150px;
    text-align: right;
}
td {
    text-align: right;
}
</style>