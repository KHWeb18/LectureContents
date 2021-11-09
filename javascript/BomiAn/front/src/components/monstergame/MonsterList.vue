<template>
  <div>
    <h2>몬스터 도감</h2>
    <table border="1">
      <tr>
        <th align="center" width="100">번호</th>
        <th align="center" width="250">몬스터명</th>
        <th align="center" width="150">HP</th>
        <th align="center" width="150">EXP</th>
        <th align="center" width="300">Money</th>
        <th align="center" width="240">등록일자</th>
      </tr>
      <tr v-if="!monsters || (Array.isArray(monsters) && monsters.length === 0)">
                <td colspan="6">
                    현재 등록된 상품이 없습니다!
                </td>
       </tr>
       <tr v-else v-for="monster in monsters" :key="monster.monsterNo">
                <td align="center">{{ monster.monsterNo }}</td>
                <td align="left">
                    <router-link :to="{ name: 'MonsterReadPage',
                                    params: { monsterNo: monster.monsterNo.toString() } }">
                        {{ monster.monsterName }}
                    </router-link>
                </td>
                <td align="center">{{ monster.monsterHp }}</td> 
                <td align="center">{{ monster.monsterExp }}</td>
                <td align="center">{{ monster.monsterMoney }}</td>
                <td align="center">{{ monster.regDate }}</td>
            </tr>
    </table>
  </div>
</template>

<script>
export default {
  naem: 'MonsterList',
  props: {
    monsters: {
      type: Array
    }
  }
}
</script>