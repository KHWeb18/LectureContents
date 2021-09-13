<template>
  <v-sheet>
    <v-card class="my-5 pt-1" color="primary">
      <v-card class="ma-5">
        <v-toolbar flat>
          <v-toolbar-title>
            {{ recommend.title }}
          </v-toolbar-title>
          <v-spacer></v-spacer>

          <v-menu offset-y>
            <template v-slot:activator="{ on, attrs }">
              <v-btn v-if="userInfo.id == id" v-bind="attrs" v-on="on" icon>
                <v-icon>mdi-dots-vertical</v-icon>
              </v-btn>
            </template>
            <v-list>
              <v-list-item @click="modifyRecommend">
                수정
              </v-list-item>
              <!-- 삭제 확인 dialog -->
              <remove-dialog v-on:remove="removeRecommend"></remove-dialog>
            </v-list>
          </v-menu>
        </v-toolbar>

        <v-divider></v-divider>

        <v-card class="mx-auto mt-2 mb-10" width="400" flat>
          <v-img :src="showFile()" ></v-img>
        </v-card>

        <v-card-text class="text-center my-10">
          <p v-html="content"></p>
        </v-card-text>

        <v-card v-if="showMap" class="mx-auto mt-2  mb-5" width="300">
          
          <naver-maps :height="300" :width="300" :mapOptions="mapOptions"></naver-maps>
          <naver-marker :lat="mapOptions.lat" :lng="mapOptions.lng" @click="showPlace = true"/>
        
          <v-alert v-if="showPlace" dense>
            {{ placeName }} ({{ address }})
          </v-alert>
                  
        </v-card>

        <v-card-text></v-card-text>
        
        <v-card-text class="card-text-id caption">
          {{ recommend.id }}
        </v-card-text>
        <v-card-text class="card-text-date caption">
          {{ recommend.regDate }}
        </v-card-text>
      
      </v-card>
    
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn @click="showRecommendList" class="pa-6" color="secondary" icon>
          <v-icon>apps</v-icon>
        </v-btn>
      </v-card-actions>
    </v-card>
    
    <read-recommend-comment :boardNo="boardNo"></read-recommend-comment>
  </v-sheet>
  
</template>


<script>
import RemoveDialog from '@/components/RemoveDialog'
import ReadRecommendComment from '@/components/comment/ReadRecommendComment'
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
  components: {
    RemoveDialog,
    ReadRecommendComment
  },
  data () {
    return {
      boardNo: null,
      id: null,
      mapOptions: {
        lat: null,
        lng: null,
        zoom: 17,
      },
      showMap: false,
      placeName: null,
      address: null,
      showPlace: false
    }
  },
  created () {
    this.boardNo = this.$route.query.boardNo
    this.id = this.$route.query.id
  },
  mounted() {
    this.fetchRecommend(this.boardNo)
    this.fetchRecommendComments(this.boardNo)
  },
  beforeUpdate () {
    console.log('update')
    this.mapOptions.lat = Number(this.recommend.y)
    this.mapOptions.lng = Number(this.recommend.x)
    this.placeName = this.recommend.placeName
    this.address = this.recommend.address
    if (this.recommend.y != null) {
      this.showMap = true
    }
  },
  computed: {
    ...mapState([ 'recommend', 'userInfo' ]),
    content () {
      return this.recommend.content.replace(/(?:\r\n|\r|\n)/g, '<br />')
    }
  },
  methods: {
    ...mapActions([ 'fetchRecommend', 'fetchRecommendComments' ]),
    modifyRecommend () {
      this.$router.push(
        { name: 'ModifyRecommend', query: { boardNo: this.boardNo, id: this.id } }
      )
    },
    removeRecommend () {
      axios.delete(`http://localhost:7777/recommend/remove/${this.boardNo}`).then(() => {
        alert('삭제가 완료되었습니다!')

        this.$router.push(
          { name: 'Recommend' }
        )
      })
    },
    showRecommendList () {
      this.$router.push(
        { name: 'Recommend' }
      )
    },
    showFile () {
      try {
        return require(`../../../../FirstProject/images/recommend/${this.boardNo}_${this.id}.jpg`)
      } catch (e) {
        return require(`@/assets/icon/noImg.png`)
      }
    }
  }
}
</script>


<style scoped>
.card-text-date {
  position: absolute;
  bottom: 0;
  text-align: right;
}
.card-text-id {
  position: absolute;
  bottom: 0;
}
</style>