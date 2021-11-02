<template>
  <div>
    <table>
      <tr>
        <td>No</td>
        <td><input type="text" :value="monster.monsterNo" readonly></td>
      </tr>
      <tr>
        <td>name</td>
        <td><input type="text" :value="monster.name" readonly></td>
      </tr>
      <tr>
        <td>hp</td>
        <td><input type="text" :value="monster.hp" readonly></td>
      </tr>
      <tr>
        <td>exp</td>
        <td><input type="text" :value="monster.exp" readonly></td>
      </tr>
      <tr>
        <td>money</td>
        <td><input type="text" :value="monster.money" readonly></td>
      </tr>
      <tr>
        <td>item</td>
        <td><input type="text" :value="monster.item" readonly></td>
      </tr>
    </table>
  </div>
</template>


<script>
export default {
  name: 'MonsterRead',
  props: {
    monster: {
      type: Object,
      required: true
    }
  }
}
</script>