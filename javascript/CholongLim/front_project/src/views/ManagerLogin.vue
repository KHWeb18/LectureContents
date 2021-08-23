<template>
     <v-container fill-height style="max-width:450px;">
        <v-layout align-center row wrap>
            <v-flex xs12>
                 <!-- <v-alert
                    class="mb-3"
                    :value="isLoginError"
                    type="error"
                    >
                    아이디와 비밀번호를 확인해주세요.
                </v-alert>
                <v-alert
                    class="mb-3"
                    :value="isLogin"
                    type="success"
                    >
                    로그인이 완료되었습니다.
                </v-alert> -->
                <v-card>
                    <v-toolbar flat color="grey lighten-3">
                        <v-toolbar-title>관리자 로그인</v-toolbar-title>
                    </v-toolbar>
                    <div class="pa-3">
                        <v-text-field
                            v-model="mId"
                            type="id"
                            label="이메일을 입력하세요"
                        >
                        </v-text-field>

                        <v-text-field
                            v-model="mPassword"
                            type="password"
                            label="패스워드를 입력하세요"
                        >
                        </v-text-field>
                        <v-btn large block depressed color="primary"
                                @click="login({ userId, password })">로그인</v-btn>
                    </div>
                </v-card>
            </v-flex>
        </v-layout>
    </v-container>
</template>