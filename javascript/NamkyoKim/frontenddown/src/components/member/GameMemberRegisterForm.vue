<template>
    <form @submit.prevent="onSubmit">
        <h3>회원 가입 양식</h3>
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
            <button type="submit">회원가입</button>
            <router-link :to="{ name: 'Home' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'GameMemberRegisterForm',
    data () {
        return {
            id: '',
            pw: ''
        }
    },
    methods: {
        onSubmit () {
            const { id, pw } = this
            this.$emit('submit', { id, pw })
        }
    }
}
</script>
