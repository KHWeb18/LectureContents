<template>
  <div>
    <table border="1">
      <tr>
        <th align="center" width="100">No</th>
        <th align="center" width="150">name</th>
        <th align="center" width="150">hp</th>
        <th align="center" width="150">exp</th>
        <th align="center" width="150">money</th>
        <th align="center" width="200">item</th>
      </tr>
      <tr v-if="!monsters || (Array.isArray(monsters) && monsters.length === 0)">
        <td colspan="6">
          현재 등록된 몬스터가 없습니다!
        </td>
      </tr>
      <tr v-else v-for="monster in monsters" :key="monster.monsterNo">
        <td align="center">{{ monster.monsterNo }}</td>
        <td align="center"> 
          <router-link :to="{ name: 'MonsterReadPage', params: { monsterNo: monster.monsterNo.toString() }}">
            {{ monster.name }}
          </router-link></td>
        <td align="center">{{ monster.hp }}</td>
        <td align="center">{{ monster.exp }}</td>
        <td align="center">{{ monster.money }}</td>
        <td align="center">{{ monster.item }}</td>
      </tr>
    </table>
  </div>
</template>



<script>
export default {
  name: 'MonsterGuide', 
  props: {
    monsters: {
      type: Array
    }
  }
}
</script>