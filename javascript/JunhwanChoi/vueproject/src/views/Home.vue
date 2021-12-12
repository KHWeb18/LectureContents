<template>
  <div>
      <home-header></home-header>
      <home-news></home-news>
      <!-- <home-footer></home-footer> -->
  </div>

</template>

<script>

import HomeHeader from '@/components/home/HomeHeader.vue'
import HomeNews from '@/components/home/HomeNews.vue'
//import HomeFooter from '@/components/home/HomeFooter.vue'

  export default {
    name: 'Home',
    components: {
      HomeHeader,
     // HomeFooter,
      HomeNews,
    },
  }
</script>

