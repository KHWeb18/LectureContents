<template>
    <div style="padding-top: 30px; height: 1000px;" class="grey darken-3">
        <input type="text" id="title" disabled v-bind:value="concert.concertName"/>    

        <div style="width: 25%; margin: 0px auto; padding-top: 10px;" class="circle responsive-img" v-on:mouseover="turnOffColor" v-on:mouseout="turnOnColor">

      
            <img v-if="concert.concertNo == 1 && onColor == true" class="circle responsive-img" src="@/assets/img/flyingDog2.jpg" >
            <a href="https://ko-kr.facebook.com/bandflyingdog" target="_blank" v-else-if="concert.concertNo == 1 && onColor == false">
            <img class="circle responsive-img" src="@/assets/img/flyingDog2.jpg" id="bluredImg"
            style="position: relative"></a>
            
            <img v-if="concert.concertNo == 2 && onColor == true" class="circle responsive-img" src="@/assets/img/kidmilli2.jpg">
            <a href="https://www.instagram.com/kidcozyboy/?hl=ko" target="_blank" v-else-if="concert.concertNo == 2 && onColor == false">
            <img class="circle responsive-img" src="@/assets/img/kidmilli2.jpg" id="bluredImg"
            style="position: relative"></a>

            <img v-if="concert.concertNo == 3 && onColor == true" class="circle responsive-img" src="@/assets/img/messgram2.jpg">
            <a href="https://ko-kr.facebook.com/Messgram/" target="_blank" v-else-if="concert.concertNo == 3 && onColor == false">
            <img class="circle responsive-img" src="@/assets/img/messgram2.jpg" id="bluredImg"
            style="position: relative"></a>

            <img v-if="concert.concertNo == 4 && onColor == true" class="circle responsive-img" src="@/assets/img/crackshot2.jpg">
            <a href="https://www.instagram.com/crackshot_official/?hl=ko" target="_blank" v-else-if="concert.concertNo == 4 && onColor == false">
            <img class="circle responsive-img" src="@/assets/img/crackshot2.jpg" id="bluredImg"
            style="position: relative"></a>

            <div v-if="onColor == false" class="hide-on-med-and-down search">사진을 클릭하시면 해당 아티스트의 포털사이트 정보페이지로 이동합니다!</div>
        </div>
         
        <div>
            <input type="text" id="name" disabled v-bind:value="concert.concertArtist"/>
        </div>
         
        <input type="text" id="date2" disabled v-bind:value="concert.concertDate"/>
          
        <input type="text" id="venue" disabled v-bind:value="concert.concertVenue"/>

        <input type="text" id="venue" disabled v-bind:value="concert.numberOfLikes + '명이 좋아요했습니다!'" style="font-size: 12px;"/>
       
        <hr style="width: 25%">

        <div class="container" style="width: 25%;">
            <textarea id="infoText" style='height: 90px;' disabled v-bind:value="concert.concertInfo"/>
        </div>
          
        <div align="center">
            <!-- <v-btn text="text" class="btn-flat red-text waves-effect waves-teal" style="margin-right: 30px;" 
            @click="onReservation" outlined>예약하기!</v-btn> -->
            <booking-dialogue/>

            <v-btn v-if="notLikedYet == true" text="text" class="btn-flat red-text waves-effect waves-teal" style="margin-right: 10px;" outlined
            @click="addLiked(concert.concertNo)">찜하기!</v-btn>

            <v-btn v-else-if="notLikedYet == false" text="text" class="btn-flat red-text waves-effect waves-teal" style="margin-right: 10px;" outlined
            @click="unLiked(concert.concertNo)">찜해제</v-btn>

            <!-- <p>.....{{ likedList }}</p> -->
        </div>

    </div>    
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import BookingDialogue from '@/components/concertMainDialogue/BookingDialogue'

