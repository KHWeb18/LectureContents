<template>
    <v-container>
        <form @submit.prevent="onSubmit">
            <h3>로그인 양식</h3>
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
                <button type="submit">로그인</button>
                <router-link :to="{ name: 'Home' }">
                    취소
                </router-link>
            </div>
        </form>
    </v-container>
</template>

<script>

import axios from 'axios'

export default {
    name: 'PythonLoginTestPage',
    data () {
        return {
            id: '',
            pw: ''
        }
    },
    methods: {
        onSubmit () {
            const { id, pw } = this
            axios.post('http://localhost:5000/login', { userId: id, password: pw })
                    .then(res => {
                        if (res.data != "") {
                            alert('로그인 성공! - ' + JSON.stringify(res.data))
                        } else {
                            alert('로그인 실패! - ' + res.data)
                        }
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}

</script>