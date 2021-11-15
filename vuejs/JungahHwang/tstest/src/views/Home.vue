<template>
  <v-container>
    <v-spacer></v-spacer>
    <v-layout row wrap>
      <v-flex xs4 md3 class="teal white--text">
        <router-link :to="{ name: 'Home' }">
          Home
        </router-link>
      </v-flex>
      <v-flex xs4 md3 class="blue white--text">
        <router-link :to="{ name: 'About' }">
          About
        </router-link>
      </v-flex>
      <v-flex xs4 md3 class="red white--text">
        <router-link :to="{ name: 'BoardList' }">
          BoardList
        </router-link>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script lang="ts">
  import Vue from 'vue'
  
  export default Vue.extend({
    name: 'Home',

    components: {
      
    },
  })
</script>


<style scoped>
.v-application a {
  color: black;
}
</style> 