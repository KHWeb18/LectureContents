<template>
  <div align="center">
    <h2>몬스터 등록</h2>
    <monster-create @submit="onSubmit"/>
  </div>
</template>


<script>
import axios from "axios"
import MonsterCreate from '@/components/monster/MonsterCreate'

export default {
  name: 'MonsterCreatePage',
  components: {
    MonsterCreate
  },
  methods: {
    onSubmit (payload) {
      const { name, hp, exp, money, item } = payload

      axios.post('http://localhost:7777/vuemonster/create', { name, hp, exp, money, item }).then(() => {
        alert('몬스터가 등록되었습니다')
        this.$router.push({
          name: 'MonsterGuidePage' 
        })
      }).catch(res => {
        alert(res.response.data.message)
      })
    }
  }

}
</script>