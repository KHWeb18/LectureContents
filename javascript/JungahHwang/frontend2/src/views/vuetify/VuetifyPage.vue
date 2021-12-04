<template>
  <div>
    <!-- 글씨, 배경색 -->
    <p class="blue lighten-5 red--text">Test</p>
    <p class="blue">Test</p>
    <p class="blue darken-3 white--text">Test</p>
    
    <!-- 버튼 -->
    <v-btn class="teal" rounded @click="roundBtnClick">Round Button</v-btn>
    <v-btn class="indigo white--text">Basic</v-btn>
    <v-btn class="orange" text>Basic</v-btn>
    <v-btn class="pink" dark>
      <v-icon>bluetooth</v-icon>
      <span>bluetooth</span>
    </v-btn>
    <v-btn fab color="purple" dark>
      <v-icon>bluetooth</v-icon>
    </v-btn>

    <!-- 버튼 숨기기 -->
    <v-btn color="red" class="hidden-xs-only">xs</v-btn> <!-- 화면 창이 작으면 xs버튼 사라짐 -->
    <v-btn color="orange" class="hidden-sm-only">sm</v-btn> <!-- 화면 창이 중간이면 sm버튼 사라짐 -->
    <v-btn color="yellow" class="hidden-md-only">md</v-btn> <!-- 화면 창이 크면 md버튼 사라짐 -->

    <!-- 그리드(Grid) -->
    <!-- container: container(화면 70% 차지)역할을 수행하며 그리드 기능을 서포트 해주고
         페이지 중앙정렬을 기본으로 함, 너비를 자동 확장할 경우 fluid 옵션을 줌 -->
    <v-container fluid>
      <!-- 그리드 시스템의 한 행을 정의 -->
      <v-layout row wrap>
        <!-- 12개의 컬럼으로 이루어져 한 행에서 제일 작은 것들이 12개가 만들어지면 자동으로 다음으로 넘어 감 -->
        <v-flex xs12 md6 class="primary white--text">
          <div>{{ message }}</div>
        </v-flex>
        <v-flex xs4 md2 class="green white--text">
          <div>{{ message }}</div>
        </v-flex>
        <v-flex xs4 md2 class="indigo white--text">
          <div>{{ message }}</div>
        </v-flex>
        <v-flex xs4 md2 class="purple white--text">
          <div>{{ message }}</div>
        </v-flex>
      </v-layout>
      <v-layout row wrap>
        <v-flex xs4 md3 class="primary white--text">
          <div>{{ message }}</div>
        </v-flex>
        <v-flex xs4 md3 class="primary white--text">
          <div>{{ message }}</div>
        </v-flex>
      </v-layout>
    </v-container>

    <!-- 알림창 -->
    <!-- justify-center: 양쪽 정렬 -->
    <v-layout row justify-center>
      <!-- v-dialog: 사용자에게 알림을 제공하거나 중요 정보를 포함해 의사 결정을 하도록 유도하는데 활용
                     대화상자가 뜨면서 알림이나 선택 등등에 활용하기 좋음
                     v-dialog에 template를 넣고 v-btn을 이용하면 버튼 클릭 시 v-card가 동작함 
                     여러 대화상자를 사용한다면 v-model에 dialog를 여러개로 분리하거나 배열로 관리해야 함 -->
      <v-dialog v-model="dialog" persistent max-width="400">
        <template v-slot:activator="{ on }">
          <v-btn color="primary" dark v-on="on">결제</v-btn>
        </template>
        <v-card>
          <v-card-title class="headline">
            {{ service.name }}
          </v-card-title>
          <v-card-text>호텔 30% 할인! {{ service.name }} 결제하시겠습니까?</v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="teal darken-1" text @click.native="btn_click($event)">취소</v-btn>
            <v-btn color="teal darken-1" text @click.native="btn_click($event)">결제</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-layout>

    <!-- 로그인 창 -->
    <v-dialog v-model="loginDialog" persistent max-width="500px">
      <template v-slot:activator="{ on }">
        <v-btn color="primary" dark v-on="on">로그인</v-btn>
      </template>
      <v-card>
        <v-card-title>
          <span class="headline">Log in</span>
        </v-card-title>
        <v-card-text>
          <v-main grid-list-md>
            <v-layout wrap>
              <v-flex xs12>
                <v-text-field label="Email" v-model="userInfo.email" required></v-text-field>
              </v-flex>
              <v-flex xs12>
                <v-text-field label="Password" v-model="userInfo.password"
                              type="password" required></v-text-field>
              </v-flex>
            </v-layout>
          </v-main>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="primary" text @click="btnLoginClick($event)">취소</v-btn>
          <v-btn color="primary" text @click="btnLoginClick($event)">로그인</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

    <!-- 툴바 -->
    <v-toolbar>
      <!-- xs일 때 사라짐 -->
      <v-toolbar-items v-if="$vuetify.breakpoint.smAndUp">
        <v-btn text>First Test</v-btn>
        <v-btn text>Second Test</v-btn>
        <v-btn text>Third Test</v-btn>
      </v-toolbar-items>
      <!-- xs일 때 나타남 -->
      <v-toolbar-items class="d-sm-none">
        <v-btn text>Home</v-btn>
        <v-btn text>Main</v-btn>
        <v-btn text>Login</v-btn>
      </v-toolbar-items>
    </v-toolbar>

    <!-- 네비게이션 바 -->
    <!--
    <v-navigation-drawer app permanent>
      <v-list nav dense>
        <v-list-item-group active-class="deep-puple--text text--accent-4">
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

    <v-toolbar dense dark>
      <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>
        <span class="font-weight-light">Toolbar</span>
        <span>ㅎㅎ</span>
      </v-toolbar-title>
      <v-toolbar-items>
        <v-btn text v-for="link in links" :key="link.icon" :to="link.route">{{ link.text }}</v-btn>
      </v-toolbar-items>
    </v-toolbar>
    <v-navigation-drawer app v-model="nav_drawer" temporary>
      <v-list nav dense>
        <v-list-item-group v-model="group" active-class="deep-puple--text text--accent-4">
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

    <!-- 드롭 다운 버튼 -->
    <div>
      <v-menu offset-y>
        <template v-slot:activator="{ on }">
          <v-btn color='teal darken-1' class="white--text ma-5" v-on="on">Drop Down Test Button</v-btn>
        </template>
        <v-list>
          <v-list-item v-for="(item, index) in dropItems" :key="index" link>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </div>

    <!-- 테이블 -->
    <!-- :는 vuetify의 v-data-table과 v-bind로 연결
         headers: 제목, items: 내용, items-per-page: 한 페이지에 보여 줄 게시물 개수 -->
    <v-container>
      <v-data-table :headers="headers" :items="contents"
                    :items-per-page="5" class="elevation-1"></v-data-table>
    </v-container>
  </div> 
