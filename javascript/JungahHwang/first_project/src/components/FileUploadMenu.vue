<template>
<v-card flat>
  <v-menu :rounded="rounded" offset-y>
    <template v-slot:activator="{ attrs, on }">
      <v-btn class="float-right" v-bind="attrs" v-on="on">
        메뉴
      </v-btn>
    </template>

    <v-list>
      <v-list-item link>
        <v-list-item-title>ㅎㅎ</v-list-item-title>
      </v-list-item>
      <v-list-item link>
        <v-list-item-title>ㅎdㅎ</v-list-item-title>
      </v-list-item>
    </v-list>
  </v-menu>
  
  <v-file-input class="mx-5" color="secondary" :rules="rules" accept="image/png, image/jpeg, image/bmp"
    placeholder="사진을 선택해주세요." prepend-icon="mdi-camera" label="Select Files"
    ref="files" multiple v-on:change="handleFileUpload"></v-file-input>
  <v-btn @click="submitFiles()">업로드</v-btn>
</v-card>
</template>


<script>
export default {
  data() {
    return {
      files: null,
      rules: [
        value => !value || value.size < 30000000 || 'Avatar size should be less than 30 MB!',
      ],
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