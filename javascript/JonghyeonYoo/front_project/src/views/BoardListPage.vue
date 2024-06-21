<template>
    <div id="board">  
        <board-list :boards="boards"/> <!-- 여기서 : <-는 v-bind를 의미한다 --> 
        
    </div>
</template>

<script>

import BoardList from '@/components/board/BoardList.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'BoardListPage',    
    components: {
        BoardList,
 
    },
    computed: {
        ...mapState(['boards'])
    },
    mounted () {
        this.fetchBoardList()
    },
    methods: {
        ...mapActions(['fetchBoardList'])
    },
    
}
</script>