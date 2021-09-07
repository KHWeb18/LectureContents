<template>

  <v-card class="mb-10" color="primary">
    <add-comment :boardNo="boardNo"></add-comment>

    <v-card v-if="!comments || (Array.isArray(comments) && comments.length ===0)" 
      class="pa-5" color="primary" flat>
      <p class="ma-2">등록된 댓글이 없습니다.</p>
    </v-card>

    <v-card v-else v-for="item in comments" :key="item.commentNo" class="mx-4" color="primary" flat>
      
      <v-list-item>
        <v-list-item-avatar>
          {{ item.id }}
        </v-list-item-avatar>
        
        <v-list-item>
          {{ item.content }}
        </v-list-item>
        
        <!--
        <v-list-item class="caption">
          {{ item.regDate }}
        </v-list-item>
        -->
        
        <v-menu offset-y>
          <template v-slot:activator="{ on }">
            <v-btn v-if="userInfo.id == item.id" v-on="on" icon>
              <v-icon>mdi-dots-vertical</v-icon>
            </v-btn>
          </template>
          <v-list>

            <modify-comment :commentNo="item.commentNo"></modify-comment>

            <v-list-item @click="removeComment(item.commentNo)">
              삭제
            </v-list-item>
          </v-list>
        </v-menu>
        
        <!--
        <v-btn icon small color="secondary" class="pa-6">
          <v-icon>create</v-icon>
        </v-btn>
        <v-btn icon small color="secondary" class="pa-6">
          <v-icon>mdi-delete</v-icon>
        </v-btn>
        -->
      </v-list-item>
      
      <v-divider></v-divider>
      
      
      
    </v-card>
  </v-card>  
</template>


<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import AddComment from './AddComment.vue'
import ModifyComment from './ModifyComment.vue'

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
      modify: false,
    }
  },
  computed: {
    ...mapState([ 'comments', 'userInfo' ])
  },
  mounted() {
    this.fetchComments(this.boardNo)
  },
  methods: {
    ...mapActions([ 'fetchComments', 'fetchComment' ]),
    
    removeComment (commentNo) {
      axios.delete(`http://localhost:7777/comment/remove/${commentNo}`).then(() => {
        alert('댓글이 삭제되었습니다!')
      })
      this.fetchComments(this.boardNo)
    },
  }
}
</script>