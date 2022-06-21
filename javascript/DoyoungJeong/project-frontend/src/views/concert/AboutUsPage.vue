<template>
    <div align="center" class="grey darken-0.1" style="height: 100%;">
        <h3 class="topBar" style="margin-top: 0px; padding-top: 30px;">ABOUT US</h3>

        <p class="description">MUSIC GHUETTO는 고객분들과 아티스트를 더욱 가깝게합니다 :)</p>
        <br>
        <p class="description" style="margin-top: -28px;"
        >MUSIC GHUETTO는 수 많은 공연장들 그리고 아티스트들과 함께 일합니다. MUSIC GHUETTO에서 아티스트들과 더 가깝게 더 빠르게 함께하세요!</p>

        <v-container style="margin-top: 40px;">
        <v-row>
            <v-col v-for="(image, index) in images" :key="index" class="d-flex child-flex" cols="3" style="margin-bottom: 25px;">

                    <v-img :src="image" aspect-ratio="1" class="gery lighten-2 bigImg" v-on:mouseover="turnOnColor(index)" v-on:mouseout="turnOffColor"
                    v-if="onColor == false || imgNum != index">

                        <template v-slot:placeholder>
                            <v-row class="fill-height ma-0" align="center" justify="center">
                                <v-progress-circular indeterminate color="grey lighten-5">
                                </v-progress-circular>
                            </v-row>
                        </template>
                    </v-img>
                    
                    <v-img :src="image" aspect-ratio="1" class="gery lighten-2" v-on:mouseover="turnOnColor(index)" v-on:mouseout="turnOffColor"
                    v-else-if="onColor == true || imgNum != index">
                    
                        <template v-slot:placeholder>
                            <v-row class="fill-height ma-0" align="center" justify="center">
                                <v-progress-circular indeterminate color="grey lighten-5">
                                </v-progress-circular>
                            </v-row>
                        </template>
                    </v-img>

            </v-col>
        </v-row>
    </v-container>
        
    </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
    name: 'AboutUsPage',
    data () {
        return {
            images: [
                require('@/assets/img/히피토끼.jpg'),
                require('@/assets/img/AcousticHolic.jpg'),
                require('@/assets/img/ClubFF.jpg'),
                require('@/assets/img/PrismHall.jpg'),
                require('@/assets/img/Evans.jpg'),
                require('@/assets/img/AllOfRock.jpg'),
                require('@/assets/img/RollingHall.jpg'),
                require('@/assets/img/MuvHall.png'),
                require('@/assets/img/Convent.jpg'),
                require('@/assets/img/Veloso.jpg'),
                // "https://flutter-kr.io/images/flutter-logo-sharing.png", 링크로 넣을 경우
            ],

            onColor: false,
            imgNum: 0,
            infoBar: false,
            wideColorChange: true,
        }
    },
    methods: {
        turnOnColor(index) {
            if(this.wideColorChange) {
                this.onColor = true
                this.imgNum = index
            }
        },
        turnOffColor() {
            if (this.wideColorChange) { 
                this.onColor = false
                this.imgNum = 0
            } 
        }
    },
    computed: {
        ...mapState(['isLoggedIn'])
    },
    mounted() {
        this.$store.state.userProfile = this.$cookies.get("currentUser")

        if(this.$store.state.userProfile.id != '') {

            this.$store.state.isLoggedIn = true
            this.$store.state.userIdentity = this.$store.state.userProfile.identity
        }
    }
}
</script>

<style>

.bigImg {
    filter: blur(1px) grayscale(100%); 
    opacity: 0.6;
}

.imgDesc {
    position: absolute; 
    text-align: center; 
    left: 50%;
    top: 75%;
    transform: translate(-50%, -50%);
    color: #ff0062;
    font-family: 'Roboto', sans-serif;
    font-style: italic;
    font-size: 30px;
    line-height: 120px;
}

</style>