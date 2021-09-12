<template>

  <v-card class="my-5 pt-1" color="primary">
    <v-card class="ma-5">
      <v-text-field v-model="title" class="mb-n7" color="secondary"
        label="제목을 입력하세요." solo flat></v-text-field>
      <v-divider></v-divider>

      <v-card flat>
        <v-list-item class="ml-n1">
          <v-list-item-title class="gray--text">사진이나 지도 첨부</v-list-item-title>
          <v-btn icon @click="show = !show">
            <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
          </v-btn>
        </v-list-item>
        <v-expand-transition>
          <div v-show="show">
            <!--
            <file-upload-menu @fileUpload="fileUpload"></file-upload-menu>
            -->
            <add-map @selectMap="selectMap"></add-map >
          
          </div>
        </v-expand-transition>
      
      </v-card>
      
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
//import FileUploadMenu from '@/components/FileUploadMenu'
import AddMap from '@/components/map/AddMap'
import axios from 'axios'
import { mapState } from 'vuex'

export default {
  data () {
    return {
      show: false,
      title: null,
      content: null,
      formData: [],
      img:null,
      x: null,
      y: null,
      placeName: null,
      address: null,
      phone: null,
      url: null
    }
  },
  components: {
    //FileUploadMenu,
    AddMap,
  },
  computed: {
    ...mapState([ 'userInfo' ])
  },
  methods: {
    fileUpload (img, formData) {
      this.img = img,
      this.formData = formData
    },
    selectMap (name, address, x, y, phone, url) {
      console.log(name)
      this.placeName = name
      this.address = address
      this.x = x
      this.y = y
      this.phone = phone
      this.url = url
    },
    addRecommend () {
      const id = this.userInfo.id
      const title = this.title
      const content = this.content
      const img = this.img
      const placeName = this.placeName
      const address = this.address
      const x = this.x
      const y = this.y
      const phone = this.phone
      const url = this.url

      const formData = this.formData

      axios.post('http://localhost:7777/recommend/register', { id, title, content, img, placeName, 
      address, x, y, phone, url }).then(() => {
        alert('등록이 완료되었습니다!')

        this.$router.push(
          { name: 'Recommend' }
        )
      })

      if (formData != null) {
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
}
</script>



<style scoped>
.gray--text {
  color:rgba(100, 100, 100, 0.815)
}
</style>