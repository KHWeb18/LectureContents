<template>
    <form @submit.prevent="onSubmit">
        <v-layout justify-center>
            <v-dialog v-model="registerDialog" persistent max-width="600px">
            <template v-slot:activator="{ on }">
                <v-btn color="blue darken" width="15vw" height="5vh" dark v-on="on">회원가입</v-btn>
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
                                            <!-- type="name" 하면 미입력 시 다 빨갛게 변함 -->
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

export default {
    name: 'MemberLoginForm',
    data () {
        return {
            registerDialog: false,
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
    }
}

</script>