<template>
    <div>
        <p class="blue lighten-5 red-text">Test</p>
        <p class="blue white--text">Test</p>
        <p class="blue darken-3">Test</p>
        <v-btn class="cyan" rounded @click="roundBtnClick">Round 버튼</v-btn>
        <v-btn class="indigo white--text">기본 버튼</v-btn>
        <v-btn class="blue" dark>
            <v-icon>bluetooth</v-icon>
        </v-btn>
        <v-btn fab class="green" dark>
            <v-icon>bluetooth</v-icon>
        </v-btn>

        <!-- 화면 크기에 따라 배치가 어떻게 되는지를 확인할 수 있다.
             ui 작업 시 아래 3개를 켜놓고 사이즈 조절해야 한다. -->
        <v-btn color="purple" class="hidden-xs-only">Visibility -xs-only</v-btn>
        <v-btn color="orange" class="hidden-sm-only">Visibility -sm-only</v-btn>
        <v-btn color="yellow" class="hidden-md-only">Visibility -md-only</v-btn>

        <!-- 앞서서 살펴봤던 container의 역할을 수행하며
             grid 기능을 서포트해주고 기본적으로 페이지 중앙에 자동 배치함 -->
        <v-container fluid>
            <!--Grid 시스템의 한 행을 정의함 
                row 행, wrap 감싼다 -->
            <v-layout row wrap>
                <!-- 12개의 컬럼으로 이루어져 한 행에서 
                제일 작은 것들이 12개가 만들어지면 
                다음으로 자동 넘김 처리 -->
                <v-flex xs12 md6 class="primary whit--text">
                    <div>{{ message }}</div>
                </v-flex>
                <v-flex xs4 md2 class="green whit--text">
                    <div>{{ message }}</div>
                </v-flex>
                <v-flex xs4 md2 class="green whit--text">
                    <div>{{ message }}</div>
                </v-flex>
                <v-flex xs4 md2 class="green whit--text">
                    <div>{{ message }}</div>
                </v-flex>
            </v-layout>
            <v-layout row wrap>
                <v-flex xs4 md3 class="red whit--text">
                    <div>{{ message }}</div>
                </v-flex>
                <v-flex xs4 md3 class="red whit--text">
                    <div>{{ message }}</div>
                </v-flex>
            </v-layout>
        </v-container>

        <!-- justify-center 정중앙배치 -->
        <v-layout rpw justify-center>
            <!-- 사용자에게 알림을 제공하거나 중요 정보를 포함해 의사 결정을 하도록 유도하는데 활용 
            대화 상자가 뜨면서 결제할 것인지 취소할 것인지 등등에 활용하기 좋음
            v-dialog에 template을 넣고 v-btn으로 아래와 같은 형식을 만들면
            무조건 버튼 클릭시 v-card가 동작하게 된다.
            단, 주의할 점이라면 v-model에 dialog가 겹치게 만들면 안된다.
            여러 대화상자(Dialog)를 사용하게된다면 이 부분을 여러개로 분리하거나 배열로 관리해야 한다. -->
            <v-dialog v-model="dialog" persistent max-width="400">
                <!-- activator : 활성화 시킨다. 
                    { on }이 $event 역할을 한다. -->
                <template v-slot:activator="{ on }">
                    <v-btn color="primary" dark v-on="on">결제</v-btn>
                </template>
                <v-card>
                    <v-card-title class="headline">
                        {{ service.name }}
                    </v-card-title>
                    <v-card-text>
                        비수기 30% 할인가 적용혜택 {{ service.name }} 결제하시겠습니까?
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn color="blue darken-1" text @click.native="btn_click($event)">
                            취소
                        </v-btn>
                        <v-btn color="blue darken-1" text @click.native="btn_click($event)">
                            결제승인
                        </v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
        </v-layout>

        
        <v-dialog v-model="loginDialog" persistent max-width="500px">
            <template v-slot:activator="{ on }">
                    <v-btn color="primary" dark v-on="on">로그인</v-btn>
            </template>
            <v-card>
                <v-card-title class="headline">
                    Lonin
                </v-card-title>
                <v-card-text>
                    <v-container grid-list-md>
                        <v-layout wrap>
                            <v-flex xs12>
                                <!-- 반드시 이메일 정보가 있어야하며 저런 형태이다 -->
                                <v-text-field label="Email" v-model="userInfo.email" required>
                                </v-text-field>
                            </v-flex>
                            <v-flex xs12>
                                <v-text-field label="Password" v-model="userInfo.password"
                                                type="password" required>
                                </v-text-field>
                            </v-flex>
                        </v-layout>
                    </v-container>
                </v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text @click="btnLoginClick($event)">
                        취소
                    </v-btn>
                    <v-btn color="blue darken-1" text @click="btnLoginClick($event)">
                        로그인
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>

        <v-toolbar>
            <v-toolbar-items v-if="$vuetify.breakpoint.smAndUp">
                <v-btn text>About</v-btn>
                <v-btn text>Rooms</v-btn>
                <v-btn text>Special</v-btn>
                <v-btn text>Reservation</v-btn>
                <v-btn text>Boards</v-btn>
            </v-toolbar-items>
            <v-toolbar>
                <!-- <v-toolbar-items class="hidden-so-and-down"> -->
                    <v-toolbar-items class="d-sm-none">
                    <v-btn text>Wow</v-btn>
                    <v-btn text>Oops</v-btn>
                    <v-btn text>Yeah</v-btn>
                </v-toolbar-items>
            </v-toolbar>
        </v-toolbar>

        <!-- 메뉴 -네비게이션바 -->
        <!-- <v-navigation-drawer app permanent>
            <v-list nav dense>
                <v-list-item-group active-class="deep-purple--text text--accent-4">
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
        </v-navigation-drawer> -->

        <!-- 홈페이지 홈 + 네비게이션 바 합쳐서 만들어보기 -->
        <v-toolbar dense dark>
            <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
            </v-app-bar-nav-icon>
            <v-toolbar-title>
                <span class="font-weight-light">JEJU</span>
                <span>숙소</span>
            </v-toolbar-title>
            <v-toolbar-items>
                <v-btn text v-for="link in links" :key="link.icon" :to="link.route">
                    {{ link.text }}
                </v-btn>
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
    
        <div>
            <v-menu offset-y>
                <template v-slot:activator="{ on }">
                    <v-btn color='teal darken-1'
                            class="white--text ma-5"
                            v-on="on">
                        Down Hover
                    </v-btn>
                </template>

                <v-list>
                    <v-list-item v-for="( dropItem, index ) in dropItems"
                            :key="index"
                            link>
                        <v-list-item>{{ dropItem.title }}</v-list-item>
                    </v-list-item>
                </v-list>
            </v-menu>
        </div>

        <!--  :items-per-page="10" = 한페이지당 보여줄 게시물 갯수 -->
        <v-container>
            <v-data-table :headers="headerTitle"
                    :items="contents"
                    :items-per-page="10"
                    class="elevation-1">
            </v-data-table>
        </v-container>
    </div>   
