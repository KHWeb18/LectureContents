<template>
    <div id="board">
        <vaccine-page-bar></vaccine-page-bar>
        

        <v-container>
            <h4>백신 정보</h4>
            <h6><i><span style="color: blue;">다양한 백신 후기를 공유해 보세요.</span></i></h6>

            <hr><br>
            <board-list :boards="boards"/>
            <br>
            <center>
               <v-btn color="blue lighten-5" @click="logincheck()"> 후기 작성 </v-btn> 
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
        ...mapActions(['fetchBoardList']),

        logincheck(){
            if(this.$store.state.session==null){
                alert('로그인 후 이용해 주세요.')
                this.$router.push('sessionLogin')
            }
            else{
                this.$router.push('/board/create')

            }
        }
    }
    
}
</script>