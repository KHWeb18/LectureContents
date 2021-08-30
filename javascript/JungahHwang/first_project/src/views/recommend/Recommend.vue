<template>
  <div>
    <h2>추천 페이지</h2>
    <v-btn @click="addRecommend">글쓰기</v-btn>
    <v-snackbar v-model="login" :timeout="timeout" color="secondary" outlined
        bottom rounded="xl">
      <p>로그인 해주세요!!</p>
      <login></login>
    </v-snackbar>

    <recommend-list></recommend-list>
  </div>
</template>


<script>
import { mapState } from 'vuex'
import RecommendList from '../../components/recommend/RecommendList.vue'
import Login from '../member/Login.vue'

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