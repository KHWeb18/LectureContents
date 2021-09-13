<template>
  <v-card class="mx-auto" max-width="850" >
    <naver-maps :height="700" :width="850" :mapOptions="mapOptions"></naver-maps>
    <naver-marker v-for="list in placeList" :key="list.index" 
      :lat="list.y" :lng="list.x" @click="showPlaceInfo(list.name, list.address, 
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
                {{ name }}
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
      name: null,
      address: null,
      phone: null,
      url: null,
      dialog: false
    }
  },
  mounted () {
    axios.get('http://localhost:7777/map/list').then(res => {
      this.placeList = res.data
    })
  },
  methods: {
    showPlaceInfo (name, address, phone, url) {
      this.name = name
      this.address = address
      this.phone = phone
      this.url = url

      this.dialog = true
    },
    btnGo () {
      this.dialog = false
    },
    btnOk () {
      this.dialog = false
    }
  },
  
}
</script>