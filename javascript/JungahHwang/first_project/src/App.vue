<template>
<v-app>
  <nav-bar/>
  <v-main>
    <router-view/>
  </v-main>
</v-app>  
</template>


<script>
import NavBar from '@/views/NavBar'

export default {
  name: 'App', 
  components: {
    NavBar
  }  
}
</script>


<style>
#app {
  font-family: "GongGothicMedium";
}
</style>

