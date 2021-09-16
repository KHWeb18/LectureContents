<template>
     <div class="app">
      <v-toolbar dense dark height="100px">
        <v-toolbar-title class="change-font" style="cursor: pointer" @click="$router.push('/Login_MainHome')">
          <span>Movie</span>
        </v-toolbar-title>
        <v-toolbar-items class="flex text-center">
            <v-spacer></v-spacer>
          <v-btn text v-for="link in links" :key="link.text" :to="link.route">
           <v-icon left>{{ link.icon }}</v-icon>
            {{ link.text }}
          </v-btn>
        </v-toolbar-items>
        <v-toolbar-items class="flex text-right" style="margin-right: 30px">
             <v-spacer></v-spacer>
               <v-btn text v-for="link in links2" :key="link.text" :to="link.route">
            {{ link.text }}
          </v-btn>
             <v-btn text v-for="link in links3"  :key="link.text" :to="link.route">
            {{ link.text }}
          </v-btn>
        </v-toolbar-items>
      </v-toolbar>
    </div>

</template>


<script>
export default {
  name: "Login_Header",
  data() {
    return {
      links: [
        {  icon: 'home', text: "홈", name: "home", route: "Login_MainHome" },
        {  icon: 'tv', text: "TV프로그램", name: "tv", route: "Login_TVprogramPage" },
        {  icon: 'movie', text: "영화", name: "movie", route: "Login_MoviePage" },
        {  icon: '', text: "게시판", name: "board", route: "Board" },
      ],
      links2: [
        { text: "마이페이지", name: "mypage", route: "MyPage" },
      ],
      links3: [
        { text: "로그아웃", name: "logout", route: "MainHome" },
      ]
    };
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
.v-btn{margin-left: 15px;}

</style>