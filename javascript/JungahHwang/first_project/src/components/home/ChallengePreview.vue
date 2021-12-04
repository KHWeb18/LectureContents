<template>
  <v-card class="pa-2" color="primary">
    <v-tooltip top>
      <template v-slot:activator="{on}">
        <p class="headline ma-3" v-on="on" @click="readChallenge">Challenge</p>
      </template>
      <span>이동하기</span>
    </v-tooltip>

    <v-divider></v-divider>
    
    <v-list v-for="video in videoList" :key="video.index" color="primary">
      <v-list-item-group>
        <v-list-item>
          <img class="mr-2" :src="video.thumbnail" width="60">
          <v-list-item-title @click="readChallenge">
            {{ video.title }}
          </v-list-item-title>
        </v-list-item>
      </v-list-item-group>
    </v-list>
  </v-card>
</template>


<script>
import thankyouBubu from '@/assets/data/thankyouBubu'

export default {
  data () {
    return {
      videoList: []
    }
    
  },
  mounted () {
    for (let i = 0; i < 3; i++) {
      let list = thankyouBubu.items
      
      this.videoList.push(
        { videoId: list[i].id.videoId, 
          thumbnail: list[i].snippet.thumbnails.high.url, 
          title: list[i].snippet.title }
      )
    }
  },
  methods: {
    readChallenge () {
      this.$router.push(
        { name: 'Challenge' } 
      )
    }
  }
}
</script>