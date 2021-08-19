<template>
    <div>
        <form id="board"  class="loginForm">
            <v-dialog v-model="loginDialog"  max-width="500px">
              
              <v-card>
                  <v-card-title>
                      <span class="headline">
                          Log in
                      </span>
                  </v-card-title>
                  <v-card-text>
                      <v-container grid-list-md>
                          <v-layout wrap>
                              <v-flex xs12>
                                  <v-text-field label="Email" v-model="userInfo.email" required flat solo>
                                  </v-text-field>
                              </v-flex>
                              <v-flex xs12>
                                  <v-text-field label="Password" v-model="userInfo.password"
                                                  type="password" required flat solo>
                                  </v-text-field>
                              </v-flex>
                          </v-layout>
                      </v-container>
                  </v-card-text>
                  <v-card-actions>
                      <v-spacer></v-spacer>
                      
                      <v-btn color="teal darken-1" text @click="btnLoginClick($event)">
                          확인
                      </v-btn>

                      <router-link :to="{ name: 'Home' }"
                                        class="nav-link"
                                        active-class="active">
                            <v-btn color="teal darken-1" text @click="btnLoginClick($event)">
                                     나가기
                             </v-btn>
                      </router-link>
                  </v-card-actions>
              </v-card>
        </v-dialog>
        </form>
    </div>
</template>

<script>
export default {
    name: 'LoginPageForm',

    data(){
      return{
            dialog: true,
            loginDialog: true,
            
            userInfo: {
                email: '',
                password: ''
            },

      }
    },
    methods:{
      btnLoginClick ($event) {
            if ($event.target.innerHTML == " 확인 ") {
                alert('로그인이 완료되었습니다!')

                // 이부분에 axios를 쓰면 스프링과 연동할 수 있음

                console.log("입력된 정보 - 이메일: " + this.userInfo.email + 
                            ", 비밀번호: " + this.userInfo.password)
                this.loginDialog = false
            }
            this.userInfo.email = ''
            this.userInfo.password = ''
        }
    }
    
}
</script>

<style>
 

</style>

