<!--spring에서 데이터 연동하는걸  view에서 처리-->
<template>
    <div id="board">
        <h2>Vue+Spring 게시판 구현</h2>
        <router-link :to="{name: 'BoardRegisterPage'}">
            게시물 작성
        </router-link>
        <!--:boards="boards  ==> v-bind:boards="boards"-->
        <board-list :boards="boards"/>
    </div>
</template>

<script>

import BoardList from '@/components/board/BoardList.vue'
import {mapState,mapActions} from 'vuex'

export default {
    
    name: 'BoardListPage',
    components:{
        BoardList,
    },
    //실제값에 변동이발생할때 발생
    computed:{
        ...mapState(['boards'])
    },
    //created는 객체가 생성될때,
    //mounted는 웹이랑 붙을때 작동함
    mounted(){
        this.fetchBoardList()
    },
    methods:{
        ...mapActions(['fetchBoardList'])
    }

}
</script>