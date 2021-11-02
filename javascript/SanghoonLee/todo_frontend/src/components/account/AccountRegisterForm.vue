<template>
    <v-container>
        <form @submit.prevent="onSubmit">
            <h3>회원 가입 양식</h3>
            <table>
                <tr>
                    <td>이메일</td>
                    <td><input type="text" v-model="email"></td>
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
    </v-container>
</template>

<script>

export default {
    name: 'AccountRegisterForm',
    data () {
        return {
            email: '',
            password: ''
        }
    },
    methods: {
        onSubmit () {
            const { email, password } = this
            this.$emit('submit', { email, password })
        }
    }
}

</script>