<template>
  <v-card color="primary" flat>
    <v-card v-if="videoId" class="mx-auto mt-5 pb-1" max-width="560">
      <youtube :video-id="videoId" ref="youtube" 
        @playing="playing" :player-vars="playerVars" width="560" height="315"></youtube>
      
      <v-tooltip bottom>
        <template v-slot:activator="{on}">
          <div v-on="on" class="ma-3">
            <a :href="'https://www.youtube.com/watch?v=' + videoId" target='_blank'>
              {{ videoTitle }}
            </a>
          </div>
        </template>
        <span>이동하기</span>
      </v-tooltip>
    </v-card>

    <v-card class="mt-3" color="primary" flat>
      <v-data-iterator :items="videoList" :items-per-page="itemsPerPage"
        :page.sync="page" hide-default-footer>

        <template v-slot:default="props">
          <v-card class="pa-3" color="primary" flat>
            <v-row>
              <v-col v-for="item in props.items" :key="item.index"
                cols="12" sm="6" md="4" lg="3">
                
                <v-hover v-slot="{hover}" close-delay="50">
                  <v-card :elevation="hover ? 16:2" class="{ 'on-hover': hover }" 
                    @click="showVideo(item.id.videoId, item.snippet.title)">
                    <v-list-item>
                      <v-list-item-title>
                        {{ item.snippet.title }}
                      </v-list-item-title>
                    </v-list-item>
                    
                    <v-divider></v-divider>
                    <img :src="item.snippet.thumbnails.high.url" width="100%"/>

                    <v-card-text class="caption">
                      {{ item.snippet.channelTitle }}
                    </v-card-text>
                  
                  </v-card>
                </v-hover>
              </v-col>
            </v-row>
          </v-card>
        </template>

        <template v-slot:footer>
        <v-row class="mt-2 pa-3" align="center" justify="center">
          <v-spacer></v-spacer>

          <v-btn @click="formerPage" icon color="secondary">
            <v-icon>mdi-chevron-left</v-icon>
          </v-btn>
          <span class="secondary--text">
             {{ page }} / {{ numberOfPages }}
          </span>
          <v-btn @click="nextPage" icon color="secondary">
            <v-icon>mdi-chevron-right</v-icon>
          </v-btn>
        </v-row>
      </template>

      </v-data-iterator>
    </v-card>
  </v-card>
</template>


<script>

export default {
  props: {
    videoList: {
      type: Array
    },
  },
  data () {
    return {
      videoId: null,
      videoTitle: null,
      search: null,
      page: 1,
      itemsPerPage: 12,
      playerVars: {
        origin: 'http://localhost:8080'
      },
    }
  },
  computed: {
    numberOfPages () {
      return Math.ceil(this.videoList.length / this.itemsPerPage)
    },
  },
  methods: {
    showVideo (videoId, videoTitle) {
      console.log(videoId)
      this.videoId = videoId
      this.videoTitle = videoTitle
    },
    playing() {
      console.log('유튜브!')
    },
    nextPage () {
      if (this.page + 1 <= this.numberOfPages) this.page += 1
    },
    formerPage () {
      if (this.page - 1 >= 1) this.page -= 1
    },
    
  }
}
</script>



<style scoped>
a:link {
  text-decoration: none;
  color: #000;
}
a:visited {
  color: #000;
}
a:hover {
  color: #356859;
}
</style>