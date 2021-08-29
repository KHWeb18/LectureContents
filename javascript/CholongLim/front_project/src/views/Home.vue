<template>
    <div class="home">
        <div id="header">
            <router-link :to="{ name: 'MainPage' }"
                    class="nav-link"
                    active-class="active">
                메인홈
            </router-link>
        </div>
        <div id="header">
            <router-link :to="{ name: 'test' }"
                    class="nav-link"
                    active-class="active">
                test
            </router-link>
        </div>
    </div>
</template>

<script>

  export default {
    name: 'Home'
  }

</script>
