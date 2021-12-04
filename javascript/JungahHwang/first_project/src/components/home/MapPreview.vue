<template>
  <v-card class="mt-5 pa-2" color="primary">
    <v-tooltip top>
      <template v-slot:activator="{on}">
        <p class="headline ma-3" v-on="on" @click="mapPage">Map</p>
      </template>
      <span>이동하기</span>
    </v-tooltip>

    <v-divider></v-divider>
    
    <v-card-text class="mb-n2">
      <v-list v-for="m in map" :key="m.index" class="primary ma-n3">
        <v-list-item>
          <v-list-item-title>
            {{m}}
          </v-list-item-title>
        </v-list-item>
        
      </v-list>
    </v-card-text>

  </v-card>
</template>


<script>
import axios from 'axios'

export default {
  data () {
    return {
      map: null
    }
  },
  created () {
    axios.get('http://localhost:7777/map/list').then(res => {
      let list = []
      
      for (let i = 0; i < res.data.length; i++) {
        if (res.data[i].name != null) {
          list.push(res.data[i].name)
        }
      }
      this.map = list.reverse().splice(0, 2)
    })
  },
  methods: {
    mapPage () {
      this.$router.push(
        { name: 'Map' } 
      )
    }
  }
}
</script>