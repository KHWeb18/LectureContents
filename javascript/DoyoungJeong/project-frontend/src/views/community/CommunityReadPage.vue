<template>
    <div align="center" class="grey darken-0.1" style="height: 100%;">
        <h3 class="topBar" style="margin-top: 0px; padding-top: 30px;">COMMUNITY COMMENT</h3>

        <p class="description" style="display: inline;">MUSIC GHUETTO 이용자들의 공연 관람 후기입니다. 참고하세요. :)</p>

        <community-board-read v-if="board" :board="board"/>
        <p class="description" v-else-if="!board">해당 게시글의 정보를 불러오는 중입니다. 조금만 기다려주세요. :)</p>
        
        <reply-section/>

    </div>
</template>

<script>
//import EventBus from '@/eventBus.js'
import { mapActions, mapState } from 'vuex'
import CommunityBoardRead from '@/components/communityBoard/CommunityBoardRead'
import ReplySection from '@/components/communityBoard/ReplySection'

export default {
    name: 'CommunityReadPage',
    components: {
        CommunityBoardRead,
        ReplySection
    },
    props: {
        boardNo: {
            type: String,
            required: true
        } 
    },
    data() {
        return {
            //boardNo: 0
        }
    },
    mounted() {
        // EventBus.$on('sendNum', (payload) => {
        //     this.boardNo = payload

        //     this.fetchBoard(this.boardNo)
        //     this.fetchReplyList(this.boardNo)
        // })
        this.fetchBoard(this.boardNo)
        this.fetchReplyList(this.boardNo)

        //alert(this.boardNo)

        this.$store.state.userProfile = this.$cookies.get("currentUser")

        if(this.$store.state.userProfile.id != '') {

            this.$store.state.isLoggedIn = true
            this.$store.state.userIdentity = this.$store.state.userProfile.identity
        }
    },
    computed: {
        ...mapState(['userProfile', 'isLoggedIn', 'board'])
    },
    methods: {
        ...mapActions(['fetchBoard', 'fetchReplyList'])
    }
}
</script>
