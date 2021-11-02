<template>
    <div align="center">
        <h3>몬스터 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="80">번호</th>
                <th align="center" width="250">몬스터 이름</th>
                <th align="center" width="150">HP</th>
                <th align="center" width="150">경험치</th>
                <th align="center" width="150">드랍머니</th>
                <th align="center" width="200">드랍아이템</th>
            </tr>
            <tr v-if="!monsters || (Array.isArray(monsters) && monsters.length === 0)">
                <td colspan="4">
                    현재 등록된 몬스터가 없습니다.
                </td>
            </tr>
            <tr v-else v-for="monster in monsters" :key="monster.monsterNo">
                <td align="center">{{ monster.monsterNo }}</td>
                <td align="left">
                     <router-link :to="{ name: 'MonsterReadPage',
                                    params: { monsterNo: monster.monsterNo.toString() } }">
                        {{ monster.name }}
                    </router-link>
                </td>
                <td align="right">{{ monster.hp }}</td>
                <td align="center">{{ monster.exp }}</td>
                <td align="center">{{ monster.dropMoney }}</td>
                <td align="center">{{ monster.dropItem }}</td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'MonsterList',
    props: {
        monsters: {
            type: Array
        }
    }
}
</script>