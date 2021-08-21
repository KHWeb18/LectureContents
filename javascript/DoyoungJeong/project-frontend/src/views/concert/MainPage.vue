<template>
    <div class="grey darken-3">
        <br>
        
        <div align="center" style="margin-top: -20px;">
            <img class="responsive-img" id="bigImg" src="@/assets/img/wall2.jpg" width="100%" style="margin-bottom: -6px;">
        </div>
        <hr>
        <div class="row" style="margin-bottom: -20px;"> 
            <genre-dialogue style="margin-top: 12px;" class="col xs4 sm4 md4 lg4"/>    
            <artist-dialogue class="col xs4 sm4 md4 lg4"/> 
            <date-dialogue class="col xs4 sm4 md4 lg4"/>                        
        </div>

        <div>
            <div class="row" style="width: 101%;">
                <div style="position: relative;" v-on:mouseover="turnOnColor(1)" v-on:mouseout="turnOffColor"  @click="showInfoBar(1)">
                    <img v-if="onColor == false || imgNum != 1" class="responsive-img" id="bigImg" 
                    src="@/assets/img/flyingDog.jpg">

                    <img v-else-if="onColor == true && imgNum == 1" class="responsive-img" id="bigColorImg" 
                    src="@/assets/img/flyingDog.jpg">

                    <div v-if="(onColor == false || imgNum != 1) && !wideOffLetters">
                        <div id="imgTitle">Flying-Dog</div>
                        <div id="location">Club FF</div>
                        <div id="date">08-20-2021</div>                 
                    </div>   
                    <div v-else-if="onColor == true && imgNum == 1">
                        <div id="imgTitleBlur">Flying-Dog</div>
                        <div id="locationBlur">Club FF</div>
                        <div id="dateBlur">08-20-2021</div>                 
                    </div>                    
                </div>
                <div style="position: relative;" v-on:mouseover="turnOnColor(2)" v-on:mouseout="turnOffColor"  @click="showInfoBar(2)">
                    <img v-if="onColor == false || imgNum != 2" class="responsive-img" id="bigImg"
                     src="@/assets/img/kidmili.jpg">

                    <img v-else-if="onColor == true && imgNum == 2" class="responsive-img" id="bigColorImg"
                     src="@/assets/img/kidmili.jpg">

                    <div v-if="onColor == false || imgNum != 2 && !wideOffLetters">
                        <div id="imgTitle">Kid Milli</div>
                        <div id="location">NB2</div>
                        <div id="date">08-18-2021</div> 
                    </div>    
                    <div v-else-if="onColor == true && imgNum == 2">
                        <div id="imgTitleBlur">Kid Milli</div>
                        <div id="locationBlur">NB2</div>
                        <div id="dateBlur">08-18-2021</div> 
                    </div>    
                </div>
                <div style="position: relative;" v-on:mouseover="turnOnColor(3)" v-on:mouseout="turnOffColor" @click="showInfoBar(3)">
                    <img v-if="onColor == false || imgNum != 3" class="responsive-img" id="bigImg" 
                    src="@/assets/img/messgram.jpg">

                    <img v-else-if="onColor == true && imgNum == 3" class="responsive-img" id="bigColorImg" 
                     src="@/assets/img/messgram.jpg">

                    <div v-if="onColor == false || imgNum != 3 && !wideOffLetters">
                        <div id="imgTitle">Mess<br>Gram</div>
                        <div id="location">RollingStones</div>
                        <div id="date">08-19-2021</div> 
                    </div>
                    <div v-else-if="onColor == true && imgNum == 3">
                        <div id="imgTitleBlur">Mess<br>Gram</div>
                        <div id="locationBlur">RollingStones</div>
                        <div id="dateBlur">08-19-2021</div> 
                    </div>
                </div>
                <div style="position: relative;"  v-on:mouseover="turnOnColor(4)" v-on:mouseout="turnOffColor" @click="showInfoBar(4)">
                    <img v-if="onColor == false || imgNum != 4" class="responsive-img" id="bigImg" 
                    src="@/assets/img/crackshot.jpg">

                    <img v-else-if="onColor == true || imgNum != 4" class="responsive-img" id="bigColorImg" 
                    src="@/assets/img/crackshot.jpg">

                    <div v-if="onColor == false || imgNum != 4 && !wideOffLetters">
                        <div id="imgTitle">Crack<br>Shot</div>
                        <div id="location">RollingStones</div>
                        <div id="date">08-19-2021</div> 
                    </div>
                    <div v-else-if="onColor == true && imgNum == 4">
                        <div id="imgTitleBlur">Crack<br>Shot</div>
                        <div id="locationBlur">RollingStones</div>
                        <div id="dateBlur">08-19-2021</div> 
                    </div>
                </div>
            </div>
            
        </div>
        <!-- 반응형으로 줄어들긴하는데 아주 창을 줄여야 작아짐 -->

        <information-box v-if="concert" v-bind:infoBar="infoBar" v-bind:concert="concert" v-on:offInfoBox="removeInfoBar"/>
     
    </div>
