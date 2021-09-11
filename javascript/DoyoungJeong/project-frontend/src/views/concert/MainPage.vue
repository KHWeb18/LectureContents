<template>
    <div class="grey darken-3" style="height: 100%;">
        <br>
        
        <div align="center" style="margin-top: -20px;">
            <img class="responsive-img bigImg" src="@/assets/img/wall2.jpg" width="100%" style="margin-bottom: -6px;">
        </div>
        <hr>
        <div class="row" style="margin-bottom: -20px;"> 
            <genre-dialogue style="margin-top: 12px;" class="col xs4 sm4 md4 lg4"/>    
            <artist-dialogue class="col xs4 sm4 md4 lg4"/> 
            <date-dialogue class="col xs4 sm4 md4 lg4"/>                        
        </div>

        <concert-row-1/>

        <concert-row-2/>

        <concert-row-3/>

        <main-page-footer/>
     
    </div>
</template>

<script>
import cookies from 'vue-cookies'
import Vue from 'vue'
Vue.use(cookies)

import { mapState } from 'vuex'

import GenreDialogue from '@/components/concertMainDialogue/GenreDialogue'
import ArtistDialogue from '@/components/concertMainDialogue/ArtistDialogue'
import DateDialogue from '@/components/concertMainDialogue/DateDialogue'

import ConcertRow1 from '@/components/concertMainPage/ConcertRow1'
import ConcertRow2 from '@/components/concertMainPage/ConcertRow2'
import ConcertRow3 from '@/components/concertMainPage/ConcertRow3'
import MainPageFooter from '@/components/concertMainPage/MainPageFooter'

export default {
    name: 'MainPage',
    
    components: {
        GenreDialogue,
        ArtistDialogue,
        DateDialogue,

        ConcertRow1,
        ConcertRow2,
        ConcertRow3,

        MainPageFooter
    },
    data() {
        return {
            nav_drawer: false,
        }
    },
    computed: {
        ...mapState(['isLoggedIn', 'userProfile', 'userIdentity'])
    },
    mounted() {
        this.$store.state.userProfile = this.$cookies.get("currentUser")

        if(this.$store.state.userProfile.id != '') {

            this.$store.state.isLoggedIn = true
            this.$store.state.userIdentity = this.$store.state.userProfile.identity
        } 
        //alert(this.$store.state.userProfile.id + ' ' + this.$store.state.userProfile.identity + ' ' + this.$store.state.userProfile.memberNo)
        //alert(JSON.stringify(this.$store.state.userProfile))

        //alert('isLoggedIn: ' + this.$store.state.isLoggedIn)
        //alert('currentUser ' + JSON.stringify(this.$cookies.get("currentUser")))
        //alert(JSON.stringify(this.$store.state.userProfile.id))
        //alert('userProfile ' + this.$store.state.userProfile)
    }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@1,900&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap');


.topBar {
    font-style: italic;
    margin-right: 25px;
    color: white;
}

.inputBar {
    font-style: italic;
    font-size: 8;
    color: white;
}

.imgTitle {
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

.location {
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

.date {
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

.imgTitleBlur {
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

.locationBlur {
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

.dateBlur {
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

.bigImg {
    filter: blur(1px) grayscale(100%); 
    opacity: 0.6;
}

</style>
