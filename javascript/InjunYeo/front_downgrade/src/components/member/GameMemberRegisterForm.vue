  
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
                <td><input type="password" v-model="password"></td>
            </tr>
        </table>

        <div>
            <button type="submit">등록</button>
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
            password: ''
        }
    },
    methods: {
        onSubmit () {
            const { id, password } = this
            this.$emit('submit', { id, password })
        }
    }
}
</script>