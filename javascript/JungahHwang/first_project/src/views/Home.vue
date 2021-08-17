<template>
  <div class="home">
    <h2>메인 페이지</h2>
    <v-btn color="red" class="hidden-xs-only">xs(폰)</v-btn>
    <v-btn color="orange" class="hidden-sm-only">sm(태블릿)</v-btn>
    <v-btn color="yellow" class="hidden-md-only">md(노트북)</v-btn>
    <v-btn color="green" class="hidden-lg-only">lg(데스크탑)</v-btn>

    <router-link :to="{ name: 'Test' }" 
      class="nav-link" 
      active-class="active">Test
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
