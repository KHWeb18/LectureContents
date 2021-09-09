<template>

  <v-card class="my-5 pt-1" color="primary">
    <v-card class="ma-5">
      <v-text-field v-model="title" class="mb-n7" color="secondary"
        label="제목을 입력하세요." solo flat></v-text-field>
      <v-divider></v-divider>

      <file-upload-menu v-on:fileUpload="fileUpload"></file-upload-menu>

      <v-textarea v-model="content" color="secondary" height="500px" 
        label="내용을 입력하세요." solo flat></v-textarea>
    </v-card>
    <v-card-actions>
      <v-spacer></v-spacer>
      <v-btn @click="addRecommend" class="pa-6" color="secondary" icon>
        <v-icon>done</v-icon>
      </v-btn>
    </v-card-actions>
    
  </v-card>
    

</template>


<script>
import FileUploadMenu from '@/components/FileUploadMenu'
import axios from 'axios'
import { mapState } from 'vuex'

export default {
  data () {
    return {
      title: null,
      content: null,
      formData: [],
      img:null
    }
  },
  components: {
    FileUploadMenu,
  },
  computed: {
    ...mapState([ 'userInfo' ])
  },
  methods: {
    fileUpload (img, formData) {
      this.img = img,
      this.formData = formData
    },
    addRecommend () {
      const id = this.userInfo.id
      const title = this.title
      const content = this.content
      const img = this.img
      const formData = this.formData

      axios.post('http://localhost:7777/recommend/register', { id, title, content, img }).then(() => {
        alert('등록이 완료되었습니다!')

        this.$router.push(
          { name: 'Recommend' }
        )
      })

      
      axios.post('http://localhost:7777/file/upload', formData, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      }).then (res => {
        this.response = res.data

        alert('사진 업로드 완료!')
      }).catch (res => {
        this.response = res.message
      })
    }
  }
}
</script>