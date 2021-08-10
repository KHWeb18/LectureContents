<template>
  <div>
    <v-dialog v-model="dialog" persistent max-width="500px">
      <template v-slot:activator="{ on }">
        <v-btn v-on="on" text>아직 회원이 아니신가요?
        </v-btn>
      </template>
    
      <v-card ref="form" class="basil rounded-xl pa-4" >
        <v-card-title>
          <span class="headline basil--text">Signup</span>
        </v-card-title>
        <v-card-text>
          <v-text-field ref="id" color="teal darken-3" label="Id" v-model="id" 
          :rules="[() => !!id || '아이디를 입력해주세요!']" :error-messages="errorMessages"
          required></v-text-field>
          <v-text-field ref="pw" color="teal darken-3" label="Password" v-model="pw"
          :rules="[() => !!pw || '비밀번호를 입력해주세요!']"
          type="password" required></v-text-field>
          <v-text-field ref="name" color="teal darken-3" label="Name" v-model="name" 
          :rules="[() => !!name || '이름을 입력해주세요!']" required></v-text-field>
          <v-row>
            <v-col cols="12" md="4">
              <v-autocomplete ref="birth" color="teal darken-3" label="Year" v-model="birth" 
              :rules="[() => !!birth || '생일을 입력해주세요!']" required></v-autocomplete>
            </v-col>
            <v-col cols="12" md="4">
              <v-autocomplete ref="birth" color="teal darken-3" label="Month" v-model="birth" 
              :rules="[() => !!birth || '생일을 입력해주세요!']" required></v-autocomplete>
            </v-col>
            <v-col cols="12" md="4">
              <v-autocomplete ref="birth" color="teal darken-3" label="Day" v-model="birth" 
              :rules="[() => !!birth || '생일을 입력해주세요!']" required></v-autocomplete>
            </v-col>
          </v-row>
          
          <v-text-field ref="gender" color="teal darken-3" label="Gender" v-model="gender" 
          :rules="[() => !!gender || '성별을 입력해주세요!']" required></v-text-field>
          <v-text-field ref="email" color="teal darken-3" label="Email" v-model="email" 
          :rules="[() => !!email || '이메일을 입력해주세요!']" required></v-text-field>
          <v-text-field ref="phone" color="teal darken-3" label="Phone" v-model="phone" 
          :rules="[() => !!phone || '전화번호를 입력해주세요!']" required></v-text-field>
          <v-row>
            <v-col cols="12" md="6">
              <v-autocomplete ref="address" color="teal darken-3" label="City" v-model="address" 
              :items="cities"
              :rules="[() => !!address || '주소를 입력해주세요!']" required></v-autocomplete>
            </v-col>
            <v-col cols="12" md="6">
              <v-autocomplete ref="address" color="teal darken-3" label="District" v-model="address" 
              :rules="[() => !!address || '주소를 입력해주세요!']" required></v-autocomplete>
            </v-col>
          </v-row>
        </v-card-text>

        <v-divider></v-divider>
        <v-card-actions>
          <v-btn class="basil--text" text @click="resetForm">cancel</v-btn>
          <v-spacer></v-spacer>
          <v-btn class="basil--text" text @click="btnSignup">signup</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>


<script>
//import axios from 'axios'

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
      cities: [ '서울시', '인천시', '경기도' ]
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
    }
  },
  watch: {
    id () {
      this.errorMessages = ''
    }
  },
  methods: {
    btnSignup () {
      // const { id, pw, name, birth, gender, email, phone, address } = payload
      // axios.post('http://localhost:7777/vue/signup', { id, pw, name, birth, gender, email, phone, address })
      // .then(() => {
      //   alert('회원가입이 완료되었습니다.')
      // }).catch(res => {
      //   alert(res)
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
