<template>
    <div>
        <v-toolbar dense color="blue lighten-3">
                <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
                </v-app-bar-nav-icon>
                    <v-toolbar-title>
                        <span class="font-weight-light">COVID-19 PAGE </span>
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
                session:[],

        }
    },

        
    watch: {
        group () {
            this.nav_drawer = false
        }
    },
    created(){
        this.session= this.$store.state.session
        
    },
    
    
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


