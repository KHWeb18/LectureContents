<template>
    <form @submit.prevent="onSubmit">
       <h2>회원정보입력</h2>
        <table>
            <tr>
                <td>이메일</td>
                <td><input type="text" v-model="email"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" v-model="name"></td>
            </tr>
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
            <!--
            <router-link :to="{ name: 'MemberListPage' }">
                취소
            </router-link>
            -->
        </div>
    </form>
</template>

<script>
export default {
    name: 'MemberRegisterForm',
    data () {
        return {
            id: '',
            pw: '',
            email: '',
            name: '',

        }
    },
    methods: {
        onSubmit () {
            const { id, pw, email, name } = this
            this.$emit('submit', { id, pw, email, name })
        }
    }
}
</script> 