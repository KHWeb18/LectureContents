<template>
  <div>
    <v-dialog v-model="dialog" persistent max-width="500px">
      <template v-slot:activator="{ on }">
        <v-btn v-on="on" icon class="float-right">
          <v-icon color="secondary">lock_open</v-icon>
        </v-btn>
      </template>
    
      <v-card ref="form" class="primary rounded-xl pa-4" >
        <v-card-title>
          <span class="headline secondary--text font-weight-bold">Login</span>
        </v-card-title>
        <v-card-text>
          <v-text-field ref="id" color="secondary" label="Id" v-model="id" 
          :rules="idRules" :error-messages="errorMessages" required></v-text-field>
          <v-text-field ref="pw" color="secondary" label="Password" v-model="pw"
          :rules="pwRules" type="password" required></v-text-field>
        </v-card-text>

        <signup-form></signup-form>
        
        <v-divider></v-divider>
        <v-card-actions>
          <v-btn @click="resetForm" class="secondary--text font-weight-bold" text>cancel</v-btn>
          <v-spacer></v-spacer>
          <v-btn @click="btnLogin" class="secondary--text font-weight-bold" text>login</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>


<script>
import axios from 'axios'
import SignupForm from '@/components/member/SignupForm'
import { mapActions, mapState } from 'vuex'

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
      errorMessages: '',
      formHasErrors: false,
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
    ...mapActions ([ 'userLogin' ]),

    btnLogin () {
      this.formHasErrors = false

      Object.keys(this.form).forEach(f => {
        if (!this.form[f]) this.formHasErrors = true

        this.$refs[f].validate(true)
      })

      const id = this.id
      const pw = this.pw
      
      axios.post('http://localhost:7777/member/login', { id, pw }).then(res => {
        
        if (res.data) {
          alert('로그인이 완료되었습니다.')

          this.$store.commit('USER_LOGIN', res.data)
          this.userLogin(id)

          this.dialog = false
        } else if (!res.data) {
          alert('아이디와 비밀번호를 확인해주세요!')

          console.log('isLogin: ' + res.data)
        }
        
      }).catch(err => {
        alert(err)
      })
      
    },
    resetForm () {
      this.errorMessages = []
      this.formHasErrors = false,

      Object.keys(this.form).forEach(f => {
        this.$refs[f].reset()
      })
      this.dialog = false
    }
  }
}  
</script>

