<template>
    <div align="center">
        <h3>던전 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="100">던전 번호</th>
                <th align="center" width="350">던전 이름</th>
                <th align="center" width="650">던전 설명</th>
                <th align="center" width="240">몬스터 수</th>
            </tr>
            <tr v-if="!dungeons || (Array.isArray(dungeons) && dungeons.length === 0)">
                <td colspan="4">
                던전 생성이 안됩니다!
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

import EventBus from '@/eventBus.js'

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