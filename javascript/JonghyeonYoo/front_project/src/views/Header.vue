<template>
     <div class="app">

      <v-toolbar dense dark height="100px">
        <v-toolbar-title class="change-font" style="cursor: pointer" @click="$router.push('/MainHome')">
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
        </v-toolbar-items>
      </v-toolbar>
       </div>
   
    
</template>


<script>
export default {
  name: "Header",
  data() {
    return {
      links: [
        { icon: 'home', text: "홈", name: "home", route: "MainHome" },
        { icon: 'tv', text: "TV프로그램", name: "tv", route: "TVprogramPage" },
        { icon: 'movie_creation', text: "영화", name: "movie", route: "MoviePage" },
        { icon: 'question_answer', text: "게시판", name: "board", route: "Board" },
      ],
      links2: [
        { text: "로그인", name: "login", route: "MemberLogin" },
        { text: "회원가입", name: "register", route: "MemberRegister" },
      ],
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