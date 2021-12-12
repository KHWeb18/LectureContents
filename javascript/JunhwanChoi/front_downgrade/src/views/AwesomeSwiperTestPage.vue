<template>
    <div class="slide-3d">
        <v-spacer></v-spacer>
        <v-container>
            <swiper class="swiper" :options="swiperOption">
                <swiper-slide>슬라이드 1</swiper-slide>
                <swiper-slide>슬라이드 2</swiper-slide>
                <swiper-slide>슬라이드 3</swiper-slide>
                <swiper-slide>슬라이드 4</swiper-slide>
                <swiper-slide>슬라이드 5</swiper-slide>
                <swiper-slide>슬라이드 6</swiper-slide>
                <swiper-slide>슬라이드 7</swiper-slide>
                <swiper-slide>슬라이드 8</swiper-slide>
                <swiper-slide>슬라이드 9</swiper-slide>
                <swiper-slide>슬라이드 10</swiper-slide>
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
            swiperOption: {
                loop: true,
                effect: 'coverflow',
                grabCursor: true,
                centeredSlides: true,
                slidesPerView: 'auto',
                coverflowEffect: {
                    rotate: 50,
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
                    dynamicBullets: true
                },
                autoplay: {
                    delay: 1000
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
    padding-top: 50px;
    padding-bottom: 50px;
}
.swiper {
    height: 100%;
    width: 100%;
    .swiper-slide {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 300px;
        height: 300px;
        text-align: center;
        font-weight: bold;
        font-size: 1.7rem;
        background-color: mediumpurple;
        background-position: center;
        background-size: cover;
    }
}
</style>