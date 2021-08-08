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
            <h1>Royal Pool Villa</h1>
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
            <section>
                <v-container class="royal-img-01">
                <v-img style="overflow: visible"
                src="https://images.pexels.com/photos/5231749/pexels-photo-5231749.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
                </v-img></v-container></section>
            
            <section  class="info-royal">
                <div>
                    <ul>
                        <li>침대</li>
                        <li>화장실</li>
                        <li>테이블</li>
                    </ul>
                </div>
                <div></div>
            </section>
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
                //"https://i.pinimg.com/originals/58/43/a4/5843a4448570ba0f06251f37030a6e6c.jpg",
                "https://images.pexels.com/photos/8134746/pexels-photo-8134746.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/8134745/pexels-photo-8134745.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/6782574/pexels-photo-6782574.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/6207947/pexels-photo-6207947.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/1571463/pexels-photo-1571463.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/2635038/pexels-photo-2635038.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                ],
            swiperOption: {
                loop: true,
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
                {name:'# DELUXE ROOM', route: '/deluxe' },
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

.about-img-top {
    max-height: 70vh;
}
.royal-img-01{
    position: relative;
    right: 10vw;
    height: 60vh;
    width: 60vh;
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
    padding: 18px 0px 18px 0px;
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
    width: 100vw;
}
</style>