<template>
     <v-container fill-height style="max-width:450px;">
        <v-layout align-center row wrap>
            <v-flex xs12>
                <v-card>
                    <v-toolbar flat color="grey lighten-3">
                        <v-toolbar-title>관리자 로그인</v-toolbar-title>
                    </v-toolbar>

            
                    <div class="pa-3">
                        <v-text-field
                            v-model="userId"
                            type="id"
                             :rules="[v => !!v || '필수정보입니다.']"
                            label="이메일을 입력하세요"
                        >
                        </v-text-field>

                        <v-text-field
                            v-model="password"
                            type="password"
                             :rules="[v => !!v || '필수정보입니다.']"
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
import { LOGIN_ERROR, LOGIN_SUCCESS } from '@/store/mutation-types'
import { mapState } from 'vuex'
import axios from 'axios'

export default {
    name: 'CinzelMemberLogin',
    data () {
        return {
            userId: '',
            password: '',
        }
    },
    computed: {
        ...mapState(["isLogin", "isLoginError", "administratorLogin"]),
    },
    methods: {
        login ( payload) {
            const { userId, password } = payload
            axios.post('http://localhost:8888/jpamember/login', { userId, password})
                    .then(res => {
                        if(res.data != "") {
                            alert('로그인이 완료되었습니다.')
                            console.log(res)
                            this.isLogined = true;
                            this.$store.commit(LOGIN_SUCCESS)

                            let token = res.data.userId
                            console.log(token)
                            localStorage.setItem("access_token", token)
                            this.$router.push({
                                    name: 'ManagerPage'
                                    })
                        } else {
                            alert('아이디와 비밀번호를 확인해주세요.')
                            this.$store.commit(LOGIN_ERROR)
                        }
                    })
                    .catch(res => {
                        console.log(res)
                    })
        }
    }
}
</script>