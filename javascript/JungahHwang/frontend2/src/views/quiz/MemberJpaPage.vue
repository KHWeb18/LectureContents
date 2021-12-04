<template>
  <div>
    <v-dialog v-model="dialog" persistent max-width="500px">
      <template v-slot:activator="{ on }">
        <v-btn color="primary" dark v-on="on">SignUp Now</v-btn>
      </template>
      <v-card>
        <v-card-title>
          <span class="headline">Sign Up</span>
        </v-card-title>
        <v-card-text>
          <v-main grid-list-md>
            <v-layout wrap>
              <v-flex xs12>
                <v-text-field label="Id" v-model="id" required flat solo></v-text-field>
              </v-flex>
              <v-flex xs12>
                <v-text-field label="Password" v-model="pw"
                              type="password" required flat solo></v-text-field>
              </v-flex>
            </v-layout>
          </v-main>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="primary" text @click="btnSignupClick($event)">취소</v-btn>
          <v-btn color="primary" text @click="btnSignupClick($event)">회원가입</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>


<script>
import axios from 'axios'

export default {
  name: 'MemberJpaPage',
  data () {
    return {
      dialog: false,
      id: null,
      pw: null
    }
  },
  methods: {
    btnSignupClick ($event) {
      if ($event.target.innerHTML === '회원가입') {
        const id = this.id
        const pw = this.pw
        console.log('id: ' + id + ', pw: ' + pw)
        axios.post('http://localhost:7777/memberjpa', { id, pw }).then(() => {
          alert('회원가입이 완료되었습니다.')
          this.dialog = false
        }).catch(res => {
          alert(res.response.data.message)
        })
      } else {
        this.dialog = false
      }
      this.id = null
      this.pw = null
    }
  }
}
</script>