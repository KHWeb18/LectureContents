<template>
    <div>
        <p>아래의 형식에 맞게 입력해주세요</p>
        <form @submit.prevent="onSubmit">
            <table>
                <v-container>
                    <v-layout wrap row justify-center>
                        <tr>
                            <td>ID</td>
                            <td><v-text-field label="email 형식" type="text" style="width: 130px;" required v-model="userInfo.id"/></td>
                        </tr>
                        <tr>
                            <td>비밀번호</td>
                            <td><v-text-field label="비밀번호" type="password" style="width: 130px;" required v-model="userInfo.password"/></td>
                        </tr>
                    </v-layout>
                </v-container>
            </table>
            <div>
                <v-btn button type="submit">가입하기!</v-btn>
            </div>
        </form>
    </div>
</template>

<script>

export default {
    name: 'VueJpaMemberRegisterForm',
    data() {
        return {
            userInfo: {
                id: '',
                password: ''
            }
        }
    },
    methods: {
        onSubmit() {
            const { id, password } = this.userInfo //와 이부분 ㅠㅠ .userInfo 안써서 개해멨다 ㅋㅋ ㅜ

            this.$emit('submit', { id, password })

            this.userInfo.id = '',
            this.userInfo.password = ''
        }
    }
}
</script>
