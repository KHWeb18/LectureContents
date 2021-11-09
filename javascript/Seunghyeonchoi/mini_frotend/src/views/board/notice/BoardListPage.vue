<template>
    <div id="board">
        <h2>공지사항</h2>

        <board-list :boards="boards"/>
        <v-container>
            <v-flex text-xs-right text-sm-right>
        <router-link :to="{ name: 'NoticeBoardRegisterPage' }">
            <v-btn color="blue-grey darken-2 text center" @click="roundBtnClick" class="change-font">
                글쓰기
            </v-btn>
        </router-link>
            </v-flex>
        </v-container>
    </div>

</template>

<script>

import BoardList from '@/components/board/notice/BoardList.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'BoardListPage',
    components: {
        BoardList
    },
    computed: {
        ...mapState(['boards'])
    },
    mounted () {
        this.fetchBoardList()
    },
    methods: {
        ...mapActions(['fetchBoardList'])
        
    }
}

</script>

<style scoped>
.boardButton {
    float: right;
    width: 160px;
    height: 45px;
    border: none;
    background-color: #01579B;
    color: #fff;
    font-size: 14px;
    font-weight: 700;
}
.change-font {
    font: 12pt;
    color: white
}
</style>