<template>

  <v-card class="my-5 pt-1" color="primary">
    <v-card class="ma-5" height="600px">
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
      formData: []
    }
  },
  components: {
    FileUploadMenu,
  },
  computed: {
    ...mapState([ 'userInfo' ])
  },
  methods: {
    fileUpload (formData) {
      this.formData = formData
      console.log( 'add: ' + this.formData)
    },
    addRecommend () {
      const id = this.userInfo.id
      const title = this.title
      const content = this.content

      axios.post('http://localhost:7777/recommend/register', { id, title, content },
      //{ headers: { 'Content-Type': 'multipart/form-data' } }
      ).then(() => {
        alert('등록이 완료되었습니다!')

        this.$router.push(
          { name: 'Recommend' }
        )
      })
    }
  }
}
</script>