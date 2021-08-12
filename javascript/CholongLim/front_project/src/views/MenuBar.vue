<!--<template>
        <v-navigation-drawer v-model="drawer" :mini-variant.sync="mini"
        width="350px" permanent position="fixed">
        <v-list-item class="px-2">
            <v-list-item-avatar>
            <v-icon>menu</v-icon>
            </v-list-item-avatar>

            <v-list-item-title>MENU</v-list-item-title>

            <v-btn icon @click.stop="mini = !mini">
            <v-icon>close</v-icon>
            </v-btn>
        </v-list-item>
        <v-spacer></v-spacer>
        
        <v-container>
            <v-container>
                <v-list> 
                    <v-list-item v-for="link in links" :key="link.name" router :to="link.route">
                        <v-list-item-content>
                            <v-list-item-title right>{{ link.text }}</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-list>
            </v-container>
        </v-container>
        </v-navigation-drawer>
</template>

<script>
  export default {
    data () {
      return {
        drawer: true,
        links: [
                { 
                    text: 'ABOUT', name:'ABOUT',  route: '/'
                },
                { 
                    text: 'ROOMS', name:'ROOMS', route: '/'
                },
                { 
                    text: 'TOUR', name:'TOUR', route: '/'
                },
                { 
                    text: 'RESERVATION', name:'RESERVATION', route: '/'
                },
                { 
                    text: 'BOARD', name:'BOARD', route: '/'
                }
            ],
        mini: true,
      }
    },
  }
</script>-->

<template>
    <div>
        <v-toolbar>
            <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
            </v-app-bar-nav-icon>
            <v-toolbar-title>
                <span class="logo">
                    <a href="/cinzel">CINZEL</a></span>
            </v-toolbar-title>
            <v-toolbar-items class="login-locate">
                <!-- <span><member-login-form @submit="onSubmit"/></span> -->
                <v-btn text router :to="'/login'">로그인</v-btn>
                
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

export default {
    name: 'MenuBar',
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
                    text: 'TOUR', name:'TOUR', route: '/tour'
                },
                { 
                    text: 'RESERVATION', name:'RESERVATION', route: '/reservation'
                },
                { 
                    text: 'BOARD', name:'BOARD', route: '/boardList'
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
        logout() {
            console.log('로그아웃')
        }
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