<template>
  <v-card class="my-5 pt-1" color="primary">
    <v-card class="ma-5">
      <v-text-field v-model="title" class="mb-n7" color="secondary" 
        label="제목을 입력하세요." solo flat></v-text-field>
      <v-divider></v-divider>

      <v-card flat>
        <v-list-item class="ml-n1">
          <v-list-item-title class="gray--text">사진이나 링크 첨부</v-list-item-title>
          <v-btn icon @click="show = !show">
            <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
          </v-btn>
        </v-list-item>
        <v-expand-transition>
          <div v-show="show">
            <v-row>
              <v-col cols="12" md="6">
                <together-file-upload @selectFile="selectFile"></together-file-upload>
              </v-col>
              <v-col cols="12" md="6">
                <v-text-field v-model="link" class="mr-10" color="secondary" 
                label="링크 추가" prepend-icon="insert_link"></v-text-field>
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
      <v-btn @click="[addTogether(), addFile()]" class="pa-6" color="secondary" icon>
        <v-icon>done</v-icon>
      </v-btn>
    </v-card-actions>
    
  </v-card>
</template>


<script>
import TogetherFileUpload from '@/components/together/TogetherFileUpload'
import axios from 'axios'
import { mapState } from 'vuex'

export default {
  data () {
    return {
      title: null,
      content: null,
      link: null,
      show: false,
      files: [],
      boardNo: null
    }
  },
  components: {
    TogetherFileUpload
  },
  computed: {
    ...mapState([ 'userInfo' ])
  },
  methods: {
    selectFile (files) {
      this.files = files
    },
    addTogether () {
      const title = this.title
      const content = this.content
      const link = this.link
      const id = this.userInfo.id

      axios.post('http://localhost:7777/together/register', { title, content, link, id }).then(res => {
        alert('등록이 완료되었습니다!')

        this.boardNo = res.data.boardNo

        this.$router.push(
          { name: 'Together' }
        )
      })
    },
    addFile () {
      setTimeout(() => {
        const formData = new FormData()

        for (let i = 0; i < this.files.length; i++) {
          formData.append('fileList', this.files[i])
        }

        formData.append('boardNo', this.boardNo)
        formData.append('id', this.userInfo.id)

        axios.post(`http://localhost:7777/fileUpload/together`, formData, {
          headers: {
            'Content-Type': 'multipart/form-data'
          }
        }).then (res => {
          console.log(res.data)
        }).catch (err => {
          console.log(err)
        })
      }, 1000)
    }
  }
}
</script>


<style scoped>
.gray--text {
  color:rgba(100, 100, 100, 0.815)
}
</style>