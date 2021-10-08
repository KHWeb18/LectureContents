<template>
    <div>
        <h2>로그인</h2>
        <vuetify-member-register-form @submit="onSubmit" />

        
    <v-btn tile color="teal" @click="onJPATest">
        Click me
    </v-btn>
    <v-spacer></v-spacer>
        <v-btn tile color="teal" @click="showSession">
            <v-icon left>
                ads_click
            </v-icon>
            세션 보기
        </v-btn>
        <v-spacer></v-spacer>
        <v-btn tile color="teal" @click="removeSession">
            <v-icon left>
                ads_click
            </v-icon>
            세션 끊기
        </v-btn>
    </div>
</template>

<script>
import VuetifyMemberRegisterForm from '../components/member/LoginForm.vue'

import axios from 'axios'
export default {
    name: 'VuetifyMemberRegisterFormPage',
    components: {
        VuetifyMemberRegisterForm
    },
       data () {
        return {
            isLogin: false
        }
    },
    methods: {
        onSubmit (payload) {
            const { id, pw } = payload
            axios.post('http://localhost:7777/jpamember/login', { userId: id, password: pw, auth: null })
                    .then(res => {
                        if (res.data != "") {
                            alert('로그인 성공! - ' + res.data)
                            this.isLogin = true
                        } else {
                            alert('로그인 실패! - ' + res.data)
                        }
                        /*
                        this.$router.push({
                            name: 'BoardReadPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                        */
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        },
            showSession () {
            if (this.isLogin == true) {
                axios.post('http://localhost:7777/jpamember/needSession')
                        .then(res => {
                            if (res.data == true) {
                                alert('세션 정보 유지! - ' + res.data)
                            } else {
                                alert('세션 정보 유지 안되는 중! - ' + res.data)
                            }
                            /*
                            this.$router.push({
                                name: 'BoardReadPage',
                                params: { boardNo: res.data.boardNo.toString() }
                            })
                            */
                        })
                        .catch(res => {
                            alert(res.response.data.message)
                        })
            } else {
                alert('먼저 로그인부터 하세요!')
            }
        },
        removeSession () {
            axios.post('http://localhost:7777/jpamember/removeSession')
                    .then(res => {
                        this.isLogin = res.data
                    })
    }
    }
}
</script>

