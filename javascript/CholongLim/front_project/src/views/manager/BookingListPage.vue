<template>
    <div id="room" class="img-cover">
        <div class="container" style="margin-bottom:2%" v-if="cookie == true">
            <div>
                <v-card>
                <v-row justify="center" style="margin:3%;">
                    <h4 style="margin-top:5%;">예약목록</h4>
                </v-row>
                <room-list :rooms="rooms" :reserveDate="reserveDate" class="table-box"/>
                </v-card>
            </div>
        </div>  
        <div class="container" style="margin-bottom:2%" v-if="cookie == false">
            <div>            
                <v-row justify="center" style="margin:10% auto;">
                <h4 style="margin-top:5%; color:white;">로그인 시간이 초과되었습니다.</h4>
                </v-row>
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
    data() {
        return {
            cookie: this.$cookies.isKey('user')
        }
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
@import url('https://fonts.googleapis.com/css2?family=Gowun+Batang&display=swap');
@import url('https://fonts.googleapis.com/css2?family=MonteCarlo&display=swap');


p {
    font-family: 'Nanum Myeongjo';
    font-size: 18px;
    text-align: center;
    padding: 18px 0px 18px 0px;
}


h4 {
    margin-top: 0px;
    font-family: 'Gowun Batang';
    font-size: 25px;
}

.img-cover{
     position: relative;
     height: 100%;
     width: 100%;
     background-image: url('https://images.pexels.com/photos/6109124/pexels-photo-6109124.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940');
     background-size: cover;                                                            
     z-index:1;
}

.table-box{
    margin-bottom: 10%;
}
</style> 