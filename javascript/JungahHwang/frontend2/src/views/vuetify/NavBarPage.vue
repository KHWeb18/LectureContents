<!-- 화면에 고정된 네비게이션 바(App.vue에 컴포넌트 추가) -->
<template>
  <div>
    <v-toolbar dense dark>
      <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>
        <span class="font-weight-light">고정형 바</span>
      </v-toolbar-title>
      <v-toolbar-items>
        <v-btn text v-for="link in links" :key="link.icon" :to="link.route">{{ link.text }}</v-btn>
      </v-toolbar-items>
    </v-toolbar>
    <v-navigation-drawer app v-model="nav_drawer" temporary>
      <v-list nav dense>
        <v-list-item-group v-model="group" active-class="deep-puple--text text--accent-4">
          <v-list-item v-for="link in links" :key="link.name" router :to="link.route">
            <v-list-item-action>
              <v-icon left>{{ link.icon }}</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title>{{ link.text }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>
  </div> 
</template>


<script>
export default {
  data () {
    return {
      group: false,
      nav_drawer: false,
      links: [
        { icon: 'home', text: 'Home', name: 'home', route: '/' },
        { icon: 'shopping_cart', text: 'Product', name: 'shopping_cart', route: '/product' },
        { icon: 'dns', text: 'Todo', name: 'dns', route: '/todo' },
      ]
    }
  },
  methods: {
    
  },
  watch: {
    group () {
      this.nav_drawer = false
    }
  }
}
</script>


<style scoped>

h1 {
  margin: 10px;
}
p {
  padding: 10px;
  margin: 5px 10px;
}
</style>