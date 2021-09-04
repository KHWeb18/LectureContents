<template>
    <div class="session" style="margin: 200px auto 0;">
        <v-btn title color = 'teal' @click="logout" v-if="isLogin">
            <v-icon left>
                ads_click
            </v-icon>
            로그 아웃
        </v-btn>
        <div v-else>
        <member-login-form @submit="onSubmit"/>
        </div>
         <v-spacer></v-spacer>
        <v-btn tile color="teal" @click="showSession">
            <v-icon left>
                ads_click
            </v-icon>
            세션 보기
        </v-btn>
        <v-spacer></v-spacer>
 
    </div>

</template>

<script>
import MemberLoginForm from '@/components/member/MemberLoginForm.vue'
import axios from 'axios'
import Vue from 'vue'
import cookies from 'vue-cookies'
import { mapState } from 'vuex'

Vue.use(cookies)

export default {
    name: 'MemberLogin',
    components: {
        MemberLoginForm,
    },
     data () {
        return {
            isLogin: false,
         
        }
    },
    mounted() {
        // this.fetchSession()
        this.$store.state.session = this.$cookies.get("user")

        if (this.$store.state.session != null) {
            this.isLogin = true
        }
    },
    computed: {
        ...mapState(['session'])
    },
    methods: {
        onSubmit (payload) {
               if (this.$store.state.session == null) {
            const { id, pw } = payload
            axios.post('http://localhost:1111/jpamember/login', { userId: id, password: pw, auth: null })
                    .then(res => {
                        if (res.data !== "") {
                            alert('로그인 성공! - ' + res.data)  
                            this.isLogin = true;
                             this.$store.state.session = res.data
                            this.$cookies.set("user", res.data, '1h')
                           this.$router.push({
                            path: '/MainHome' 
                        }) 
                   
                        } else {
                           alert('아이디, 비밀번호를 확인하세요! - ' + res.data)
                            this.isLogin = false
                        } 
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
               } else {
                alert('이미 로그인 되어 있습니다' + this.$store.state.session.userId)
            }
        },
    showSession () {
            if (this.isLogin == true) {
                axios.post('http://localhost:1111/jpamember/needSession')
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
  
        logout() {
            this.$cookies.remove("user")
            this.isLogin = false
            this.$store.state.session = null
        }
    }
}
</script>