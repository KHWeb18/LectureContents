<template>
    <div>
        <v-container class="slide">
            <swiper class="swiper" :options="swiperOption">
                <swiper-slide v-for="image in images" :key="image">
                    <v-img :src="image" max-height="100%"></v-img>
                </swiper-slide>
                <div class="swiper-pagination" slot="pagination"></div>
                <div class="swiper-button-prev" slot="button-prev"></div>
                <div class="swiper-button-next" slot="button-next"></div>
            </swiper>
            <div class="section">
            <p class="intro-font">" The gladdest moment in human life, methinks, is a departure into unknown lands. "</p>
        </div>
        </v-container>

        <v-container class="about-top">
            <p>WELCOME TO CINZEL</p>
            <h1>Suite Room</h1>
            <p>자연속에서의 낭만같은 휴식이 있는 날들</p>
        </v-container>
        <v-divider></v-divider>

        <v-container>
            <v-container class="btn-box">
                <v-btn text v-for="room in rooms" :key="room" router :to="room.route">
            {{ room.name }}
            </v-btn>
            </v-container>
        </v-container>
        <v-divider></v-divider>

        <div class="intro-room01">
            <div>
                <v-container class="suite-img-01">
                <v-img style="overflow: visible"
                src="https://images.pexels.com/photos/5231749/pexels-photo-5231749.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
                </v-img>
                </v-container></div>
            
            <div>
                <div class="info-suite">
                    <h5 class="info-top-title"><b>Basic facilities <br>기본시설</b></h5>
                    <ul>
                        <li>퀸 베드1</li>
                        <li>화장실</li>
                        <li>벽걸이TV</li>
                        <li>에어컨</li>
                        <li>소파</li>
                        <li>테이블</li>
                        <li>냉장고</li>
                        <li>와이파이</li>
                    </ul>
                </div>
                <div class="info-suite2">
                    <h5 class="info-top-title"><b>Cooking<br>취사도구</b></h5>
                    <ul>
                        <li>인덕션</li>
                        <li>전자렌지</li>
                        <li>전기포트</li>
                    </ul>
                </div>
                <div class="info-suite3">
                    <h5 class="info-top-title"><b>Bathroom ware<br>욕실용품</b></h5>
                    <ul>
                        <li>수건</li>
                        <li>핸드워시</li>
                        <li>치약</li>
                        <li>바디타올</li>
                        <li>바디워시</li>
                        <li>샴푸</li>
                        <li>린스</li>
                        <li>헤어드라이기</li>
                    </ul>
                </div>
            </div>
        </div>

        <v-container>
        <p>바닥글</p>
        </v-container>
    </div>
    
     
</template>

<script>
import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
import 'swiper/css/swiper.css'
export default {
    name: 'RoomSuite',
    components: {
        Swiper,
        SwiperSlide
    },
    data () {
        return {
            images: [
                "https://images.pexels.com/photos/2506986/pexels-photo-2506986.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/2506990/pexels-photo-2506990.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/2507014/pexels-photo-2507014.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/2507016/pexels-photo-2507016.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                ],
            swiperOption: {
                //loop: true,
                effect: 'coverflow',
                grabCursor: true,
                centeredSlides: true,
                slidesPerView: 'auto',
                coverflowEffect: {
                    // rotate: 50,
                    stretch: 0,
                    depth: 100,
                    // 회전 많이하고 싶으면 높을수록 많이 돌아가고
                    // 그 대신 폭이 작아짐
                    // 아예 0으로 두면 회전이 없어져서 일직선이다
                    modifier: 0,
                    slideShadows: true
                },
                pagination: {
                    el: '.swiper-pagination'
                    //dynamicBullets: true
                },
                navigation: {
                    nextEl: '.swiper-button-next',
                    prevEl: '.swiper-button-prev'
                },
                autoplay: {
                    delay: 3000
                    // 1000(1초)
                }
            },
            rooms: [
                {name: '# DELUXE ROOM', route: '/deluxe' },
                {name: '# SUITE POOL VILLA', route: '/suite'},
                {name: '# ROYAL POOL VILLA', route: '/royal'}
            ]
        }
    }
}

</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Gowun+Batang&display=swap');


/*폰트*/
.info-top-title{
    font-size: 20px;
    font-family: 'Gowun Batang';
}

/*위치*/
.info-suite{
    margin-left: 55vw;
    position: relative;
    bottom: 30vh;
}
.info-suite2{
    margin-left: 66vw;
    position: relative;
    bottom: 55.4vh;
}
.info-suite3{
    margin-left: 75vw;
    position: relative;
    bottom: 69.5vh;
}

.about-img-top {
    max-height: 70vh;
}
.suite-img-01{
    position: relative;
    right: 28vw;
    height: 60vh;
    width: 80vh;
}
.about-img-02 {
    position: relative;
    right: 40vw;
    height: 60vh;
    margin-top: 55vh;
}
.about-img-03 {
    position: relative;
    left: 18vw;
    height: 60vh;
    margin-top: 5vh;
}

.about-bottom {
    margin-top: 60vh;
}

.section {
    background: #dcdfdc;
    height: 10vh;
    width: 100vw;
    position: relative;
    padding: 15px 0px 15px 0px;
}

p {
    font-family: 'Nanum Myeongjo';
    font-size: 18px;
    text-align: center;
    padding: 2vh 0vh 2vh 0vh;
    margin-bottom: 0px;
}

.about-top {
    padding-top: 8vh;
}

h1 {
    font-family: "Cinzel";
    font-size: 50px;
    text-align: center;
    margin-top: 10px;
}

.btn-box{
    padding: 18px 10px 18px 10px;
    text-align: center;
}

.intro-room01 {
    background: #f6f7f7;
    height: 100vh;
}

.slide {
    padding-left: 0px;
    margin-left: 0px;
    padding-top: 0px;
}

.slide-3d {
    padding-top: 0px;
    padding-bottom: 0px;
}

.swiper {
    height: 94vh;
    width: 99.6vw;
}
</style>