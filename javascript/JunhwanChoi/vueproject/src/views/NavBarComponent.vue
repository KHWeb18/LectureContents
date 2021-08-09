<template>
    <div>
        <v-toolbar dense color="blue lighten-3">
                <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
                </v-app-bar-nav-icon>
                    <v-toolbar-title>
                        <span class="font-weight-light">COVID-19 PAGE</span>
                    </v-toolbar-title>
                    <div class="flex-grow-1"></div>
                    <v-toolbar-items>
                        <v-btn text class="text-right" 
                                    v-for="link in links" :key="link.icon" :to="link.route">
                                    {{link.text}}
                        </v-btn>
                        
                    </v-toolbar-items>
            </v-toolbar>
        <v-navigation-drawer app v-model="nav_drawer" temporary>
            <v-list nav dense>
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
        </v-navigation-drawer>
    </div>
</template>

<script>
export default {
    name: 'VuetifyAllInOneTestPage',
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
                        route:'/login'
                    },
                    {
                        icon: 'account_circle',
                        text: '회원가입',
                        name: 'register',
                        route:'/register'
                    }
                ],
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


