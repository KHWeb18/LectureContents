<template>
    <div>
        <p class="blue lighten-5 red--text">Test</p>
        <p class="blue white--text">Test</p>
        <p class="blue darken-3">Test</p>
        <v-btn class="teal" rounded @click="roundBtnClick">Round 버튼</v-btn>
        <v-btn class="indigo white--text">기본버튼</v-btn>
        <v-btn class="teal text">기본버튼</v-btn>
        <v-btn class="teal" dark>
            <v-icon>bluetooth</v-icon>
            <span>bluetooth</span>
        </v-btn>
        <v-btn fab color="orange" dark>
            <v-icon>bluetooth</v-icon>
        </v-btn>
        <!--제일 큰놈이 md>sm>xs-->
        <v-btn color="blue" class="hidden-xs-only">Visibility -xs-only</v-btn>
        <v-btn color="red" class="hidden-sm-only">Visibility -sm-only</v-btn>
        <v-btn color="yellow" class="hidden-md-only">Visibility -md-only</v-btn>
        
        <!-- 앞서서 살펴봤던 container의 역할을 수행하며 
                grid 기능을 서포트해주고 기본적으로 페이지 중앙에 자동 배치함
                추가적으로 너비를 자동 확장할 경우 fluid 옵션을 준다.-->
        <v-container fluid>
            <!-- Grid 시스템의 한 행을 정의함-->
            <v-layout row wrap>
                <!-- 12개의 컬럼으로 이뤄져 한 행에서 제일 작은것들이 12개가 만들어지면 다음으로 자동 넘김 처리-->
                <v-flex xs12 md6 class="primary white--text">
                    <div>{{message}}</div>
                </v-flex>
                <v-flex xs4 md2 class="green white--text">
                    <div>{{message}}</div>
                </v-flex>
                <v-flex xs4 md2 class="green white--text">
                    <div>{{message}}</div>
                </v-flex>
                <v-flex xs4 md2 class="green white--text">
                    <div>{{message}}</div>
                </v-flex>
            </v-layout>
            <v-layout row wrap>
                <v-flex xs4 md3 class="teal white--text">
                    <div>{{message}}</div>
                </v-flex>
                <v-flex xs4 md3 class="teal white--text">
                    <div>{{message}}</div>
                </v-flex>
            </v-layout>
        </v-container>
        <!--justify 양쪽정렬-->
        <v-layout row justify-center>
            <!-- 사용자에게 알림을 제공하거나 중요 정보를 포함해 의사 결정을 하도록 유도하는데 활용
                    대화상자가 뜨면서 결제할 것인지 취소할 것인지 어쩔건지 등등에 활용하기 좋음
                    v-dialog에 template을 넣고 v-btn으로 아래와 같은 형식을 만들면 
                    무조건 버튼 클릭시 v-card가 동작하게 된다.
                    단 주의 할점이라면 v-model에 dialog를 겹치게 만들면 안된다.
                    여러 대화상자(Dialog)를 사용한다면 이 부분을 여러개로 분리하거나 배열로 관리해야 한다.-->
            <v-dialog v-model="dialog" persistent max-width="400">
                <!--v slot 부모 컴퍼넌트에 on을 전송 화면으로 결제가 보이도록 전송한다.--> 
                <!--on으로 클릭이벤트가 들어가있음-->
                <template v-slot:activator="{ on }">
                    <v-btn color="primary" dark v-on="on">결제</v-btn>
                </template>
                <v-card>
                    <v-card-title class="headline">
                        {{ service.name}} 
                    </v-card-title>
                    <v-card-text>
                        5성급 호텔이 30%할인! {{service.name}} 결제하시겠습니까?
                    </v-card-text>
                    <!-- 클릭후 나오는 화면-->
                    <v-card-actions>
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
                                <v-text-field label="Email" v-model="userInfo.emil" required>
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
                    <!-- 클릭후 나오는 화면-->
                    <v-card-actions>
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
                <v-btn text>First Test</v-btn>
                <v-btn text>Second Test</v-btn>
                <v-btn text>Third Test</v-btn>
            </v-toolbar-items>
        </v-toolbar>
        <v-toolbar>
            <!---->
            <!-- <v-toolbar-items class="hidden-sm-and-down">-->
                <v-toolbar-items class="d-sm-none">
                <v-btn text>Home</v-btn>
                <v-btn text>집에 갈래요</v-btn>
                <v-btn text>드루 오세요</v-btn>
            </v-toolbar-items>
            </v-toolbar>
        <!--app은  APP.vue에 있는 <v-app> 자식이라는 뜻이다. 
            네이게이션 안에 리스트를 넣어서 목록을 구성한다.-->
        <!--클릭해서 뭔가를 하고싶을땐 v-on click을 사용한다.-->
        <!--deep-purple은 클릭했을때 나오는 색-->
        <!-- 아이콘 형식에 해당하는 양식-->
        <!-- 아이콘 이름에 해당하는 양식-->
        <!--
        <v-navigation-drawer app permanent>
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
            </v-navigation-drawer>
        -->
        <!--@click="nav_drawer = !nav_drawer drawer 보였다 안보였다하게 함-->
        <v-toolbar dense dark>
            <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
            </v-app-bar-nav-icon>  
            <v-toolbar-title>
                <span class="font-weight-light">쵝오의 여행!</span>
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
                        Drop Down Test Button
                    </v-btn>
                </template>

                <v-list>
                    <v-list-item v-for="(dropItem, index) in dropItems"
                            :key="index"
                            link>
                        <v-list-item-title> {{ dropItem.title}}</v-list-item-title>
                    </v-list-item>
                </v-list>
            </v-menu>
        </div>
        <!-- header는 v-dat-table로 넘어간다 얘를 제목으로 만들어줌-->
        <!-- :headrs, items는 v-data-table에 이미 props로 들어가있는것이다.-->
        <v-container>
            <v-data-table :headers="headerTitle"
                    :items="contents"
                    :items-per-page="10"
                    clas="elevation-1">
            </v-data-table>
        </v-container>
    </div>

