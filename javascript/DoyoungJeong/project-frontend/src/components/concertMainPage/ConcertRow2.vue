<template>
    <div style="margin-top: 40px;">

        <div>
            <div class="row" style="width: 101%;">
                <div style="position: relative; width: 25%" v-on:mouseover="turnOnColor(5)" v-on:mouseout="turnOffColor"  @click="showInfoBar(5)">
                    <img v-if="onColor == false || imgNum != 5" class="responsive-img bigImg"
                    src="@/assets/img/박소은.jpeg">

                    <img v-else-if="onColor == true && imgNum == 5" class="responsive-img bigColorImg"
                    src="@/assets/img/박소은.jpeg">

                    <div v-if="(onColor == false || imgNum != 5) && !wideOffLetters">
                        <div class="imgTitle d-none d-lg-block">Park So-Eun</div>
                        <div class="location d-none d-lg-block">Acoustic-Holic</div>
                        <div class="date d-none d-lg-block">09-03-2021</div>                 
                    </div>   
                    <div v-else-if="onColor == true && imgNum == 5">
                        <div class="imgTitleBlur d-none d-lg-block">Park So-Eun</div>
                        <div class="locationBlur d-none d-lg-block">Acoustic-Holic</div>
                        <div class="dateBlur d-none d-lg-block">09-03-2021</div>                
                    </div>                    
                </div>

                <div style="position: relative; width: 25%" v-on:mouseover="turnOnColor(6)" v-on:mouseout="turnOffColor"  @click="showInfoBar(6)">
                    <img v-if="onColor == false || imgNum != 6" class="responsive-img bigImg"
                    src="@/assets/img/RollingQuartz.jpeg">

                    <img v-else-if="onColor == true && imgNum == 6" class="responsive-img bigColorImg"
                    src="@/assets/img/RollingQuartz.jpeg">

                    <div v-if="(onColor == false || imgNum != 6) && !wideOffLetters">
                        <div class="imgTitle d-none d-lg-block">Rolling Quartz</div>
                        <div class="location d-none d-lg-block">RollingStones</div>
                        <div class="date d-none d-lg-block">09-03-2021</div>                 
                    </div>   
                    <div v-else-if="onColor == true && imgNum == 6">
                        <div class="imgTitleBlur d-none d-lg-block">Rolling Quartz</div>
                        <div class="locationBlur d-none d-lg-block">RollingStones</div>
                        <div class="dateBlur d-none d-lg-block">09-03-2021</div>                
                    </div>                    
                </div>

                <div style="position: relative; width: 25%" v-on:mouseover="turnOnColor(7)" v-on:mouseout="turnOffColor"  @click="showInfoBar(7)">
                    <img v-if="onColor == false || imgNum != 7" class="responsive-img bigImg"
                    src="@/assets/img/OceanFromTheBlue.jpeg">

                    <img v-else-if="onColor == true && imgNum == 7" class="responsive-img bigColorImg"
                    src="@/assets/img/OceanFromTheBlue.jpeg">

                    <div v-if="(onColor == false || imgNum != 7) && !wideOffLetters">
                        <div class="imgTitle d-none d-lg-block" style="font-size: 70px; line-height: 75px;">Ocean From The Blue</div>
                        <div class="location d-none d-lg-block">Jammers</div>
                        <div class="date d-none d-lg-block">09-10-2021</div>                 
                    </div>   
                    <div v-else-if="onColor == true && imgNum == 7">
                        <div class="imgTitleBlur d-none d-lg-block" style="font-size: 70px; line-height: 75px;">Ocean From The Blue</div>
                        <div class="locationBlur d-none d-lg-block">Jammers</div>
                        <div class="dateBlur d-none d-lg-block">09-10-2021</div>                
                    </div>                    
                </div>

                <div style="position: relative; width: 25%" v-on:mouseover="turnOnColor(8)" v-on:mouseout="turnOffColor"  @click="showInfoBar(8)">
                    <img v-if="onColor == false || imgNum != 8" class="responsive-img bigImg"
                    src="@/assets/img/김심야.jpg">

                    <img v-else-if="onColor == true && imgNum == 8" class="responsive-img bigColorImg"
                    src="@/assets/img/김심야.jpg">

                    <div v-if="(onColor == false || imgNum != 8) && !wideOffLetters">
                        <div class="imgTitle d-none d-lg-block">Kim-Sim-Yah</div>
                        <div class="location d-none d-lg-block">Club Soap</div>
                        <div class="date d-none d-lg-block">09-11-2021</div>                 
                    </div>   
                    <div v-else-if="onColor == true && imgNum == 8">
                        <div class="imgTitleBlur d-none d-lg-block">Kim-Sim-Yah</div>
                        <div class="locationBlur d-none d-lg-block">Club Soap</div>
                        <div class="dateBlur d-none d-lg-block">09-11-2021</div>                
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

            EventBus.$emit('removeInfoBarExceptRow2')
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


