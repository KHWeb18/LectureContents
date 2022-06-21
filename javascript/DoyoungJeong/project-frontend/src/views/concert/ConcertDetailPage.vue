<template>
    <div style="padding-top: 30px; height: 100%;" class="grey darken-3">
        <input type="text" class="detailTitle" disabled v-bind:value="concert.concertName" style="font-size: 50px; color: white;"/>    

        <div style="width: 25%; margin: 0px auto; padding-top: 10px;" class="circle responsive-img" v-on:mouseover="turnOffColor" v-on:mouseout="turnOnColor">

            <img v-if="concert.concertNo == 1 && onColor == true" class="circle responsive-img" src="@/assets/img/flyingDog2.jpg" >
            <a href="https://ko-kr.facebook.com/bandflyingdog" target="_blank" v-else-if="concert.concertNo == 1 && onColor == false">
            <img class="circle responsive-img bluredImg" src="@/assets/img/flyingDog2.jpg"
            style="position: relative"></a>
            
            <img v-if="concert.concertNo == 2 && onColor == true" class="circle responsive-img" src="@/assets/img/kidmilli2.jpg">
            <a href="https://www.instagram.com/kidcozyboy/?hl=ko" target="_blank" v-else-if="concert.concertNo == 2 && onColor == false">
            <img class="circle responsive-img bluredImg" src="@/assets/img/kidmilli2.jpg"
            style="position: relative"></a>

            <img v-if="concert.concertNo == 3 && onColor == true" class="circle responsive-img" src="@/assets/img/messgram2.jpg">
            <a href="https://ko-kr.facebook.com/Messgram/" target="_blank" v-else-if="concert.concertNo == 3 && onColor == false">
            <img class="circle responsive-img bluredImg" src="@/assets/img/messgram2.jpg"
            style="position: relative"></a>

            <img v-if="concert.concertNo == 4 && onColor == true" class="circle responsive-img" src="@/assets/img/crackshot2.jpg">
            <a href="https://www.instagram.com/crackshot_official/?hl=ko" target="_blank" v-else-if="concert.concertNo == 4 && onColor == false">
            <img class="circle responsive-img bluredImg" src="@/assets/img/crackshot2.jpg"
            style="position: relative"></a>

            <img v-if="concert.concertNo == 5 && onColor == true" class="circle responsive-img" src="@/assets/img/박소은2.jpg">
            <a href="https://www.facebook.com/singersongwritersoeun" target="_blank" v-else-if="concert.concertNo == 5 && onColor == false">
            <img class="circle responsive-img bluredImg" src="@/assets/img/박소은2.jpg"
            style="position: relative"></a>

            <img v-if="concert.concertNo == 6 && onColor == true" class="circle responsive-img" src="@/assets/img/RollingQuartz2.jpeg">
            <a href="https://www.instagram.com/rolling_quartz/?hl=ko" target="_blank" v-else-if="concert.concertNo == 6 && onColor == false">
            <img class="circle responsive-img bluredImg" src="@/assets/img/RollingQuartz2.jpeg"
            style="position: relative"></a>

            <img v-if="concert.concertNo == 7 && onColor == true" class="circle responsive-img" src="@/assets/img/OceanFromTheBlue2.jpg">
            <a href="https://www.instagram.com/oceanfromtheblue/" target="_blank" v-else-if="concert.concertNo == 7 && onColor == false">
            <img class="circle responsive-img bluredImg" src="@/assets/img/OceanFromTheBlue2.jpg"
            style="position: relative"></a>

            <img v-if="concert.concertNo == 8 && onColor == true" class="circle responsive-img" src="@/assets/img/김심야2.jpg">
            <a href="http://www.beastsandnatives.com/#subscribe" target="_blank" v-else-if="concert.concertNo == 8 && onColor == false">
            <img class="circle responsive-img bluredImg" src="@/assets/img/김심야2.jpg"
            style="position: relative"></a>

            <img v-if="concert.concertNo == 9 && onColor == true" class="circle responsive-img" src="@/assets/img/DJ 팁토2.jpg">
            <a href="http://www.beastsandnatives.com/#subscribe" target="_blank" v-else-if="concert.concertNo == 9 && onColor == false">
            <img class="circle responsive-img bluredImg" src="@/assets/img/DJ 팁토2.jpg"
            style="position: relative"></a>

            <img v-if="concert.concertNo == 10 && onColor == true" class="circle responsive-img" src="@/assets/img/이준형2.jpg">
            <a href="http://www.beastsandnatives.com/#subscribe" target="_blank" v-else-if="concert.concertNo == 10 && onColor == false">
            <img class="circle responsive-img bluredImg" src="@/assets/img/이준형2.jpg"
            style="position: relative"></a>

            <img v-if="concert.concertNo == 11 && onColor == true" class="circle responsive-img" src="@/assets/img/Surl2.jpg">
            <a href="http://www.beastsandnatives.com/#subscribe" target="_blank" v-else-if="concert.concertNo == 11 && onColor == false">
            <img class="circle responsive-img bluredImg" src="@/assets/img/Surl2.jpg"
            style="position: relative"></a>

            <img v-if="concert.concertNo == 12 && onColor == true" class="circle responsive-img" src="@/assets/img/Net Gala2.jpg">
            <a href="http://www.beastsandnatives.com/#subscribe" target="_blank" v-else-if="concert.concertNo == 12 && onColor == false">
            <img class="circle responsive-img bluredImg" src="@/assets/img/Net Gala2.jpg"
            style="position: relative"></a>

            <div v-if="onColor == false" class="hide-on-med-and-down search">사진을 클릭하시면 해당 아티스트의 관련 페이지로 이동합니다!</div>
        </div>
         
        <div style="margin-top: 10px;">
            <input type="text" class="name" disabled v-bind:value="concert.concertArtist" style="font-size: 40px; color: white;"/>
        </div>
         
        <input type="text" class="date2" disabled v-bind:value="concert.concertDate" style="color: white;"/>
          
        <input type="text" class="venue" disabled v-bind:value="concert.concertVenue" style="color: white;"/>

        <input type="text" class="venue" disabled v-bind:value="concert.numberOfLikes + '명이 좋아요했습니다!' + ' 현재 남은 자리 수 ' + 
        concert.venueCapacity" style="font-size: 15px; color: white;" />

        <hr style="width: 25%">

        <div class="container" style="width: 25%;">
            <textarea class="infoText" style='height: 90px; color: white;' disabled v-bind:value="concert.concertInfo"/>
        </div>
          
        <div align="center" style="margin-bottom: 60px;">
            <!-- <v-btn text="text" class="btn-flat red-text waves-effect waves-teal" style="margin-right: 30px;" 
            @click="onReservation" outlined>예약하기!</v-btn> -->
            <booking-dialogue v-if="notBookedYet || isLoggedIn == false" :member="member" :concertNo="concertNo"/>

            <v-tooltip bottom v-else-if="!notBookedYet && isLoggedIn == true">
                <template v-slot:activator="{ on, attrs }">
                    <v-btn  class="btn-flat red-text waves-effect waves-teal" style="margin-right: 30px;" @click="cancelBook" outlined color="pink" v-bind="attrs" v-on="on">
                        <v-icon>
                            email
                        </v-icon>
                    </v-btn>
                </template>
                <span>예약 취소</span>    
            </v-tooltip>

            <v-tooltip bottom v-if="notLikedYet == true || isLoggedIn == false">
                <template v-slot:activator="{ on, attrs }">
                    <v-btn text="text" class="btn-flat red-text waves-effect waves-teal" style="margin-right: 10px;" outlined
                    @click="addLiked(concert.concertNo)" color="black" v-bind="attrs" v-on="on">
                        <v-icon>
                            mdi-heart
                        </v-icon>
                    </v-btn>
                </template>
                <span>찜하기!</span>    
            </v-tooltip>

            <v-tooltip bottom v-else-if="notLikedYet == false && isLoggedIn == true">
                <template v-slot:activator="{ on, attrs }">
                    <v-btn text="text" class="btn-flat red-text waves-effect waves-teal" style="margin-right: 10px;" outlined
                    @click="unLiked(concert.concertNo)" color="pink" v-bind="attrs" v-on="on">
                        <v-icon>
                            mdi-heart
                        </v-icon>
                    </v-btn>
                </template>
                <span>찜해제</span>    
            </v-tooltip>

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
    props: {
        concertNo: {
            type: String,
            required: true
        }
    },
    data() {
        return {
            onColor: true,
            memNoAndConNoArr: []
        }
    },
    computed: {
        ...mapState(['concert', 'likedList', 'isLoggedIn', 'userProfile', 'notLikedYet', 'member', 'notBookedYet'])
    },
    methods: {
        ...mapActions(['fetchLikedOrNot', 'fetchConcert', 'fetchMember', 'fetchBookedOrNot']),

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
                            
                            // console.log("{ memberNo }: " + memberNo)
                            // console.log("{ concert }: " + JSON.stringify(this.$store.state.concert))

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
        },
        cancelBook() {
            alert('예약 취소는 마이페이지의 예약리스트에서 할 수 있습니다! :)')
        }
    },
    mounted() {
        this.fetchConcert(this.concertNo) //이상하네.. 이게 맨 뒤에 있을 때는 실행이 안되다가 왜 지금처럼 위에 놓으면 실행되지?
        //alert(this.concertNo)

        this.$store.state.userProfile = this.$cookies.get("currentUser")

        if(this.$store.state.userProfile.id != '') {

            this.$store.state.isLoggedIn = true
            this.$store.state.userIdentity = this.$store.state.userProfile.identity

            this.memNoAndConNoArr.push(this.$store.state.userProfile.memberNo)
            this.memNoAndConNoArr.push(this.concertNo) //얘가 this.$store.state.concert.concertNo에서 this.concertNo로 수정해주니까 잘됨 --> 위의 fetchConcert가 
            //db에서 concert를 가져와 concert.concertNo를 주기 전에 이 명령이 실행되니까 그런거였음. 그래서 애초에 props로 받은 this.concertNo를 사용해주니까 잘됨
            this.fetchLikedOrNot(this.memNoAndConNoArr)
            //alert(this.memNoAndConNoArr)
            this.fetchBookedOrNot(this.memNoAndConNoArr)

            this.fetchMember(this.$store.state.userProfile.memberNo)
        }
        
    }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Do+Hyeon&display=swap');

td, th {
    padding: 0px 0px;
}

hr{
	margin: 0px auto;
}

.detailTitle {
    color: white;
    font-family: 'Do Hyeon', sans-serif;
    font-style: italic;
    text-align: center;
}

.name {
    font-size: 90px;
    color: white;
    font-family: 'Do Hyeon', sans-serif;
    font-style: italic;
    text-align: center;
    margin-top: 10px;
}

.date2 {
    color: white;
    font-family: 'Roboto', sans-serif;
    font-style: italic;
    text-align: center;
    margin-top: -300px;
}

.venue {
    font-size: 15px;
    color: white;
    font-family: 'Do Hyeon', sans-serif;
    font-style: italic;
    text-align: center;
    margin-top: -100px;
}

.bluredImg {
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