</template>


<script>
export default {
  data () {
    return {
      message: 'Grid!!!!!',
      dialog: false,
      loginDialog: false,
      group: false,
      nav_drawer: false,
      service: {
        name: '일주일 여행 코스'
      },
      userInfo: {
        email: null,
        password: null,
      },
      links: [
        { icon: 'home', text: 'Home', name: 'home', route: '/' },
        { icon: 'shopping_cart', text: 'Product', name: 'shopping_cart', route: '/product' },
        { icon: 'dns', text: 'Todo', name: 'dns', route: '/todo' },
      ],
      dropItems: [
        { title: 'Click Me' },
        { title: 'Click Me' },
        { title: 'Click Me' },
        { title: 'Click Me' },
        { title: 'Click Me' }
      ],
      headers: [
        { text: '번호', value: 'boardNo', width: '50px' },
        { text: '제목', value: 'title', width: '200px' },
        { text: '작성자', value: 'writer', width: '50px' },
        { text: '내용', value: 'contents', width: '200px' },
      ],
      contents: [
        { boardNo: 1, title: '첫 번째', writer: '정아', contents: '안녕하세요' },
        { boardNo: 2, title: '두 번째', writer: '정아', contents: '안녕' },
        { boardNo: 3, title: '세 번째', writer: '정아', contents: 'Hi' },
        { boardNo: 4, title: '네 번째', writer: '정아', contents: 'Hello' },
        { boardNo: 5, title: '다섯 번째', writer: '정아', contents: 'Bye' },
        { boardNo: 6, title: '여섯 번째', writer: '정아', contents: 'Good Morning' },
      ]
    }
  },
  methods: {
    roundBtnClick () {
      alert('Vuetify button')
    },
    btn_click ($event) {
      if($event.target.innerHTML === '결제') {
        alert('결제가 완료되었습니다.')
        this.dialog = false
      }
    },
    btnLoginClick ($event) {
      if ($event.target.innerHTML === '로그인') {
        alert('로그인이 완료되었습니다.')
        console.log('이메일: ' + this.userInfo.email + ', 비밀번호: ' + this.userInfo.password)
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