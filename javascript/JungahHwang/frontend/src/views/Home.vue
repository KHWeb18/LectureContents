<template>
  <div class="home">
    <!--
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    -->
    <router-link :to="{ name: 'Home' }" 
      class="nav-link" 
      active-class="active">Home
    </router-link>
    <router-link :to="{ name: 'Test' }" 
      class="nav-link" 
      active-class="active">Test
    </router-link>
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
    // HelloWorld
  }
}
</script>
