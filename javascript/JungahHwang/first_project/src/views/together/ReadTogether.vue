<template>
  <v-card class="my-5 pt-1" color="primary">
    <v-card class="ma-5">
      <v-toolbar flat>
        <v-toolbar-title>
          {{ together.title }}
        </v-toolbar-title>
        <v-spacer></v-spacer>
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
            <remove-board-dialog v-on:remove="removeTogether"></remove-board-dialog>
          </v-list>
        </v-menu>
      </v-toolbar>

      <v-divider></v-divider>
      <v-card-text>
        <p v-html="content"></p>
      </v-card-text>
      
      <v-card-text class="card-text-id caption">
        {{ together.id }}
      </v-card-text>
      <v-card-text class="card-text-date caption">
        {{ together.regDate }}
      </v-card-text>
    
    </v-card>
  
    <v-card-actions>
      <v-spacer></v-spacer>
      <v-btn @click="showTogetherList" class="pa-6" color="secondary" icon>
        <v-icon>apps</v-icon>
      </v-btn>
    </v-card-actions>
  </v-card>
  
</template>


<script>
import RemoveBoardDialog from '@/components/RemoveBoardDialog'
import axios from 'axios'
import { mapState } from 'vuex'

export default {
  components: {
    RemoveBoardDialog
  },
  props: {
    boardNo: {
      type: Number
    },
    id: {
      type: String
    }
  },
  computed: {
    ...mapState([ 'together', 'userInfo' ]),
    content () {
      return this.together.content.replace(/(?:\r\n|\r|\n)/g, '<br />')
    }
  },
  methods: {
    modifyTogether () {
      
      this.$router.push(
        { name: 'ModifyTogether', params: { boardNo: this.boardNo, id: this.id } }
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
    }
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