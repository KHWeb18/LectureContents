<template>
  <v-card color="basil" scroll-off-screen
      scroll-target="#scrolling-techniques">
    <login-form></login-form>

    <v-card-title class="text-center justify-center ">
      <h1 class="font-weight-bold text-h2 basil--text">Test</h1>
    </v-card-title>

    <v-text-field append-icon="mdi-magnify" class="mx-16 py-3"
        flat hide-details label="Search" solo ></v-text-field>

    <v-tabs v-model="tab" background-color="transparent" color="basil"
    class="basil--text" grow>
      <v-tab v-for="tab of tabs" :key="tab" :to="tab.route">{{ tab.name }}</v-tab>

    </v-tabs>

    
  </v-card>
</template>


<script>
import LoginForm from '@/components/member/LoginForm'

export default {
  name: 'NavBar',
  components: {
    LoginForm
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
          { name: "Talk", route: `/talk` }, 
        ]
    }
  }
}
</script>

