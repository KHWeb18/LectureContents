<template>
  <div class="home">
    <router-link :to="{ name: 'Home' }" 
      class="nav-link" 
      active-class="active">Home
    </router-link>
    <router-link :to="{ name: 'SignUp' }" 
      class="nav-link" 
      active-class="active">SignUp
    </router-link>
  </div>
</template>

<script>

  export default {
    name: 'Home',

    components: {

    },
  }
</script>
