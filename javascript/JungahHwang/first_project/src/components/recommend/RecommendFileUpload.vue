<template>
  <v-card flat>
   
    <v-file-input class="mx-10" v-model="files" @change="select" label="사진 찾기"
      color="secondary"  chips multiple ></v-file-input>

    <v-card class="mx-10" flat>
      <v-img class="ml-10" :src="url" width="80%"/>
    </v-card>

  </v-card>
</template>


<script>
//import axios from 'axios'

export default {
  data () {
    return {
      files: [],
      url: null
    }
  },
  methods: {
    select () {
      console.log(this.files)
      this.url = URL.createObjectURL(this.files[0])

      this.$emit('selectFile', this.files)
    },
    // fileUpload () {
    //   let formData = new FormData()

    //   for (let i = 0; i < this.files.length; i++) {
    //     formData.append('fileList', this.files[i])
    //   }

    //   formData.append('boardNo', 12)
    //   formData.append('id', 'test')

    //   console.log(formData)

      
    //   axios.post(`http://localhost:7777/fileUpload/recommend`, formData, {
    //       headers: {
    //         'Content-Type': 'multipart/form-data'
    //       }
    //     }).then (res => {
    //       this.response = res.data

    //       alert('사진 업로드 완료!')
    //     }).catch (res => {
    //       this.response = res.message
    //     })

    // },
    // fileDownload () {
    //   try {
    //     return require(`../../../../FirstProject/images/12_test.jpg`)
    //   } catch (e) {
    //     return require(`@/assets/icon/logo.png`)
    //   }
    // }
  }
}
</script>