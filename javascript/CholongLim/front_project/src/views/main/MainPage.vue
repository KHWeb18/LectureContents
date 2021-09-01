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

h1 {
    margin: 10px;
}

h2 {
    font-family: 'MonteCarlo';
    font-size: 200px;
    color:white;
    text-shadow: 3px 2px 2px rgb(5, 68, 119);
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