</template>

<script>

export default {
    name: 'VuetifyAllInOnTestPage',
    data () {
        return {
            headerTitle: [
                { text: '번호', value: 'boardNo', width: "70px"},
                { text: '제목', value: 'title', width: "200px"},
                { text: '작성자', value: 'writer', width: "100px"},
                { text: '내용', value: 'content', width: "100px"}
            ],
            contents: [
                { boardNo: 1, title: '일', writer: 'first', content: '하나' },
                { boardNo: 2, title: '이', writer: 'second', content: '둘' },
                { boardNo: 3, title: '삼', writer: 'third', content: '셋' },
                { boardNo: 4, title: '사', writer: 'fourth', content: '넷' },
                { boardNo: 5, title: '오', writer: 'fifth', content: '다섯' },
                { boardNo: 6, title: '육', writer: 'sixth', content: '여섯' },
                { boardNo: 7, title: '칠', writer: 'seventh', content: '일곱' },
                { boardNo: 8, title: '팔', writer: 'eighth', content: '일곱' },
                { boardNo: 9, title: '구', writer: 'ninth', content: '여덟' },
                { boardNo: 10, title: '십', writer: 'tenth', content: '아홉' },
                { boardNo: 11, title: '십일', writer: 'eleventh', content: '열' },
                { boardNo: 12, title: '십이', writer: 'twelvth', content: '열하나' },
            ],
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
                    icon: 'account_circle', text: '로그인', name: 'account_circle', route: '/product'
                },
                { 
                    icon: 'favorite', text: '찜하기', name: 'favorite', route: '/materialize'
                },
            ],
            dropItems: [
                { title: '1번'},
                { title: '2번'},
                { title: '3번'},
                { title: '4번'}
            ]
        }
    },
    methods: {
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