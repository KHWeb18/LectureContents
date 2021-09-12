<template>
  <v-card class="primary" >
    <login v-if="!isLogin"></login>
    <login-info v-else></login-info>

    <v-card-title class="text-center justify-center ">
      <router-link :to="{ name: 'Home' }">
        <h1 class="font-weight-bold text-h2 secondary--text">Test</h1>
      </router-link>
    </v-card-title>

    <v-tabs v-model="tab" background-color="transparent" color="secondary" show-arrows grow>
      <v-tab v-for="tab of tabs" :key="tab.name" :to="tab.route" class="font-weight-bold">
        {{ tab.name }}
      </v-tab>
    </v-tabs>
  </v-card>
</template>


<script>
import Login from '@/views/member/Login'
import LoginInfo from '@/components/member/LoginInfo'

import { mapState } from 'vuex'


export default {
  name: 'NavBar',
  components: {
    Login,
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
          { name: "Map", route: `/map` }, 
        ]
      }
    },
    computed: {
      ...mapState([ 'isLogin' ])
    }
  }
</script>


