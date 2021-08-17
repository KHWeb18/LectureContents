<template>
    <div class="img">
        <div class="content">
            <v-container fill-height style="max-width:700px;">
            <!-- <member-login-form @submit="onSubmit" class="comp-login"/> -->
            <v-flex xs12> 
                  <!-- <v-alert
                    class="mb-3"
                    :value="isLoginError"
                    type="error"
                    >
                    아이디와 비밀번호를 확인해주세요.
                </v-alert>
                <v-alert
                    class="mb-3"
                    :value="isLogin"
                    type="success"
                    >
                    로그인이 완료되었습니다.
                </v-alert> -->
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
            <v-btn width="410" height="50" @click="login({ userId, password })" color="blue" style="float:left; margin-top:3%;"
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
// import MemberLoginForm from '@/components/member/MemberLoginForm.vue'
import { LOGIN_ERROR, LOGIN_SUCCESS } from '@/store/mutation-types'
import { mapState } from 'vuex'
import axios from 'axios'

export default {
    name: 'CinzelMemberLogin',
    // components: {
    //     MemberLoginForm
    // },
    data () {
        return {

            userId: '',
            password: '',
        }
    },
    computed: {
        ...mapState(["isLogin", "isLoginError"]),
    },
    methods: {
        login ( payload) {
            const { userId, password } = payload
            axios.post('http://localhost:8888/jpamember/login', { userId, password})
                    .then(res => {
                        if(res.data != "") {
                            alert('로그인이 완료되었습니다.')
                            console.log(res)
                            this.isLogined = true;
                            this.$store.commit(LOGIN_SUCCESS)

                            let token = res.data.userId
                            console.log(token)
                            localStorage.setItem("access_token", token)
                            this.$router.push({
                                    name: 'MainPage'
                                    })
                        } else {
                            alert('아이디와 비밀번호를 확인해주세요.')
                            this.$store.commit(LOGIN_ERROR)
                        }
                    })
                    .catch(res => {
                        console(res)
                    })
        }
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