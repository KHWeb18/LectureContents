<template>
<v-card flat>
  <v-card v-if="!isLogin" class="pa-5" color="primary" flat>
    <p class="ma-2">댓글을 입력하려면 로그인 해주세요!</p>
  </v-card>

  <v-toolbar v-else class="my-3 pt-3" color="primary" flat>
    <v-text-field v-model="content" label="댓글을 입력해 주세요."
      solo hide-details></v-text-field>
    <v-btn @click="addComment" class="float-right ml-2" color="secondary" icon>
      <v-icon>done</v-icon>
    </v-btn>
  </v-toolbar>
</v-card>  
</template>


<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
  data () {
    return {
      content: null
    }
  },
  props: {
    boardNo: {
      
    }
  },
  computed: {
    ...mapState([ 'userInfo', 'isLogin' ])
  },
  methods: {
    ...mapActions([ 'fetchTogetherComments' ]),
    addComment () {
      const id = this.userInfo.id
      const content = this.content
      const boardNo = this.boardNo

      axios.post('http://localhost:7777/together/comment/add', { id, content, boardNo }).then(() => {
        alert('댓글이 등록되었습니다!')

        this.fetchTogetherComments(boardNo)

        this.content = null
      }).catch(res => {
        alert(res)
      })
      
    }
  }
}
</script>