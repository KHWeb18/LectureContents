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
    <router-link :to="{ name: 'Reference' }" 
      class="nav-link" 
      active-class="active">Reference
    </router-link>
    <router-link :to="{ name: 'Quiz' }" 
      class="nav-link" 
      active-class="active">Quiz
    </router-link>
    <router-link :to="{ name: 'Todo' }" 
      class="nav-link" 
      active-class="active">Todo
    </router-link>
    <router-link :to="{ name: 'Monster' }" 
      class="nav-link" 
      active-class="active">Monster
    </router-link>
    <router-link :to="{ name: 'BoardListPage' }" 
      class="nav-link" 
      active-class="active">Board
    </router-link>
    <router-link :to="{ name: 'ProductListPage' }" 
      class="nav-link" 
      active-class="active">Product
    </router-link>
    <router-link :to="{ name: 'Concave' }" 
      class="nav-link" 
      active-class="active">Concave
    </router-link>
    <router-link :to="{ name: 'EventBusTestPage' }" 
      class="nav-link" 
      active-class="active">EventBus
    </router-link>
    <router-link :to="{ name: 'DaumNewsCrawlerPage' }" 
      class="nav-link" 
      active-class="active">DaumNews
    </router-link>
    <router-link :to="{ name: 'Slot' }" 
      class="nav-link" 
      active-class="active">Slot
    </router-link>
    <router-link :to="{ name: 'MaterializePage' }" 
      class="nav-link" 
      active-class="active">Materialize
    </router-link>
    <router-link :to="{ name: 'VuetifyPage' }" 
      class="nav-link" 
      active-class="active">Vuetify
    </router-link>
    <router-link :to="{ name: 'MemberJoinColumnPage' }" 
      class="nav-link" 
      active-class="active">MemberJoinColumn
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
