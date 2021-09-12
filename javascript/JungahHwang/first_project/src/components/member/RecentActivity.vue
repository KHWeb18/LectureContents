<template>
  <v-card class="mr-6 my-3" v-if="isLogin">
    <v-card-text>
      <v-list-item-title>
        <p>최근 활동</p>
      </v-list-item-title>
      <v-divider></v-divider>

      <v-list-item-title  
        v-if="!recommendList || (Array.isArray(recommendList) && recommendList.length ===0)">
        <p>작성한 게시물이 없습니다.</p>
      </v-list-item-title>

      <v-list v-else v-for="list in recommendList" :key="list.index">
        <v-list-item-group>
          <v-list-item @click="readRecommendPage(list.boardNo)">
            <v-list-item-title>
              {{ list.title }}
            </v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>

      <v-divider></v-divider>

      <v-list-item-title  
        v-if="!togetherList || (Array.isArray(togetherList) && togetherList.length ===0)">
        <p>작성한 게시물이 없습니다.</p>
      </v-list-item-title>

      <v-list v-else v-for="list in togetherList" :key="list.index">
        <v-list-item-group>
          <v-list-item @click="readTogetherPage(list.boardNo)">
            <v-list-item-title>
              {{ list.title }}
            </v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>

    </v-card-text>
    
  </v-card>
</template>


<script>
import axios from 'axios'
import { mapState } from 'vuex'

export default {
  data () {
    return {
      recommendList: [],
      togetherList: [],
    }
  },
  mounted () {
    const id = this.userInfo.id

    axios.get(`http://localhost:7777/recommend/userRead/${id}`).then(res => {
      let list = res.data.reverse()

      if (list.length >= 3) {
        for (let i = 0; i < 3; i++) {
          this.recommendList.push({ boardNo: list[i].boardNo, title: list[i].title })
        }
      } else {
        for (let i = 0; i < list.length; i++) {
          this.recommendList.push({ boardNo: list[i].boardNo, title: list[i].title })
        }
      }
      
      console.log(this.recommendList)
    })

    axios.get(`http://localhost:7777/together/userRead/${id}`).then(res => {
      let list = res.data.reverse()

      if (list.length >= 3) {
        for (let i = 0; i < 3; i++) {
          this.togetherList.push({ boardNo: list[i].boardNo, title: list[i].title })
        }
      } else {
        for (let i = 0; i < list.length; i++) {
          this.togetherList.push({ boardNo: list[i].boardNo, title: list[i].title })
        }
      }
      
      console.log(this.togetherList)
    })

  },
  computed: {
    ...mapState([ 'userInfo', 'isLogin' ])
  },
  methods: {
    readRecommendPage (boardNo) {
      this.$router.push(
        { name: 'ReadRecommend', query: { boardNo: boardNo, id: this.userInfo.id} }
      )
    },
    readTogetherPage (boardNo) {
      this.$router.push(
        { name: 'ReadTogether', query: { boardNo: boardNo, id: this.userInfo.id} }
      )
    }
  }
}
</script>