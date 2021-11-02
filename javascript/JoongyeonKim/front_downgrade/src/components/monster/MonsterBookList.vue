<template>
    <div align="center">
        <h3>상품목록 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="100">몬스터 번호</th>
                <th align="center" width="350">몬스터 이름</th>
                <th align="center" width="350">체력</th>
                <th align="center" width="240">공격력</th>
                <th align="center" width="440">생성날짜</th>
            </tr>
            <tr v-if="!monsters || (Array.isArray(monsters) && monsters.length === 0)">
                <td colspan="5">
                현재 등록된 몬스터가 없습니다!
                </td>
            </tr>
            <tr v-else v-for="monster in monsters" :key="monster.monsterNo">
                <td align="center">{{ monster.monsterNo }}</td>
                <td align="left">
                    <router-link :to="{ name: 'MonsterBookReadPage',
                                    params: { monsterNo: monster.monsterNo.toString() } }">
                        {{ monster.name }}
                    </router-link> 
                </td>
                <td align="center">{{ monster.hp }}</td>
                <td align="center">{{ monster.atk }}</td>
                <td align="center">{{ monster.regDate }}</td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'MonsterBookList',
    props: {
        monsters: {
            type: Array
        }
    }
}
</script>