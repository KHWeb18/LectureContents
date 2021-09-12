<template>

  <v-card class="mb-10" color="primary">
    <add-comment :boardNo="boardNo"></add-comment>

    <v-card v-if="!comments || (Array.isArray(comments) && comments.length ===0)" 
      class="pa-5" color="primary" flat>
      <p class="ma-2">등록된 댓글이 없습니다.</p>
    </v-card>

    <v-card v-else v-for="item in comments" :key="item.commentNo" class="mx-4" color="primary" flat>
      <v-list color="primary">
        <v-list-item>
          <v-list-item-avatar>
            {{ item.id }}
          </v-list-item-avatar>
          
          <v-list-item>
            {{ item.content }}
          </v-list-item>
          
          
          <v-menu offset-y>
            <template v-slot:activator="{ on }">
              <v-btn v-if="userInfo.id == item.id" v-on="on" icon>
                <v-icon>mdi-dots-vertical</v-icon>
              </v-btn>
            </template>
            <v-list>

              <modify-comment :commentNo="item.commentNo" :boardNo="boardNo"></modify-comment>

              <v-list-item @click="removeDialog(item.commentNo)">
                삭제
              </v-list-item>
            </v-list>
          </v-menu>
          
        </v-list-item>
      </v-list>
      <v-divider></v-divider>
    </v-card>

    <v-dialog v-model="dialog" max-width="350">
      <v-card class="primary rounded-xl pa-4">
        <v-card-title class="secondary--text font-weight-bold">
          <p>정말 삭제하시겠습니까?</p>
        </v-card-title>

        <v-card-text></v-card-text>

        <v-card-actions>
          <v-btn @click="btnCancle" class="secondary--text font-weight-bold" text >
            Cancle
          </v-btn>
          <v-spacer></v-spacer>
          <v-btn @click="btnRemove" class="secondary--text font-weight-bold" text>
            Delete
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

  </v-card>  
</template>


<script>
import AddComment from '@/components/comment/AddComment'
import ModifyComment from '@/components/comment/ModifyComment'
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
  components: {
    AddComment,
    ModifyComment
  },
  props: {
    boardNo: {
      
    }
  },
  data () {
    return {
      dialog: false,
      commentNo: null
    }
  },
  computed: {
    ...mapState([ 'comments', 'userInfo' ])
  },
  mounted () {
    this.fetchComments(this.boardNo)
  },
  methods: {
    ...mapActions([ 'fetchComments', 'fetchComment' ]),

    removeDialog (commentNo) {
      this.dialog = true
      this.commentNo = commentNo
    },
    btnCancle () {
      this.dialog = false
    },
    btnRemove () {
      axios.delete(`http://localhost:7777/comment/remove/${this.commentNo}`).then(() => {
        alert('댓글이 삭제되었습니다!')

        this.fetchComments(this.boardNo)

        this.dialog = false
      })
    },
  }
}
</script>