</template>


<script>
export default {
name: 'VuetifyAllInOneTestPage',
data (){
    return {
        headerTitle:[
            { text: '번호', value: 'boardNo', width: "70px" },
            { text: '제목', value: 'title', width: "150px"},
            { text: '작성자', value: 'writer', width: "100px" },
            { text: '내용', value: 'content', width: "100px" }
        ],
        contents: [
            { boardNo: 1, title: '무야호', writer: '옴마', content: '호로로로로롤'},
            { boardNo: 2, title: '호야무', writer: '마옴', content: '호라라라라랄'},
            { boardNo: 3, title: '무호야', writer: '바바', content: '호리리리리릴'},
            { boardNo: 4, title: '무야호', writer: '옴마', content: '호로로로로롤'},
            { boardNo: 5, title: '호야무', writer: '마옴', content: '호라라라라랄'},
            { boardNo: 6, title: '무호야', writer: '바바', content: '호리리리리릴'},
            { boardNo: 7, title: '무야호', writer: '옴마', content: '호로로로로롤'},
            { boardNo: 8, title: '호야무', writer: '마옴', content: '호라라라라랄'},
            { boardNo: 9, title: '무호야', writer: '바바', content: '호리리리리릴'},
            { boardNo: 10, title: '무야호', writer: '옴마', content: '호로로로로롤'},
       ],
        message:'환장',
        nav_drawer: false,
        group: false,
        dialog: false,
        loginDialog: false,
        service:{
            name: '7박 8일 여행 코스'
        },
        userInfo: {
            email: '',
            password:''
        },
        links: [
            {
                icon: 'home',text: 'Home',name: 'Home', route: '/'
            },
            {
                icon: 'credit_card',text: '법인카드',name: '긁으세요', route: '/product'
            },
            {
                icon: 'ev_station',text: 'EV station',name: 'EV station', route: '/materialize'
            },
        ],
        dropItems: [
            {title: 'Click Me'},
            {title: 'Click Me'},
            {title: 'Click Me'},
            {title: 'Click Me 2'},
        ]
    }
},
methods: {
    btn_click ($event) {
        if($event.target.innerHTML == " 결제승인 ") {
            alert('결제가 완료되었습니다!')
            this.dialog = false
        }
    },
    roundBtnClick(){
        alert('Vuetify 버튼이라고 들어봤니?')
    },
    btnLoginClick($event){
        if($event.target.innerHTML == " 확인 "){
            alert('로그인이 완료되었습니다.')
            console.log("입력된 정보 - 이메일: " + this.userInfo.email + 
            ", 비밀번호: " + this.userInfo.password)
            this.loginDialog = false
        }
        this.userInfo.email =''
        this.userInfo.password=''
    }
},
watch: {
    group (){
        this.nav_drawer = false
    }
}
}
</script>

<style scoped>

h1{
margin: 10px;
}
p{
padding: 10px;
margin: 5px 10px;
}


</style>