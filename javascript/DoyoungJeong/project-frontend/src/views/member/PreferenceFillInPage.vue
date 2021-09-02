<template>
    <div align="center" class="grey darken-0.1" style="height: 100%;">
        <h3 class="topBar" style="margin-top: 0px; padding-top: 30px;">PRFERENCE</h3>
        <p class="description" style="margin-right: 25px;">공연을 선택하는데 어려움이 있나요??? 고객님의 취향에 맞게 장르와 아티스트를 선택해보세요! :)</p>

        <preference-box v-if="isLoggedIn" style="margin-top: 30px;"/>
        <p v-else-if="!isLoggedIn" class="footerText" style="margin-top: 50px;">로그인이 필요한 서비스입니다! 로그인해주세요 :)</p>

        <div v-if="isLoggedIn" style="margin-top: 30px;">
            <p class="description" style="margin-right: 25px;">선택하신 사항에 따라 좋아하실만한 공연을 추천해드립니다!</p>
            <p class="description" style="margin-right: 25px;">편하게 선택해주세요~</p>
        </div>
    </div>
</template>

<script>
import { mapState } from 'vuex'
import PreferenceBox from '@/components/memberPage/PreferenceBox'

export default {
    name: 'PreferenceFillInPage',
    components: {
        PreferenceBox
    },
    computed: {
        ...mapState(['isLoggedIn'])
    },
    methods: {
    }
}
</script>

<style>

.genreText {
    font-size: 25px;
    padding-top: 15px;
}

</style>