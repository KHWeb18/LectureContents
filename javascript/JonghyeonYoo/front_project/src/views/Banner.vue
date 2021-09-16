<template>
  <swiper class="swiper" :options="swiperOption">

    
    <swiper-slide><a href="BlackWidow"><img src="@/assets/img/블랙위도우.png"></a></swiper-slide>

    <swiper-slide><a href="HarryPotter"><img src="@/assets/img/해리포터 배너.png" /></a></swiper-slide>
    <swiper-slide><a href="WatchMen"><img src="@/assets/img/왓치맨 배너.png" /></a></swiper-slide>
    <div class="swiper-pagination" slot="pagination"></div>
    <div class="swiper-button-prev" slot="button-prev"></div>
    <div class="swiper-button-next" slot="button-next"></div>
  </swiper>
</template>

<script>
import { Swiper, SwiperSlide } from "vue-awesome-swiper";
import "swiper/css/swiper.css";

export default {
  name: "Banner",
  components: {
    Swiper,
    SwiperSlide,
  },
  data() {
    return {
      swiperOption: {
        slidesPerView: 3,
        spaceBetween: 30,
        loop: true,
        grabCursor: false,
        pagination: {
          el: ".swiper-pagination",
          clickable: true,
        },
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
        autoplay: {
          delay: 3000,
        },
      },
    };
  },
};
</script>

 <style lang="scss" scoped>
.swiper-slide {
  padding-top: 100px;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  font-weight: bold;
}

.swiper-slide img {
  display: block;
  width: 100%;
  height: 100%;
  object-fit: cover;
}
.swiper-button-next,
.swiper-button-prev {
  position: absolute;
  color: white;
}
.swiper-pagination {
  padding: 20px;
  display: flex;
  position: static;
  justify-content: center;
  align-items: center;
  text-align: center;
  width: auto;

  vertical-align: middle;
}


</style>