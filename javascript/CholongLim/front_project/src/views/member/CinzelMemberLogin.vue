<template>
    <div class="img">
        <div class="content">
            <v-container fill-height style="max-width:700px;">
            <v-flex xs12> 
                <h1>Welcome</h1> <h2>to</h2> <h1>Cinzel</h1>

                    <div>
            <v-icon class="mail-icon" color="white">email</v-icon>
            <v-text-field label="아이디" dense required height="5vh"
                           v-model="userId" :rules="[v => !!v || '필수정보입니다.']" type="id">
            </v-text-field>

            <v-icon class="mail-icon" color="white">lock</v-icon>
            <v-text-field label="비밀번호" dense required height="5vh"
                        v-model="password" :rules="[v => !!v || '필수정보입니다.']" type="password">
            </v-text-field>


            <div class="btn-size">
                <v-btn width="410" height="50" @click="login({ userId, password })"
                    color="blue" style="float:left; margin-top:3%;"
                    class="white--text">
                    로그인
                </v-btn>
                <v-btn width="410" height="50" color="blue darken-4" style="float:left; margin-top:3%;"
                    class="white--text" route :to="'/memberRegister'">
                    회원가입
                </v-btn>    
            </div>  
            </div>
            </v-flex>
            </v-container>
        </div>
        <div class="img-cover"></div>
    </div>
</template>

<script>
import { LOGIN_SUCCESS } from '@/store/mutation-types'
// import { mapActions, mapState } from 'vuex'
// import axios from 'axios'
// import cookies from 'vue-cookies'


export default {
    name: 'CinzelMemberLogin',
    data () {
        return {
            userId: '',
            password: '',
        }
    },
    mounted () {
        this.$store.state.session = this.$cookies.get("user")

        if(this.$store.state.session != null) {
            LOGIN_SUCCESS
        }
    },
    // computed: {
    //     ...mapState(["isLogin", "isLoginError", "session"])
    // },
    methods: {
        login (payload) {
            if(this.$store.state.session == null) {
            const { userId, password } = payload
            this.$store.dispatch('login', {userId, password})
            this.$router.push({
                    name: 'MainPage'
            })
            } else  {
              alert('이미 로그인 되어 있습니다.')
          }
        }

        // 수업시간 로그인
    //     login ( payload) {
    //     if(this.$store.state.session == null) {
    //     const { userId, password } = payload
    //     axios.post('http://localhost:8888/jpamember/login', { userId, password})
    //             .then(res => {
    //                 if(res.data != "") {
    //                     alert('로그인이 완료되었습니다.')
    //                     console.log(res)
    //                     this.$store.loginCookie
    //                     cookies.set("user",res.data)
    //                     this.$store.state.session = res.data
    //                     console.log(res.data)
    //                     console.log(this.$store.state.session.userId)

    //                     // this.$store.commit(LOGIN_SUCCESS)
    //                     // cookies.set("user", res.date)
    //                     // this.$store.state.session = res.data
    //                     // console.log(res.data)
    //                     // console.log(this.$store.state.session.userId)


    //                     // this.$cookies.set("user", res.date, '1h')

    //                     // let token = res.data.userId
    //                     // console.log(token)
    //                     // localStorage.setItem("access_token", token)
    //                     this.$router.push({
    //                             name: 'MainPage'
    //                             })
    //                 } else {
    //                     alert('아이디와 비밀번호를 확인해주세요.')
    //                     this.$store.commit(LOGIN_ERROR)
    //                     // this.$store.state.isLogin = false
    //                 }
    //             })
    //             .catch(res => {
    //                 console.log(res)
    //             })
    //     } else  {
    //         alert('이미 로그인 되어 있습니다.' + this.$store.state.session.userId)
    //         console.log(this.$store.state.session.userId)
    //     }
        
    // }


    // 기존에 쓰던 로그인
        // login ( payload) {
        //     const { userId, password } = payload
        //     axios.post('http://localhost:8888/jpamember/login', { userId, password})
        //             .then(res => {
        //                 if(res.data != "") {
        //                     alert('로그인이 완료되었습니다.')
        //                     console.log(res)
        //                     this.$store.commit(LOGIN_SUCCESS)
                            
        //                     this.isLogin = true

        //                     let token = res.data.userId
        //                     console.log(token)
        //                     localStorage.setItem("access_token", token)
        //                     this.$router.push({
        //                             name: 'MainPage'
        //                             })
        //                 } else {
        //                     alert('아이디와 비밀번호를 확인해주세요.')
        //                     this.$store.commit(LOGIN_ERROR)
        //                 }
        //             })
        //             .catch(res => {
        //                 console.log(res)
        //             })
        //     } 
        // },
    }

    
}
</script>



 <style scoped>

 
.btn-size{
    position: relative;
    left: 13%;
}

.mail-icon{
    float: left;
    padding: 10px 20px 10px 20px;
}

h1{
    font-family: "Cinzel";
    font-size: 80px;
    margin: 0;

}

h2{
    font-family: "Cinzel";
    font-size: 40px;
    margin: -3%;
}


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