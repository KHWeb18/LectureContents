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
            
            <v-row>
              <v-col cols="12" md="6">
                <recommend-file-upload @selectFile="selectFile"></recommend-file-upload>
              </v-col>
              <v-col cols="12" md="6">
                <add-map @selectMap="selectMap"></add-map>
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
      <v-btn @click="[modifyRecommend(), modifyFile(), modifyMap()]" class="pa-6" color="secondary" icon>
        <v-icon>done</v-icon>
      </v-btn>
    </v-card-actions>
  </v-card> 
</template>


<script>
import RecommendFileUpload from '@/components/recommend/RecommendFileUpload'
import AddMap from '@/components/map/AddMap'
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
      map: {
        x: null,
        y: null,
        name: null,
        address: null,
        phone: null,
        url: null
      }
    }
  },
  components: {
    RecommendFileUpload,
    AddMap
  },
  computed: {
    ...mapState([ 'recommend' ])
  },
  created () {
    this.boardNo = this.$route.query.boardNo
    this.id = this.$route.query.id
    this.title = this.recommend.title
    this.content = this.recommend.content
    console.log(this.id, this.boardNo)
  },
  methods: {
    ...mapActions([ 'fetchRecommend' ]),
    selectFile (files) {
      this.files = files
    },
    selectMap (name, address, x, y, phone, url) {
      console.log(name)
      this.map.name = name
      this.map.address = address
      this.map.x = x
      this.map.y = y
      this.map.phone = phone
      this.map.url = url
    },
    modifyRecommend() {
      const title = this.title
      const content = this.content
      
      axios.patch(`http://localhost:7777/recommend/modify/${this.boardNo}`, { title, content }).then(() => {
        
        this.fetchRecommend(this.boardNo)

      })
    },
    modifyFile () {
      const formData = new FormData()

      for (let i = 0; i < this.files.length; i++) {
        formData.append('fileList', this.files[i])
      }

      formData.append('boardNo', this.boardNo)
      formData.append('id', this.id)

      axios.post(`http://localhost:7777/fileUpload/recommend`, formData, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      }).then (() => {
        console.log('사진 업로드 성공!')
      }).catch (() => {
        console.log('사진 업로드 실패!')
      })
    },
    modifyMap () {
      axios.patch(`http://localhost:7777/map/modify/${this.boardNo}`, this.map ).then(()=> {
        alert('수정이 완료되었습니다!')

        this.$router.push(
          { name: 'ReadRecommend', query: { boardNo: this.boardNo, id: this.id } } 
        )
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