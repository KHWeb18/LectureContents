<template>
<div>
    <black-Widow-Form @submit="onSubmit" v-if="isLogin"></black-Widow-Form>
  <Go-To-Login v-else></Go-To-Login>
    <v-container>

    </v-container>
   
    </div>
 
</template>

<script>

import blackWidowForm from '@/components/detailPageForm/blackWidowForm.vue';
import GoToLogin from '@/components/member/GoToLogin.vue'
import { mapState } from 'vuex';


export default {
 computed:{
     ...mapState(['session'])
 },
    components: {
        blackWidowForm,
        GoToLogin
    },
         data () {
        return {
            isLogin: false,
         
        }
    },
    mounted() {
        // this.fetchSession()
        this.$store.state.session = this.$cookies.get("user")

        if (this.$store.state.session != null) {
            this.isLogin = true
        }
    },
    methods: {
        onSubmit() {
          if (this.isLogin == true) {
              this.$router.push ({ path: '' })
          }else {
              this.isLogin = false 
              this.$router.push({ path: '/memberlogin'})
              alert('로그인이 필요 합니다. ')
          } 
          
        }
    },
}
</script>