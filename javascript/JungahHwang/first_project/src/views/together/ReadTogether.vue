<template>
  <v-sheet>
    <v-card class="my-5 pt-1" color="primary">
      <v-card class="ma-5">
        <v-toolbar flat>
          <v-toolbar-title>
            {{ together.title }}
          </v-toolbar-title>
          <v-spacer></v-spacer>
          
          <v-btn v-if="together.link" icon :href="together.link" target="_blank">
            <v-icon>insert_link</v-icon>
          </v-btn>

          <v-menu offset-y>
            <template v-slot:activator="{ on, attrs }">
              <v-btn v-if="userInfo.id == id" v-bind="attrs" v-on="on" icon>
                <v-icon>mdi-dots-vertical</v-icon>
              </v-btn>
            </template>
            <v-list>
              <v-list-item @click="modifyTogether">
                수정
              </v-list-item>
              <!-- 삭제 확인 dialog -->
              <remove-dialog v-on:remove="removeTogether"></remove-dialog>
            </v-list>
          </v-menu>
        </v-toolbar>

        <v-divider></v-divider>

        <v-card class="mx-auto mt-2 mb-10" width="400" flat>
          <v-img :src="showFile()"></v-img>
        </v-card>

        <v-card-text class="text-center my-10">
          <p v-html="content"></p>
        </v-card-text>

        <v-card-text></v-card-text>
        
        <v-card-text class="card-text-id caption">
          {{ together.id }}
        </v-card-text>
        <v-card-text class="card-text-date caption">
          {{ new Date(together.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(0, 11) }}
          {{ new Date(together.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(12, 8) }}
        </v-card-text>
      
      </v-card>
    
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn @click="showTogetherList" class="pa-6" color="secondary" icon>
          <v-icon>apps</v-icon>
        </v-btn>
      </v-card-actions>
    </v-card>

    <read-together-comment :boardNo="boardNo"></read-together-comment>
  </v-sheet>  
</template>


<script>
import RemoveDialog from '@/components/RemoveDialog'
import ReadTogetherComment from '@/components/comment/ReadTogetherComment'
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
  components: {
    RemoveDialog,
    ReadTogetherComment
  },
  data () {
    return {
      boardNo: null,
      id: null
    }
  },
  created () {
    this.boardNo = this.$route.query.boardNo
    this.id = this.$route.query.id
  },
  mounted() {
    this.fetchTogether(this.boardNo)
    this.fetchTogetherComments(this.boardNo)
  },
  computed: {
    ...mapState([ 'together', 'userInfo' ]),
    content () {
      return this.together.content.replace(/(?:\r\n|\r|\n)/g, '<br />')
    }
  },
  methods: {
    ...mapActions([ 'fetchTogether', 'fetchTogetherComments' ]),
    modifyTogether () {
      
      this.$router.push(
        { name: 'ModifyTogether', query: { boardNo: this.boardNo, id: this.id } }
      )
    },
    removeTogether () {
      axios.delete(`http://localhost:7777/together/remove/${this.boardNo}`).then(() => {
        alert('삭제가 완료되었습니다!')

        this.$router.push(
          { name: 'Together' }
        )
      })
    },
    showTogetherList () {
      this.$router.push(
        { name: 'Together' }
      )
    },
    showFile () {
      try {
        return require(`../../../../FirstProject/images/together/${this.boardNo}_${this.id}.jpg`)
      } catch (e) {
        return require(`@/assets/icon/noImg.png`)
      }
    },
    
  }
}
</script>


<style scoped>
.card-text-date {
  position: absolute;
  bottom: 0;
  text-align: right;
}
.card-text-id {
  position: absolute;
  bottom: 0;
}
</style>