<template>
  <div id="app">
    <banner></banner>
    <div class="content">
      <v-container>
        <div class="title">
          <h2 class="title-area">
            <span class="label">HBO 시리즈!</span>
            
          </h2>
        </div>

  <swiper class="swiper" :options="swiperOption">
    
    <swiper-slide><a href="GameOfThrones"><img src="@/assets/img/왕좌의게임8.jpg">
     <p class="name">왕좌의게임 시즌8</p></a></swiper-slide>
    <swiper-slide><a href="BandOfBrothers"><img src="@/assets/img/밴드오브브라더스.jpg" />
     <p class="name">밴드 오브 브라더스</p></a></swiper-slide>
    <swiper-slide><a href="Chernobyl"><img src="@/assets/img/체르노빌.jpg" />
    <p class="name">체르노빌</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/종이의집4.jpg" />
    <p class="name">종이의집 시즌4</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/더퍼시픽.jpg" />
    <p class="name">더 퍼시픽</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/왕좌의게임7.jpg" />
    <p class="name">왕좌의게임 시즌7</p></a></swiper-slide>
    <div class="swiper-button-prev" slot="button-prev"></div>
    <div class="swiper-button-next" slot="button-next"></div>
  </swiper>

   
       
        <div class="title">
          <h2 class="title-area">
            <span class="label">인기 영화</span>
          </h2>
        </div>
  <swiper class="swiper" :options="swiperOption">
    <swiper-slide><a href="#"><img src="@/assets/img/기생충.jpg">
    <p class="name">기생충</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/조커.jpg" />
    <p class="name">조커</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/인터스텔라.jpg" />
    <p class="name">인터스텔라</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/모가디슈.jpg" />
    <p class="name">모가디슈</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/테넷.jpg" />
    <p class="name">테넷</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/블랙위도우.jpg" />
    <p class="name">블랙위도우</p></a></swiper-slide>
    <div class="swiper-button-prev" slot="button-prev"></div>
    <div class="swiper-button-next" slot="button-next"></div>
  </swiper>
       
      </v-container>
    </div>
  </div>
</template>

<script>
import { Swiper, SwiperSlide } from "vue-awesome-swiper";
import "swiper/css/swiper.css";

import Banner from "../views/Banner.vue";

export default {
  name: "MainHome",
  components: {
    banner: Banner,
        Swiper,
    SwiperSlide,
  },
  data() {
    return {
      swiperOption: {
        slidesPerView: 5,
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
      },
    };
  },
};
</script>

<style scoped>
.title {
  margin-top: 5px;
}
.title h2 {
  display: inline-block;
  font-size: 30px;
  line-height: 36px;
  color: #fff;
  font-weight: 400;
  vertical-align: middle;
}
.title-area {
  display: inline-block;
  vertical-align: middle;
}
.title-area .label {
  color: #fff;
}

.title .title-area .more {
  position: absolute;

  font-size: 16px;
  color: #a5a5a5;
  background-size: 20px auto;
}

/* ----------------------- */
.swiper-slide {
  padding-top: 0px;
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
.name{
  color: white;
  margin-top: 10px;
  text-align: center;
}
</style>