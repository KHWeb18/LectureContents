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
                        color="blue lighten-3"
                        white
                        flat
                        >
                        <v-toolbar-title>로그인</v-toolbar-title>
                        <v-spacer></v-spacer>
                       
                        </v-toolbar>
                        <v-card-text>
                        <v-form>
                            <v-text-field
                            label="이름"
                            prepend-icon="mdi-account"
                            type="text"
                            v-model="email"
                            flat solo
                            ></v-text-field>

        
                            <v-text-field
                            id="password"
                            label="비밀번호"
                            name="password"
                            prepend-icon="mdi-lock"
                            type="password"
                            v-model="password"
                            
                            flat solo></v-text-field>
                        </v-form>

                        </v-card-text>
                        <v-card-actions>
                        <v-spacer></v-spacer>

                        <v-btn color="blue lighten-3"
                        type="submit"
                        >로그인</v-btn>&nbsp;&nbsp;
                        

                        <router-link :to="{name:'Home'}">
                            <v-btn color="blue lighten-3">취소</v-btn>
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
    name: 'SessionLoginForm',
    data () {
        return {
            email: '',
            password: ''
        }
    },
    methods: {
        onSubmit () {
            const { email, password } = this
            this.$emit('submit', { email, password })
        }
    }
}
</script>