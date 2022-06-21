<template>
    <div style="padding-top: 200px;">
        
        <v-container>
            <swiper class="swiper" :options="swiperOption">
                <swiper-slide><img class="responsive-img" src="@/assets/img/liam.jpeg"></swiper-slide>
                <swiper-slide>슬라이드2</swiper-slide>
                <swiper-slide>슬라이드3</swiper-slide>
                <swiper-slide>슬라이드4</swiper-slide>
                <swiper-slide>슬라이드5</swiper-slide>
                <swiper-slide>슬라이드6</swiper-slide>
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
    data() {
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
                    modifier: 1,
                    //modifier가 0이면 그냥 사진 슬라이드느낌
                    slideShadows: true
                },
                pagination: {
                    el: '.swiper-pagination'
                },
                autoplay: {
                    delay: 8000
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
        justify-content: center; //안에 문자 가운데정렬
        align-items: center;
        width: 400px;
        height: 400px;
        text-align: center;
        font-weight: bold;
        font-size: 1.6rem;
        background-color: mediumturquoise;
        background-position: center;
        background-size: cover;
        

    }
}
</style>
