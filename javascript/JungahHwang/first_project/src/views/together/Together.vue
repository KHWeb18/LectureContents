<template>
  <v-card class="mt-5" flat>

    <together-list v-on:addButton="addTogether"></together-list>

    <v-snackbar v-model="login" :timeout="timeout" color="secondary" outlined
        bottom rounded="xl">
      <p>로그인 해주세요!!</p>
      <login></login>
    </v-snackbar>

  </v-card>
</template>


<script>
import { mapState } from 'vuex'
import TogetherList from '@/components/together/TogetherList'
import Login from '@/views/member/Login'

export default {
  data() {
    return {
      login: false,
      timeout: 2000,
    }
  },
  components: { 
    Login,
    TogetherList
  },
  computed: { 
    ...mapState([ 'isLogin' ])
  },
  methods: {
    addTogether () {
      if (this.isLogin) {
        this.$router.push(
          { name: 'AddTogether' }
        )
      } else {
        this.login = true

      }
    }
  }
}
</script>