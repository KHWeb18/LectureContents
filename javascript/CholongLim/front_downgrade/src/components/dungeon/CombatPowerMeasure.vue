<template>
    <div>
        <p> {{ dungeons }} </p>
        <ul v-for="(dd,idx) in dungeons_details" :key="idx">
            <li v-if="dd.monster_amount == dungeons[0]">
                던전명: {{ dungeons[1] }}, 몬스터 수: {{ dungeons[0] }}<br>
                입장 제한 : {{ dd.text }}
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
                {monster_amount: '0', text: "레벨 1 이상 입장가능" },
                {monster_amount: '1', text: "레벨 10 이상 입장가능" },
                {monster_amount: '2', text: "레벨 15 이상 입장가능" },
                {monster_amount: '3', text: "레벨 20 이상 입장가능" },
                {monster_amount: '4', text: "레벨 25 이상 입장가능" },
                {monster_amount: '5', text: "레벨 30 이상 입장가능" },
                {monster_amount: '6', text: "레벨 35 이상 입장가능" },
                {monster_amount: '7', text: "레벨 40 이상 입장가능" }
            ],
            dungeons: []
        }
    },
    created: function() {
        EventBus.$on('measureMonsterAmount', (payload) => {
            this.dungeons = payload
        })
    }
}
</script>

<style scoped>


div {
    background:lightsalmon;
    color:red;
    padding: 10px;
    font-weight: bold;
}

ul {
    list-style: none;
}
</style>