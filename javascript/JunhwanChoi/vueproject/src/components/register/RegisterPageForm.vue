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
                            name="username"
                            prepend-icon="mdi-name"
                            type="text"
                            v-model="username"
                            flat solo
                            ></v-text-field>

                            <v-text-field
                            label="생년월일"
                            name="birth"
                            prepend-icon="mdi-birth"
                            type="text"
                            v-model="birth"
                            flat solo
                            ></v-text-field>

                            <v-text-field
                            label="아이디"
                            name="id"
                            prepend-icon="mdi-account"
                            type="text" 
                            v-model="id"
                            flat solo
                            ></v-text-field>
        
                            <v-text-field
                            id="password"
                            label="비밀번호."
                            name="password"
                            prepend-icon="mdi-lock"
                            type="password"
                            v-model="password"
                            
                            flat solo></v-text-field>
                        </v-form>

                        </v-card-text>
                        <v-card-actions>
                        <v-spacer></v-spacer>

                        <v-btn color="primary"
                        type="submit"
                        >회원가입 완료</v-btn>&nbsp;&nbsp;
                        

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
    name: 'RegisterPageForm',

    data(){
        return{
            username:'',
            birth:'',    
            id:'',
            password:'',

        }
    },
    methods:{
          onSubmit () {
            const { id, password, username, birth } = this
            this.$emit('submit', { id, password, username, birth })
        }
    }
}
</script>