<template>
    <div>
        <v-toolbar>
            <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
            </v-app-bar-nav-icon>
            <v-toolbar-title >
                <span class="logo">
                    <a href="/cinzel">CINZEL</a></span>
            </v-toolbar-title>
            <v-toolbar-items class="login-locate">
                <!-- <span><member-login-form @submit="onSubmit"/></span> -->
                <v-btn  v-if="isLogin === false" text router :to="'/login'">로그인</v-btn>
                
                <v-menu offset-y v-if="isLogin">
                    <template v-slot:activator="{ on, attrs }">
                        <v-btn
                        text
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
            

            </v-toolbar-items>
        </v-toolbar>
        <v-navigation-drawer app v-model="nav_drawer" temporary>
            <v-list nav dense  class="menubar">
                <v-list-item-group v-model="group" active-class="deep-blue--text text--accent-4">
                    <v-list-item v-for="link in links" :key="link.name" router :to="link.route">
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
import { mapState,mapActions } from 'vuex'

export default {
    name: 'MenuBar',
    computed: {
        ...mapState(["isLogin"])
    },
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
                    text: 'ABOUT', name:'ABOUT',  route: '/about'
                },
                { 
                    text: 'ROOMS', name:'ROOMS', route: '/room301'
                },
                { 
                    text: 'TOUR', name:'TOUR', route: '/tourCrawler'
                },
                { 
                    text: 'RESERVATION', name:'RESERVATION', route: '/reservation'
                },
                { 
                    text: 'BOARD', name:'BOARD', route: '/board'
                }
            ]
        }
    },
    watch: {
        group () {
            this.nav_drawer = false
        }
    },
    methods: {
        ...mapActions(["logout"]),
    }
}

</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Cinzel+Decorative&display=swap');

.menubar {
    padding-top: 100px;
    padding-left: 40px;
}

.logo {
    padding-left: 41vw;
    vertical-align: middle;
    font-family: "Cinzel Decorative";
    font-size: 40px;
}
.account {
    padding-left: 40vw;
}
.login-locate {
    padding: 10px 0px 10px 0px;
    position: absolute;
    right: 0.5%;
}

</style>