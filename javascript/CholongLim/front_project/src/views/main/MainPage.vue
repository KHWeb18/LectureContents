<!-- <template>
    <div class="slide-3d">
        <v-container class="slide-3d" fluid ma-0 pa-0 fill-height>
            <swiper class="swiper" :options="swiperOption"
            v-for="image in images" :key="image">
                <swiper-slide>
                    <v-img :src="image" max-height="100%">
                    </v-img>
                </swiper-slide>
                <div class="swiper-pagination" slot="pagination">
                </div>
            </swiper>
        </v-container>
    </div>

</template> -->

<template>
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

                "https://images.pexels.com/photos/2507011/pexels-photo-2507011.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
                "https://images.pexels.com/photos/3201917/pexels-photo-3201917.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
                "https://images.pexels.com/photos/2507010/pexels-photo-2507010.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
                "https://images.pexels.com/photos/2506990/pexels-photo-2506990.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
                "https://images.pexels.com/photos/2507014/pexels-photo-2507014.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
                "https://images.pexels.com/photos/189296/pexels-photo-189296.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
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
                loop: true,
                effect: 'coverflow',
                calculateHeight:true,
                grabCursor: true,
                centeredSlides: true,
                slidesPerView: 'auto',
                coverflowEffect: {
                    // rotate: 50,
                    stretch: 0,
                    depth: 100,
                    // 회전 많이하고 싶으면 높을수록 많이 돌아가고
                    // 그 대신 폭이 작아짐
                    // 아예 0으로 두면 회전이 없어져서 일직선이다
                    modifier: 0,
                    slideShadows: true
                },
                pagination: {
                    el: '.swiper-pagination'
                    //dynamicBullets: true
                },
                autoplay: {
                    delay: 3000
                    // 1000(1초)
                }
            }
        }
    }
}

</script>


<style lang="scss" scoped>

h1 {
    margin: 10px;
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
        //display: flex;
        justify-content: center;
        align-items: center;
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