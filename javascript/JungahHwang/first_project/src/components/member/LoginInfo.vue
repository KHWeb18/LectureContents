<template>
  <div>
    <v-dialog v-model="dialog" max-width="400">
      <template v-slot:activator="{ on }">
        <v-btn icon v-on="on" class="float-right">
          <v-icon color="secondary">lock_outline</v-icon>
        </v-btn>
      </template>

      <v-card class="primary rounded-xl pa-4">
        <v-card-title>
          <p class="headline secondary--text font-weight-bold">
            {{ userInfo.name }}님 환영합니다!
          </p>
        </v-card-title>
        
        <v-card-actions>
          <v-btn class="secondary--text font-weight-bold" text >
            Logout
          </v-btn>
          <v-spacer></v-spacer>
          <v-btn @click="goMypage" class="secondary--text font-weight-bold" text>
            Mypage
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>


<script>
import { mapState } from 'vuex'

export default {
  data () {
    return {
      dialog: false
    }
  },
  computed: {
    ...mapState([ 'userInfo' ])
  },
  methods: {
    goMypage () {
      this.$router.push({ name: 'Mypage' })
      this.dialog = false
    }
  }
}
</script>