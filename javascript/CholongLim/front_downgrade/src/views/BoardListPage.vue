<template>
    <div id="board">
        <h2>Vue + Spring 게시판 구현</h2>
        <router-link :to="{ name: 'BoardRegisterPage' }">
            게시물 작성
        </router-link>
        <board-list :boards="boards"/>
    </div>
</template>

<script>
import BoardList from '@/components/board/BoardList.vue'
import { mapState, mapActions } from 'vuex'
export default {
    name: 'BoardListPage',
    components: {
        BoardList
    },
    // 실제 값에 변경이 발생할때 동작함
    computed: {
        ...mapState(['boards'])
    },
    // mounted : 객체가 생성되고나서 웹이랑 붙을 때
    mounted () {
        this.fetchBoardList()
    },
    methods: {
        ...mapActions(['fetchBoardList'])
    }
}
</script>