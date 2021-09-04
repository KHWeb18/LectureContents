<template>
  <div class="app">
    <div class="header">
      <v-toolbar dense dark height="100px">
        <v-toolbar-title
          class="change-font"
          style="cursor: pointer"
          @click="$router.push('/MainHome')"
        >
          <span>BoDa</span>
        </v-toolbar-title>
        <v-toolbar-items class="flex text-center">
          <v-spacer></v-spacer>
          <v-btn text v-for="link in links" :key="link.text" :to="link.route">
            <v-icon left>{{ link.icon }}</v-icon>
            {{ link.text }}
          </v-btn>
        </v-toolbar-items>

        <v-toolbar-items
          v-if="!this.$store.state.session"
          class="flex text-right"
          style="margin-right: 30px"
        >
          <v-spacer></v-spacer>
          <v-btn text v-for="link in links2" :key="link.text" :to="link.route">
            {{ link.text }}
          </v-btn>
        </v-toolbar-items>

        <v-toolbar-items v-if="this.$store.state.session " class="flex text-right" style="margin-right: 30px">
             <v-spacer></v-spacer>
               <v-btn text v-for="link in links3" :key="link.text" :to="link.route">
            {{ link.text }}
          </v-btn>
                         <v-btn text v-for="link in links4" :key="link.text" @click="logout" onclick="location.href='MainHome'">
            {{ link.text }}
          </v-btn>
        </v-toolbar-items>
      </v-toolbar>
    </div>
  </div>
</template>


<script>
import { mapState } from "vuex";

export default {
  name: "NavBarComponent",
  data() {
    return {
      isLogin: false,
      links: [
        { icon: "home", text: "홈", name: "home", route: "/MainHome" },
        { icon: "tv", text: "TV프로그램", name: "tv", route: "/TVprogramPage" },
        {
          icon: "local_movies",
          text: "영화",
          name: "movie",
          route: "/MoviePage",
        },
        {
          icon: "question_answer",
          text: "게시판",
          name: "board",
          route: "/Board",
        },
               {
          icon: "import_contacts",
          text: "뉴스",
          name: "news",
          route: "/daumNewsCrawler",
        },
      ],
      links2: [
        { text: "로그인", name: "login", route: "MemberLogin" },
        { text: "회원가입", name: "register", route: "MemberRegister" },
      ],
      links3: [{ text: "마이페이지", name: "mypage", route: "MyPage" }],
      links4: [{ text: "로그아웃", name: "logout" }],
    };
  },
  mounted() {
    // this.fetchSession()
    this.$store.state.session = this.$cookies.get("user");

    if (this.$store.state.session != null) {
      this.isLogin = true;
    }
  },
  computed: {
    ...mapState(["session"]),
  },
  methods: {
    logout() {
      this.$cookies.remove("user");
      this.isLogin = false;
      this.$store.state.session = null;
    },
  },
};
</script>

<style scoped>
.change-font {
  font-family: "Arial";
  font-size: 2.5rem;
  color: red;
  margin-left: 30px;
}
.v-btn {
  margin-left: 15px;
}
.header {
  position: fixed;
  z-index: 2000;
  top: 0;
  left: 0;
  width: 100%;
}
</style>