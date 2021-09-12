<template>
  <div>
    <v-app-bar class="primary" dense>
      <v-app-bar-nav-icon @click="drawer = !drawer" color="secondary"></v-app-bar-nav-icon>

      <v-toolbar-title>
        <router-link :to="{ name: 'Home' }">
          <h1 class="font-weight-bold text-h5 secondary--text">Test</h1>
        </router-link>  
      </v-toolbar-title>
      
      <v-spacer></v-spacer>

      <login></login>
    </v-app-bar>

    <v-navigation-drawer app v-model="drawer" color="primary" temporary>
      <v-list nav dense>
        <v-list-item-group v-model="group" active-class="secondary--text text--accent-4" pa-6>
          <v-list-item v-for="item in items" :key="item.name" router :to="item.route" >
            <v-list-item-content>
              <v-list-item-title>{{ item.name }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>

  </div>
</template>


<script>
import Login from '@/views/member/Login'

export default {
  name: 'Toolbar',
  components: {
    Login
  },
  data() {
    return {
      drawer: false,
      group: false,
      items: [
        { name: 'Home', route: `/` }, 
        { name: 'Record', route: `/record` }, 
        { name: 'Challenge', route: `/challenge` }, 
        { name: 'Recommend', route: `/recommend` }, 
        { name: 'Together', route: `/together` }, 
        { name: 'Map', route: `/map` }, 
      ],
    }
  },
  watch: {
    group () {
      this.drawer = false
    }
  }
}
</script>