<template>
    <div>
        <p>{{ dungeons[2] }}</p>
        <p>{{ dungeons[1] }}</p>
        <ul v-for="(dungeon, index) in dungeons_details" :key="index">
            <li v-if="dungeon.dcode == dungeons[0]">
                제한 레벨: {{ dungeon.text }}
            </li>
        </ul>
    </div>
</template>

<script>
import EventBus from '@/eventBus.js'

export default {
    data() {
        return {
            dungeons_details: [
                { dcode: '2', text: "출현 몬스터 2! 렙 20 이상 들어갈 수 있습니다!" },
                { dcode: '3', text: "출현 몬스터 3! 렙 30 이상 들어갈 수 있습니다!" },
                { dcode: '5', text: "출현 몬스터 5! 렙 50 이상 들어갈 수 있습니다!" },
                { dcode: '7', text: "출현 몬스터 7! 렙 70 이상 들어갈 수 있습니다!" }
            ],
            dungeons: []
        }
    },
    created: function() {
        EventBus.$on('sendDungeonInfo', (payload) => {
            //EventBus.$once('sendcode', (payload) => { 
            //once는 한 번 작동 on은 계속 작동
            this.dungeons = payload
        })
    }
}
</script>

<style scoped>
div {
    background: #ff4081;
    color: white;
    padding: 10px;
    font-weight: bold;
}
ul {
    list-style: none;
}
</style>