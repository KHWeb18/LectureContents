<template>
  <v-sheet class="home">
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
    

  }
}
</script>
