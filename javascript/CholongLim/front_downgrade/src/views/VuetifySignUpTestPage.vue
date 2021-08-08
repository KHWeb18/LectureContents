<template>
    <v-layout justify-center>
        <v-dialog v-model="signUpDialog" persistent max-width="500px">
        <template v-slot:activator="{ on }">
            <v-btn color="indigo darken-1" dark v-on="on">회원가입</v-btn>
        </template>
        <v-card>
            <v-card-title primary-title class="justify-center">
                회원가입
            </v-card-title>
            <v-card-text>
                <v-container grid-list-md>
                    <v-layout wrap>
                        <v-flex xs12>
                            <v-text-field label="이름" :counter="10"
                                        :rules="[v => !!v || '필수정보입니다.']" 
                                        v-model="userInfo.name" required flat solo>
                                        <!-- type="name" 하면 미입력 시 다 빨갛게 변함 -->
                            </v-text-field>
                        </v-flex>
                        <v-flex xs12>
                            <v-text-field label="아이디" v-model="userInfo.id"
                                            :rules="[v => !!v || '필수정보입니다.']"
                                            required flat solo type="id">
                            </v-text-field>
                        </v-flex>
                        <v-flex xs12>
                            <v-text-field label="비밀번호" v-model="userInfo.password"
                                            :rules="[v => !!v || '필수정보입니다.']"
                                            required flat solo type="password">
                            </v-text-field>
                        </v-flex>
                        <v-flex xs12>
                            <v-text-field label="전화번호" v-model="userInfo.phoneNum"
                                            :rules="[v => !!v || '필수정보입니다.']"
                                            required flat solo type="phoneNum">
                            </v-text-field>
                        </v-flex>
                        <v-flex xs12>
                            <!-- <v-select
                                v-model="userInfo.birth"
                                :items="months"
                                :rules="[v => !!v || '필수정보입니다.']"
                                label="월"
                                required
                                ></v-select> -->
                            <v-text-field label="생년월일" v-model="userInfo.memberBirth"
                                            :rules="[v => !!v || '필수정보입니다.']"
                                            required flat solo type="memberBirth">
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
                <v-btn color="blue darken-1" text @click="btnSignUpClick($event)">
                    취소
                </v-btn>
                <v-btn color="blue darken-1" text @click="btnSignUpClick($event)">
                    회원가입
                </v-btn>
            </v-card-actions>
        </v-card>
        </v-dialog>
    </v-layout>
</template>

<script>

import axios from 'axios'

export default {
    name: 'VuetifySignUpPage',
    data () {
        return {
            signUpDialog: false,
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
        btnSignUpClick ($event) {
            if($event.target.innerHTML == ' 회원가입 ') {
                const { name, id, password, phoneNum, memberBirth } = this
                axios.post('http://localhost:7777/vuejpamember/register', 
                { name, id, password, phoneNum, memberBirth })
                    .then(res => {
                        alert('회원가입이 완료되었습니다. - ' + res)
                        this.signUpDialog = false
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
            }
        }
    }
}

</script>