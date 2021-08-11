<template>
  <div>
    <v-dialog v-model="dialog" persistent max-width="500px">
      <template v-slot:activator="{ on }">
        <v-btn icon v-on="on">
          <v-icon color="secondary">lock_open</v-icon>
        </v-btn>
      </template>
    
      <v-card ref="form" class="primary rounded-xl pa-4" >
        <v-card-title>
          <span class="headline secondary--text">Login</span>
        </v-card-title>
        <v-card-text>
          <v-text-field ref="id" color="secondary" label="Id" v-model="id" 
          :rules="idRules" :error-messages="errorMessages"
          required></v-text-field>
          <v-text-field ref="pw" color="secondary" label="Password" v-model="pw"
          :rules="pwRules"
          type="password" required></v-text-field>
        </v-card-text>

        <signup-form></signup-form>
        
        <v-divider></v-divider>
        <v-card-actions>
          <v-btn class="secondary--text" text @click="resetForm">cancel</v-btn>
          <v-spacer></v-spacer>
          <v-btn class="secondary--text" text @click="btnLogin">login</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>


<script>
//import axios from 'axios'
import SignupForm from '@/components/member/SignupForm'
import { mapState } from 'vuex'

export default {
  name: 'LoginFrom',
  components: {
    SignupForm
  },
  data () {
    return {
      dialog: false,
      id: null,
      pw: null,
      errorMessages: ''
    }
  },
  computed: {
    form () {
      return {
        id: this.id,
        pw: this.pw
      }
    },
    ...mapState([
      'idRules',
      'pwRules'
    ])
  },
  watch: {
    id () {
      this.errorMessages = ''
    }
  },
  methods: {
    btnLogin () {
      
      // axios.post('http://localhost:7777/vue/login', { id, pw }).then(() => {
      //   alert('로그인이 완료되었습니다.')
      //   this.dialog = false
      // }).catch(res => {
      //   alert(res.response.data.message)
      // })
      
    },
    resetForm () {
      this.errorMessages = []
      Object.keys(this.form).forEach(f => {
        this.$refs[f].reset()
      })
      this.dialog = false
    }
  }
}  
</script>

