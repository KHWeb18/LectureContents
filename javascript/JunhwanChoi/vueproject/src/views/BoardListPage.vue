<template>
    <div id="board">
        <vaccine-page-bar></vaccine-page-bar>
        

        <v-container>
            <h4>백신 정보</h4>
            <hr><br>
            <board-list :boards="boards"/>
            <br>
            <center>
            <router-link :to="{ name: 'BoardRegisterPage' }">
               <v-btn color="blue lighten-5"> 후기 작성 </v-btn> 
            </router-link>
            </center>
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