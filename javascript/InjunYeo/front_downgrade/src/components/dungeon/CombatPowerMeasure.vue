<template>
    <div>
        <p>{{ dungeons }}</p>
        <ul v-for="(dungeon,idx) in dungeons_details" :key="idx">
            <li v-if="dungeon.monsterAmount == dungeons[0]">
                <!--여기서 dungeons는 데이터가 들어오면서 새로만들어진 배열이다-->
                던전 명:{{ dungeons[1] }} ,몬스터수량: {{ dungeons[0] }}<br>
                {{dungeon.text}}
            </li>
        </ul>
    </div>
</template>

<script>
import EventBus from '@/eventBus.js'
export default {
    data(){
        return{
            dungeons_details:[
                {monsterAmount: '1', text: "전투력 5000이상!"},
                {monsterAmount: '2', text: "전투력 10000이상!"},
                {monsterAmount: '3', text: "전투력 15000이상!"},
                {monsterAmount: '4', text: "전투력 20000이상!"},
                {monsterAmount: '5', text: "전투력 25000이상!"},

            ],
            dungeons: []
        }
    },
    // created () {
    created: function() {
        EventBus.$on('measureMonsterAmount', (payload) => {   //on은작동을 계속한다
            this.dungeons = payload
        })
    }
}
</script>