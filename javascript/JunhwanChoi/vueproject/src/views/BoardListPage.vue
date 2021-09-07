<template>
    <div id="board">
        <vaccine-page-bar></vaccine-page-bar>

        <v-container>
            <board-list :boards="boards"/>
            <router-link :to="{ name: 'BoardRegisterPage' }">
                후기 작성
            </router-link>
        </v-container>
    </div>
</template>

<script>
import BoardList from '@/components/board/BoardList.vue'
import VaccinePageBar from '@/components/bar/VaccinePageBar.vue'
import { mapState, mapActions } from 'vuex'
export default {
    name: 'BoardListPage',
    components: {
        BoardList,
        VaccinePageBar
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