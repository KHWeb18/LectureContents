<template>
<div class="list-view">
  <div id="g-container">
    <div class="page-top">
      <div class="page-top-inner">
    <h2 tabindex="0" class="page-title">TV 프로그램</h2>
      </div>
    </div>
 
<v-container>
  <div class="title">
          <h2 class="title-area">
            <span class="label">인기 드라마</span>
          </h2>
        </div>
  <swiper class="swiper" :options="swiperOption">
    <swiper-slide><a href="#"><img src="@/assets/img/펜트하우스.jpg">
    <p class="name">펜트하우스</p></a></swiper-slide>
    <swiper-slide><a href="Taxi"><img src="@/assets/img/모범택시.jpg" />
    <p class="name">모범택시</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/괴물.jpg" />
    <p class="name">괴물</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/슬기로운 의사 생활2.jpg" />
    <p class="name">슬기로운 의사 생활<br>시즌2</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/호텔 델루나.jpg" />
    <p class="name">호텔 델루나</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/낭만닥터 김사부2.jpg" />
    <p class="name">낭만닥터 김사부2</p></a></swiper-slide>
    <div class="swiper-button-prev" slot="button-prev"></div>
    <div class="swiper-button-next" slot="button-next"></div>
  </swiper>

    <div class="title">
          <h2 class="title-area">
            <span class="label">Netflix 시리즈</span>
          </h2>
        </div>
  <swiper class="swiper" :options="swiperOption">
    <swiper-slide><a href="#"><img src="@/assets/img/종이의집4.jpg">
    <p class="name">종이의 집 시즌4</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/기묘한 이야기.jpg" />
    <p class="name">기묘한 이야기</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/블랙미러.jpeg" />
    <p class="name">블랙 미러</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/킹덤 시즌2.jpg" />
    <p class="name">킹덤 시즌2</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/퀸스 갬빗.jpg" />
    <p class="name">퀸스 갬빗</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/스위트홈.jpg" />
    <p class="name">스위트 홈</p></a></swiper-slide>
    <div class="swiper-button-prev" slot="button-prev"></div>
    <div class="swiper-button-next" slot="button-next"></div>
  </swiper>

    <div class="title">
          <h2 class="title-area">
            <span class="label">쀼쀼쀼쀼</span>
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

    <div class="title">
          <h2 class="title-area">
            <span class="label">다시 보고싶은 드라마</span>
          </h2>
        </div>
  <swiper class="swiper" :options="swiperOption">
    <swiper-slide><a href="#"><img src="@/assets/img/킹덤 시즌2.jpg">
    <p class="name">킹덤</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/비밀의 숲.jpg" />
    <p class="name">비밀의 숲</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/슬기로운 의사 생활2.jpg" />
    <p class="name">슬기로운 의사 생활</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/괴물.jpg" />
    <p class="name">괴물</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/부부의 세계.jpg" />
    <p class="name">부부의 세계</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/빈센조.jpg" />
    <p class="name">빈센조</p></a></swiper-slide>
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


export default {
  
  name: "TVprogramPage",
  components: {
Swiper, SwiperSlide
  
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
    }
    }
  }
}
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

.list-view{
  width: 100%;
    min-width: 1240px;
    height: 100%;
    min-height: 550px;
    overflow: hidden;
    z-index: 10;
    margin: 80px auto 0;
  background-color: #171717;
}
.page-top{
  margin-bottom: 20px;
  padding: 20px 0;
  background-color: #252525;
}
.page-top-inner {
    position: relative;
    max-width: 1940px;
    margin: 0 auto;
}
.page-title {
    font-size: 24px;
    line-height: 36px;
    color: #fff;
    font-weight: 400;
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