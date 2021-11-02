<template>
    <div>
        <h3>몬스터 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="100">몬스터번호</th>
                <th align="center" width="450">몬스터명</th>
                <th align="center" width="150">hp</th>
              
            </tr>
            <tr v-if="!monsters || (Array.isArray(monsters) && monsters.length === 0)">
                <td colspan="4">
                    현재 등록된 몬스터가 없습니다!
                </td>
            </tr>
            <tr v-else v-for="monster in monsters" :key="monster.monsterNo">
                <td align="center">{{ monster.monsterNo }}</td>
                  
                <td align="left">
                    <router-link :to="{ name: 'MonsterReadPage',
                                    params: { monsterNo: monster.monsterNo.toString() }}">
                        {{ monster.monster_name }}
                    </router-link>

                </td>
                <td align="center">{{ monster.monster_hp }}</td>
              
            </tr>
        </table>
    </div>
</template>



<script>
export default {
    name: 'MonsterListing',
    props: {
        monsters: {
            type: Array
        }
    }
}
</script>