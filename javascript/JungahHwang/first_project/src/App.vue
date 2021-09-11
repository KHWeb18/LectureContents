<template>
<v-app>
  <v-container pa-0 mt-0>
    <nav-bar class="hidden-xs-only"/>
    
    <toolbar class="d-flex d-sm-none"/>
    
    <v-main>
      <router-view/>
    </v-main>
  </v-container>
</v-app>  
</template>


<script>
import NavBar from '@/views/bar/NavBar'
import Toolbar from '@/views/bar/Toolbar'

export default {
  name: 'App', 
  components: {
    NavBar,
    Toolbar
  }  
}
</script>


<style>
#app {
 font-family: 'Noto Sans KR', sans-serif;
}
</style>

