<template>
    <div>
        <v-btn tile color="teal" @click="logout" v-if="isLogin">
            <v-icon left>
                ads_click
            </v-icon>
            로그 아웃
        </v-btn>
        <div align="center" v-else>
            <h2>로그인</h2>
            <vuetify-member-login-form @submit="onSubmit"/>
        </div>
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
import VuetifyMemberLoginForm from '@/components/member/VuetifyMemberLoginForm.vue'
import axios from 'axios'
import { mapState } from 'vuex'
import Vue from 'vue'
import cookies from 'vue-cookies'

Vue.use(cookies)

export default {
    name: 'VuetifyMemberLoginPage',
    components: {
        VuetifyMemberLoginForm
    },
    data () {
        return {
            isLogin: false
        }
    },
    mounted () {
        this.$store.state.session = this.$cookies.get("user")

        if(this.$store.state.session != null) {
            this.isLogin = true;
        }
    },
    computed: {
        ...mapState(['session'])
    },
    methods: {
        onSubmit (payload) {
            if(this.$store.state.session == null) {
            const { userId, password } = payload
            axios.post('http://localhost:7777/jpamember/login', { userId, password, auth: null })
                    .then(res => {
                        if (res.data != "") {
                            alert('로그인 성공! - ' + res.data.userId)
                            this.isLogin = true;
                            this.$store.state.session = res.data
                            this.$cookies.set("user", res.date, '1h')
                        } else {
                            alert('로그인 실패! - ' + res.data)
                            this.isLogin = false;
                        }
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
            } else {
                alert('이미 로그인 되어 있습니다.' + this.$store.state.session.userId)
            }
        },
        logout () {
            this.$cookies.remove("user")
            this.isLogin = false
            this.$store.state.session = null
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
                        alert('로그아웃')
                    })
        }
    }
}
</script>