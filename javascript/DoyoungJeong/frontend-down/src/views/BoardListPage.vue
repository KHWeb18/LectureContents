<template>
    <div id="board">
        <h2>VUE + Spring 게시판</h2>
        <router-link :to="{ name: 'BoardRegisterPage' }">
            게시물 작성
        </router-link>
        <board-list :boards="boards"/> <!-- :은 v-bind -->
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
    computed: {
        ...mapState(['boards'])
    },
    mounted() {
        this.fetchBoardList()
    },
    methods: {
        ...mapActions(['fetchBoardList'])
    }
}
</script>

//created는 객체가 만들어질 때, mounted는 ....'웹에 닿으면 변화해라'라는 뜻. 즉 서버와 만나면 작동해서 boards값을 업뎃한다.
//그리고 mysql에서 row를 하나 삭제했을 때는 새로고침을 해야 업데이트 사항이 반영이된다.

//required는 boardNo가 반드시 있어야한다. 머 그런뜻