<template>
    <div v-if="infoBar" class="col xs12 sm12 md12 lg12 app grey darken-5">
        <div style="padding-left: 50px; margin-top: 10px;" class="row">
            <div style="margin-right: -500px; margin-left: 20px;">
                <input type="text" disabled class="infoText" style="font-size: 50px; color: white;" v-bind:value="concert.concertName"/>
                <input type="text" disabled class="infoText" style="font-size: 35px; color: white;" v-bind:value="concert.concertArtist"/>
                <input type="text" disabled class="infoText" style="font-size: 22px; color: white;" v-bind:value="concert.concertVenue"/>
            </div> 
            <div>
                <input type="text" disabled class="infoText" style="font-size: 20px; margin-top: -10px; display: inline; color: white;" v-bind:value="date + concert.concertDate"/>
                <input type="text" disabled class="infoText" style="font-size: 20px; margin-top: -10px; color: white;" v-bind:value="concert.concertPrice"/>
                <textarea class="infoText" cols="50" style='height: 90px;' disabled v-bind:value="concert.concertInfo"/>
            </div>

            <div class="flex-grow-1"></div> <!-- 간격 벌리기 -->

            <div style="padding-right: 100px; padding-top: 50px;">

                <v-btn text v-if="notLikedYet == true || isLoggedIn == false" class="red-text waves-effect waves-teal" style="margin-right: 30px;" 
                @click="addLiked" color="white"><v-icon>mdi-heart</v-icon></v-btn>

                <v-btn text v-else-if="notLikedYet == false && isLoggedIn == true" class="btn-flat red-text waves-effect waves-teal" style="margin-right: 30px;" 
                @click="unLiked" color="pink"><v-icon>mdi-heart</v-icon></v-btn>  <!-- text 값을 주면 버튼 배경이 없어짐 -->

                <v-btn class="btn-flat red-text waves-effect waves-teal" style="margin-right: 30px;"
                @click="sendToDetailPage">자세히보기</v-btn>

                <v-btn @click="offInfoBox" class="btn-flat red-text waves-effect waves-teal">취소</v-btn>
                <!-- <p>.....{{ likedList }}</p> -->
                <p style="text-align: right; padding-right: 15px; padding-top: 60px; font-style: italic; color: rgba(0, 0, 0, 0.3);">MUSIC GHUETTO</p>
            </div>    
        </div>
        
    <hr> 
    </div>
</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'

export default {
    name: 'InformationBox',
    components: {

    },
    props: {
        infoBar: {
            type: Boolean,
            required: true  
        },
        concert: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            date: '일시 :'
        }
    },
    computed: {
        ...mapState(['likedList', 'isLoggedIn', 'userProfile', 'notLikedYet']) //, 'concert' <-- props에 이미 있음 , 'notLikedYet' 일단 빼둠 --> 다시 넣음
    },
    methods: {
         //...mapActions(['fetchLikedOrNot']),

        offInfoBox() {
            this.$emit('offInfoBox')
        },
        sendToDetailPage() {
            this.$router.push({
                name: 'ConcertDetailPage',
                params: { concertNo: this.concert.concertNo }
            })
        },
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
        }
    }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Do+Hyeon&display=swap');

.infoText {
    color: #FFFFFF;
    font-family: 'Do Hyeon', sans-serif;
    font-style: italic;
    font-size: 13px;
    line-height: 20px;
}


textarea {
    resize: none;
}

</style>
