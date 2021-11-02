<template>
  <div>
    <h3>게시물 목록</h3>
    <table border="1">
      <tr>
        <th align="center" width="50">번호</th>
        <th align="center" width="150">던전명</th>
        <th align="center" width="500">설명</th>
        <th align="center" width="100">몹숫자</th>
      </tr>
      <tr v-if="!dungeons || (Array.isArray(dungeons) && dungeons.length === 0)">
        <td colspan="4">
          망겜입니다! 던전 생성이 안됩니다! 삭제하십시오!
        </td>
      </tr>
      <tr v-else v-for="(dungeon, idx) in dungeons" :key="idx">
        <td align="center">{{ dungeon.dungeonNo }}</td>
        <td align="center" v-on:click="measureMonsterAmount(dungeon.monsterAmount, $event)">
          {{ dungeon.name }}</td>
        <td align="center">{{ dungeon.description }}</td>
        <td align="center">{{ dungeon.monsterAmount }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import EventBus from "../../eventBus";

export default {
  name: 'DungeonList',
  props: {
    dungeons: {
      type: Array
    }
  },
  methods: {
    measureMonsterAmount(monsterAmount, $event) {
      const payload = [ monsterAmount, $event.target.innerHTML ]
      EventBus.$emit('measureMonsterAmount', payload)
    }
  }
}
</script>