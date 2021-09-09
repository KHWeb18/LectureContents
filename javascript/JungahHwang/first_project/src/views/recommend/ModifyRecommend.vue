<template>
  <v-card class="my-5 pt-1" color="primary">
    <v-card class="ma-5" height="600px">
      <v-text-field v-model="title" class="mb-n7" color="secondary"
        label="제목을 입력하세요." solo flat></v-text-field>
      <v-divider></v-divider>
      <v-textarea v-model="content" color="secondary" height="500px"
       label="내용을 입력하세요." solo flat></v-textarea>
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
  data () {
    return {
      title: null,
      content: null,
      boardNo: null,
      id: null
    }
  },
  computed: {
    ...mapState([ 'recommend' ])
  },
  created () {
    this.boardNo = this.$route.query.boardNo
    this.id = this.$route.query.id
    this.title = this.recommend.title
    this.content = this.recommend.content
    console.log(this.id, this.boardNo)
  },
  methods: {
    ...mapActions([ 'fetchRecommend' ]),
    modify() {
      const title = this.title
      const content = this.content
      
      axios.patch(`http://localhost:7777/recommend/modify/${this.boardNo}`, { title, content }).then(() => {
        alert("수정이 완료되었습니다!")

        this.fetchRecommend(this.boardNo)

        this.$router.push(
          { name: 'ReadRecommend', query: { boardNo: this.boardNo, id: this.id } } 
        )
      })
    }
  }
}
</script>