<template>
  <v-card class="mt-5" flat>

    <recommend-list v-on:addButton="addRecommend"></recommend-list>

    <v-snackbar v-model="login" :timeout="timeout" color="secondary" outlined
        bottom rounded="xl">
      <p>로그인 해주세요!!</p>
      <login v-on:onLogin="addRecommend"></login>
    </v-snackbar>

  </v-card>
</template>


<script>
import { mapState } from 'vuex'
import RecommendList from '@/components/recommend/RecommendList'
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
    RecommendList
  },
  computed: { 
    ...mapState([ 'isLogin' ])
  },
  methods: {
    addRecommend () {
      if (this.isLogin) {
        this.$router.push(
          { name: 'AddRecommend' }
        )
      } else {
        this.login = true

      }
    }
  }
}
</script>