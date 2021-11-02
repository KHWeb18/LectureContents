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
    computed: {
        ...mapState(['boards'])
    },
    // 흐름을 보자면 list페이지를 보여주기위해서 미리 임계영역에 boards에 배열을 계산해놓는다.
    // 크롬에서 디버깅했는데 computed가 먼저 실행되는거 같은 이유가 맨처음 빈화면으로 로딩된다.
    // computed에서 맨처음 임계영역에 있는 아직 요청받기전에 빈 board를 가져와서 그런것같다.
    // 그후에 HTML요소를 붙이는 mounted가 실행되는데 이 mounted 안에는 mapAciont에 있는
    // fetchBoardList가 있다. 서버에 요청해서 get한 데이터를 동기화한후에 임계영역 boards 데이터에 넣는다.
    // 그러면 monuted로 온다. 데이터가 v-for 형태로 board-list 구조에 맞게 하나씩 나열됨

    mounted () {
        this.fetchBoardList()
    },
    methods: {
        ...mapActions(['fetchBoardList'])
    }
}
</script>