<template>
  <v-card class="my-5 pt-1" color="primary">
    <v-card class="ma-5">
      <v-text-field v-model="title" class="mb-n7" color="secondary" 
        label="제목을 입력하세요." solo flat></v-text-field>
      <v-divider></v-divider>

      <v-card flat>
        <v-list-item class="ml-n1">
          <v-list-item-title class="gray--text">사진 첨부</v-list-item-title>
          <v-btn icon @click="show = !show">
            <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
          </v-btn>
        </v-list-item>
        <v-expand-transition>
          <div v-show="show">
            <v-row>
              <v-col cols="12" md="7">
                <together-file-upload @selectFile="selectFile"></together-file-upload>
              </v-col>
            </v-row>
        </div>
        </v-expand-transition>
      </v-card>

      <v-textarea v-model="content" color="secondary" height="500px" 
        label="내용을 입력하세요." solo flat></v-textarea>
    </v-card>
    <v-card-actions>
      <v-spacer></v-spacer>
      <v-btn @click="[modifyTogether(), modifyFile()]" class="pa-6" color="secondary" icon>
        <v-icon>done</v-icon>
      </v-btn>
    </v-card-actions>
  </v-card> 
</template>


<script>
import TogetherFileUpload from '@/components/together/TogetherFileUpload'
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
  data () {
    return {
      title: null,
      content: null,
      boardNo: null,
      id: null,
      show: false,
      files: null,
    }
  },
  components: {
    TogetherFileUpload
  },
  computed: {
    ...mapState([ 'together' ])
  },
  created () {
    this.boardNo = this.$route.query.boardNo
    this.id = this.$route.query.id
    this.title = this.together.title
    this.content = this.together.content
  },
  methods: {
    ...mapActions([ 'fetchTogether' ]),
    selectFile (files) {
      this.files = files
    },
    modifyTogether() {
      const title = this.title
      const content = this.content
      
      axios.patch(`http://localhost:7777/together/modify/${this.boardNo}`, { title, content }).then(() => {
        this.fetchTogether(this.boardNo)
      })
    },
    modifyFile () {
      const formData = new FormData()

      for (let i = 0; i < this.files.length; i++) {
        formData.append('fileList', this.files[i])
      }

      formData.append('boardNo', this.boardNo)
      formData.append('id', this.id)

      axios.post(`http://localhost:7777/fileUpload/together`, formData, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      }).then (() => {
        alert("수정이 완료되었습니다!")

        this.$router.push(
          { name: 'ReadTogether', query: { boardNo: this.boardNo, id: this.id } } 
        )
      }).catch (() => {
        console.log('사진 업로드 실패!')
      })
    }
  }
}
</script>


<style scoped>
.gray--text {
  color:rgba(100, 100, 100, 0.815)
}
</style>