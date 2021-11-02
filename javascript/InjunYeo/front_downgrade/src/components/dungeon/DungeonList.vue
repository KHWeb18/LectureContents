<template>
    <div>
        <h3>던전 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="50">던전번호</th>
                <th align="center" width="150">던전이름</th>
                <th align="center" width="500">던전 설명</th>
                <th align="center" width="50">몬스터 숫자</th>
            </tr>
            <tr v-if="!dungeons || (Array.isArray(dungeons) && dungeons.length === 0)">
                <td colspan="4">
                    던전 생성이 안됩니다
                </td>
            </tr>
            <tr v-else v-for="(dungeon,index) in dungeons" :key="index"
                >

                <td align="center" >{{ dungeon.dungeonNo }}</td>             
                <td align="center" v-on:click="measureMonsterAmount(dungeon.monsterAmount, $event)">{{ dungeon.name }}</td>
                <td align="center">{{ dungeon.description }}</td>
                <td align="center">{{ dungeon.monsterAmount }}</td>
                
            </tr>
        </table>
    </div>
</template>

<script>
import EventBus from '@/eventBus.js'
export default {
    name: 'DungeonList',
    props: {
        dungeons: {
            type: Array
        }
    },
    methods:{
        measureMonsterAmount(monsterAmount, $event) {  //$event 는 어떤이벤트가 발생했는지 확인해주는 객체 마우스이벤트로인해 어떤것이 클릭되었는지 확인하는것이다.
            const payload = [ monsterAmount, $event.target.innerHTML ]
            EventBus.$emit('measureMonsterAmount', payload)
        }
    }
}
</script>