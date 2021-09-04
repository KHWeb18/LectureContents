<template>
    <div id="room">
        <div class="container" style="margin-bottom:2%">
            <div>
                <v-row justify="center" style="margin:3%;">
                    <h4 style="margin-top:5%;">예약목록</h4>
                </v-row>
                <room-list :rooms="rooms" :reserveDate="reserveDate" class="table-box"/>
            </div>
        </div>  
    </div>
</template>

<script>
import RoomList from '@/components/manager/RoomList.vue'
import { mapState, mapActions } from 'vuex'
export default {
    name: 'BookingListPage',
    components: {
        RoomList
    },
    computed: {
        ...mapState(['rooms','reserveDate'])
    },
    mounted () {
        this.fetchRoomList(),
        this.fetchReserveList()
    },
    methods: {
        ...mapActions(['fetchRoomList','fetchReserveList']),
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');
@import url('https://fonts.googleapis.com/css2?family=MonteCarlo&display=swap');


p {
    font-family: 'Nanum Myeongjo';
    font-size: 18px;
    text-align: center;
    padding: 18px 0px 18px 0px;
}


h4 {
    margin-top: 0px;
    font-family: 'Nanum Myeongjo';
    font-size: 25px;
}


.table-box{
    margin-bottom: 10%;
}
</style> 