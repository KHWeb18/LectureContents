<template>
  <v-card class="mt-5 pa-2" color="primary">
    <v-tooltip top>
      <template v-slot:activator="{on}">
        <p class="headline ma-3" v-on="on" @click="recommendPage">Recommend</p>
      </template>
      <span>이동하기</span>
    </v-tooltip>

    <v-divider></v-divider>
    
    <v-list v-for="recommend in recommendList" :key="recommend.index" color="primary">
      <v-list-item-group>
        <v-list-item>
          <v-list-item-title @click="readRecommendPage(recommend.boardNo, recommend.id)">
            {{ recommend.title }}
          </v-list-item-title>
        </v-list-item>
      </v-list-item-group>
    </v-list>
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
      this.recommendList = res.data.reverse().splice(0, 3)
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