export default {
    name: 'ConcertDetailPage',
    components: {
        BookingDialogue
    },
    data() {
        return {
            onColor: true,
            memNoAndConNoArr: []
        }
    },
    computed: {
        ...mapState(['concert', 'likedList', 'isLoggedIn', 'userProfile', 'notLikedYet'])
    },
    methods: {
        ...mapActions(['fetchLikedOrNot']),

        addLiked() {
            if(this.$store.state.isLoggedIn == true) {
                axios.post('http://localhost:8888/member/needSession')
                    .then(res => {
                        if(res.data == true) {
                            // var index = this.concert.concertNo -1
                            // this.likedList.splice(index, 1, 1)

                            const memberNo = this.$store.state.userProfile.memberNo
                            const concertNo = this.$store.state.concert.concertNo
                            const concertName = this.$store.state.concert.concertName
                            const concertArtist = this.$store.state.concert.concertArtist
                            const concertVenue = this.$store.state.concert.concertVenue
                            const concertPrice = this.$store.state.concert.concertPrice
                            const concertDate = this.$store.state.concert.concertDate
                            const concertInfo = this.$store.state.concert.concertInfo
                            
                            console.log("{ memberNo }: " + memberNo)
                            console.log("{ concert }: " + JSON.stringify(this.$store.state.concert))

                            axios.post('http://localhost:8888/member/addLiked', { memberNo, concertNo, concertName, concertArtist, concertVenue, concertPrice, concertDate, concertInfo })
                                .then(alert('관심 목록에 추가되었습니다!'))

                               this.$store.state.concert.numberOfLikes ++
                               this.$store.state.notLikedYet = false

                        } else {
                            alert('세션 정보가 만료되었습니다. 다시 로그인해주세요!')
                            this.$store.state.isLoggedIn = false
                        }
                    })
            } else {
                alert('로그인이 필요한 서비스입니다!')
            }
        },
        unLiked() {
            if(this.$store.state.isLoggedIn == true) {
                axios.post('http://localhost:8888/member/needSession')
                    .then(res => {
                        if(res.data == true) {
                            // var index = this.concert.concertNo -1
                            // this.likedList.splice(index, 1, 0)

                            const memberNo = this.$store.state.userProfile.memberNo
                            const concertNo = this.$store.state.concert.concertNo

                            axios.post('http://localhost:8888/member/deleteLiked', { memberNo, concertNo })
                                .then(alert('관심 목록에서 제거되었습니다!'))

                            this.$store.state.concert.numberOfLikes --
                            this.$store.state.notLikedYet = true


                        } else {
                            alert('세션 정보가 만료되었습니다. 다시 로그인해주세요!')
                            this.$store.state.isLoggedIn = false
                        }
                    })
            } else {
                alert('로그인이 필요한 서비스입니다!')
            }
        },
        onReservation() {

        },
        turnOffColor() {
            this.onColor = false
        },
        turnOnColor() {
            this.onColor = true
        }
    },
    mounted() {

        this.memNoAndConNoArr.push(this.$store.state.userProfile.memberNo)
        this.memNoAndConNoArr.push(this.$store.state.concert.concertNo)
        
        this.fetchLikedOrNot(this.memNoAndConNoArr)
    }
}
</script>

<style>

td, th {
    padding: 0px 0px;
}

hr{
	margin: 0px auto;
}

#title {
    font-size: 45px;
    color: white;
    font-family: 'Roboto', sans-serif;
    font-style: italic;
    text-align: center;
}

#name {
    font-size: 90px;
    color: white;
    font-family: 'Roboto', sans-serif;
    font-style: italic;
    text-align: center;
    margin-top: 10px;
}

#date2 {
    font-size: 18px;
    color: white;
    font-family: 'Roboto', sans-serif;
    font-style: italic;
    text-align: center;
    margin-top: -300px;
}

#venue {
    font-size: 15px;
    color: white;
    font-family: 'Roboto', sans-serif;
    font-style: italic;
    text-align: center;
    margin-top: -100px;
}

#bluredImg {
    filter: blur(2px) grayscale(80%); 
    opacity: 0.6;
}

.search {
    position: absolute; 
    left: 50%;
    top: 25%;
    transform: translate(-50%, -50%);
    color: #ffffff;
    font-family: 'Roboto', sans-serif;
    font-style: italic;
    font-size: 13px;
}

</style>
