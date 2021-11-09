<template>
    <div>
        <p>{{ dungeons }}</p>
        <ul v-for="(dd, idx) in dungeon_details" :key="idx">
            <li v-if="dd.monsterAmount == dungeons[0]">
                던전명: {{ dungeons[1] }}, 몬스터 수량: {{ dungeons[0] }}<br>
                {{ dd.text}}
            </li>
        </ul>
    </div>
</template>

<script>
import EventBus from '@/eventBus.js'

export default {
    data () {
        return {
            dungeon_details: [
                { monsterAmount: '1', text: "전투력 500이상 가능!" },
                { monsterAmount: '2', text: "전투력 600이상 가능!" },
                { monsterAmount: '3', text: "전투력 700이상 가능!" },
                { monsterAmount: '4', text: "전투력 800이상 가능!" },
                { monsterAmount: '5', text: "전투력 900이상 가능!" },
                { monsterAmount: '6', text: "전투력 1000이상 가능!" },
                { monsterAmount: '7', text: "전투력 1500이상 가능!" },
            ],
            dungeons: []
        }
    },
    // created () {
    created: function() {
        // $on은 이벤트를 감지함 <<<
        // $emit은 이벤트를 발생시킴 <<<
        EventBus.$on('measureMonsterAmount', (payload) => {
        //once를 넣으면 한번만 작동 한다.
        // EventBus.$once('sendcode', (payload) => {
            this.dungeons = payload
        })
    }
}
</script>

<style scoped>
/*
div {
    background: #ff4081;
    color: white;
    padding: 10px;
    font-weight: bold;
}
ul {
    list-style: none;
}
*/
</style>