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

#app {
background-color: #171717;

}
.nav-bar-component{
  position: fixed;
}
</style>