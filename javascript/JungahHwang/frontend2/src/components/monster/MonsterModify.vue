<template>
  <div>
    <form @submit.prevent="onSubmit">
      <table>
        <tr>
          <td>No</td>
          <td><input type="text" :value="monster.monsterNo" disabled></td>
        </tr>
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
        <button type="submit">수정 완료</button>
        <router-link :to="{ name: 'MonsterReadPage', params: { monsterNo: monster.monsterNo.toString() }}">
          취소
        </router-link>
      </div>
    </form>
  </div>
</template>


<script>
export default {
  name: 'MonsterModify',
  props: {
    monster: {
      type: Object,
      required: true
    }
  },
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
      this.$emit('submit', { name, hp, exp, money, item })
    }
  },
  created () {
    this.name = this.monster.name
    this.hp = this.monster.hp
    this.exp = this.monster.exp
    this.money = this.monster.money
    this.item = this.monster.item
  }
}
</script>