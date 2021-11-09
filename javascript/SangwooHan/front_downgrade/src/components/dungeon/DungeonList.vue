<template>
    <div>
        <h3>던전 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="100">던전번호</th>
                <th align="center" width="250">던전이름</th>
                <th aligh="center" width="400">던전설명</th>
                <th align="center" width="50">몹수</th>
            </tr>
            <tr v-if="!dungeons || (Array.isArray(dungeons) && dungeons.length === 0)">
                <td colspan="4">
                    등록된 던전이 없습니다.
                </td>
            </tr>
            <tr v-else v-for="(dungeon, idx) in dungeons" :key="idx.dungeonNo">
         
                <td align="center">{{ dungeon.dungeonNo }}</td>
        
                <td align="left" v-on:click="sendCode(idx.dungeonNo, $event)"> {{ dungeon.name }}</td>
                <td align="center">{{dungeon.description}}</td>
                 <td align="center">{{dungeon.monsterAmount}}</td>
           

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
        sendCode(zz, $event) {
            const payload = [ zz, $event.target.innerHTML ]
            EventBus.$emit('sendcode', payload)
        }
    }
}
</script>