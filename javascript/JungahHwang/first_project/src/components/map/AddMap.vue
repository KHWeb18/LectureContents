<template>
  <v-card max-width="450" flat>

    <v-text-field v-model="search" class="ml-3" color="secondary" label="장소 검색" 
    @keypress.enter="searchMap" prepend-icon="mdi-magnify" ></v-text-field>

    <v-sheet v-if="show" id="scrolling-techniques-7" class="overflow-y-auto" max-height="350">
      <v-card>
        <v-list v-for="list in resultList" :key="list.index">
          <v-list-item-group>
            <v-list-item tow-line @click="selectAddress(list.placeName, list.address, list.x, list.y, list.phone, list.url)">
              <v-list-item-content>
              <v-list-item-title>
                {{list.placeName}}
              </v-list-item-title>
              <v-list-item-subtitle>
                {{list.address}}
              </v-list-item-subtitle>
            </v-list-item-content>   
            </v-list-item>
          </v-list-item-group>
        </v-list>
      </v-card>
     
    </v-sheet>
    
    <v-card v-if="placeName" class="mx-auto my-2" width="300">
          
      <naver-maps :height="300" :width="300" :mapOptions="mapOptions"></naver-maps>
      <naver-marker :lat="mapOptions.lat" :lng="mapOptions.lng"/>
      <v-card-text>{{ placeName }}</v-card-text>
              
    </v-card>
  </v-card>
</template>


<script>
import axios from 'axios'

export default {
  data() {
    return {
      resultList: [],
      placeName: null,
      show: false,
      search: null,
      mapOptions: {
        lat: null,
        lng: null,
        zoom: 17,
      },
    }
  },
  methods: {
    searchMap () {
      const search = this.search
      axios.get(`https://dapi.kakao.com/v2/local/search/keyword.json?y=37.498721&x=127.0329693&radius=20000&query=${search}`,
      { headers: { 'Authorization': 'KakaoAK ' + '' }}).then(res => {
        console.log(res.data)

        const list = res.data.documents

        this.resultList = []

        for (let i = 0; i < list.length; i++) {
          this.resultList.push(
            { address: list[i].road_address_name, placeName: list[i].place_name, 
            x: list[i].x, y: list[i].y, phone:list[i].phone, url: list[i].place_url }
          )
        }
        console.log(this.resultList)
        this.show = true
      })
    },
    selectAddress (placeName, address, x, y, phone, url) {
      console.log('x: ' + x + ' / y: ' + y)
      this.placeName = placeName
      this.mapOptions.lat = Number(y)
      this.mapOptions.lng = Number(x)

      this.$emit('selectMap', placeName, address, x, y, phone, url)

      this.show = false
    }
  }
}
</script>