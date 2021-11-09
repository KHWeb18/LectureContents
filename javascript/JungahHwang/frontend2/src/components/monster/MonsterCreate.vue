<template>
  <form @submit.prevent="onSubmit">
    <table>
      <tr>
        <td>name</td>
        <td><input type="text" v-model="name"></td>
      </tr>
      <tr>
        <td>hp</td>
        <td><input type="text" v-model="hp"></td>
      </tr>
      <tr>
        <td>exp</td>
        <td><input type="text" v-model="exp"></td>
      </tr>
      <tr>
        <td>money</td>
        <td><input type="text" v-model="money"></td>
      </tr>
      <tr>
        <td>item</td>
        <td><input type="text" v-model="item"></td>
      </tr>
    </table>
    <div>
      <button type="submit">등록</button>
      <router-link :to="{ name: 'Monster' }">
        취소
      </router-link>
    </div>
  </form>
</template>


<script>
export default {
  name: 'MonsterCreate',
  data () {
    return {
      name: null,
      hp: null,
      exp: null,
      money: null,
      item: null
    }
  },
  methods: {
    onSubmit () {
      const { name, hp, exp, money, item } = this
      this.name !== null && this.hp !== null && this.exp !== null && this.money !== null
      ? this.$emit('submit', { name, hp, exp, money, item }) : alert('정보를 입력해주세요')
      
    }
  }
}
</script>