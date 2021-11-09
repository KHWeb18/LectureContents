<template>
    <div id="eventBusDungeon">
        <h2>Dungeon Monster List</h2>
        <dungeons></dungeons>
        <dungeon-detail></dungeon-detail>
    </div>
</template>

<script>

import Dungeons from '../components/dungeon/Dungeons.vue'
import DungeonDetail from '../components/dungeon/DungeonDetail.vue'

export default {
    name: 'DungeonPage',
    components: {
        Dungeons,
        DungeonDetail
    }
    
}
</script>

<style scoped>
ul {
    list-style-type: none;
    background: #3399ff;
    padding: 10px;
}
ul li {
    background: #cce5ff;
    margin: 5px;
}
</style>

//event를 쓰는 이유는 event.target.html을 보려고하는 의도이다.
