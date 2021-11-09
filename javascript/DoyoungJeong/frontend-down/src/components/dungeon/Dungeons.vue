<template>
    <ul v-if="dungeons">
        <li v-for="(dungeon, index) in dungeons" :key="index"
        v-on:click="sendDungeonInfo(dungeon.monAmount, dungeon.desc, $event)">
            {{ dungeon.name }}
        </li>
    </ul>
</template>

<script>
import EventBus from '@/eventBus.js'
//EventBus는 전역변수처럼 활용됨, 어디서나 쓸 수 있음

import { mapActions, mapState } from 'vuex'

export default {
    name: 'Dungeons',
    data() {
        return {
        }
    },
    methods: {
        ...mapActions(['fetchDungeonList']),

        sendDungeonInfo(incode, incode1, $event) {
            
            console.log(incode + $event.target.innerHTML)
        
            const payload = [ incode, incode1, $event.target.innerHTML ]
            EventBus.$emit('sendDungeonInfo', payload)
        }
    },
    computed: {
        ...mapState(['dungeons'])
    },
    mounted() {
        this.fetchDungeonList()
    },
}
</script>
