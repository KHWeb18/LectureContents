<template>
  <v-sheet class="mt-5 mb-10">
    <v-row>
      <v-col cols="12" md="7">
        <weather></weather>
        <v-row>
          <v-col>
            <record-preview></record-preview>
          </v-col>
          <v-col>
            <map-preview></map-preview>
          </v-col>
        </v-row>
      </v-col>
      <v-col cols="12" md="5">
        <challenge-preview></challenge-preview>
        <recommend-preview></recommend-preview>
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
import RecordPreview from '@/components/home/RecordPreview'
import MapPreview from '@/components/home/MapPreview'

export default {
  name: 'Home',

  components: {
    Weather,
    ChallengePreview,
    RecommendPreview,
    TogetherPreview,
    RecordPreview,
    MapPreview
  },
  created () {
  },
  methods: {
    

  }
}
</script>
