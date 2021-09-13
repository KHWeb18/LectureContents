<template>
  <div>
    <v-app class="test">
      <nav-bar-component/>
      <v-main>
        <router-view/>
      </v-main>
      <div class="apptest">
        <main-footer/>
      </div>
    </v-app>
  </div>
</template>

<script>
import NavBarComponent from './views/NavBarComponent.vue'
import MainFooter from './views/MainFooter.vue'

export default {
  components: { NavBarComponent, MainFooter },
  name: 'App'
}
</script>

<style>
  
</style>