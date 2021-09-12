<template>
  <v-card class="mx-auto" max-width="850" >
    <naver-maps :height="700" :width="850" :mapOptions="mapOptions"></naver-maps>
    <naver-marker v-for="list in placeList" :key="list.index" 
      :lat="list.y" :lng="list.x" @click="showPlaceInfo(list.placeName, list.address, 
      list.phone, list.url)"/>

      <v-dialog v-model="dialog" max-width="350">
        <v-card class="primary rounded-xl pa-4">
          <v-card-title>
            <span class="headline secondary--text font-weight-bold">Place Info</span>
          </v-card-title>
          <v-divider></v-divider>  

    
          <v-list-item three-line class="text-center ma-3">
            <v-list-item-content>
              <v-list-item-title>
                {{ placeName }}
              </v-list-item-title>
              <v-list-item-subtitle>
                {{ address }}
              </v-list-item-subtitle>
              <v-list-item-subtitle>
                {{ phone }}
              </v-list-item-subtitle>
            </v-list-item-content>
            
          </v-list-item>
          

          <v-card-actions>
            <v-btn @click="btnGo" class="secondary--text font-weight-bold" text
              :href="url" target="_blank">Go</v-btn>
            <v-spacer></v-spacer>
            <v-btn @click="btnOk" class="secondary--text font-weight-bold" text>Ok</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
        
  </v-card>
</template>


<script>
import axios from 'axios'

export default {
  data () {
    return {
      mapOptions: {
        lat: 37.498721,
        lng: 127.0329693,
        zoom: 15,
      },
      placeList: [],
      placeName: null,
      address: null,
      phone: null,
      url: null,
      dialog: false
    }
  },
  mounted () {
    axios.get('http://localhost:7777/recommend/mapList').then(res => {
      const list = res.data

      for (let i = 0; i < list.length; i++) {
        if (list[i][0] != null) {
          this.placeList.push(
            { x: Number(list[i][0]), y: Number(list[i][1]), placeName: list[i][2], 
            address: list[i][3], phone: list[i][4], url: list[i][5] }
          )
        }
      }
    })
  },
  methods: {
    showPlaceInfo (placeName, address, phone, url) {
      this.placeName = placeName
      this.address = address
      this.phone = phone
      this.url = url

      this.dialog = true
    },
    btnGo () {
      console.log(this.url)
    },
    btnOk () {
      this.dialog = false
    }
  },
  
}
</script>