<template>
    <div>
        {{$store.state.session}}
        <v-toolbar dense color="blue-grey lighten-4">
                <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
                </v-app-bar-nav-icon>
                    <v-toolbar-title>
                        <span class="font-weight-light">COVID-19</span>
                    </v-toolbar-title>
                    <div class="flex-grow-1"></div>
                    <v-toolbar-items v-if="$store.state.session == null">
                        <v-btn  text class="text-right" 
                                    v-for="link in links" :key="link.icon" :to="link.route" >
                                    {{link.text}}
                        </v-btn>
                    </v-toolbar-items>
                    <v-toolbar-items v-if="$store.state.session != null">
                        <v-btn  text class="text-right" 
                                    v-for="flink in flinks" :key="flink.icon" :to="flink.route">
                                    {{flink.text}}
                        </v-btn>
                    </v-toolbar-items>
            </v-toolbar>
        <v-navigation-drawer app v-model="nav_drawer" temporary>
            <v-list nav dense  v-if="$store.state.session == null">
                <v-list-item-group v-model="group" active-class="deep-purple--text text--accent-4">
                    <v-list-item v-for="link in links" :key="link.name" router :to="link.route">
                        <v-list-item-action>
                            <v-icon left>{{ link.icon }}</v-icon>
                        </v-list-item-action>
                        <v-list-item-content>
                            <v-list-item-title>{{ link.text }}</v-list-item-title>
                        </v-list-item-content>               
                    </v-list-item>
                </v-list-item-group>
            </v-list>
            <v-list nav dense  v-if="$store.state.session != null">
                <v-list-item-group v-model="group" active-class="deep-purple--text text--accent-4">
                    <v-list-item v-for="flink in flinks" :key="flink.name" router :to="flink.route">
                        <v-list-item-action>
                            <v-icon left>{{ flink.icon }}</v-icon>
                        </v-list-item-action>
                        <v-list-item-content>
                            <v-list-item-title>{{ flink.text }}</v-list-item-title>
                        </v-list-item-content>      
                        <v-list-item-content>
                        </v-list-item-content>           
                    </v-list-item>
                </v-list-item-group>
            </v-list>
        </v-navigation-drawer>

    </div>
</template>

<script>

import { mapState, mapActions } from 'vuex'
import Vue from 'vue'
import cookies from 'vue-cookies'
import axios from 'axios'
Vue.use(cookies)

export default {
    data () {
        return {
            nav_drawer: false,
            group: false,
        
            links:
                [
                    {
                        icon: 'home',
                        text: 'Home',
                        name: 'Home',
                        route:'/'
                    },
                    {
                        icon: 'open_in_new',
                        text: '로그인',
                        name: 'login',
                        route:'/sessionLogin'
                    },
                    {
                        icon: 'account_circle',
                        text: '회원가입',
                        name: 'register',
                        route:'/accountRegister'
                    }
                ],
            flinks:
                [
                    {
                        icon: 'home',
                        text: 'Home',
                        name: 'Home',
                        route:'/'
                    },
                    {
                        icon: 'open_in_new',
                        text: '로그아웃',
                        name: 'logout',
                        route:'/logout'

                    },
                    {
                        icon: 'account_circle',
                        text: '마이페이지',
                        name: 'Mypage',
                        route:'/mypage'
                    }
                ],
                isLogin: false,
        }
    },

        
    watch: {
        group () {
            this.nav_drawer = false
        }
    },
    mounted () {
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
        ...mapActions(['fetchSession']),
        onSubmit (payload) {
            if (this.$store.state.session == null) {
                const { email, password } = payload
                axios.post('http://localhost:3647/jpasession/sign-in', { email, password })
                        .then(res => {
                            if (res.data.hashcode != null) {
                                alert('로그인 성공! - ' + res.data)
                                this.isLogin = true
                                this.$store.state.session = res.data
                                this.$cookies.set("user", res.data, '10h')
                                
                            } else {
                                alert('로그인 실패! - ' + res.data)
                                this.isLogin = false
                            }
                        })
                        .catch(res => {
                            alert(res.response.data.message)
                        })
            } else {
                alert('이미 로그인 되어 있습니다 - 계정: ' + this.$store.state.session.email)
            }
        },
        showSession () {
            if (this.isLogin == true) {
                axios.post('http://localhost:3647/jpamember/needSession')
                        .then(res => {
                            if (res.data == true) {
                                alert('세션 정보 유지! - ' + res.data)
                            } else {
                                alert('세션 정보 유지 안되는 중! - ' + res.data)
                            }
                        
                        })
                        .catch(res => {
                            alert(res.response.data.message)
                        })
            } else {
                alert('먼저 로그인부터 하세요!')
            }
        },
        removeSession () {
            axios.post('http://localhost:3647/jpamember/removeSession')
                    .then(res => {
                        this.isLogin = res.data
                    })
        },
        logout () {
            this.$cookies.remove("user")
            this.isLogin = false
            this.$store.state.session = null
        }
    }
    
}
</script>

<style scoped>
h1 {
    margin: 10px;
}
p {
    padding: 10px;
    margin: 5px 10px;
}
</style>


