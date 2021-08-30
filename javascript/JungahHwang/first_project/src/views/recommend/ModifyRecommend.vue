<template>
  <v-card>
    <v-text-field v-model="title" label="제목을 입력하세요." solo></v-text-field>
    <v-textarea v-model="content" label="내용을 입력하세요." solo></v-textarea>
    <v-btn @click="modify">수정완료</v-btn>
  </v-card>
</template>


<script>
import axios from 'axios'
import { mapState } from 'vuex'

export default {
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
    modify() {
      const title = this.title
      const content = this.content
      const boardNo = this.recommend.no
      const id = this.recommend.id

      axios.put(`http://localhost:7777/recommend/modify/${boardNo}`, { id, title, content }).then(() => {
        alert("수정이 완료되었습니다!")
      })
    }
  }
}
</script>