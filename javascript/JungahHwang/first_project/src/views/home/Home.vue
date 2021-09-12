<template>
  <v-sheet class="home">
    <!--
    <h2>메인 페이지</h2>
    <v-btn color="red" class="hidden-xs-only">xs(폰)</v-btn>
    <v-btn color="orange" class="hidden-sm-only">sm(태블릿)</v-btn>
    <v-btn color="yellow" class="hidden-md-only">md(노트북)</v-btn>
    <v-btn color="green" class="hidden-lg-only">lg(데스크탑)</v-btn>

    <router-link :to="{ name: 'Test' }" 
      class="nav-link" 
      active-class="active">Test
    </router-link>
    <router-link :to="{ name: 'ListTest' }" 
      class="nav-link" 
      active-class="active">ListTest
    </router-link>

    <v-btn @click="cookies">쿠키</v-btn>
    -->

    <weather></weather>

    <v-row class="mt-5">
      <v-col cols="12" md="4">
        <challenge-preview></challenge-preview>
      </v-col>
      <v-col cols="12" md="4">
        <recommend-preview></recommend-preview>
      </v-col>
      <v-col cols="12" md="4">
        <together-preview></together-preview>
      </v-col>
    </v-row>
    
  </v-sheet>
</template>


<script>
import Weather from '@/components/home/Weather'
import ChallengePreview from '@/components/home/ChallengePreview'
import RecommendPreview from '@/components/home/RecommendPreview'
import TogetherPreview from '@/components/home/TogetherPreview'

export default {
  name: 'Home',

  components: {
    Weather,
    ChallengePreview,
    RecommendPreview,
    TogetherPreview,

  },
  created () {
  },
  methods: {
    cookies () {
      let userCookies = this.$cookies.get('user')
      console.log(userCookies)
    },

  }
}
</script>
