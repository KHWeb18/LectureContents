<template>
  <div>
    <div align="center">
      <h2>로그인</h2>
    </div>
    <member-login @submit="onSubmit"></member-login>
    <v-spacer></v-spacer>
    <v-btn @click="logout" v-if="isLogin">로그아웃</v-btn>
    <v-btn color="teal" @click="showSession">세션 보기</v-btn>
    <v-btn color="teal" @click="removeSession">세션 끊기</v-btn>
  </div>
</template>

<script>
import MemberLogin from '@/components/jpa/MemberLogin'
import axios from 'axios'
import Vue from 'vue'
import cookies from 'vue-cookies'
import { mapState } from 'vuex'

Vue.use(cookies)

export default {
  name: 'MemberLoginPage',
  components: {
    MemberLogin
  },
  data () {
    // 실제 프로젝트에서는 데이터를 state에 
    return {
      isLogin: false
    }
  },
  mounted () {
    // this.fetchSession() -> 실제 프로젝트에서는 이렇게
    this.$store.state.session = this.$cookies.get("user")

    if (this.$store.state.session != null) {
      this.isLogin = true
    }
  },
  computed: {
    ...mapState([ 'session' ])
  },
  methods: {
    onSubmit (payload) {
      if (this.$store.state.session == null) {
        const { id, pw } = payload
        axios.post('http://localhost:7777/jpamember/login', { id, pw, auth: null }).then(res => {
          if (res.data != "") {
            alert('로그인이 완료되었습니다!')
            
            this.isLogin = true;
            this.$store.state.session = res.data
            this.$cookies.set('user', res.data, '1h')
          } else {
            alert('로그인에 실패하였습니다.')
            this.isLogin = false
          }
        }).catch(res => {
          alert(res.response.data.message)
        })
      } else {
        alert('이미 로그인이 되어있습니다!! ' + this.$store.state.session.id)
      }
      
    },
    showSession () {
      if (this.isLogin == true) {
        axios.post('http://localhost:7777/jpamember/needSession').then(res => {
        if (res.data == true) {
          alert('세션 정보 유지')
        } else {
          alert('세션 정보 없음')
        }
      }).catch(res => {
        alert(res.response.data.message)
      })
      }
    },
    removeSession () {
      axios.post('http://localhost:7777/jpamember/removeSession').then(res => {
        this.isLogin = res.data
      })
    },
    logout () {
      this.$cookies.remove('user')
      this.isLogin = false
      this.$store.state.session = null
    }  
  }
}
</script>