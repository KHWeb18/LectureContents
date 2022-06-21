<template>
    <div>
        <v-toolbar flat color="transparent">
          
            <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer" ></v-app-bar-nav-icon>
                    <v-btn text router :to="'/cinzel'" class="home-btn" plain>
                    home
                    </v-btn>
                    
                <v-toolbar-items class="login-locate">
                    <v-btn plain text v-if="this.cookie === false " router :to="'/login'">
                    <v-icon>input</v-icon>
                    </v-btn>
                    
                    <v-menu offset-y v-if="(this.cookie === true) && (this.individual == '개인')">
                        <template v-slot:activator="{ on, attrs }">
                            <v-btn text v-bind="attrs" v-on="on">
                                <v-icon>account_circle</v-icon>
                            </v-btn>
                        </template>
                        <v-list>

                            <v-list-item router :to="{name: 'UserList'}">
                                <v-list-item-title>마이페이지</v-list-item-title>
                            </v-list-item>
                            <v-list-item @click="logout">
                                <v-list-item-title>로그아웃</v-list-item-title>
                            </v-list-item>
                        </v-list>
                    </v-menu>

                    <v-menu offset-y v-if="(this.cookie === true) && (this.individual != '개인')">
                        <template v-slot:activator="{ on, attrs }">
                            <v-btn text v-bind="attrs" v-on="on">
                                <v-icon>account_circle</v-icon>
                            </v-btn>
                        </template>
                        <v-list>
                            <v-list-item router :to="{name: 'MemberListPage'}">
                                <v-list-item-title >관리자페이지</v-list-item-title>
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

import { mapActions, mapState } from 'vuex'

export default {
    name: 'MenuBar',
    computed: {
        ...mapState(["isLogin","userInfo"])
    },
    data () {
        return {
            nav_drawer: false,
            group: false,
            cookie: this.$cookies.isKey('user'),
            individual: this.$cookies.get('auth'),
            userId: this.$cookies.get('user'),
            links: [
                { 
                    text: 'ABOUT', name:'ABOUT',  route: '/about'
                },
                { 
                    text: 'ROOMS', name:'ROOMS', route: '/rooms'
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
        ...mapActions(['logout'])
    }
}

</script>


<style scoped>

@import url('https://fonts.googleapis.com/css2?family=Cinzel+Decorative&display=swap');

.menubar {
    padding-top: 100px;
    padding-left: 40px;
}

.nav-menu{
    position: absolute;
    top:3%;
    left:1%;

}

.logo {
    font-family: "Cinzel Decorative";
    font-size: 40px;
    margin: 0 auto;

}
.account {
    padding-left: 40vw;
}
.login-locate {
    padding: 10px 0px 10px 0px;
    position: absolute;
    right: 0.5%;
    top:1%;
}

.home-btn{
    padding: 10px 0px 10px 0px;
    position: absolute;
    right: 5%;
    top:22%;
}

</style>