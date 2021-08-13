<template>
  <div>
    <v-toolbar class="primary" dense>
      <v-app-bar-nav-icon @click="drawer = !drawer" color="secondary"></v-app-bar-nav-icon>

      <v-toolbar-title>
        <router-link :to="{ name: 'Home' }">
          <h1 class="font-weight-bold text-h5 secondary--text">Test</h1>
        </router-link>  
      </v-toolbar-title>

      <v-navigation-drawer app v-model="drawer" temporary>
        <v-list nav dense>
          <v-list-item-group v-model="group" active-class="secondary--text text--accent-4">
            
            
            <!-- 리스트 추가하면 툴바 사라짐,,,,
            <v-list-item v-for="item of items" :key="item.name" :to="itme.route">
              <v-list-item-title>{{ item.name }}</v-list-item-title>
            </v-list-item>
            -->
          </v-list-item-group>
        </v-list>
      </v-navigation-drawer>

      <v-spacer></v-spacer>

      <login-form></login-form>
    </v-toolbar>
  </div>
</template>


<script>
import LoginForm from '@/components/member/LoginForm'

export default {
  name: 'Toolbar',
  components: {
    LoginForm
  },
  data() {
    return {
      drawar: false,
      group: null,
      items: [
        { name: "Home", route: `/` }, 
        { name: "Record", route: `/record` }, 
        { name: "Challenge", route: `/challenge` }, 
        { name: "Recommend", route: `/recommend` }, 
        { name: "Together", route: `/together` }, 
        { name: "Chatting", route: `/chatting` }, 
      ]
    }
  },
}
</script>