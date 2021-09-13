<template>
    <div class="img">
        <div class="content">
            <v-container fill-height style="max-width:700px;">

                <v-card class="login-box">
                    <v-flex xs12> 
                    <h1 style="color:black;">Login</h1>
                    <p>Please enter your account.</p>
                    <div>
                        <v-container style="width:80%; margin-top:10%;">
                            <v-text-field solo flat v-model="userId" type="text" required height="5vh"
                            dense label="아이디" :rules="[v => !!v || '필수정보입니다.']"></v-text-field>
                    
                            <v-text-field solo flat v-model="password" type="password" required height="5vh"
                            dense label="비밀번호" :rules="[v => !!v || '필수정보입니다.']"></v-text-field>
                        </v-container>

                        <div class="btn-size">
                            <v-btn width="300" height="50" @click="login({ userId, password })" rounded
                                color="blue" style="float:left; margin-top:3%;"
                                class="white--text">
                                LOGIN
                            </v-btn>
                            <v-btn width="300" height="50" color="blue darken-4" style="float:left; margin-top:3%;"
                                class="white--text" route :to="'/memberRegister'" text plain>
                                Is this your first time?
                            </v-btn>    
                        </div>  
                    </div>
                </v-flex>
                </v-card>
            </v-container>
        </div>
        <div class="img-cover"></div>
    </div>
</template>

<script>
import { LOGIN_SUCCESS } from '@/store/mutation-types'

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
    methods: {
        login (payload) {
            if(this.$store.state.session == null) {
            const { userId, password } = payload
            this.$store.dispatch('login', {userId, password})
            } else  {
              alert('이미 로그인 되어 있습니다.')
          }
        }
    }

    
}
</script>



 <style scoped>

.login-box{
    padding: 10% 0% 10% 0%;
}
 
.btn-size{
    position: relative;
    left: 13%;
}

.mail-icon{
    float: left;
    padding: 10px 20px 10px 20px;
}
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@700&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Questrial&display=swap');
h1{
    /* font-family: "Cinzel"; */
    
    font-size: 80px;
    margin: 0;

}

h2{
    font-family: 'Questrial';
    font-weight: bold;
    font-size: 40px;
    margin: -3%;
}

p{
    font-size: 14px;
    margin: 2% 0% 2% 0%;
}


.comp-login{
    width: 500px;
    height: 500px;
}

 .img{
    position: relative;
    background-image: url('https://images.pexels.com/photos/533923/pexels-photo-533923.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940');                                                               
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

<!-- 
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
            <v-text-field label="비밀번호" dense required height="5vh" id="password" solo flat
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
    methods: {
        login (payload) {
            if(this.$store.state.session == null) {
            const { userId, password } = payload
            this.$store.dispatch('login', {userId, password})
            } else  {
              alert('이미 로그인 되어 있습니다.')
          }
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
 </style>-->