<template>
    <div>
        <v-toolbar dense dark>
            <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
            </v-app-bar-nav-icon>
            <v-toolbar-title>
                <span class="font-weight-light">JEJU</span>
                <span>숙소</span>
            </v-toolbar-title>
            <v-toolbar-items>
                
                <v-btn v-if="isLogin === false" route :to="{name : 'Login'}">Login</v-btn>

                <v-menu offset-y v-if="isLogin">
                    <template v-slot:activator="{ on, attrs }">
                        <v-btn
                        flat
                        dark
                        v-bind="attrs"
                        v-on="on"
                        >
                        <v-icon>account_circle</v-icon>
                        </v-btn>
                    </template>
                    <v-list>
                        <v-list-item router :to="{name: 'MyPage'}">
                        <v-list-item-title>마이페이지</v-list-item-title>
                        </v-list-item>
                        <v-list-item @click="logout">
                        <v-list-item-title>로그아웃</v-list-item-title>
                        </v-list-item>
                    </v-list>
                </v-menu>
                <v-btn v-if="isLogin === true" route :to="{name: 'MyPage'}">MyPage</v-btn>

            </v-toolbar-items>
        </v-toolbar>
        <v-navigation-drawer app v-model="nav_drawer" temporary>
            <v-list nav dense>
                <v-list-item-group v-model="group" active-class="deep-blue--text text--accent-4">
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
        </v-navigation-drawer>
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
    name: 'VuetifyAllInOnTestPage',
    data () {
        return {
            nav_drawer: false,
            group: false,
            message: '오잉',
            dialog: false,
            loginDialog: false,
            service: {
                name: 'Room 401호'
            },
            userInfo: {
                email: '',
                password: ''
            },
            links: [
                { 
                    icon: 'home', text: 'Home', name: 'Home', route: '/'
                },
                { 
                    icon: 'account_circle', text: '로그인', name: 'account_circle', route: '/login'
                },
                { 
                    icon: 'favorite', text: '마이페이지', name: 'favorite', route: '/mypage'
                },
            ]
        }
    },
    computed: {
        ...mapState(["isLogin"])
    },
    methods: {
        ...mapActions(["logout"]),
        btn_click ($event) {
            if($event.target.innerHTML == " 결제승인 ") {
                alert('결제가 완료되었습니다.')
                this.dialog = false
            } else {
                this.dialog = false
            }
        },
        roundBtnClick () {
            alert('Vuetify 버튼이다')
        },
        btnLoginClick ($event) {
            if($event.target.innerHTML == " 로그인 ") {
                alert('로그인이 완료되었습니다.')
                console.log('입력된 정보 - 이메일: ' + this.userInfo.email + 
                ', 비밀번호: ' + this.userInfo.password)
                this.loginDialog = false
            } else {
                this.loginDialog = false
            }
            this.userInfo.email = ''
            this.userInfo.password = ''

        }
    },
    watch: {
        group () {
            this.nav_drawer = false
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