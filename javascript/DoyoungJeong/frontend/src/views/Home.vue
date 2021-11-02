<template>
  <div class="home">
    <div class=header>
    <router-link :to="{ name: 'Home' }"
        class="nav-link"
        active-class="active">
      Home
    </router-link>
    <router-link :to="{ name: 'Test' }"
        class="nav-link"
        active-class="active">
      Test
    </router-link>
    </div>
    <h2>홈 페이지</h2>
  </div>
</template>

<script>
// @ is an alias to /src
export default {
  name: 'Home',
  components: {
  }
}
</script>
