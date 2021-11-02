<template>
    <div class="home">
        <div id="header">
           
            <router-link :to="{ name: 'BoardListPage' }"
                    class="nav-link"
                    active-class="active">
                BoardListPage
            </router-link>
          
        </div>
        
    </div>
</template>

<script>

  export default {
    name: 'Home'
   
  }
</script>   
       