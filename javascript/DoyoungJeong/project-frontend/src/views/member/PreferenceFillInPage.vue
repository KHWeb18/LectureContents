<template>
    <div align="center" class="grey darken-0.1" style="height: 100%;">
        <h3 class="topBar" style="margin-top: 0px; padding-top: 30px;">PRFERENCE</h3>
        <p class="description" style="margin-right: 25px;">공연을 선택하는데 어려움이 있나요??? 고객님의 취향에 맞게 장르와 아티스트를 선택해보세요! :)</p>

        <preference-box v-if="isLoggedIn && notDecidedYet" style="margin-top: 30px;" @complete="onComplete"/>
        <p v-else-if="!isLoggedIn" class="footerText" style="margin-top: 50px; margin-right: 30px;">로그인이 필요한 서비스입니다! 로그인해주세요 :)</p>
        <p v-else-if="!notDecidedYet" class="footerText" style="margin-top: 50px; margin-right: 30px;">이미 이전에 취향을 정하셨어요! 다시 하실건가요???</p>

        <div v-if="!notDecidedYet && isLoggedIn" style="margin-right: 30px">
            <v-btn :loading="loading" class="ma-1 footerText" x-large color="error" plain @click="confirm">
                네!
            </v-btn>
            <v-btn :loading="disabled" class="ma-1 footerText" x-large color="error" plain @click="goBack">
                BACK
            </v-btn>
        </div>

        <div v-if="isLoggedIn" style="margin-top: 30px;">
            <p class="description" style="margin-right: 25px;">선택하신 사항에 따라 좋아하실만한 공연을 추천해드립니다!</p>
            <p class="description" style="margin-right: 25px;">편하게 선택해주세요~</p>
        </div>
    </div>
</template>

<script>
import axios from 'axios'

import { mapActions, mapState } from 'vuex'
import PreferenceBox from '@/components/memberPage/PreferenceBox'

export default {
    name: 'PreferenceFillInPage',
    components: {
        PreferenceBox
    },
    computed: {
        ...mapState(['isLoggedIn', 'userProfile', 'notDecidedYet'])
    },
    methods: {
        ...mapActions(['fetchAlreadyDecidePrefOrNot']),

        onComplete(payload) {
            
            const memberNo = this.$store.state.userProfile.memberNo
            const { chosenGenres, speedTaste, atmosphereTaste, chosenArtists } = payload

            axios.post('http://localhost:8888/member/taste/postTaste', { memberNo, chosenGenres, speedTaste, atmosphereTaste, chosenArtists })
                .then(() => {
                    alert('취향이 등록되었습니다! 빠른 시일 내에 반영시키도록하겠습니다. :)')

                    this.$router.push({
                        name: 'MainPage'
                    })
                })
        },
        goBack() {
            this.$router.push({
                name: 'MainPage'
            })
        },
        confirm() {
            this.$store.state.notDecidedYet = true
        }
    },
    mounted() {
        this.$store.state.userProfile = this.$cookies.get("currentUser")

        this.fetchAlreadyDecidePrefOrNot(this.$store.state.userProfile.memberNo)

        if(this.$store.state.userProfile.id != '') {

            this.$store.state.isLoggedIn = true
            this.$store.state.userIdentity = this.$store.state.userProfile.identity

            this.fetchAlreadyDecidePrefOrNot(this.$store.state.userProfile.memberNo)
            //alert(this.notDecidedYet)
        }
    }
}
</script>

<style>

.genreText {
    font-size: 25px;
    padding-top: 15px;
}

</style>