<template>
  <v-sheet class="pa-3 ma-3">
    <table>
      <tr>
        <td>제목</td>
        <td><v-text-field v-model="title" label="제목" solo></v-text-field></td>
      </tr>
      <tr>
        <td>내용</td>
        <td><v-textarea v-model="content" label="내용" solo></v-textarea></td>
      </tr>
    </table>
    <v-btn @click="addRecommend">등록</v-btn>
  </v-sheet>
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
    ...mapState([ 'userInfo' ])
  },
  methods: {
    addRecommend () {
      const title = this.title
      const content = this.content
      const id = this.userInfo.id

      axios.post('http://localhost:7777/recommend/register', { title, content, id }).then(() => {
        alert('등록이 완료되었습니다!')
      })
    }
  }
}
</script>