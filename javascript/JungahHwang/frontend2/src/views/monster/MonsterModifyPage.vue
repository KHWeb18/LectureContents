<template>
  <div align="center">
    <h2>몬스터 수정</h2>
    <monster-modify v-if="monster" :monster="monster" @submit="onSubmit"/>
    <p v-else>로딩중..</p>
  </div>
</template>


<script>
import axios from 'axios'
import MonsterModify from '@/components/monster/MonsterModify'
import { mapActions, mapState } from 'vuex'

export default {
  name: 'MonsterModifyPage',
  components: {
    MonsterModify
  },
  props: {
    monsterNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['monster'])
  },
  methods: {
    ...mapActions(['fetchMonster']),
    onSubmit (payload) {
      const { name, hp, exp, money, item } = payload
      axios.put(`http://localhost:7777/vuemonster/${this.monsterNo}`, { name, hp, exp, money, item }).then(res => {
        alert('수정이 완료되었습니다')
        this.$router.push({
          name: 'MonsterReadPage',
          params: { monsterNo: res.data.monsterNo.toString() }
        })
      }).catch(err => {
        alert(err.response.data.message)
      })
    }
  },
  created () {
    this.fetchMonster(this.monsterNo).catch(err => {
      alert(err.response.data.message)
      this.$router.back()
    })
  }
}
</script>