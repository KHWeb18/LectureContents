<template>
  <div align="center">
    <h2>몬스터 생성</h2>
    <monster-register-form @submit="onSubmit"/>
  </div>
</template>

<script>
import MonsterRegisterForm from '@/components/monstergame/MonsterRegisterForm.vue'
import axios from 'axios'
export default {
  name: 'MonsterRegisterPage',
  components: {
    MonsterRegisterForm
  },
  methods: {
    onSubmit (payload) {
            const { monsterName, monsterHp, monsterExp, monsterMoney } = payload
            axios.post('http://localhost:7777/vuemonster/registerMon', {  monsterName, monsterHp, monsterExp, monsterMoney })
                    .then((res) => {
                        alert('등록 성공! - ' + res)
                        this.$router.push({
                            name: 'MonsterListPage'
                        })
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
  },
}
</script>