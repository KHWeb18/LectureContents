<template>
    <div class="img">
        <div class="content">
            <member-login-form @submit="onSubmit" class="comp-login"/>

            <v-btn @click="login">state 로그인 후 세션 확인</v-btn><br>
            <v-btn @click="logout">state 로그아웃 확인</v-btn><br>
            
            <v-btn tile color="teal" @click="showSession">
            로그인 상태 확인
            </v-btn>
            <v-btn tile color="teal" @click="removeSession">
            로그아웃 확인
            </v-btn>
        </div>
        <div class="img-cover"></div>
    </div>
</template>

<script>
import MemberLoginForm from '@/components/member/MemberLoginForm.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'CinzelMemberLogin',
    components: {
        MemberLoginForm
    },
    props: {
        isLogin: {
            type: String
        }
    },
    data () {
        return {
            isLogined: false
        }
    },
    computed: {
        ...mapState(['isLogin'])
    },
    mounted () {
        this.login()
    },
    methods: {
        ...mapActions(['login']),
        onSubmit (payload) {
            const { userId, password } = payload
            axios.post('http://localhost:8888/jpamember/login', { userId, password})
                    .then(res => {
                        if(res.data != "") {
                            alert('로그인 성공. - ' + res.data)
                            this.isLogined = true;
                            !this.$store.state.isLogin

                            
                            // this.$router.push({
                            // name: 'MainPage',
                        // })

                        } else {
                            alert('이메일 또는 비밀번호를 다시 확인하세요.')
                        }
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        },
        showSession () {
            if (this.isLogined == true) {
                axios.post('http://localhost:8888/jpamember/needSession')
                        .then(res => {
                            if (res.data == true) {
                                alert('세션 정보 유지! - ' + res.data)
                            } else {
                                alert('세션 정보 유지 안되는 중! - ' + res.data)
                            }
                        })
                        .catch(res => {
                            alert(res.response.data.message)
                        })
            } else {
                alert('먼저 로그인부터 하세요!')
            }
        },
        removeSession () {
            axios.post('http://localhost:8888/jpamember/removeSession')
                    .then(res => {
                        this.isLogined = res.data
                        alert('로그아웃')
                    })
        }
    }
}
</script>

 <style scoped>

.comp-login{
    width: 500px;
    height: 500px;
}

 .img{
    position: relative;
    background-image: url(https://images.pexels.com/photos/17727/pexels-photo.jpg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260);                                                               
    height: 100vh;
    background-size: cover;
  }

  .img-cover{
     position: absolute;
     height: 100%;
     width: 100%;
     background-color: rgba(0, 0, 0, 0.6);                                                                 
     z-index:1;
  }

  .img .content{
     position: absolute;
     top:50%;
     left:50%;
     transform: translate(-50%, -50%);                                                                   
     font-size:5rem;
     color: white;
     z-index: 2;
     text-align: center;
  }
 </style>