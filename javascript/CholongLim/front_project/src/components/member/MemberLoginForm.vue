<!--<template>
    <form @submit.prevent="onSubmit">
        <v-layout class="login-locate">
            <v-dialog v-model="signUpDialog" persistent max-width="500px">
            <template v-slot:activator="{ on }">
                <v-btn plain large v-on="on">로그인</v-btn>
            </template>
            <v-card>
                <v-card-title class="justify-center">
                    로그인
                </v-card-title>
                <v-card-text>
                    <v-container grid-list-md>
                        <v-layout wrap class="justify-center">
                            <v-flex xs12>
                                <v-text-field label="아이디" dense required 
                                             height="5vh"
                                             outlined v-model="userId"
                                             :rules="[v => !!v || '필수정보입니다.']"
                                             type="id">
                                </v-text-field>
                            </v-flex>
                            <v-flex xs12>
                                <v-text-field label="비밀번호" dense required
                                                height="5vh"
                                                outlined v-model="password"
                                                :rules="[v => !!v || '필수정보입니다.']"
                                                type="password">
                                </v-text-field>
                            </v-flex>
                        </v-layout>
                    </v-container>
                </v-card-text>
                <v-card-actions indigo white--text class="justify-center">
                    <v-btn color="blue darken-2" dark width="15vw" height="5vh"
                            @click="btnSignUpClick($event)">
                        로그인
                    </v-btn>
                </v-card-actions>
                <v-card-actions indigo white--text class="justify-center">
                        <member-register-form/>
                </v-card-actions>
                <v-card-actions indigo white--text class="justify-center">
                    <v-btn color="blue darken-1" text width="15vw" height="5vh"
                            @click="btnSignUpClick($event)">
                        취소
                    </v-btn>
                </v-card-actions>
            </v-card>
            </v-dialog>
        </v-layout>
    </form>
</template>

<script>
import MemberRegisterForm from '@/components/member/MemberRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'MemberLoginForm',
    components: {
        MemberRegisterForm
    },
    data () {
        return {
            signUpDialog: false,
            userId: '',
            password: '',
            checkbox: ''
        }
    },
    methods: {
        btnSignUpClick ($event) {
            if($event.target.innerHTML == ' 로그인 ') {
                const { userId, password } = this
                axios.post('http://localhost:7777/jpamember/login', { userId, password, auth: null })
                    .then(res => {
                        if(res.data == true) {
                            alert('로그인 성공. - ' + res.data)
                        } else {
                            alert('로그인 실패. - ' + res.data)
                        }
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
                this.signUpDialog = false   
            } else {
                this.signUpDialog = false  
            }
        }
    }
}

</script>


<style scoped>

.login-locate {
    padding-left: 500px;
}


</style>-->

<template>
    <form @submit.prevent="onSubmit">
       <div justify-center>
           <h1>Welcome</h1> <h2>to</h2> <h1>Cinzel</h1>
        <div class="login-form">
            <v-icon class="mail-icon" color="white">email</v-icon>
            <v-text-field label="아이디" dense required height="5vh"
                           v-model="userId" :rules="[v => !!v || '필수정보입니다.']" type="id">
        </v-text-field>

        <v-icon class="mail-icon" color="white">lock</v-icon>
        <v-text-field label="비밀번호" dense required height="5vh"
                       v-model="password" :rules="[v => !!v || '필수정보입니다.']" type="password">
        </v-text-field>


        <div class="btn-size">
            <v-btn width="410" height="50" type="submit" color="blue" style="float:left; margin-top:3%;"
            class="white--text">
            로그인
            </v-btn>
            <v-btn width="410" height="50" color="blue darken-4" style="float:left; margin-top:3%;"
            class="white--text" route :to="'/memberRegister'">
            회원가입
            </v-btn>    
        </div>

        </div>
       </div>
    </form>
</template>

<script>

export default {
    name: 'MemberLoginForm',
    data () {
        return {
            userId: '',
            password: '',
            signUpDialog: false
        }
    },
    methods: {
        onSubmit () {
            const { userId, password } = this
            this.$emit('submit', { userId, password })
        },
        btnSignUpClick() {
            this.signUpDialog = false
        }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');


.btn-size{
    position: relative;
    left: 15%;
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

</style>