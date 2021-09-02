<template>
    <div style="margin-top: 40px;">

        <div>
            <div class="row" style="width: 101%;">
                <div style="position: relative; width: 25%" v-on:mouseover="turnOnColor(9)" v-on:mouseout="turnOffColor" @click="showInfoBar(9)">
                    <img v-if="onColor == false || imgNum != 9" class="responsive-img bigImg"
                    src="@/assets/img/DJ팁토.jpg">

                    <img v-else-if="onColor == true && imgNum == 9" class="responsive-img bigColorImg"
                    src="@/assets/img/DJ팁토.jpg">

                    <div v-if="(onColor == false || imgNum != 9) && !wideOffLetters">
                        <div class="imgTitle d-none d-lg-block">DJ TipToe</div>
                        <div class="location d-none d-lg-block">Cakeshop</div>
                        <div class="date d-none d-lg-block">09-12-2021</div>                 
                    </div>   
                    <div v-else-if="onColor == true && imgNum == 9">
                        <div class="imgTitleBlur d-none d-lg-block">DJ TipToe</div>
                        <div class="locationBlur d-none d-lg-block">Cakeshop</div>
                        <div class="dateBlur d-none d-lg-block">09-12-2021</div>                
                    </div>                    
                </div>

                <div style="position: relative; width: 25%" v-on:mouseover="turnOnColor(10)" v-on:mouseout="turnOffColor" @click="showInfoBar(10)">
                    <img v-if="onColor == false || imgNum != 10" class="responsive-img bigImg"
                    src="@/assets/img/이준형.jpeg">

                    <img v-else-if="onColor == true && imgNum == 10" class="responsive-img bigColorImg"
                    src="@/assets/img/이준형.jpeg">

                    <div v-if="(onColor == false || imgNum != 10) && !wideOffLetters">
                        <div class="imgTitle d-none d-lg-block">Lee Jun Hyung</div>
                        <div class="location d-none d-lg-block">All-Of-Rock</div>
                        <div class="date d-none d-lg-block">09-12-2021</div>                 
                    </div>   
                    <div v-else-if="onColor == true && imgNum == 10">
                        <div class="imgTitleBlur d-none d-lg-block">Lee Jun Hyung</div>
                        <div class="locationBlur d-none d-lg-block">All-Of-Rock</div>
                        <div class="dateBlur d-none d-lg-block">09-12-2021</div>                
                    </div>                    
                </div>

                <div style="position: relative; width: 25%" v-on:mouseover="turnOnColor(11)" v-on:mouseout="turnOffColor" @click="showInfoBar(11)">
                    <img v-if="onColor == false || imgNum != 11" class="responsive-img bigImg"
                    src="@/assets/img/Surl.jpg">

                    <img v-else-if="onColor == true && imgNum == 11" class="responsive-img bigColorImg"
                    src="@/assets/img/Surl.jpg">

                    <div v-if="(onColor == false || imgNum != 11) && !wideOffLetters">
                        <div class="imgTitle d-none d-lg-block" style="font-size: 120px;">Surl</div>
                        <div class="location d-none d-lg-block">Prism-Hall</div>
                        <div class="date d-none d-lg-block">09-12-2021</div>                 
                    </div>   
                    <div v-else-if="onColor == true && imgNum == 11">
                        <div class="imgTitleBlur d-none d-lg-block" style="font-size: 120px;">Surl</div>
                        <div class="locationBlur d-none d-lg-block">Prism-Hall</div>
                        <div class="dateBlur d-none d-lg-block">09-12-2021</div>                
                    </div>                    
                </div>

                <div style="position: relative; width: 25%" v-on:mouseover="turnOnColor(12)" v-on:mouseout="turnOffColor" @click="showInfoBar(12)">
                    <img v-if="onColor == false || imgNum != 12" class="responsive-img bigImg"
                    src="@/assets/img/Net Gala.jpg">

                    <img v-else-if="onColor == true && imgNum == 12" class="responsive-img bigColorImg"
                    src="@/assets/img/Net Gala.jpg">

                    <div v-if="(onColor == false || imgNum != 12) && !wideOffLetters">
                        <div class="imgTitle d-none d-lg-block">Net Gala</div>
                        <div class="location d-none d-lg-block">Voful</div>
                        <div class="date d-none d-lg-block">09-18-2021</div>                 
                    </div>   
                    <div v-else-if="onColor == true && imgNum == 12">
                        <div class="imgTitleBlur d-none d-lg-block">Net Gala</div>
                        <div class="locationBlur d-none d-lg-block">Voful</div>
                        <div class="dateBlur d-none d-lg-block">09-18-2021</div>                
                    </div>                    
                </div>
            </div>

        </div>
        <hr>
        <information-box v-if="concert" v-bind:infoBar="infoBar" v-bind:concert="concert" v-on:offInfoBox="removeInfoBar"/>
    </div>
</template>

<script>
import EventBus from '@/eventBus.js'
import { mapActions, mapState } from 'vuex'

import InformationBox from '@/components/concertMainPage/InformationBox'

export default {
    name: 'ConcertRow3',
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
        ...mapActions(['fetchConcert', 'fetchLikedOrNot']),

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

            EventBus.$emit('removeInfoBarExceptRow3')
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
        EventBus.$on('removeInfoBarExceptRow1', () => {
            this.infoBar = false

            this.wideColorChange = false
            this.wideOffLetters = true
            this.onColor = false
        })

        EventBus.$on('removeInfoBarExceptRow2', () => {
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
