<template>
  <v-app>
    <nav-bar-component/>
    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>
import NavBarComponent from './views/NavBarComponent.vue'
// import VuetifyAllInOneTestPage from './views/VuetifyAllInOneTestPage.vue'
export default {
  components: { NavBarComponent },
  name: 'App'
}
</script>

<style>
/*
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
#nav {
  padding: 30px;
}
#nav a {
  font-weight: bold;
  color: #2c3e50;
}
#nav a.router-link-exact-active {
  color: #42b983;
}
*/
</style>