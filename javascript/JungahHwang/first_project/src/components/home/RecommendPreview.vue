<template>
  <v-card class="pa-3" color="primary">
    <v-card class="pa-3">
      
      <v-tooltip top>
        <template v-slot:activator="{on}">
          <p class="headline ma-3" v-on="on" @click="recommendPage">Recommend</p>
        </template>
        <span>이동하기</span>
      </v-tooltip>

      <v-divider></v-divider>
      <v-list v-for="recommend in recommendList" :key="recommend.index">
        <v-list-item-group>
          <v-list-item>
            <v-list-item-title @click="readRecommendPage(recommend.boardNo, recommend.id)">
              {{ recommend.title }}
            </v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-card>
 </v-card>
</template>


<script>
import axios from 'axios'


export default {
  data () {
    return {
      recommendList: []
    }
  },
  computed: {
    
  },
  created () {
    axios.get('http://localhost:7777/recommend/lists').then(res => {
      let list = res.data.reverse()
      
      for (let i = 0; i < 3; i++) {
        this.recommendList.push({ boardNo: list[i][0], id: list[i][1], title: list[i][2] })
      }
    })
  },
  methods: {
    recommendPage () {
      this.$router.push(
        { name: 'Recommend' }
      )
    },
    readRecommendPage (boardNo, id) {
      this.$router.push(
        { name: 'ReadRecommend', query: { boardNo: boardNo, id: id } }
      )
    }
  }
}
</script>
