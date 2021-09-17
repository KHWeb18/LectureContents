<template>
    <div align="center" class="grey darken-0.1" style="height: 100%; padding-top: 60px;">
        <p class="memberListTitle">Concert Request Modify</p>
        <p class="description">회원님이 작성한 공연 게시 요청 정보입니다. 거부되어도 재요청을 보낼 수 있습니다. :)</p>
        
        <my-request-modify v-if="concertRequest" :concertRequest="concertRequest" @submit="onSubmit"/>
        <p v-else-if="!concertRequest">잠시만 기다려주세요!</p> <!-- 이게 있어야 새로고침해도 concertRequest값이 자식 컴포넌트에 들어감? -->
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import MyRequestModify from '@/components/authArtist/MyRequestModify'

export default {
    name: 'MyRequestModifyPage',
    components: {
        MyRequestModify
    },
    props: {
        concertRequestNo: {
            type: Number,
            required: true
        }
    },
    methods: {
        ...mapActions(['fetchConcertRequest']),

        onSubmit(payload) {
            //alert(JSON.stringify(payload))

            const { concertRequestNo, memberNo, regName, artistName, venueName, concertName, dateOfConcert, timeOfConcert, timeOfEnd } = payload

            axios.put('http://localhost:8888/member/concertRegister/requestModify', { concertRequestNo, memberNo, regName, artistName, venueName, concertName, dateOfConcert, timeOfConcert, timeOfEnd })
                .then(() => {
                    alert('업로드가 완료되었습니다.')

                    this.$router.push({
                        name: 'MyRequestReadPage',
                        params: { concertRequestNo: this.concertRequest.concertRequestNo }
                    })
                })
                .catch(() => {
                    alert('서버에 문제가 있습니다. 잠시후에 다시 시도해주세요!')
                })
        }
    },
    computed: {
        ...mapState(['userProfile', 'isLoggedIn', 'concertRequest'])
    },
    mounted() {
        this.fetchConcertRequest(this.concertRequestNo)
        //alert('mounted: ' + JSON.stringify(this.concertRequest)) --> null로 나옴, 새로고침해도 v-model에 값 유지되게하는건 자식 컴포넌트 만들고 v-else-if
    
        this.$store.state.userProfile = this.$cookies.get("currentUser")

        if(this.$store.state.userProfile.id != '') {

            this.$store.state.isLoggedIn = true
            this.$store.state.userIdentity = this.$store.state.userProfile.identity
        }
    }
}
</script>
