<template>
    <div>
        <p>{{ dungeons }}</p>
        <!-- dd = dungeon-detail)-->
        <ul v-for="(dd, idx) in dungeons_details" :key="idx">
            <!-- 밑의 EventBus에서 던전명과 몬스터수량이 넘어오므로 -->
            <li v-if="dd.monsterAmount == dungeons[0]">
                <!-- 뿌려주기-->
                던전명: {{ dungeons.name }} 몬스터수량: {{ dungeons.monsterAmount }}<br>
                {{ dd.text }}
            </li>
        </ul>
    </div>
</template>

<script>
import EventBus from '@/eventBus.js'
export default {
    data () {
        return {
            dungeons_details: [
                { monsterAmount: '1', text: "전투력 5000이상 요구!" },
                { monsterAmount: '2', text: "전투력 10000이상 요구!" },
                { monsterAmount: '3', text: "전투력 15000이상 요구!" },
                { monsterAmount: '4', text: "전투력 20000이상 요구!" },
                { monsterAmount: '5', text: "전투력 40000이상 요구!" },
                { monsterAmount: '6', text: "전투력 100000이상 요구!" },
                { monsterAmount: '7', text: "전투력 300000이상 요구!" },
            ],
            dungeons: []
        }
    },
    created: function() {
        // 몬스터수량(measureMonsterAmount)과 던전명(payload)이 전달됨
        EventBus.$on('measureMonsterAmount', (payload) => {
            this.dungeons = payload
        })
    }
}
</script>

<style scoped>
div {
    background: #353032;
    color: white;
    padding: 10px;
    font-weight: bold;
}
ul {
    list-style: none;
}
</style>