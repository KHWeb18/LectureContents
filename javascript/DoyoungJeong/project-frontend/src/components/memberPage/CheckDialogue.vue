<template>
    <v-dialog v-model="checkDialog" persistent max-width="290">
        <template v-slot:activator="{ on }">
        
            <div style="margin-top: 20px;">
                <!-- <router-link :to="{ name: 'MemberModifyPage' }" v-on="on" 
                class="btn-flat red-text waves-effect waves-teal" text="text" style="margin-right: 40px;">
                    수정
                </router-link>
        
                <router-link :to="{ name: 'MemberWithdrawalPage', params: { memberNo: memberNo } }" v-on="on" 
                class="btn-flat red-text waves-effect waves-teal" text="text">
                    탈퇴
                </router-link> -->

                <v-btn class="btn-flat red-text waves-effect waves-teal" style="margin-right: 30px;" v-on="on" outlined @click="checkWord($event)">수정</v-btn>
                <v-btn class="btn-flat red-text waves-effect waves-teal" style="margin-right: 30px;" v-on="on" outlined @click="checkWord($event)">탈퇴</v-btn>
            </div>

        </template>

        <v-card>
            <v-card-title class="headLine">
                
                    <p class="footerText" style="margin-bottom: -5px; font-size: 30px; margin: auto;">잠깐만요!</p>
                    <p style="margin-bottom: -5px; font-size: 12px; margin: auto; line-height: 20px; padding-top: 10px;">
                        변경이나 탈퇴 전 본인 확인을 위해 비밀번호를 다시한번 더 입력해주세요!</p>
             
            </v-card-title>
            <v-card-text>

                <v-container grid-list-md style="width: 100%;">

                    <v-layout wrap>
                        <v-flex xs12>
                            <v-text-field label="Password" type="password" required v-model="password"></v-text-field>
                        </v-flex>
                        <v-flex xs12>
                            <v-text-field label="Password 재입력" type="password" required v-model="passwordCheck"></v-text-field>
                        </v-flex>
                    </v-layout>

                </v-container>

            </v-card-text>
            <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="teal darken-1" text @click.native="confirm">
                    확인
                </v-btn>
                <v-btn color="teal darken-1" text @click.native="cancel">
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
    name: 'CheckDialogue',
    props: {
        memberNo: {
            type: String,
            required: true
        }
    },
    data() {
        return {
            checkDialog: false,
            password: '',
            passwordCheck: '',
            checkedWord: ''
        }
    },
    computed: {
        ...mapState(['userProfile'])
    },
    methods: {
        checkWord($event) {
            this.checkedWord = $event.target.innerHTML
        },
        confirm() {
            if(this.password == this.passwordCheck) {
                //alert(this.checkedWord)
                const id = this.$store.state.userProfile.id
                const password = this.password
                //개별로 값을 넣을 때는 {}에 변수명을 싸주면 안됐음

                //{ id: this.$store.state.userProfile.id, password: this.password }
                axios.post('http://localhost:8888/member/checkPassword', { id, password })
                    .then(res => {
                        if(res.data) {
                            this.checkDialog = false

                            if(this.checkedWord == '수정') {
                                this.$router.push({
                                    name: 'MemberModifyPage'
                                })

                            } else if(this.checkedWord == '탈퇴') {
                                this.$router.push({
                                    name: 'MemberWithdrawalPage',
                                    params: { memberNo: this.$store.state.userProfile.memberNo.toString() }
                                })
                            }

                        } else {
                            alert('올바른 비밀번호가 아닙니다!')
                        }
                    })
            } else {
                alert('비밀번호와 비밀번호 확인이 일치하지 않습니다!')
            }
        },
        cancel() {
            this.password = ''
            this.passwordCheck = ''

            this.checkDialog = false
        }
    }
}
</script>
