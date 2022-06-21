<template>
  <v-app>
    <menu-bar v-if="($route.name !== 'MainPage') && ($route.name !== 'Home') && ($route.name !== 'BookingListPage') 
    && ($route.name !== 'BookingReadPage') && ($route.name !== 'MemberListPage')&& ($route.name !== 'MemberModifyPage') 
    && ($route.name !== 'MemberReadPage') && ($route.name !== 'MyReservation') && ($route.name !== 'ReservationReadPage')
    && ($route.name !== 'UserList') && ($route.name !== 'UserModifyPage')&& ($route.name !== 'UserReadPage')"/>
    <v-main>
      <router-view/>
    </v-main>
    <cinzel-footer/>
  </v-app>
</template>

<script>
import MenuBar from '@/views/MenuBar.vue'
import CinzelFooter from './views/CinzelFooter.vue'

export default {
  name: 'App',
  components: {
    MenuBar,
    CinzelFooter
  }
}
</script>

<style
    CinzelFootere>
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