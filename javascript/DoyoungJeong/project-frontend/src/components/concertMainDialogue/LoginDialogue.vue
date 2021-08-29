<template>
    <v-dialog v-model="loginDialog" persistent max-width="290">
        <template v-slot:activator="{ on }">
            <p id="topBarText" class="flat waves-effect waves-red" v-on="on" style="margin-top: -5px;">lOG IN</p>
        </template>

        <v-card>
            <v-card-title class="headLine">
                <p id="headline" style="margin-bottom: -5px;">Login</p>
            </v-card-title>
            <v-card-text>
                <v-container grid-list-md>
                    <v-layout wrap>
                        <v-flex xs12>
                            <v-text-field label="Email" type="text" required v-model="userInfo.id"></v-text-field>
                        </v-flex>
                        <v-flex xs12>
                            <v-text-field label="Password" type="password" required v-model="userInfo.password"></v-text-field>
                        </v-flex>
                    </v-layout>
                </v-container>
            </v-card-text>
            <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="teal darken-1" text @click.native="btn_login($event)">
                    로그인
                </v-btn>
                <v-btn color="teal darken-1" text @click.native="btn_login($event)">
                    취소
                </v-btn>
            </v-card-actions>
        </v-card>
    </v-dialog>
    
</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'

export default {
    name: 'LoginDialogue',
    data() {
        return {
            userInfo: { id: '', password: "" },
            loginDialog: false
        }
    },
    computed: {
           ...mapState(['isLoggedIn', 'userIdentity', 'userProfile'])
    },
    methods: {
        btn_login($event) {
            if($event.target.innerHTML == ' 취소 ') {
                this.loginDialog = false
                this.userInfo.id = ''
                this.userInfo.password = ''
           
            } else if(this.userInfo.id == '' || this.userInfo.password == '') {
                alert('email 또는 비밀번호를 입력해주세요!')
         
            } else if($event.target.innerHTML == ' 로그인 ') {
                const { id, password } = this.userInfo

                axios.post('http://localhost:8888/member/login', { id, password }) //null값이 반환되면 무조건 콘솔창에 에러 메시지
                .then(res => {
                    if(res.data.id.length > 2) {
                        alert(res.data.id + '으로 로그인되었습니다!')

                        this.$store.state.isLoggedIn = true;
         
                        this.$store.state.userIdentity = res.data.memberIdentityList[0].identity
                        this.$store.state.userProfile = res.data

                        // console.log(this.$store.state.userIdentity)
                        // console.log(this.$store.state.userProfile)

                    } else {
                        alert('로그인 실패!')
                    }
                })
                .catch(res => {
                    alert(res.response.data.message + '로그인 실패!')
                })
                this.loginDialog = false
                this.userInfo.id = ''
                this.userInfo.password = ''   
            } 
        }
    }
    
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@1,900&display=swap');

#headline {
    font-size: 30px;
    color: white;
    font-family: 'Roboto', sans-serif;
    font-style: italic;
    margin-right: 10px;
}

</style>
