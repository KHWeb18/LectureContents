<template>
    <div>
        <h3>몬스터 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="100">번호</th>
                <th align="center" width="150">이름</th>
                <th align="center" width="640">상세설명</th>
                <th align="center" width="240">등록일자</th>
            </tr>
            <tr v-if="!monsters || (Array.isArray(monsters) && monsters.length === 0)">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="monster in monsters" :key="monster.monsterNo">
                <td align="center">{{ monster.monsterNo }}</td>
                <td align="left">
                    <router-link :to="{ name: 'MonsterReadPage',
                                    params: { monsterNo: monster.monsterNo.toString() } }">
                        {{ monster.monster_name }}
                    </router-link>
                </td>
                <td align="right">{{ monster.monster_description }}</td>
                <td align="center">{{ monster.regDate }}</td>
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