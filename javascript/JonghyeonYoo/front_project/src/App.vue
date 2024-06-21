<template>
  <v-app>
<nav-bar-component/> 
    <v-main>
      <router-view/>
    </v-main>
  <!--  <v-footer>
      <Footer/>
    </v-footer> -->
  </v-app>
</template>

<script>

import NavBarComponent from './views/NavBarComponent.vue'
// import VuetifyAllInOneTestPage from './views/VuetifyAllInOneTestPage.vue'
// import Footer from './views/Footer.vue'

export default {
  components: {
     NavBarComponent, },
   //  Footer
  name: 'App'
}
</script>

<style>

#app {
background-color: #171717;

}
.nav-bar-component{
  position: fixed;
}
/*
.Footer{
  position: relative;
} 
*/
</style>