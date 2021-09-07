<template>
  <v-dialog v-model="dialog" max-width="400">
    <template v-slot:activator="{ on }">
      <v-list-item v-on="on">
        수정
      </v-list-item>
    </template>

    <v-card class="primary rounded-xl pa-4">
      <v-card-title class="secondary--text">
        <p>댓글 수정</p>
      </v-card-title>
      <v-text-field v-model="content">

      </v-text-field>
      <v-card-actions>
        <v-btn @click="btnCancle" class="secondary--text font-weight-bold" text >
          Cancle
        </v-btn>
        <v-spacer></v-spacer>
        <v-btn @click="modifyComment" class="secondary--text font-weight-bold" text>
          Modify
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>


<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
  name: 'ModifyComment',
  props: {
    commentNo: {

    }
  },
  data () {
    return {
      dialog: false,
      content: null
    }
  },
  computed: {
    ...mapState([ 'comments', 'comment' ])
  },
  created () {
    
  },
  mounted () {
    this.fetchComment(this.commentNo)
    this.content = this.comment.content
  },
  methods: {
    ...mapActions(['fetchComment']),
    btnCancle () {
      this.dialog = false
    },
    modifyComment () {
      const content  = this.content
      axios.patch(`http://localhost:7777/comment/modify/${this.commentNo}`, { content }).then(res => {
        alert('수정이 완료되었습니다')
        console.log(res.data)
      })
      this.dialog = false
    }
  }
}
</script>