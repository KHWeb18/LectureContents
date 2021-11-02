<template>
<div class="home">
 <div id="header">

  <router-link :to="{ name: 'Home'}"
          class="nav-link"
          active-class="active">
          Home
 </router-link>
 <router-link :to="{ name: 'SignupPage'}"
          class="nav-link"
          active-class="active">
          회원가입 페이지
        
 </router-link>
 
 


 </div>
</div>
</template>

<script>


  export default {
    name: 'Home',

    components: {
   
    },
  }
</script>
