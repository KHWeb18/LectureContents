<template>
<div class="list-view">
  <div id="g-container">
    <div class="page-top">
      <div class="page-top-inner">
    <h2 tabindex="0" class="page-title">영화</h2>
      </div>
    </div>
 
<v-container>
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

    <div class="title">
          <h2 class="title-area">
            <span class="label">박스오피스</span>
          </h2>
        </div>
  <swiper class="swiper" :options="swiperOption">
    <swiper-slide><a href="#"><img src="@/assets/img/인질.jpg">
    <p class="name">인질</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/싱크홀.jpg" />
    <p class="name">싱크홀</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/모가디슈.jpg" />
    <p class="name">모가디슈</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/올드.jpg" />
    <p class="name">올드</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/프리가이.jpg" />
    <p class="name">프리가이</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/퍼피 구조대 더 무비.jpg" />
    <p class="name">퍼피 구조대 더 무비</p></a></swiper-slide>
    <div class="swiper-button-prev" slot="button-prev"></div>
    <div class="swiper-button-next" slot="button-next"></div>
  </swiper>

    <div class="title">
          <h2 class="title-area">
            <span class="label">액션</span>
          </h2>
        </div>
  <swiper class="swiper" :options="swiperOption">
    <swiper-slide><a href="#"><img src="@/assets/img/존윅3.jpg">
    <p class="name">존윅3</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/론 서바이버.jpg" />
    <p class="name">론 서바이버</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/반도.jpg" />
    <p class="name">반도</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/솔저발터.jpg" />
    <p class="name">솔저발터</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/성난황소.jpg" />
    <p class="name">성난황소</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/마녀.jpg" />
    <p class="name">마녀</p></a></swiper-slide>
    <div class="swiper-button-prev" slot="button-prev"></div>
    <div class="swiper-button-next" slot="button-next"></div>
  </swiper>

    <div class="title">
          <h2 class="title-area">
            <span class="label">SF 판타지</span>
          </h2>
        </div>
  <swiper class="swiper" :options="swiperOption">
    <swiper-slide><a href="#"><img src="@/assets/img/신과함께(인과 연).jpg">
    <p class="name">신과함께:인과 연</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/해리포터(마법사의돌).jpg" />
    <p class="name">해리포터와 마법사의 돌</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/반지의제왕.jpg" />
    <p class="name">반지의 제왕</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/인셉션.jpg" />
    <p class="name">인셉션</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/스파이더맨3.jpg" />
    <p class="name">스파이더맨3</p></a></swiper-slide>
    <swiper-slide><a href="#"><img src="@/assets/img/레지던트이블4.jpg" />
    <p class="name">레지던트 이블4</p></a></swiper-slide>
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