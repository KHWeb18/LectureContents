<template>
  <div>
    <v-dialog v-model="dialog" max-width="500px">
      <template v-slot:activator="{ on }">
        <v-btn v-on="on" text>아직 회원이 아니신가요?</v-btn>
      </template>
    
      <v-card ref="form" class="primary rounded-xl pa-0" >
        <v-card-title>
          <span class="headline secondary--text font-weight-bold">Signup</span>
        </v-card-title>
        
        <v-card-text>
          <v-text-field ref="id" color="secondary" label="Id" v-model="id" 
          :rules="idRules" :error-messages="errorMessages" required></v-text-field>

          <v-text-field ref="pw" color="secondary" label="Password" v-model="pw"
          :rules="pwRules" type="password" required></v-text-field>

          <!--
          <v-text-field ref="mpw" color="secondary" label="Password" v-model="mpw"
          :rules="matchPwRules" type="password" required></v-text-field>
          -->

          <v-text-field ref="name" color="secondary" label="Name" v-model="name" 
          :rules="nameRules" required></v-text-field>

          <v-text-field ref="birth" color="secondary" label="Birth" v-model="birth" 
          :rules="birthRules" required></v-text-field>

          <!--
          <v-row>
            <v-col cols="12" md="4">
              <v-autocomplete ref="birth" color="secondary" label="Year" v-model="birth" 
              :rules="birthRules" required></v-autocomplete>
            </v-col>
            <v-col cols="12" md="4">
              <v-autocomplete ref="birth" color="secondary" label="Month" v-model="birth" 
                required></v-autocomplete>
            </v-col>
            <v-col cols="12" md="4">
              <v-autocomplete ref="birth" color="secondary" label="Day" v-model="birth" 
                required></v-autocomplete>
            </v-col>
          </v-row>
          -->

          <v-text-field ref="gender" color="secondary" label="Gender" v-model="gender" 
          :rules="genderRules" required></v-text-field>

          <v-text-field ref="email" color="secondary" label="Email" v-model="email" 
          :rules="emailRules" required></v-text-field>

          <v-text-field ref="phone" color="secondary" label="Phone" v-model="phone" 
          :rules="phoneRules" required></v-text-field>

          <v-text-field ref="address" color="secondary" label="Address" v-model="address" 
          :rules="addrRules" required></v-text-field>

          <!--
          <v-row>
            <v-col cols="12" md="6">
              <v-autocomplete ref="address" color="secondary" label="City" v-model="address" 
              :items="cities" :rules="addrRules" required></v-autocomplete>
            </v-col>
            <v-col cols="12" md="6">
              <v-autocomplete ref="address" color="secondary" label="District" v-model="address" 
              :rules="addrRules" required></v-autocomplete>
            </v-col>
          </v-row>
          -->

        </v-card-text>
      
        <v-divider></v-divider>
        <v-card-actions>
          <v-btn class="secondary--text font-weight-bold" text @click="resetForm">cancel</v-btn>
          <v-spacer></v-spacer>
          <v-btn class="secondary--text font-weight-bold" text @click="btnSignup">signup</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>


<script>
import { mapState } from 'vuex'
import axios from 'axios'

export default {
  name: 'SignupForm',
  data () {
    return {
      dialog: false,
      id: null,
      pw: null,
      name: null,
      birth: null,
      gender: null,
      email: null,
      phone: null,
      address: null,
      errorMessages: '',
      formHasErrors: false,
      cities: [ '서울시', '인천시', '경기도' ],
    }
  },
  computed: {
    form () {
      return {
        id: this.id,
        pw: this.pw,
        name: this.name,
        birth: this.birth,
        gender: this.gender,
        email: this.email,
        phone: this.phone,
        address: this.address
      }
    },
    ...mapState([
      'idRules',
      'pwRules',
      'matchPwRules',
      'nameRules',
      'birthRules',
      'genderRules',
      'emailRules',
      'phoneRules',
      'addrRules'
    ])
  },
  watch: {
    id () {
      this.errorMessages = ''
    }
  },
  methods: {
    resetForm () {
      this.errorMessages = []
      this.formHasErrors = false

      Object.keys(this.form).forEach(f => {
        this.$refs[f].reset()
      })
      this.dialog = false
    },
    btnSignup () {
      this.formHasErrors = false

      Object.keys(this.form).forEach(f => {
        if (!this.form[f]) this.formHasErrors = true

        this.$refs[f].validate(true)
      })
        
      axios.post('http://localhost:7777/member/signup', this.form)
      .then(() => {
        alert('회원가입이 완료되었습니다.')
        this.dialog = false
      }).catch(res => {
        alert(res)
      })
      
    },
  }
}
  </script>