</template>

<script>
import GenreDialogue from '@/components/concertMainDialogue/GenreDialogue'
import ArtistDialogue from '@/components/concertMainDialogue/ArtistDialogue'
import DateDialogue from '@/components/concertMainDialogue/DateDialogue'

import InformationBox from '@/components/concertMainPage/InformationBox'


import { mapState, mapActions } from 'vuex'

export default {
    name: 'MainPage',
    
    components: {
        GenreDialogue,
        ArtistDialogue,
        DateDialogue,
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
        },
        removeInfoBar() {
            this.infoBar = false
            this.wideColorChange = true
            this.wideOffLetters = false
        }
    },
    computed: {
        ...mapState(['concert', 'userProfile'])
    }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@1,900&display=swap');

#topBar {
    font-style: italic;
    margin-right: 25px;
    color: white;
}

#inputBar {
    font-style: italic;
    font-size: 8;
    color: white;
}

#imgTitle {
    position: absolute; 
    text-align: center; 
    left: 50%;
    top: 40%;
    transform: translate(-50%, -50%);
    color: #EAEAEA;
    font-family: 'Roboto', sans-serif;
    font-style: italic;
    font-size: 85px;
    line-height: 90px;
}

#location {
    position: absolute; 
    text-align: center; 
    left: 50%;
    top: 75%;
    transform: translate(-50%, -50%);
    color: #EAEAEA;
    font-family: 'Roboto', sans-serif;
    font-style: italic;
    font-size: 30px;
    line-height: 120px;
}

#date {
    position: absolute; 
    text-align: center; 
    left: 50%;
    top: 82%;
    transform: translate(-50%, -50%);
    color: #EAEAEA;
    font-family: 'Roboto', sans-serif;
    font-style: italic;
    font-size: 30px;
    line-height: 120px;
}

#imgTitleBlur {
    position: absolute; 
    text-align: center; 
    left: 50%;
    top: 40%;
    transform: translate(-50%, -50%);
    color: #EAEAEA;
    font-family: 'Roboto', sans-serif;
    font-style: italic;
    font-size: 85px;
    line-height: 90px;
    filter: blur(5px);
    color: rgba(0, 0, 0, 0.3);
}

#locationBlur {
    position: absolute; 
    text-align: center; 
    left: 50%;
    top: 75%;
    transform: translate(-50%, -50%);
    color: #EAEAEA;
    font-family: 'Roboto', sans-serif;
    font-style: italic;
    font-size: 30px;
    line-height: 120px;
    filter: blur(5px);
    color: rgba(0, 0, 0, 0.3);
}

#dateBlur {
    position: absolute; 
    text-align: center; 
    left: 50%;
    top: 82%;
    transform: translate(-50%, -50%);
    color: #EAEAEA;
    font-family: 'Roboto', sans-serif;
    font-style: italic;
    font-size: 30px;
    line-height: 120px;
    filter: blur(5px);
    color: rgba(0, 0, 0, 0.3);
}

#bigImg {
    filter: blur(1px) grayscale(100%); 
    opacity: 0.6;
}

</style>
