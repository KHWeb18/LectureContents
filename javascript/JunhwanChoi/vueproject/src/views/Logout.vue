
<template>
    <div>
        <v-dialog v-model="loginDialog"  max-width="500px">
            <v-card>
                <v-card-title>
                    <span class="headline">
                        Message
                    </span>
                </v-card-title>
                <v-card-text>
                    <v-container grid-list-md>
                        <v-layout wrap>
                            <v-flex xs12>
                               접속중인 계정에서 로그아웃 하려고 합니다.
                            </v-flex>
                            <v-flex xs12>
                               로그아웃 하시겠습니까?
                            </v-flex>
                        </v-layout>
                    </v-container>
                </v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    
                    <router-link :to="{ name: 'Home' }" class="nav-link" active-class="active">
                        <v-btn @click="logout" color="blue lighten-5">로그아웃</v-btn>
                    </router-link>
                    <p class="trick">1</p>
                    <router-link :to="{ name: 'Home' }" class="nav-link" active-class="active">
                            <v-btn color="blue lighten-5"> 취소</v-btn>
                    </router-link>
                </v-card-actions>
            </v-card>
    </v-dialog>
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
        logout () {
            this.$cookies.remove("user")
            this.isLogin = false
            this.$store.state.session = null
        }
    },
    
}
</script>

<style>
 
.trick{
    color:white;
}

</style>

