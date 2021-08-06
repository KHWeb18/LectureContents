<template>
    <form @submit.prevent="onSubmit">
        <h3>회원 가입 양식</h3>
        <table>
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
                <td><input type="password" v-model="password"></td>
            </tr>
            <tr>
                <td>전화번호</td>
                <td><input type="text" v-model="phoneNum"></td>
            </tr>
            <tr>
                <td>생년월일</td>
                <td><input type="text" v-model="memberBirth"></td>
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
            name: '',
            id: '',
            password: '',
            phoneNum: '',
            memberBirth: ''
        }
    },
    methods: {
        onSubmit () {
            const { name, id, password, phoneNum, memberBirth } = this
            this.$emit('submit', { name, id, password, phoneNum, memberBirth })
        }
    }
}
</script>