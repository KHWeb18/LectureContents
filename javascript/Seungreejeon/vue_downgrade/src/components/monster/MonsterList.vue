  
<template>
    <div>
        <h3>게시물 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="100">몬스터번호</th>
                <th align="center" width="250">몬스터명</th>
                <th align="center" width="200">HP</th>
                <th align="center" width="150">경험치</th>
                <th align="center" width="150">드랍머니</th>
                <th align="center" width="150">드랍아이템</th>
            </tr>
            <tr v-if="!monsters || (Array.isArray(monsters) && monsters.length === 0)">
                <td colspan="4">
                    현재 등록된 상품이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="monster in monsters" :key="monster.monsterNo">
                <td align="center">{{ monster.monsterNo }}</td>
                <td>
                <router-link :to="{ name: 'MonsterReadPage',
                                    params: { monsterNo: monster.monsterNo.toString() } }">
                                    {{ monster.name }}
                </router-link>
                </td>

                <!-- <td align="center">{{ product.producer }}</td> -->
                <td align="left"> 
                    
                        {{ monster.hp }}
                  
                </td> 
                <td align="center">{{ monster.hp }}</td>
                <td align="center">{{ monster.exp }}</td>
                <td align="center">{{ monster.dropMoney }}</td>
                <td align="center">{{ monster.dropItem }}</td>
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