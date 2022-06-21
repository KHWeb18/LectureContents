<template>
    <div align="center" class="grey darken-0.1" style="height: 850px;">
        <h3 class="topBar" style="margin-top: 0px; padding-top: 30px;">COMMUNITY COMMENT</h3>

        <p class="description" style="display: inline;">글을 자유롭게 수정, 삭제하실 수 있습니다. :)</p>
        
        <community-board-modify v-if="board" :board="board"/>
        <p class="description" v-else-if="!board">해당 게시글의 정보를 불러오는 중입니다. 조금만 기다려주세요. :)</p>

    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'

import CommunityBoardModify from '@/components/communityBoard/CommunityBoardModify'

export default {
    name: 'CommunityModifyPage',
    components: {
        CommunityBoardModify
    },
    props: {
        boardNo: {
            type: String, //String인가??
            required: true
        }
    },
    computed: {
        ...mapState(['userProfile', 'isLoggedIn', 'board'])
    },
    methods: {
        ...mapActions(['fetchBoard'])
    },
    mounted() {
        this.$store.state.userProfile = this.$cookies.get("currentUser")

        if(this.$store.state.userProfile.id != '') {

            this.$store.state.isLoggedIn = true
            this.$store.state.userIdentity = this.$store.state.userProfile.identity
        }
        //alert(this.boardNo)
        this.fetchBoard(this.boardNo)
    }
}
</script>
