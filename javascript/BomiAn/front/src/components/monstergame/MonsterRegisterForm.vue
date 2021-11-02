<template>
  <form @submit.prevent="onSubmit">
    <h3>몬스터 생성</h3>
    <table>
      <tr>
        <td>몬스터명</td>
        <td><input type="text" v-model="monsterName"></td>
      </tr>
      <tr>
        <td>HP</td>
        <td><input type="number" v-model="monsterHp"></td>
      </tr>
      <tr>
        <td>EXP</td>
        <td><input type="number" v-model="monsterExp"></td>
      </tr>
      <tr>
        <td>보상금</td>
        <td><input type="number" v-model="monsterMoney"></td>
      </tr>
    </table>

    <div>
      <button type="submit">등록</button>
      <router-link :to="{ name: 'MonsterListPage' }">취소</router-link>
    </div>
  </form>
</template>

<script>
export default {
  name: 'MonsterRegisterForm',
  data() {
    return {
      monsterName: '',
      monsterHp: 0,
      monsterExp: 0,
      monsterMoney: 0
    }
  },
  methods: {
    onSubmit () {
      const { monsterName, monsterHp, monsterExp, monsterMoney } =  this
      this.$emit('submit', { monsterName, monsterHp, monsterExp, monsterMoney })
    }
  },
}
</script>