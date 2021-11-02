<template>
  <div>
    <table border="1">
      <tr>
        <th align="center" width="100">No</th>
        <th align="center" width="150">name</th>
        <th align="center" width="200">description</th>
        <th align="center" width="100">amount</th>
      </tr>
      <tr v-if="!dungeons || (Array.isArray(dungeons) && dungeons.length === 0)">
        <td colspan="6">
          던전이 없습니다!
        </td>
      </tr>
      <tr v-else v-for="(dungeon, idx) in dungeons" :key="idx"
          v-on:click="sendCode(dungeon.name, $event)">
        <td align="center">{{ dungeon.dungeonNo }}</td>
        <td align="center">{{ dungeon.name }}</td>
        <td align="center">{{ dungeon.description }}</td>
        <td align="center">{{ dungeon.monsterAmount }}</td>
      </tr>
    </table>
  </div>
</template>



<script>
import EventBus from '@/eventBus'

export default {
  name: 'MonsterDungeon', 
  props: {
    dungeons: {
      type: Array
    }
  },
   methods: {
    sendCode(incode, $event) {
      const payload = [ incode, $event.target.innerHTML ]
      EventBus.$emit('sendname', payload)
    }
  }
}
</script>


<style scoped>
table {
  margin: auto;
}
</style>