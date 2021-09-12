<template>
  <v-card class="mb-10" color="primary" >
    <v-toolbar class="mt-5 pt-3" color="primary" flat>
      <v-text-field v-model="search" @keyup.enter="fetchVideoList" label="Search"
        solo hide-details></v-text-field>
      <v-btn @click="fetchVideoList" class="float-right ml-2" color="secondary" icon>
        <v-icon>mdi-magnify</v-icon>
      </v-btn>
    </v-toolbar>

    <challenge-form :videoList="videoList"></challenge-form>
  </v-card>  
</template>


<script>
import axios from 'axios'
import thankyouBubu from '@/assets/data/thankyouBubu'
import ChallengeForm from '@/components/challenge/ChallengeForm'

export default {
  components: { 
    ChallengeForm
  },
  data () {
    return {
      videoList: thankyouBubu.items,
      search: null,
    }
  },
  methods: {
    fetchVideoList () {
      console.log(this.search)

      const params = {
        part: 'snippet',
        maxResults: 36,
        order: 'viewCount',
        q: `${this.search} 운동`,
        type: 'video',
        videoDefinition: 'high',
        key: ''
      }

      axios.get('https://www.googleapis.com/youtube/v3/search', { params }).then(res => {
        this.videoList = res.data.items
      })
    }
  }
}
</script>

