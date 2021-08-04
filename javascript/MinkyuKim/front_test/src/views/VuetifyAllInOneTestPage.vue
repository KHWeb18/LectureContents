<template>
    <div>
        <p class="blue lighten-5 red--text">Test</p>
        <p class="blue white--text">Test</p>
        <p class="blue darken-3">Test</p>
        <v-btn class="teal" rounded @click="roundBtnClick">Round 버튼</v-btn>
        <v-btn class="indigo white--text">기본 버튼</v-btn>
        <v-btn class="teal" text>기본 버튼</v-btn>
        <v-btn class="teal" dark>
            <v-icon>bluetooth</v-icon>
            <span>bluetooth</span>
        </v-btn>
        <v-btn fab color="orange" dark>
            <v-icon>bluetooth</v-icon>            
        </v-btn>
        <!-- 크기 md > sm > xs 순이며, 큰순서대로 사라짐?-->
        <v-btn color="grey" class="hidden-xs-only">Visibility -xs-only</v-btn>
        <v-btn color="blue" class="hidden-sm-only">Visibility -sm-only</v-btn>
        <v-btn color="green" class="hidden-md-only">Visibility -md-only</v-btn>
    
        <!-- 앞서 살펴봤던 container의 역할을 수행하며 
             grid 기능을 서포트해주고 기본적으로 페이지 중앙에 자동 배치함 
             추가적으로 너비를 자동 확장할 경우 fluid 옵션을 준다. -->
        <v-container fluid>
            <!-- Grid 시스템의 한 행을 정의함
                 raw 행 wrap 감싸다 
                 즉, 전체를 감싸서 삐져나오는 것이 없게 하겠다라는 의미 -->
            <v-layout row wrap>
                <!-- 12개의 컬럼으로 이루어져 한 행에서 제일 작은것들이 12개가 만들어지면 다음으로 자동 넘김 처리 -->
                <!-- md의 합이 12로 이루어진다 -->
                <v-flex xs12 md6 class="primary white--text">
                    <div>{{ message }}</div>
                </v-flex>
                <v-flex xs4 md2 class="green white--text">
                    <div>{{ message }}</div>
                </v-flex>
                <v-flex xs4 md2 class="grey white--text">
                    <div>{{ message }}</div>
                </v-flex>
                <v-flex xs4 md2 class="black white--text">
                    <div>{{ message }}</div>
                </v-flex>
            </v-layout>

            <v-layout row wrap>
                <v-flex xs4 md3 class="teal white--text">
                    <div>{{ message }}</div>
                </v-flex>
                <v-flex xs4 md3 class="teal white--text">
                    <div>{{ message }}</div>
                </v-flex>
            </v-layout>
        </v-container>


        <!-- justify-center 양쪽 정렬 -->
        <v-layout row justify-center>
            <!-- 사용자에게 알림을 제공하거나 중요 정보를 포함해 의사 결정을 하도록 유도하는데 활용 
                 대화상자가 뜨면서 결제할 것인지 취소할 것인지 어쩔건지 등등에 활용하기 좋음 -->
            <!-- v-dialog에 template를 넣고, v-btn으로 아래와 같은 형식을 만들면
                 무조건 버튼 클릭 시 v-card가 동작하게 된다.
                 단, 주의할 점은 v-model에 dialog를 겹치게 만들면 안된다.
                 여러 대화사앚(Dialog)를 사용한다면 이 부분을 여러개로 분리하거나 배열로 관리해야 한다.-->
            <v-dialog v-model="dialog" persistent max-width="400">
                <!-- 부모컴포넌트에 on을 전송-->
                <!-- on(=mouse click event)은 이벤트 동작을 의미하며, 클릭을 할 시 버튼클릭 부분인 btn_click으로 넘어가게 된다.-->
                <!-- v-slot:activator의 activator는 구동시키다라는 의미 -->
                <!-- v-on에서 on => { on } => card-actions 순으로 동작 -->
                <template v-slot:activator="{ on }">
                    <v-btn color="primary" dark v-on="on">결제</v-btn>
                </template>
                <!-- 결제를 누르게 되면 v-card가 뜨게되어있음 즉 v-slot:activator="{on}"(v-on)이 상속되어있음-->
                <v-card>
                    <v-card-title class="headline">
                        {{ service.name }}
                    </v-card-title>
                    <v-card-text>
                        5성급 호텔이 30% 할인! {{ service.name }} 결제하시겠습니까 ?
                    </v-card-text>
                    <v-card-actions>
                    <!-- 공백 만들기 -->
                        <v-spacer></v-spacer>
                        <v-btn color="teal darken-1" text @click.native="btn_click($event)">
                            취소
                        </v-btn>
                        <v-btn color="teal darken-1" text @click.native="btn_click($event)">
                            결제승인
                        </v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
        </v-layout>

        <!-- 최소한 사이즈 500을 유지하겠다라는 의미 -->
        <v-dialog v-model="loginDialog" persistent max-width="500px">
            <template v-slot:activator="{ on }">
                    <v-btn color="primary" dark v-on="on">로그인</v-btn>
            </template>
            <v-card>
                <v-card-title>
                    <span class="headline">
                        Log in
                    </span>
                </v-card-title>
                <v-card-text>
                    <v-container grid-list-md>
                        <v-layout wrap>
                            <v-flex xs12>
                                <!-- email이 반드시 적혀야 하며, vue의 양방향 정보가 전달된다 -->
                                <v-text-field label="Email" v-model="userInfo.email" required flat solo>
                                </v-text-field>
                            </v-flex>
                            <v-flex x12>
                                <v-text-field label="Password" v-model="userInfo.password"
                                                type="password" required solo>
                                </v-text-field>
                            </v-flex>
                        </v-layout>
                    </v-container>                    
                </v-card-text>
                <v-card-actions>
                <!-- 공백 만들기 -->
                    <v-spacer></v-spacer>
                    <v-btn color="teal darken-1" text @click="btnLoginClick($event)">
                        취소
                    </v-btn>
                    <v-btn color="teal darken-1" text @click="btnLoginClick($event)">
                        확인
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>

        <v-toolbar>
            <v-toolbar-items v-if="$vuetify.breakpoint.smAndUp">
                <v-btn text>Frist Test</v-btn>
                <v-btn text>Second Test</v-btn>
                <v-btn text>Third Test</v-btn>
            </v-toolbar-items>
        </v-toolbar>
        <v-toolbar>
            <v-toolbar-items class="hidden-sm-and-down">
            <!--<v-toolbar-items class="d-sm-none">-->
                <v-btn text>Home</v-btn>
                <v-btn text>집에갈래요</v-btn>
                <v-btn text>드루오세요</v-btn>
            </v-toolbar-items>
        </v-toolbar>

        <!-- temporary 있을때만 쓰고 없을땐 끈다. permanent 영구적으로 사용 -->
        <!-- bar는 가로이고 drawer는 세로로 배치. drawer의 경우 가로로도 배치가 가능하다-->
        <!-- v-navigation-drawer는 app의 자식이다.(위의 v-app의 자식. v-app은 App.vue. 현재 최상의 컴포넌트)
             app을 보통 여러개 만들기보다는, 하나에 여러개를 집어넣는 편이다(복잡해지므로)-->
        <!-- 우리가 v-navigation-drawer를 직접 커스텀하지 않는이상 app을 사용한다 보면된다. -->
        <!--중요한 것은 v-list로 목록을 만들어 구성해야한다.(vue 정식 홈페이지 참고) -->
        <!--
        <v-navigation-drawer app permanent>
            <v-list nav dense>
                <v-list-item-group v-model="group" active-class="deep-purple--text text--accent-4">-->
                    <!--nav 리스트-->
                    <!--<v-list-item v-for="link in links" :key="link.name" router :to="link.route">-->
                        <!-- 리스트를 눌렀을 때의 action
                             아이콘을 써넣는 부분 -->
                             <!--
                        <v-list-item-action>                                                        
                            <v-icon left> {{ link.icon }}</v-icon>
                        </v-list-item-action>-->
                        <!--아이콘의 이름에 해당되는 부분
                            해당 부분을 눌렀을 때 이벤트가 작동하게 하기 위해서는 v:onClick을 사용하면 된다.
                            1) 각기 다르게 작동하게 하기 위해서는 link.clickAction 처럼  작성하고,
                               아래에 action을 methods부분에 포진시키면 된다.
                            2) 클릭한 녀석이 누군지알게하고 if (~~innerHTML ==' ')로 동작시키게도 할 수 있다.-->
                        <!-- 라우터에 연결시키기 위해서는 router :to="link.router"와 같은 형식으로 연결시키면 된다.-->
                        <!--
                        <v-list-item-content>
                            <v-list-item-title>{{ link.text }}</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-list-item-group>
            </v-list>
        </v-navigation-drawer>
        -->
        

        <v-toolbar dense dark>
            <!--클릭할때마다 동작 nav~ !nav~-->
            <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
            </v-app-bar-nav-icon>
            <v-toolbar-title>
                <span class="font=weight-light">최고의 여행!</span>
                <span>꾸르팁</span>
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
                            <v-icon left> {{ link.icon }}</v-icon>
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
                            Drop Down Test Button
                    </v-btn>
                </template>

                <v-list>
                    <v-list-item v-for="(dropItem, index) in dropItems" :key="index" link>
                            <v-list-item-title>{{ dropItem.title }}</v-list-item-title>
                    </v-list-item>
                </v-list>
            </v-menu>
        </div>

        <!-- :headers :items는 자식(v-data-table)으로 가게된다.
        headers는 제목, items는 구성물 -->
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
    name: 'VuetifyAllInOneTestPage',
    data() {
        return {
            headerTitle: [
                { text: 'z번호', value: 'boardNo', width:"50px"},
                { text: '제목', value: 'title', width:"200px"},
                { text: '작성자', value: 'writer', width:"100px"},
                { text: '내용', value: 'content', width:"100px"},
                

            ],
            contents: [
                { boardNo: 1, title: '야호', writer: '으마으마', content: '으아아아앜'},
                { boardNo: 2, title: '무야호', writer: '호호호', content: '크아아앜'},
                { boardNo: 3, title: '호야', writer: '캬캬캬', content: '흐어어엌'},
                { boardNo: 4, title: '1야호', writer: '1으마으마', content: '1으아아아앜'},
                { boardNo: 5, title: '1무야호', writer: '1호호호', content: '1크아아앜'},
                { boardNo: 6, title: '1호야', writer: '1캬캬캬', content: '1흐어어엌'},
                { boardNo: 7, title: '2야호', writer: '2으마으마', content: '2으아아아앜'},
                { boardNo: 8, title: '2무야호', writer: '2호호호', content: '2크아아앜'},
                { boardNo: 9, title: '2호야', writer: '2캬캬캬', content: '2흐어어엌'},
                { boardNo: 10, title: '3야호', writer: '3으마으마', content: '3으아아아앜'},
                { boardNo: 11, title: '3무야호', writer: '3호호호', content: '3크아아앜'},
                { boardNo: 12, title: '3호야', writer: '3캬캬캬', content: '3흐어어엌'},

            ],
            message: '환장',
            nav_drawer: false,
            group: false,
            // dialog는 v-card를 맵핑해주는 것
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
                icon: 'home', text: 'Home', name: 'Home', route: '/'
                },
                {
                icon: 'credit_card', text: '신용카드', name: '긁으슈', route: '/product'
                },
                {
                icon: 'ev_station', text: 'EV Station', name: '충전소', route: '/materialize'
                }
            ],
            dropItems: [
                { title: 'clikcme1' },
                { title: 'clikcme2' },
                { title: 'clikcme3' },
                { title: 'clikcme4' },
            ]
        }
    },
    //dialog 대화창 띄워주는 것
    methods: {
        btn_click ($event) {
            if($event.target.innerHTML == " 결제승인 ") {
                alert('결제가 완료되었습니다!')
                this.dialog = false
            }
        },
        roundBtnClick() {
            alert('Vuetify 버튼이라고 들어봤니 ?')
        },
        btnLoginClick ($event) {
            if ($event.target.innerHTML == " 확인 ") {
                alert('로그인이 완료되었습니다!')
                // 이 정보를 스프링으로 보낸다 하면 axios를 사용하면 된다. (회원 아이디 비밀번호 등)
                // 즉, 이전에 이미 만들어놨던 sprin-vue에 v-model="dialog"와 axios를 사용해 껍데기만 입히면 된다.
                console.log("입력된 정보 - 이메일: " + this.userInfo.email +
                            ", 비밀번호 : " + this.userInfo.password)
                this.loginDialog = false
            }
            this.userInfo.email = '',
            this.userInfo.password = ''
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
p{
    padding: 10px;
    margin: 5px 10px;
}
</style>