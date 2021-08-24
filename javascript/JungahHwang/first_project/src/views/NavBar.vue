<template>
  <v-card class="primary" >
    <login-form v-if="!isLogin"></login-form>
    <login-info v-else></login-info>

    <v-card-title class="text-center justify-center ">
      <router-link :to="{ name: 'Home' }">
        <h1 class="font-weight-bold text-h2 secondary--text">Test</h1>
      </router-link>
    </v-card-title>

    <v-text-field append-icon="mdi-magnify" class="mx-16 py-3" color="secondary"
      flat hide-details label="Search" solo></v-text-field>

    <v-tabs v-model="tab" background-color="transparent" color="secondary" show-arrows grow>
      <v-tab class="font-weight-bold" v-for="tab of tabs" :key="tab.name" :to="tab.route">
        {{ tab.name }}
      </v-tab>
    </v-tabs>
  </v-card>
</template>


<script>
import LoginForm from '@/components/member/LoginForm'
import LoginInfo from '@/components/member/LoginInfo'

import { mapState } from 'vuex'

export default {
  name: 'NavBar',
  components: {
    LoginForm,
    LoginInfo
  },
  data () {
    return {
      tab: null,
      tabs: [ 
          { name: "Home", route: `/` }, 
          { name: "Record", route: `/record` }, 
          { name: "Challenge", route: `/challenge` }, 
          { name: "Recommend", route: `/recommend` }, 
          { name: "Together", route: `/together` }, 
          { name: "Chatting", route: `/chatting` }, 
        ]
      }
    },
    computed: {
      ...mapState([ 'isLogin' ])
    }
  }
</script>


