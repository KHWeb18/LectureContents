<!--<template>
    <v-container fill-height style="max-width:450px;">
        <v-layout align-center row wrap>
            <v-flex xs12>
                 <v-alert
                    class="mb-3"
                    :value="isLoginError"
                    type="error"
                    >
                    아이디와 비밀번호를 확인해주세요.
                </v-alert>
                <v-alert
                    class="mb-3"
                    :value="isLogin"
                    type="success"
                    >
                    로그인이 완료되었습니다.
                </v-alert>
                <v-card>
                    <v-toolbar flat color="grey lighten-3">
                        <v-toolbar-title>로그인</v-toolbar-title>
                    </v-toolbar>
                    <div class="pa-3">
                        <v-text-field
                            v-model="userId"
                            label="이메일을 입력하세요"
                        >
                        </v-text-field>

                        <v-text-field
                            v-model="password"
                            type="password"
                            label="패스워드를 입력하세요"
                        >
                        </v-text-field>
                        <v-btn large block depressed color="primary"
                                @click="login({ userId, password })">로그인</v-btn>
                    </div>
                </v-card>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
import { mapState} from "vuex"
import axios from 'axios'
import { LOGIN_ERROR, LOGIN_SUCCESS } from '../store/mutation-types'


export default {
    data() {
        return {
            userId: '',
            password: ''
            // email : null,
            // password: null,
            // allUsers:[
            //     {id: 1, name: 'cholong', email: 'cholong@gmail.com', password: "1111"},
            //     {id: 2, name: 'rara', email: 'rara@gmail.com', password: "1111"}
            // ],
            // isError: false,
            // loginSuccess: false
        }
    },
    computed: {
        ...mapState(["isLogin", "isLoginError"])
    },
    methods: {
        // ...mapActions(["login"]),
        login(payload) {
            const { userId, password } = payload
        axios.post('http://localhost:7777/jpamember/login', { userId, password })
            .then(res => {
                if (res.data != "") {
                    alert('로그인 성공! - ' + res.data)
                    this.$store.commit(LOGIN_SUCCESS)
                    console.log(res)
                } else {
                    alert('로그인 실패! - ' + res.data)
                    this.$store.commit(LOGIN_ERROR)
                }
            })
            .catch(res => {
                alert(res.response.data.message)
            })
  },
        // login() {
        //     let selectedUser = null
        //     this.allUsers.forEach(user => {
        //         if(user.email ===  this.email) selectedUser = user
        //     })
        //     selectedUser === null
        //     ? (this.isError =true)
        //     : selectedUser.password !== this.password 
        //         ? (this.isError =true)
        //         : (this.loginSuccess =true)
        // }
    }
}
</script> -->