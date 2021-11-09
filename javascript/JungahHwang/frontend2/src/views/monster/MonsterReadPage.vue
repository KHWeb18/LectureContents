<template>
  <div align="center">
    <h2>몬스터 세부사항</h2>
    <monster-read v-if="monster" :monster="monster"/>
    <p v-else>로딩중..</p>
    <router-link :to="{ name: 'MonsterModifyPage', params: { monsterNo }}">
      수정
    </router-link>
    <button @click="onDelete">삭제</button>
    <router-link :to="{ name: 'MonsterGuidePage'}">
      가이드
    </router-link>
  </div>
</template>


<script>
import axios from 'axios'
import MonsterRead from '@/components/monster/MonsterRead'
import { mapState, mapActions } from 'vuex'

export default {
  name: 'MonsterReadPage',
  props: {
    monsterNo: {
      type: String,
      required: true
    }
  },
  components: {
    MonsterRead
  },
  computed: {
    ...mapState(['monster'])
  },
  created () {
    this.fetchMonster(this.monsterNo).catch(err => {
      alert(err.response.data.message)
      this.$router.push()
    })
  },
  methods: {
    ...mapActions(['fetchMonster']),
    onDelete () {
      const { monsterNo } = this.monster
      axios.delete(`http://localhost:7777/vuemonster/${monsterNo}`).then(() => {
        alert('삭제되었습니다')
        this.$router.push({ name: 'MonsterGuidePage' })
      }).catch(err => {
        alert(err.response.data.message)
      })
    }
  }

}
</script>
