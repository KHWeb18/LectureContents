<template>
    <div class="slide-3d">
        <v-spacer></v-spacer>
        <v-container>
            <swiper class="swiper" :options="swiperOption">
                <swiper-slide class="swiper-slide" :key="banner" v-for="banner in banners">
                    <img :src="banner">
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
    name: 'AwesomeSwiperTestPage',
    components: {
        Swiper,
        SwiperSlide
    },
    data () {
        return {
            banners: [ 
                require('@/assets/imgs/test2.jpg'),
                require('@/assets/imgs/test2.jpg'),
                require('@/assets/imgs/test2.jpg'),
            ],
            swiperOption: {
                loop: true,
                effect: 'slide',
                grabCursor: true,
                centeredSlides: true,
                slidesPerView: 'auto',
                coverflowEffect: {
                    rotate: 5,
                    stretch: 0,
                    depth: 100,
                    // 회전 많이 맥이고 싶으면 높을수록 많이 돌아가고
                    // 그 대신 폭은 작아짐
                    // 아예 안주면 회전이 없어져서 일직선임
                    modifier: 1,
                    slideShadows: true
                },
                pagination: {
                    el: '.swiper-pagination',
                    //dynamicBullets: true
                },
                autoplay: {
                    delay: 1800
                }
            }
        }
    }
}
</script>

<style lang="scss" scoped>
.slide-3d {
    width: 100%;
    height: 400px;
    padding-top: 0px;
    padding-bottom: 50px;
}
.swiper {
    height: 100%;
    width: 100%;
    .swiper-slide {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 1000px;
        height: 400px;
        text-align: center;
        font-weight: bold;
        font-size: 1.7rem;
        background-color: white;
        background-position: center;
        background-size: cover;
    }
}
</style>