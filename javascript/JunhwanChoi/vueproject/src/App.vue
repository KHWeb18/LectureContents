<template>
  <v-app class="test">
    <nav-bar-component/>
    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>
import NavBarComponent from './views/NavBarComponent.vue'

export default {
  components: { NavBarComponent },
  name: 'App'
}
</script>

<style>

</style>