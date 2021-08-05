<template>
  <div>
      <v-parallax src="@/assets/img/sea.jpg" height="500"></v-parallax>
      <v-navigation-drawer
        height="1000"
        permanent
        expand-on-hover
        blue
        mini-variant
        mini-variant-width="90">
        <v-list>
          <v-list-item class="px-2">
            <v-list-item-avatar>
              <v-icon>reorder</v-icon>
            </v-list-item-avatar>
          </v-list-item>
        </v-list>

            <!-- <v-list
            nav
            dense
            >
            <v-list-item-group active-class="deep-purple--text text--accent-4">
                    <v-list-item v-for="link in links" :key="link.name" router :to="link.route">
                        <br><br><br>
                        <v-list-item-action>
                            <v-icon left></v-icon>
                        </v-list-item-action>
                        <v-list-item-content>
                            <v-list-item-title>{{ link.text }}</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-list-item-group>
            </v-list> -->
      </v-navigation-drawer>
  </div>
</template>


<script>

export default {
    name: 'MainPage',
    data () {
        return {
            links: [
                { 
                    icon: 'home', text: 'About', name: 'Home', route: '/'
                },
                { 
                    icon: 'account_circle', text: 'Rooms', name: 'account_circle', route: '/'
                },
                { 
                    icon: 'favorite', text: 'Special', name: 'favorite', route: '/'
                },
                { 
                    icon: 'favorite', text: 'Reservation', name: 'favorite', route: '/'
                },
                { 
                    icon: 'favorite', text: 'Board', name: 'favorite', route: '/'
                }
            ]
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