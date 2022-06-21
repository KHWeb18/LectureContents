<template>
    <div>

            <v-toolbar dense dark>
                <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
                    <v-icon>dehaze</v-icon> 
                </v-app-bar-nav-icon>
                <v-toolbar-title>
                    <span class="font-weight-light">NAVI</span>
                    <span>BAR</span>
                </v-toolbar-title>
                <v-toolbar-items>
                    <v-btn text v-for="link in links" v-bind:key="link.icon" :to="link.route" @click="doMethods($event)">
                        {{ link.text }}
                    </v-btn>
                </v-toolbar-items>
            </v-toolbar>

            <v-navigation-drawer app v-model="nav_drawer" temporary>          
            <!-- app permanent는 App.vue에 있는 자식? 바꿀일은 없다. 커스터마이즈하지 않는 이상 app parmanent를 건드릴필요 없다 -->
                <v-list nav dense>
                    <v-list-item-group v-model="group" active-class="deep-purple--text text--accent-4"> <!-- 여기서 v-model="group"의 역할? -->
                        <v-list-item v-for="link in links" :key="link.name" router :to="link.route"> <!-- :to="link.route" 링크 연결 -->
                            <v-list-item-action>
                                <v-icon left>{{ link.icon }}</v-icon>
                            </v-list-item-action>
                            <v-list-item-content>
                                <v-list-item-title>{{ link.text }}</v-list-item-title>
                                <!-- 메소드도 넣을 수 있다 -->
                            </v-list-item-content>
                        </v-list-item>
                    </v-list-item-group>
                </v-list>
            </v-navigation-drawer>
    </div>
</template>

<script>
export default {
    data() {
        return {
            nav_drawer: false,
            group: 2,
            dialog: false,
            loginDialog: false,
            service: {
                name: '7박 8일 여행 코스',
                description: '5% OFF for 5stars hotel!'
            },
            userInfo: {
                email: '',
                password: ''
            },
            links: [
                    {
                    icon: 'home',
                    text: 'Home',
                    name: 'Home',
                    route: '/'
                },
                    {
                    icon: 'album',
                    text: 'Album',
                    name: 'Album',
                    route: 'materialize'

                },
                    {
                    icon: 'beenhere',
                    text: 'Beenhere',
                    name: 'Beenhere',
                    route: 'materializeGridTestPage'
                }

            ]
        }
    },
    methods: {
        roundBtnClick () {
            alert('Vuetify 버튼이라고 들어봤니 ?')
        },
        btn_click() {
            alert('결제가 완료되었습니다!')
            this.dialog = false
        },
        btn_withdraw() {
            alert('결제가 취소되었습니다!')
            this.dialog = false
        },
        btn_login($event) {
            if($event.target.innerHTML == " 로그인 ") {
                this.loginDialog = false
                alert('로그인되었습니다!')
            }
        },
        btn_cancel() {
            alert('로그인 취소!')
            this.loginDialog = false
        },
        doMethods($event) {
            if($event.target.innerHTML == " Home ") {
                alert('Home!')
            } else if($event.target.innerHTML == " Album ") {
                alert('Album!')
            } else if($event.target.innerHTML == " Beenhere ") {
                alert('Beenhere!')
            } //이렇게 toolbar list에 메소드 넣는것도 가능
        }
    },
    watch: { 
        group() {
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
