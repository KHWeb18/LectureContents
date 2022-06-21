<template>
    <div class="home">
        <div id="header">
            <main-page/>
            <!-- <router-link :to="{ name: 'MainPage' }"
                    class="nav-link"
                    active-class="active">
                메인홈
            </router-link> -->
        </div>
    </div>
</template>

<script>
import MainPage from'@/views/main/MainPage.vue'

  export default {
  components: { MainPage },
    name: 'Home'
  }

</script>
