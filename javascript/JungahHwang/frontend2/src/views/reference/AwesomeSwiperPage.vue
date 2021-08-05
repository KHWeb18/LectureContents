<template>
  <div class="swiper-3d">
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
        <div class="swiper-pagination" slot="pagination"></div>
      </swiper>
    </v-container>
  </div>
</template>


<script>
import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
import 'swiper/css/swiper.css'

export default {
  name: 'AwesomeSwiperPage',
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
          // modifier: 회전을 많이 주고 싶으면 숫자를 높임, 대신 폭이 좁아짐
          modifier: 1,
          slideShadows: true
        },
        pagination: {
          el: '.swiper-pagination',
          // dynamicBullets: true
        },
        // 자동으로 넘어가는 기능 1초 = 1000
        autoplay: {
          delay: 1000
        }
      }
    }
  }
}
</script>


<style class="scss" scoped>
.swiper-3d {
  width: 100%;
    height: 400px;
    padding-top: 50px;
    padding-bottom: 50px;
}
.swiper {
  height: 100%;
  width: 100%;
}
.swiper-slide {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 300px;
  height: 300px;
  font-weight: bold;
  background-color: pink;
  color: white;
}
.swiper-pagination >>> .swiper-pagination-bullet {
  /* opacity: 나머지 bullet 을 불투명하게 (안쓰는게 이쁜 것 같음) */
  opacity: 1;
  border: white solid 1px;
  /* bullet 색: 투명하게 */
  background-color: transparent;
}
.swiper-pagination >>> .swiper-pagination-bullet-active {
  /* 선택된 bullet 색상 */
  background-color: white;
}
</style>