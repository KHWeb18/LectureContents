<template>
  <v-card class="my-5 pt-1" color="primary">
    <v-card class="ma-5" height="600px">
      <v-text-field v-model="title" class="mb-n7" label="제목을 입력하세요." solo flat></v-text-field>
      <v-divider></v-divider>
      <v-textarea v-model="content" height="500px" label="내용을 입력하세요." solo flat></v-textarea>
    </v-card>
    <v-card-actions>
      <v-spacer></v-spacer>
      <v-btn @click="modify" class="pa-6" color="secondary" icon>
        <v-icon>done</v-icon>
      </v-btn>
    </v-card-actions>
  </v-card> 
</template>


<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
  props: {
    boardNo: {
      type: Number
    }
  },
  data () {
    return {
      title: null,
      content: null
    }
  },
  computed: {
    ...mapState([ 'recommend' ])
  },
  created () {
    this.title = this.recommend.title
    this.content = this.recommend.content
  },
  methods: {
    ...mapActions([ 'fetchRecommendDetail' ]),
    modify() {
      const title = this.title
      const content = this.content
      
      axios.put(`http://localhost:7777/recommend/modify/${this.boardNo}`, { title, content }).then(() => {
        alert("수정이 완료되었습니다!")

        this.fetchRecommendDetail(this.boardNo)

        this.$router.push(
          { name: 'ReadRecommend' } 
        )
      })
    }
  }
}
</script>