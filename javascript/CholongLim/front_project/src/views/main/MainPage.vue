<template>
    <div>
        
        <v-container class="container " fill-height>
            <v-layout align-center wrap>
            <h2 class="overlay">Hello <br>Cinzel</h2>
            </v-layout>
        </v-container>
        
        <div class="slide">
            <v-container class="slide">
              
                <swiper class="swiper" :options="swiperOption">
                    <swiper-slide v-for="image in images" :key="image">
                        <v-img :src="image" max-height="100%">
                        </v-img>
                    </swiper-slide>
                    <div class="swiper-pagination" slot="pagination">
                    </div>
                </swiper>
            </v-container>

            <v-container>
                <h3 style="font-size: 15px;">CINZEL ALL AROUND</h3>
                <p>자연속에서의 낭만같은 휴식이 있는 날들</p>
                <p>To travel hopefully is a better thing than to arrive.</p>
            </v-container>

            <v-divider></v-divider>

            <div class="main-colorbox">
            <v-row>
                <v-flex xs3 sm12 lg24>
                <div class="img-s">
                    <v-img style="overflow: visible" contain width="900px" height="600px"
                        src="https://images.pexels.com/photos/355580/pexels-photo-355580.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
                    </v-img>
                </div>
           
                <div style="float:left; width:600px; margin-top:8%;">
                    <h3 style="font-size: 45px; text-align:center; margin-bottom:0px;">SPECIAL DAY</h3>
                    <p style="margin-top:0%; font-size:12px;">break in time of life</p>
                    
                    <p style="margin-top:0%; font-size:14px;">파노라마같은 낭만적인 바다속에서 보내는 오늘은<br>
                        당신에게 특별한 선물을 가져다 주어요.<br></p>
                       <p> 당신이 원하던 삶 속 황홀한 휴식이 기다립니다.</p>
                       <div style="text-align:center;">
                       <v-btn text route :to="{name : 'Room301'}">
                            more<v-icon>navigate_next</v-icon></v-btn>
                            
                       </div>
                </div>
                </v-flex>
            </v-row>
            </div>

            <div>

            </div>
        </div>
    </div>
</template>



<script>

import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
import 'swiper/css/swiper.css'

export default {
    name: 'MainPage',
    components: {
        Swiper,
        SwiperSlide
    },
    data () {
        return {
            images: [
                "https://images.pexels.com/photos/912108/pexels-photo-912108.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/6010421/pexels-photo-6010421.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/2506988/pexels-photo-2506988.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/2771921/pexels-photo-2771921.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/1484516/pexels-photo-1484516.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/7245472/pexels-photo-7245472.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",

            ],
            links: [
                { 
                    icon: 'home', text: 'About', name: 'Home', route: '/'
                },
                { 
                    icon: 'account_circle', text: 'Rooms', name: 'account_circle', route: '/'
                },
                { 
                    icon: 'favorite', text: 'Special', name: 'favorite', route: '/'
                },
                { 
                    icon: 'favorite', text: 'Reservation', name: 'favorite', route: '/'
                },
                { 
                    icon: 'favorite', text: 'Board', name: 'favorite', route: '/'
                }
            ],
            swiperOption: {
                loopedSlides: 2,
                calculateHeight:true,
                grabCursor: true,
                centeredSlides: true,
                watchSlideProgress:true,
                pagination: {
                    el: '.swiper-pagination'
                },
                autoplay: {
                    delay: 3000
                }
            }
        }
    }
}

</script>


<style lang="scss" scoped>

.img-s{
    float: left;
}

.main-colorbox{
    margin: 3% 0% 3% 0%;
    background-color: #ececec;
}

.container{
    position: relative;
    padding: 0px;
}

.overlay{
    position: absolute;
    z-index: 9;
    margin-top: 60%;
    left: 30%;
    text-align: center;
}

p {
    font-family: 'Nanum Myeongjo';
    font-size: 18px;
    text-align: center;
    padding: 5px 0px 5px 0px;
}

h1 {
    margin: 10px;
}

h2 {
    font-family: 'MonteCarlo';
    font-size: 200px;
    color:white;
    text-shadow: 3px 2px 2px rgb(5, 68, 119);
}

h3 {
    font-family: "Cinzel";
    text-align: center;
    margin: 10% 0% 5% 0%;
}

p {
    padding: 10px;
    margin: 5px 10px;
}

.slide {
    padding-left: 0px;
    margin-left: 0px;
    padding-top: 0px;
}

.slide-3d {
    padding-top: 0px;
    padding-bottom: 0px;
}

.swiper {
    height: 94vh;
    width: 100vw;
    .swiper-slide {
        display: flex;
        justify-content: center;
        width: 100%;
        height: 100%;
        text-align: center;
        font-weight: bold;
        font-size: 3rem;
        background-color:lightsteelblue;
        background-position: center;
        background-size: center;
    }
}

</style>