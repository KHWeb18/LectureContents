<template>
    <div>
            <div class="row" style="width: 101%;"> <!-- style에 width: 25%" 걸어두니까 화면 크기대로 작아짐 -->
                <div style="position: relative; width: 25%" v-on:mouseover="turnOnColor(1)" v-on:mouseout="turnOffColor"  @click="showInfoBar(1)"> 
                    <img v-if="onColor == false || imgNum != 1" class="responsive-img bigImg"
                    src="@/assets/img/flyingDog.jpg">

                    <img v-else-if="onColor == true && imgNum == 1" class="responsive-img bigColorImg"
                    src="@/assets/img/flyingDog.jpg">

                    <div v-if="(onColor == false || imgNum != 1) && !wideOffLetters">
                        <div class="imgTitle d-none d-lg-block">Flying-Dog</div>
                        <div class="location d-none d-lg-block">Club FF</div>
                        <div class="date d-none d-lg-block">08-20-2021</div>                 
                    </div>   
                    <div v-else-if="onColor == true && imgNum == 1">
                        <div class="imgTitleBlur d-none d-lg-block">Flying-Dog</div>
                        <div class="locationBlur d-none d-lg-block">Club FF</div>
                        <div class="dateBlur d-none d-lg-block">08-20-2021</div>                 
                    </div>                    
                </div>
                <div style="position: relative; width: 25%" v-on:mouseover="turnOnColor(2)" v-on:mouseout="turnOffColor"  @click="showInfoBar(2)">
                    <img v-if="onColor == false || imgNum != 2" class="responsive-img bigImg"
                     src="@/assets/img/kidmili.jpg">

                    <img v-else-if="onColor == true && imgNum == 2" class="responsive-img bigColorImg"
                     src="@/assets/img/kidmili.jpg">

                    <div v-if="(onColor == false || imgNum != 2) && !wideOffLetters">
                        <div class="imgTitle d-none d-lg-block">Kid Milli</div>
                        <div class="location d-none d-lg-block">NB2</div>
                        <div class="date d-none d-lg-block">08-18-2021</div> 
                    </div>    
                    <div v-else-if="onColor == true && imgNum == 2">
                        <div class="imgTitleBlur d-none d-lg-block">Kid Milli</div>
                        <div class="locationBlur d-none d-lg-block">NB2</div>
                        <div class="dateBlur d-none d-lg-block">08-18-2021</div> 
                    </div>    
                </div>
                <div style="position: relative; width: 25%" v-on:mouseover="turnOnColor(3)" v-on:mouseout="turnOffColor" @click="showInfoBar(3)">
                    <img v-if="onColor == false || imgNum != 3" class="responsive-img bigImg" 
                    src="@/assets/img/messgram.jpg">

                    <img v-else-if="onColor == true && imgNum == 3" class="responsive-img bigColorImg"
                     src="@/assets/img/messgram.jpg">

                    <div v-if="(onColor == false || imgNum != 3) && !wideOffLetters">
                        <div class="imgTitle d-none d-lg-block">Mess<br>Gram</div>
                        <div class="location d-none d-lg-block">RollingStones</div>
                        <div class="date d-none d-lg-block">08-19-2021</div> 
                    </div>
                    <div v-else-if="onColor == true && imgNum == 3">
                        <div class="imgTitleBlur d-none d-lg-block">Mess<br>Gram</div>
                        <div class="locationBlur d-none d-lg-block">RollingStones</div>
                        <div class="dateBlur d-none d-lg-block">08-19-2021</div> 
                    </div>
                </div>
                <div style="position: relative; width: 25%" v-on:mouseover="turnOnColor(4)" v-on:mouseout="turnOffColor" @click="showInfoBar(4)">
                    <img v-if="onColor == false || imgNum != 4" class="responsive-img bigImg"
                    src="@/assets/img/crackshot.jpg">

                    <img v-else-if="onColor == true || imgNum != 4" class="responsive-img bigColorImg" 
                    src="@/assets/img/crackshot.jpg">

                    <div v-if="(onColor == false || imgNum != 4) && !wideOffLetters">
                        <div class="imgTitle d-none d-lg-block">Crack<br>Shot</div>
                        <div class="location d-none d-lg-block">RollingStones</div>
                        <div class="date d-none d-lg-block">08-19-2021</div> 
                    </div>
                    <div v-else-if="onColor == true && imgNum == 4">
                        <div class="imgTitleBlur d-none d-lg-block">Crack<br>Shot</div>
                        <div class="locationBlur d-none d-lg-block">RollingStones</div>
                        <div class="dateBlur d-none d-lg-block">08-19-2021</div> 
                    </div>
                </div>
            </div>

        <hr>
        <information-box v-if="concert" v-bind:infoBar="infoBar" v-bind:concert="concert" v-on:offInfoBox="removeInfoBar"/>
            
        </div>
</template>

<script>
import cookies from 'vue-cookies'
import Vue from 'vue'
Vue.use(cookies)

import EventBus from '@/eventBus.js'
import InformationBox from '@/components/concertMainPage/InformationBox'

import { mapActions, mapState } from 'vuex'

export default {
    name: 'ConcertRow2',
    components: {
        InformationBox
    },
    data() {
        return {
            onColor: false,
            imgNum: 0,
            infoBar: false,
            wideColorChange: true,
            wideOffLetters: false,
            nav_drawer: false,

            memNoAndConNoArr:[]
        }
    },
    methods: {
        ...mapActions(['fetchConcert', 'fetchLikedOrNot', 'isLoggedIn']),

        turnOnColor(num) {
            if(this.wideColorChange) {
                this.onColor = true
                this.imgNum = num
            }
        },
        turnOffColor() {
            if (this.wideColorChange) { 
                this.onColor = false
                this.imgNum = 0
            } 
        },
        showInfoBar(num) {
            this.infoBar = true

            if(this.imgNum == num) {
                this.wideColorChange = false
            } else if(this.imgNum != num) {
                this.imgNum = num
            }
            this.wideOffLetters = true
            this.fetchConcert(num)

            this.memNoAndConNoArr.push(this.$store.state.userProfile.memberNo)
            this.memNoAndConNoArr.push(num)    
            this.fetchLikedOrNot(this.memNoAndConNoArr)

            this.memNoAndConNoArr = [] //초기화 필요

            EventBus.$emit('removeInfoBarExceptRow1')
            this.onColor = true
        },
        removeInfoBar() {
            this.infoBar = false
            this.wideColorChange = true
            this.wideOffLetters = false

            this.imgNum = 0

            EventBus.$emit('removeException')
        }
    },
    computed: {
        ...mapState(['concert', 'userProfile'])
    },
    updated() {
        EventBus.$on('removeInfoBarExceptRow2', () => {
            this.infoBar = false

            this.wideColorChange = false
            this.wideOffLetters = true
            this.onColor = false
        })

        EventBus.$on('removeInfoBarExceptRow3', () => {
            this.infoBar = false

            this.wideColorChange = false
            this.wideOffLetters = true
            this.onColor = false
        })

        EventBus.$on('removeException', () => {

            this.wideColorChange = true
            this.wideOffLetters = false
        })
    }
}
</script>
