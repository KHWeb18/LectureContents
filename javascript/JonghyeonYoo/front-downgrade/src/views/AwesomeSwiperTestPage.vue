<template>
  <div>
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
        <div class="swiper-pagination" slot="pagination"></div>
      </swiper>
    </v-container>
  </div>
  
</template>

<script>
import { Swiper, SwiperSlide } from "vue-awesome-swiper";
import "swiper/css/swiper.css";

export default {
  name: "AwesomeSwiperTestPage",
  components: {
    Swiper,
    SwiperSlide,
  },
  data() {
    return {
      swiperOption: {
        loop: true, // 반복 처음부터 끝까지 돌고 다시 처음으로
        effect: "coverflow",
        grabCursor: true,
        centeredSlides: true,
        slidesPerView: "auto",
        coverflowEffect: {
          rotate: 50,
          stretch: 0,
          depth: 100,
          // 넘길때 슬라이드의 회전을 먹이는 것. 높을수록 많이 먹는다
          // 그 대신 폭이 좁아짐
          // 아예 안주면 회전이없어서 다 붙어있음 (일직선)
          modifier: 1,
          slideShadows: true,
        },
        pagination: {
          el: ".swiper-pagination",
          dynamicBullets: true
        },
        autoplay: {  // 슬라이드 자동넘김
            delay: 1500
        }
      },
    };
  },
};
</script>

 <style lang="scss" scoped>
 .img{width: 300px; height: 400px;}
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
    background-color: rgb(226, 214, 145);
    background-position: center;
    background-size: cover;
  }
}
</style>