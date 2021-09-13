<template>
  <v-container>
    <h3>File Upload Result: </h3>
    <div>
      <label>Files
        <input type="file" id="files" ref="files" multiple v-on:change="handleFileUpload"/>
      </label>
      <v-btn @click="submitFiles()">업로드</v-btn>
    </div>
  </v-container>
</template>


<script>
//import axios from 'axios'

export default {
  name: 'FileUploadPage',
  data () {
    return {
      files: ''
    }
  },
  methods: {
    handleFileUpload () {
      this.files = this.$refs.files.files
    },
    submitFiles () {
      let formData = new FormData ()

      for (let idx = 0; idx < this.files.length; idx++) {
        formData.append('fileList', this.files[idx])
      }

      console.log(formData)

      // 다중 파일 업로드 할 때는 아래 형식을 지켜주어야 함
      // axios.post('http://localhost:7777/file/upload', formData, {
      //   headers: {
      //     'Content-Type': 'multipart/form-data'
      //   }
      // }).then (res => {
      //   this.response = res.data
      //   alert('Processing Complete!')
      // }).catch (res => {
      //   this.response = res.message
      // })
    },
  }
}
</script>