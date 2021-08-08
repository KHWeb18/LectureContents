<template>
    <form @submit.prevent="onSubmit">
        <v-layout class="login-locate">
            <v-dialog v-model="signUpDialog" persistent max-width="500px">
            <template v-slot:activator="{ on }">
                <v-btn plain large v-on="on"><v-icon>account_circle</v-icon></v-btn>
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
                                             outlined v-model="userInfo.id"
                                             :rules="[v => !!v || '필수정보입니다.']"
                                             type="id">
                                </v-text-field>
                            </v-flex>
                            <v-flex xs12>
                                <v-text-field label="비밀번호" dense required
                                                height="5vh"
                                                outlined v-model="userInfo.password"
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

export default {
    name: 'MemberLoginForm',
    components: {
        MemberRegisterForm
    },
    data () {
        return {
            signUpDialog: false,
            userInfo: {
                id: '',
                password: ''
            },
            checkbox: ''
        }
    },
    methods: {
        btnSignUpClick ($event) {
            if($event.target.innerHTML == ' 로그인 ') {
                alert('로그인이 완료되었습니다.')
                const { name, id, password, phoneNum, memberBirth } = this
                this.$emit('submit', { name, id, password, phoneNum, memberBirth })
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


</style>