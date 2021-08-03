<template>
    <div>
        <p class="blue lighten-5 red-text">Test</p>
        <p class="blue white-text">Test</p>
        <p class="blue darken-3">Test</p>
        <v-btn class="teal" rounded @click="roundBtnClick">Round 버튼</v-btn>
        <v-btn class="indigo blue--text" @click="roundBtnClick">기본 버튼</v-btn>

        <v-btn class="btn waves-effect waves-teal pink" dark>
            <!-- v-btn과 a로 하는 것의 차이점? -->
            <v-icon>bluetooth</v-icon>
        </v-btn>

        <v-btn fab color="orange" light> <!-- 여기에 들어가는 dark, light의 역할 뭐? -->
            <v-icon>bluetooth</v-icon>
            
        </v-btn>

        <v-btn color="blue" class="hidden-xs-only">XS</v-btn>
        <v-btn color="red" class="hidden-sm-only">SM</v-btn>
        <v-btn color="teal" class="hidden-md-only">MD</v-btn>
        <v-btn color="pink" class="hidden-lg-only">LG</v-btn>
        <v-btn color="yellow" class="hidden-xl-only">XL</v-btn>
        <!-- 화면 크기에 따라 얘네들이 보였다 나왔다 함. 그 상태의 것이 사라진다. -->


        <v-layout row justify-center>
            <v-dialog v-model="dialog" persistent max-width="400">
                <!-- dialog는 팝업창 띄워주는역할 -->
                <template v-slot:activator="{ on }">
                    <v-btn color="primary" dark v-on="on">결제</v-btn>
                </template>
                <!-- 팝업창에서 선택하는 폼이라는데.. 이해가 잘안되서 패턴처럼 외우는게 나을듯 
                어쨋든 이 dialog 기능을 on시키는거라고 생각하면된다. -->
                <v-card>
                    <v-card-title class="headline">
                        {{ service.name }}
                    </v-card-title>
                    <v-card-text>
                        {{ service.description }}                        
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn class="teal darken-1" text v-on:click.native="btn_withdraw($event)">
                            취소
                        </v-btn>
                        <v-btn color="teal darken-1" text @click.native="btn_click($event)">
                            결제 승인
                        </v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
        </v-layout>

        <v-container fluid>
            <!-- Grid 시스템의 한 행을 정의함, Container는 너비 70퍼로 줄여서 보여줌-->
            <v-layout row wrap>
                <!-- 12개의 컬럼으로 이뤄져 한 행에서 제일 작은것들이 12개가 만들어지면 다음으로 자동 넘김 처리 -->
                <v-flex xs12 md6 class="primary white--text">
                    <div class="red">x</div>
                </v-flex>
                <v-flex xs4 md2 class="green white--text">
                    <div class="blue">x</div>
                </v-flex>
                <v-flex xs4 md2 class="green white--text">
                    <div class="teal">x</div>
                </v-flex>
                <v-flex xs4 md2 class="green white--text">
                    <div class="orange">x</div>
                </v-flex>
            </v-layout>
            <v-layout row wrap>
                <v-flex xs4 md3 class="teal white--text">
                    <div class="teal">x</div>
                </v-flex>
                <v-flex xs4 md3 class="teal white--text">
                    <div class="orange">x</div>
                </v-flex>
            </v-layout>
        </v-container>

        <v-dialog v-model="loginDialog" persistent max-width="400">
                <!-- dialog는 팝업창 띄워주는역할 -->
                <template v-slot:activator="{ on }">
                    <v-btn color="teal" dark v-on="on">login</v-btn>
                </template>
                <!-- 팝업창에서 선택하는 폼이라는데.. 이해가 잘안되서 패턴처럼 외우는게 나을듯 
                어쨋든 이 dialog 기능을 on시키는거라고 생각하면된다. -->
                <v-card>
                    <v-card-title class="headline">
                        Log In
                    </v-card-title>
                    <v-card-text>              
                        <v-container grid-list-md> <!-- grid-list-md?? -->
                            <v-layout wrap>  
                                <v-flex xs12>
                                    <v-text-field label="Email" type="text" required v-model="userInfo.email">                                       
                                    </v-text-field>
                                </v-flex>
                                <v-flex xs12>
                                    <v-text-field label="password" type="password" required v-model="userInfo.password">                                       
                                    </v-text-field>
                                </v-flex>
                            </v-layout>
                        </v-container>              
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn class="teal darken-1" text v-on:click.native="btn_login($event)">
                            로그인
                        </v-btn>
                        <v-btn class="teal darken-1" text @click.native="btn_cancel($event)">
                            취소
                        </v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>

            <v-toolbar>
                <v-toolbar-items v-if="$vuetify.breakpoint.smAndUp"> <!-- sm 부터 보인다는 뜻, xs에서는 안보임! -->
                    <v-btn text class="btn waves-effect waves-teal pink">Home</v-btn>
                    <v-btn text class="btn waves-effect waves-teal black">About Us</v-btn>
                    <v-btn text class="btn waves-effect waves-teal blue">More</v-btn>
                </v-toolbar-items>
            </v-toolbar>

            <v-toolbar>
                <v-toolbar-items class="d-sm-none"> <!-- sm 부터 아무것도 안보인다는 뜻, 중간에 들어가는 크기부터 안보임 d의 뜻?-->
                    <v-btn >Home</v-btn>
                    <v-btn >집에갈래요</v-btn>
                    <v-btn >드루오세요</v-btn>
                </v-toolbar-items>
            </v-toolbar>

            <!-- <v-toolbar dense dark>
                <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
                </v-app-bar-nav-icon> 
                
                <v-toolbar-title>
                    <span class="font-weight-light">The Best Tour on the Earth</span>
                    <span>Super 꿀팁</span>
                </v-toolbar-title>
                <v-toolbar-items>
                    <v-btn text v-for="link in links" v-bind:key="link.icon" :to="link.route">
                        {{ link.icon }}
                    </v-btn>
                </v-toolbar-items>
            </v-toolbar> -->

            <v-navigation-drawer app v-model="nav_drawer" temporary>
            <!-- <v-navigation-drawer app permanent> -->
            <!-- app 는 App.vue에 있는 자식? 바꿀일은 없다. 커스터마이즈하지 않는 이상 app 을 건드릴필요 없다 -->
                <v-list nav>
                    <v-list-item-group v-model="group" active-class="deep-purple--text text--accent-4">
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
            
            <div class="container">
                <!-- :headers의 뜻 => vuetify의 데이터 테이블을 향해 자동으로 headerTitle을 headers로써 보낸다. 
                보내는 자식 컴퍼넌트는 자동으로 디폴트로 설정된 v-data-table이다. -->
                <v-data-table :headers="headerTitle" 
                            :items="contents"
                            :items-per-page="10"
                            class="elevation-1">
                </v-data-table>
            </div>

    </div>
</template>

<script>
export default {
    data() {
        return {
            headerTitle: [
                { text: 'Content No', value: 'no', width: "70px" },
                { text: 'Title', value: 'title', width: "150px" },
                { text: 'Writer', value: 'writer', width: "100px" },
                { text: 'Content', value: 'content', width: "100px" }
                //text, value는 v-data-table에서 고정된 이름, 여기에 맞춰서 작성해야한다.
            ],
            contents: [
                { no: 1, title: 'Hi', writer: 'jdy7744', content: 'fuck!' },
                { no: 2, title: 'fuxx', writer: 'fsdd1212', content: 'GoGo!' },
                { no: 3, title: '~', writer: 'vxc3211', content: 'kkkk!' },
                { no: 4, title: 'ㅋㅋ', writer: 'ㅇㄴ', content: 'ㅋㅋ!' },
                { no: 5, title: 'ㅇㅇ', writer: '211ㄴㅇ', content: 'ㅇㅇㅇ!' },
            ],
            nav_drawer: false,
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
                    route: '/',
                    
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
                alert('HOME!')
            }
        }
    },watch: { //watch가 뭐녀
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