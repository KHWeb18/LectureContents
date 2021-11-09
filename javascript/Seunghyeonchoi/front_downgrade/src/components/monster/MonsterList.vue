<template>
    <div>
        <br>
        <h3>몬스터 목록</h3>
        <br>
        <table border="1">
            <tr>
                <th align="center" width="100">번호</th>
                <th align="center" width="450">몬스터 이름</th>
                <th align="center" width="450">몬스터 설명</th>
                <th align="center" width="150">체력</th>
                <th align="center" width="150">경험치</th>
                <th align="center" width="150">드랍 아이템</th>
                <th align="center" width="150">드랍 머니</th>
                <th align="center" width="240">등록일자</th>
            </tr>
            <tr v-if="!monsters || (Array.isArray(monsters) && monsters.length === 0)">
                <td colspan="7">
                    현재 등록된 몬스터가 없습니다!
                </td>
            </tr>
            <tr v-else v-for="monster in monsters" :key="monster.monsterNo">
                <td align="center">{{ monster.monsterNo }}</td>
                <!-- <td align="center">{{ product.producer }}</td> -->
                <td align="center">
                    <router-link :to="{ name: 'MonsterReadPage',
                                    params: { monsterNo: monster.monsterNo.toString() } }">
                        {{ monster.name }}
                    </router-link>
                </td>
                <td align="center">{{ monster.description }}</td>
                <td align="center">{{ monster.hp }}</td>
                <td align="center">{{ monster.exp }}</td>
                <td align="center">{{ monster.dropItem }}</td>
                <td align="center">{{ monster.dropMoney }}</td>
                <td align="center">{{ monster.regDate }}</td>
            </tr>
        </table>
    </div>
</template>

<!-- <td align="left">
                    
                    <router-link :to="{ name: 'ProductReadPage',
                                    params: { boardNo: product.productNo.toString() } }">
                        {{ product.product_name }}
                    </router-link>
                </td> -->

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