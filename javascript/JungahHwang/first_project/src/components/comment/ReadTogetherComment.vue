<template>

  <v-card class="mb-10" color="primary">
    <add-together-comment :boardNo="boardNo"></add-together-comment>

    <v-card v-if="!togetherComments || (Array.isArray(togetherComments) && togetherComments.length ===0)" 
      class="pa-5" color="primary" flat>
      <p class="ma-2">등록된 댓글이 없습니다.</p>
    </v-card>

    <v-card v-else v-for="item in togetherComments" :key="item.commentNo" class="mx-4" color="primary" flat>
      <v-list color="primary">
        <v-list-item>
          <v-list-item-avatar>
            {{ item.id }}
          </v-list-item-avatar>
      
          <v-tooltip left>
            <template v-slot:activator="{on}">
              <v-list-item v-on="on">
                {{ item.content }}
              </v-list-item>
            </template>
            <span>
              {{new Date(item.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(0, 11)}}
              {{new Date(item.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(12, 8)}}
            </span>
          </v-tooltip>
             
          <v-menu offset-y>
            <template v-slot:activator="{ on }">
              <v-btn v-if="userInfo.id == item.id" v-on="on" icon>
                <v-icon>mdi-dots-vertical</v-icon>
              </v-btn>
            </template>
            <v-list>

              <modify-together-comment :commentNo="item.commentNo" :boardNo="boardNo"></modify-together-comment>

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
import AddTogetherComment from '@/components/comment/AddTogetherComment'
import ModifyTogetherComment from '@/components/comment/ModifyTogetherComment'
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
  components: {
    AddTogetherComment,
    ModifyTogetherComment
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
    ...mapState([ 'togetherComments', 'userInfo' ])
  },
  mounted () {
    this.fetchTogetherComments(this.boardNo)
  },
  methods: {
    ...mapActions([ 'fetchTogetherComments', 'fetchTogetherComment' ]),

    removeDialog (commentNo) {
      this.dialog = true
      this.commentNo = commentNo
    },
    btnCancle () {
      this.dialog = false
    },
    btnRemove () {
      axios.delete(`http://localhost:7777/together/comment/remove/${this.commentNo}`).then(() => {
        alert('댓글이 삭제되었습니다!')

        this.fetchTogetherComments(this.boardNo)

        this.dialog = false
      })
    },
  }
}
</script>