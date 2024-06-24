<template>
    <div>
        <v-spacer></v-spacer>
        <v-container>
            <swiper class="swiper" :options="swiperOption">
                <!--사이에 이미지 태그 넣으면 된다-->
                <swiper-slide>슬라이드1</swiper-slide>
                <swiper-slide>슬라이드2</swiper-slide>
                <swiper-slide>슬라이드3</swiper-slide>
                <swiper-slide>슬라이드4</swiper-slide>
                <swiper-slide>슬라이드5</swiper-slide>
                <swiper-slide>슬라이드6</swiper-slide>
                <swiper-slide>슬라이드7</swiper-slide>
                <swiper-slide>슬라이드8</swiper-slide>
                <swiper-slide>슬라이드9</swiper-slide>
                <swiper-slide>슬라이드10</swiper-slide>
                <swiper-slide>슬라이드11</swiper-slide>
                <swiper-slide>슬라이드12</swiper-slide>
                <div class="swiper-pagination" slot="pagination">
                </div>
            </swiper>
        </v-container>
    </div>
</template>


<script>

import {Swiper, SwiperSlide } from 'vue-awesome-swiper'
import 'swiper/css/swiper.css'

export default {
    name: 'AwesomeSwiperTestPage',
    components:{
        Swiper,
        SwiperSlide
    },
    data (){
        return{
            swiperOption: {
                loop: true,//끝에서 다시 처음으로 돌아감
                //자동으로 넘어감
                autoplay:{
                    delay: 2000
                },
                effect: 'coverflow',
                grabCursor: true,
                centeredSlides: true,
                slidesPerView: 'auto',
                coverflowEffect:{
                    rotate: 50,
                    stretch:-10,
                    // depth: 회전 많이 넣고 싶으면 많이 돌아가고 그대신 폭은 작아짐
                    depth: 3,
                    //회전이 없어져서 일직선임 슬라이드간 구분없이 감 
                    modifier: 1,
                    slideShadows: true
                },
                pagination:{
                    el: '.swiper-pagination',
                    dynamicBullets: true //갯수가 많을때 밑에 동그라미 줄여준다
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
        background-color: #bb86ff;
        background-position: center;
        background-size: cover;
    }
}
</style>