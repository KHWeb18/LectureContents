<template>
    <form @submit.prevent="onSubmit">
        <div id="app">
        <v-app id="inspire">
            <v-app id="inspire">
            <v-main>
                <v-container
                class="fill-height"
                fluid
                >
                <v-row
                    align="center"
                    justify="center"
                >
                    <v-col
                    cols="12"
                    sm="8"
                    md="4"
                    >
                    <v-card class="elevation-12">
                        <v-toolbar
                        color="blue darken-3"
                        dark
                        flat
                        >
                        <v-toolbar-title>회원가입</v-toolbar-title>
                        <v-spacer></v-spacer>
                       
                        </v-toolbar>
                        <v-card-text>
                        <v-form>
                            <v-text-field
                            label="이름"
                            prepend-icon="mdi-account"
                            type="text"
                            v-model="name"
                            :rules="nameRules"
                            flat solo
                            ></v-text-field>

                            <v-text-field
                            label="생년월일"
                            prepend-icon="mdi-cake"
                            type="text"
                            v-model="birth"
                            :rules="birthRules"
                            flat solo
                            ></v-text-field>

                            <v-text-field
                            label="아이디"
                            prepend-icon="mdi-account"
                            type="text"
                            v-model="email"
                            :rules="emailRules"
                            flat solo
                            ></v-text-field>

        
                            <v-text-field
                            id="password"
                            label="비밀번호"
                            name="password"
                            prepend-icon="mdi-lock"
                            type="password"
                            v-model="password"
                            :rules="passwordRules"
                            
                            flat solo></v-text-field>
                        </v-form>

                        </v-card-text>
                        <v-card-actions>
                        <v-spacer></v-spacer>

                        <v-btn color="primary"
                        type="submit"
                        >등록</v-btn>&nbsp;&nbsp;
                        

                        <router-link :to="{name:'Home'}">
                            <v-btn color="primary">취소</v-btn>
                        </router-link>
                        </v-card-actions>
                    </v-card>
                    </v-col>
                </v-row>
                </v-container>
            </v-main>
            </v-app>
        </v-app>
        </div>
    </form>
</template>

<script>
export default {
    name: 'AccountRegisterForm',
    data () {
        return {
            name: '',
            birth: '',
            email: '',
            password: '',

            //ruels
            nameRules:[
                v => !!v || '이름은 필수 입력사항입니다.',
                v => !(v && v.length >=20) || '이름은 20자 이상 입력 할 수 없습니다.',
                v => v.search(/\s/) === -1 || '공백을 제거해주세요!',
                v => !/[~!@#$%^&*()_+|<>?:{}]/.test(v) || '이름에는 특수문자를 사용할 수 없습니다.!'
            ],
            birthRules:[
                v => !!v || '생년월일을 작성해주세요.',
                v => /^[0-9]*$/ .test(v) || '생년월일은 숫자만 입력 가능합니다.',
                v => (v && v.length ==6) || '생년월일은 6자로 작성하여 주세요.',
                v => v.search(/\s/) === -1 || '공백을 제거해주세요!'
            ],
            emailRules:[
                v => !!v || '이메일을 작성해주세요.',
                v => /.+@.+\..+/.test(v) || '이메일 형식으로 작성해주세요.',
                v => v.search(/\s/) === -1 || '공백을 제거해주세요!'
            ],
            passwordRules:[
                v => !!v || '비밀번호를 작성해주세요',
                v => v.search(/\s/) === -1 || '공백을 제거해주세요!'
            ],
        }
    },
    methods: {
        onSubmit () {
            const { name, birth, email, password } = this
            this.$emit('submit', { name, birth, email, password })
        }
    }
}
</script>