  
<template>
    <div>
        <h3>게시물 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="100">던전번호</th>
                <th align="center" width="250">던전명</th>
                <th align="center" width="400">설명</th>
                <th align="center" width="150">몹숫자</th>
                <th align="center" width="150">날짜</th>
            </tr>
            <tr v-if="!dungeons || (Array.isArray(dungeons) && dungeons.length === 0)">
                <td colspan="4">
                    현재 등록된 던전이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="(dungeon, index) in dungeons" :key="index"
                v-on:click="sendCode(dungeon.dungeonNo)">
                <td align="center" >{{ dungeon.dungeonNo }}</td>
                <td>
                <!-- <router-link :to="{ name: 'MonsterReadPage', -->
                                    <!-- params: { dungeonNo: dungeon.dungeonNo.toString() } }"> -->
                                    {{ dungeon.name }}
                <!-- </router-link> -->
                </td>

                <!-- <td align="center">{{ product.producer }}</td> -->
                <td align="left">{{ dungeon.description }}</td> 
                <td align="center">{{ dungeon.monsterAmount }}</td>
                <td align="center">{{ dungeon.regDate }}</td>

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
import EventBus from '@/eventBus.js'
export default {
    name: 'DungeonList',
    props: {
        dungeons: {
            type: Array,
            required: true
        }
    },
    methods: {
        sendCode(incode) {
            const payload = [ incode ]
            EventBus.$emit('dungeoncode', payload)
            // EventBus.sendscode(payload)
        }
    }
}
</script>