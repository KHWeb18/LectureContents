<template>
    <div>
        <ul v-for="(cpm, index) in cpm_details" :key="index">
            <li v-if="cpm.code == dungeon[0]">
                던전 코드: {{ cpm.code }} 전튜력: {{ cpm.text }}
            </li>
        </ul>
    </div>
</template>

<script>
import EventBus from '@/eventBus.js'
export default {
    data () {
        return {
            cpm_details: [
                { code: '1', text: "전투력 1이상" },
                { code: '2', text: "전투력 100이상" },
                { code: '3', text: "전투력 105이상" },
                { code: '4', text: "전투력 200이상" },
                { code: '5', text: "전투력 400이상" },
            ],
            dungeon: []
        }
    },
    // created () {
    created: function() {
        EventBus.$on('dungeoncode', (payload) => {
            this.dungeon = payload
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