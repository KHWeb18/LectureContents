<template>
    <div align="center">
        <h3>목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="80">번호</th>
                <th align="center" width="150">던전명</th>
                <th align="center" width="300">던전 정보</th>
                <th align="center" width="150">몬스터 수</th>
            </tr>
            <tr v-if="!dungeons || (Array.isArray(dungeons) && dungeons.length === 0)">
                <td colspan="4">
                    Error : 던전이 존재하지 않습니다.
                </td>
            </tr>
            <tr v-else v-for="(dungeon, idx) in dungeons" :key="idx">
                <td align="center">{{ dungeon.dungeonNo }}</td>
                <td align="center" v-on:click="measureMonsterAmount(dungeon.monster_amount, $event)">
                    {{ dungeon.name }}</td>
                <td align="right">{{ dungeon.description }}</td>
                <td align="center">{{ dungeon.monster_amount }}</td>
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
        measureMonsterAmount(monster_amount, $event) {
            const payload = [monster_amount, $event.target.innerHTML]
            EventBus.$emit('measureMonsterAmount', payload)
        }
    }
}
</script>