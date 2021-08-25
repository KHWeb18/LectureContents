<template>
    <div align="center" class="grey darken-0.1" style="height: 850px;">
        <h3 class="topBar" style="margin-top: 0px; padding-top: 30px;">Wish List</h3>
        <p class="description" style="margin-right: 20px;">찜하신 공연을 한눈에 확인해보세요 :)</p>

        <v-container fluid style="margin-top: 30px; width: 100%">
            <table>
                <tr>
                    <td class="description" style="width: 130px;">공연 명</td>
                    <td class="description" style="width: 100px;">아티스트</td>
                    <td class="description" style="width: 100px;">일시</td>
                    <td class="description" style="text-align: center; width: 100px;">장소</td>
                    <td class="description" style="text-align: center; width: 620px;">설명</td>
                </tr>
                <tr v-if="!likedList || likedList.length == 0">
                     <td colspan="5" class="description">아직 찜한 공연이 없거나 목록을 불러오지 못했습니다!</td>
                </tr>
                <tr v-else-if="likedList" v-for="(likedElem, index) in likedList" :key="index">
                    <td class="description">{{ likedElem.concertName }}</td>
                    <td class="description">{{ likedElem.concertArtist }}</td>
                    <td class="description">{{ likedElem.concertDate }}</td>
                    <td class="description">{{ likedElem.concertVenue }}</td>
                    <td class="description">{{ likedElem.concertInfo }}</td>
                    <span>
                        <v-btn style="margin-left: 20px;" class="btn-flat red-text waves-effect waves-teal" @click="goToDetailPage(likedElem.concertNo)">바로가기</v-btn>
                        <v-btn style="margin-left: 10px;" class="btn-flat red-text waves-effect waves-teal" @click="deleteLikedConcert(likedElem.concertNo, index)">찜해제</v-btn>
                    </span>
                </tr>
            </table>
        </v-container>
    </div>

</template>

<script>
import axios from 'axios'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'LikedPage',
    computed: {
       ...mapState(['likedList', 'userProfile', 'isLoggedIn'])
    },
    data() {
        return {
            
        }
    },
    methods: {
        ...mapActions(['fetchLikedList', 'fetchConcert']),

        goToDetailPage(concertNo) {
            this.fetchConcert(concertNo)

            this.$router.push({
                name: 'ConcertDetailPage'
            })
        },
        deleteLikedConcert(conNo, index) { //conNo는 concertNo랑 같음
            
            const memberNo = this.$store.state.userProfile.memberNo
            const concertNo = conNo

            if(this.$store.state.isLoggedIn == true) {
                axios.post('http://localhost:8888/member/needSession')
                    .then(res => {
                        if(res.data == true) {
             
                            this.$store.state.likedList.splice(index, 1)

                            axios.post('http://localhost:8888/member/deleteLiked', { memberNo, concertNo })
                                .then(alert('관심 목록에서 제거되었습니다!'))

                                //this.$store.state.concert.numberOfLikes --
                                //this.$store.state.notLikedYet = true

                        } else {
                            alert('세션 정보가 만료되었습니다. 다시 로그인해주세요!')
                            this.$store.state.isLoggedIn = false
                        }
                    })
            } else {
                alert('로그인이 필요한 서비스입니다!')
            }
            
        }
    },
    mounted() {
        this.fetchLikedList(this.$store.state.userProfile.memberNo)
        console.log("즐겨찾기를 찾을 회원 번호: " + this.$store.state.userProfile.memberNo)
    }
}
</script>
