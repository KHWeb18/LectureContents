<template>
    <div>
        <v-toolbar dense dark>
            <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
            </v-app-bar-nav-icon>
            <v-toolbar-title>
                <span class="font-weight-light">쵝오의 여행!</span>
            </v-toolbar-title>
            <v-toolbar-items>
                <v-btn text v-for="link in links" :key="link.icon" :to="link.route">
                    {{ link.text }}
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
            message: '환장',
            nav_drawer: false,
            group: false,
            dialog: false,
            loginDialog: false,
            service: {
                name: '7박 8일 여행 코스'
            },
            userInfo: {
                email: '',
                password: ''
            },
            links: [
                {
                    icon: 'home', text: 'Home', name: 'home', route: '/'
                },
                {
                    icon: 'credit_card', text: '법인카드', name: 'credit_card', route: '/product'
                },
                {
                    icon: 'ev_station', text: 'EV Station', name: 'ev_station', route: '/materialize'
                }
            ]
        }
    },
    methods: {
        btn_click ($event) {
            if ($event.target.innerHTML == " 결제승인 ") {
                alert('결제가 완료되었습니다!')
                this.dialog = false
            }
        },
        roundBtnClick () {
            alert('Vuetify 버튼이라고 들어봤니 ?')
        },
        btnLoginClick ($event) {
            if ($event.target.innerHTML == " 확인 ") {
                alert('로그인이 완료되었습니다!')
                console.log("입력된 정보 - 이메일: " + this.userInfo.email + 
                            ", 비밀번호: " + this.userInfo.password)
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