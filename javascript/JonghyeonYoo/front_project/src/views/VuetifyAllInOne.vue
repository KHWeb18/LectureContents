<template>
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

  <div>

    <v-navigation-drawer app v-model="nav_drawer" temporary>
      <v-list nav dense>
        <v-list-item-group
          v-model="group"
          active-class="deep-purple--text text--accent-4"
        >
          <v-list-item
            v-for="link in links"
            :key="link.name"
            router
            :to="link.route"
          >
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

    <v-container>
      <v-data-table
        :headers="headerTitle"
        :items="contents"
        :items-per-page="10"
        class="elevation-1"
      >
      </v-data-table>
    </v-container>
  </div>
</template>


<script>
export default {
  name: "VuetifyAllInOneTestPage",
  data() {
    return {
      headerTitle: [
        { text: "번호", value: "boardNo", width: "30px" },
        { text: "제목", value: "title", width: "200px" },
        { text: "작성자", value: "writer", width: "100px" },
        { text: "내용", value: "content", width: "200px" },
      ],
      contents: [
        { boardNo: 1, title: "야호", writer: "여우", content: "오호호호~" },
        { boardNo: 2, title: "쀼쀼 ", writer: "곰", content: "운동하즈아" },
        {
          boardNo: 3,
          title: "쀼쀼 ",
          writer: "세마리가",
          content: "운동하즈아",
        },
        {
          boardNo: 4,
          title: "쀼쀼 ",
          writer: "한집에누누누",
          content: "운동하즈아",
        },
        {
          boardNo: 5,
          title: "쀼쀼 ",
          writer: "있어ㅋㅋㅋ",
          content: "운동하즈아",
        },
        {
          boardNo: 6,
          title: "쀼쀼 ",
          writer: "아빠곰고오오",
          content: "운동하즈아",
        },
        {
          boardNo: 7,
          title: "쀼쀼 ",
          writer: "엄마곰루루루",
          content: "운동하즈아",
        },
        {
          boardNo: 8,
          title: "쀼쀼 ",
          writer: "애기곰라라라",
          content: "운동하즈아",
        },
        {
          boardNo: 9,
          title: "쀼쀼 ",
          writer: "애기곰기기기",
          content: "운동하즈아",
        },
        {
          boardNo: 10,
          title: "쀼쀼 ",
          writer: "애기곰",
          content: "운동하즈아",
        },
        {
          boardNo: 11,
          title: "쀼쀼 ",
          writer: "애기곰",
          content: "운동하즈아",
        },
        {
          boardNo: 12,
          title: "쀼쀼 ",
          writer: "애기곰",
          content: "운동하즈아",
        },
        {
          boardNo: 13,
          title: "쀼쀼 ",
          writer: "애기곰",
          content: "운동하즈아",
        },
        {
          boardNo: 14,
          title: "쀼쀼 ",
          writer: "애기곰",
          content: "운동하즈아",
        },
        {
          boardNo: 15,
          title: "쀼쀼 ",
          writer: "애기곰",
          content: "운동하즈아",
        },
      ],
      message: "환장",
      nav_drawer: false,
      group: false,
      dialog: false,
      loginDialog: false,
      service: {
        name: "7박 8일 여행 코스",
      },
      userInfo: {
        email: "",
        password: "",
      },
      links: [
        {
          icon: "home",
          text: "Home",
          name: "home",
          route: "/",
        },
        {
          icon: "credit_card",
          text: "법인카드",
          name: "credit_card",
          route: "/product",
        },
        {
          icon: "ev_station",
          text: "EV Station",
          name: "ev_station",
          route: "/materialize",
        },
      ],
      dropItems: [
        { title: "Click Me" },
        { title: "Click Me" },
        { title: "Click Me" },
        { title: "Click Me2" },
      ],
    };
  },
  methods: {
    btn_click($event) {
      if ($event.target.innerHTML == " 결제승인 ") {
        alert("결제가 완료되었습니다!");
        this.dialog = false;
      }
    },
    roundBtnClick() {
      alert("Vuetify 버튼이라고 들어봤니 ?");
    },
    btnLoginClick($event) {
      if ($event.target.innerHTML == " 확인 ") {
        alert("로그인이 완료되었습니다!");
        console.log(
          "입력된 정보 - 이메일: " +
            this.userInfo.email +
            ", 비밀번호: " +
            this.userInfo.password
        );
        this.loginDialog = false;
      }
      this.userInfo.email = "";
      this.userInfo.password = "";
    },
  },
  watch: {
    group() {
      this.nav_drawer = false;
    },
  },
};
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