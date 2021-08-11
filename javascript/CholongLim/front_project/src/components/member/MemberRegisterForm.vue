<!--<template>
    <form @submit.prevent="onSubmit">
        <v-layout justify-center>
            <v-dialog v-model="registerDialog" persistent max-width="600px">
            <template v-slot:activator="{ on }">
                <v-btn color="blue darken" width="15vw" height="5vh" 
                dark v-on="on">회원가입</v-btn>
            </template>
            <v-card>
                <v-card-title primary-title class="justify-center">
                    회원가입
                </v-card-title>
                <v-card-text>
                    <v-container grid-list-md>
                        <v-layout wrap>
                            <v-flex xs12>
                                <v-text-field label="이름" type="name"
                                                value="Grocery delivery"
                                            :rules="[v => !!v || '필수정보입니다.']" 
                                            v-model="userInfo.name" required flat>
                                </v-text-field>
                            </v-flex>
                            <v-flex xs12>
                                <v-text-field label="아이디" v-model="userInfo.id"
                                                :counter="20" type="id"
                                                :rules="[v => !!v || '필수정보입니다.']"
                                                required flat>
                                </v-text-field>
                            </v-flex>
                            <v-flex xs12>
                                <v-text-field label="비밀번호" v-model="userInfo.password"
                                                :counter="20"
                                                :rules="[v => !!v || '필수정보입니다.']"
                                                required flat type="password">
                                </v-text-field>
                            </v-flex>
                            <v-flex xs12>
                                <v-text-field label="전화번호" v-model="userInfo.phoneNum"
                                                type="phoneNum"
                                                :rules="[v => !!v || '필수정보입니다.']"
                                                hint="For example, 01012345678"
                                                required flat>
                                </v-text-field>
                            </v-flex>
                            <v-flex xs12>
                                <v-text-field label="생년월일" v-model="userInfo.memberBirth"
                                                type="memberBirth"
                                                :rules="[v => !!v || '필수정보입니다.']"
                                                hint="For example, 20210808"
                                                required flat>
                                </v-text-field>
                            </v-flex> 


                            <v-checkbox
                                v-model="checkbox"
                                :rules="[v => !!v || '동의해주세요']"
                                label="개인정보 사용동의"
                                required
                            ></v-checkbox>
                        </v-layout>
                    </v-container>
                </v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text @click="btnRegisterClick($event)">
                        취소
                    </v-btn>
                    <v-btn color="blue darken" @click="btnRegisterClick($event)">
                        가입
                    </v-btn>
                </v-card-actions>
            </v-card>
            </v-dialog>
        </v-layout>
    </form>
</template>

<script>
import axios from 'axios'

export default {
    name: 'MemberLoginForm',
    data () {
        return {
            signUpDialog: false,
            registerDialog: false,
            userId: '',
            password: '',
            userInfo: {
                name: '',
                id: '',
                password: '',
                phoneNum: '',
                memberBirth: ''
            },
            checkbox: ''
        }
    },
    methods: {
        btnRegisterClick ($event) {
            if($event.target.innerHTML == ' 가입 ') {
                alert('회원가입이 완료되었습니다.')
                const { name, id, password, phoneNum, memberBirth } = this
                this.$emit('submit', { name, id, password, phoneNum, memberBirth })
                this.registerDialog = false    
            } else {
                this.registerDialog = false 
            }
        },
        btnRegisterClick ($event) {
            if($event.target.innerHTML == ' 가입 ') {
                const { userId, password, auth } = this
                axios.post('http://localhost:7777/jpamember/register', {
                        userId, password, auth
                    })
                    .then(res => {
                        alert('등록 성공! - ' + res)
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
                this.registerDialog = false    
            } else {
                this.registerDialog = false 
            }
        }
    }
}

</script>-->


<template>
    <v-container>
        <form @submit.prevent="onSubmit">
            <div justify-center>
            <div class="row">
                <v-radio-group v-model="radioGroup" row style="margin-left:40%;">
                    <v-radio v-for="kinds in kindsOfMember" :key="kinds" 
                    :label="`${kinds}`" color="white"> 
                    </v-radio>
                </v-radio-group>
            </div>

            <div justify-center>


        <div class="login-form">

            <v-icon class="name-icon" color="white">face</v-icon>
            <v-text-field label="이름" dense required height="5vh" style="margin-top:10px;" solo
                           v-model="userName" :rules="[v => !!v || '필수정보입니다.']" type="name">
            </v-text-field>

            <v-icon class="mail-icon" color="white">email</v-icon>
            <v-text-field label="아이디" dense required height="5vh" style="margin-top:10px;" solo
                           v-model="userId" :rules="[v => !!v || '필수정보입니다.']" type="id">
            </v-text-field>

            <v-icon class="pass-icon" color="white">lock</v-icon>
            <v-text-field label="비밀번호" dense required height="5vh" style="margin-top:10px;" solo
                        v-model="password" :rules="[v => !!v || '필수정보입니다.']" type="password">
            </v-text-field>

            <v-icon class="phone-icon" color="white">call</v-icon>
            <v-text-field label="전화번호" dense required height="5vh" style="margin-top:10px;" solo
                        v-model="userPhone" :rules="[v => !!v || '필수정보입니다.']" type="phone">
            </v-text-field>

        <div class="btn-size">
            <v-btn width="410" height="50" type="submit" color="blue" style="float:left; margin-top:6%;"
            class="white--text">
            회원가입
            </v-btn>
            <v-btn width="410" height="50" color="blue darken-4" style="float:left; margin-top:3%;"
            class="white--text" route :to="'/cinzel'">
            취소
            </v-btn>    
        </div>

        </div>
       </div>
            </div>
        </form>
    </v-container>
</template>

<script>
export default {
    name: 'MemberRegisterForm',
    data () {
        return {
            radioGroup: 1,
            kindsOfMember: [
                '개인',
                '사업자'
            ],
            userId: '',
            password: ''
        }
    },
    methods: {
        onSubmit () {
            const { userId, password, radioGroup } = this
            const auth = radioGroup == 0 ? '개인' : '사업자'
            this.$emit('submit', { userId, password, auth })
        }
    }
}
</script>

<style scoped>

.register-box{
    border: 1px solid #cccccc;
    background-color: white;
    float: left;
    width: 500px;
    height: 500px;
}

.btn-size{
    position: relative;
    left: 15%;
}

.name-icon{
    float: left;
    padding: 7px 20px 15px 20px;
}

.pass-icon{
    float: left;
    padding: 16px 20px 15px 20px;
}

.phone-icon{
    float: left;
    padding: 16px 20px 15px 20px;
}

.mail-icon{
    float: left;
    padding: 16px 20px 15px 20px;
}

h1{
    font-family: "Cinzel";
    font-size: 60px;
    margin: 0;

}

h2{
    font-family: "Cinzel";
    font-size: 30px;
    margin: -3%;
}

</style>