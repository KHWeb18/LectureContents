<template>
    <div style="padding-top: 25px;">

        <div align="center">
            <v-btn v-if="btnColor == 0" class="ma-2" outlined large color="black" v-on:mouseover="changeBtn">SHOW MORE</v-btn> 
            <v-btn v-else-if="btnColor == 1" class="ma-2" outlined large color="teal" v-on:mouseout="changeBtnBack">SHOW MORE</v-btn>
        </div>

        <div row style="margin-top: 70px; margin-bottom: 220px;">

            <div class="first">
                <textarea disabled v-model="firstTitle" class="boxTitle"></textarea>
                <textarea disabled v-model="firstBox" class="textBox"></textarea>
            </div>

            <div class="second">
                <textarea disabled v-model="secondTitle" class="boxTitle"></textarea>
                <textarea disabled v-model="secondBox" class="textBox"></textarea>
            </div>

            <div class="third">
                <textarea disabled v-model="thirdTitle" class="boxTitle"></textarea>
                <textarea disabled v-model="thirdBox" class="textBox"></textarea>
            </div>

        </div>

        <div style="width: 100%;"> <!-- margin-left: 10%; 또는 margin: auto; 로 슬라이드 가운데 정렬-->

            <agile :nav-buttons="false" :autoplay-speed="5000" :speed="2500" fade pause-on-hover pause-on-dots-hover autoplay>
            <img class="slide" src='@/assets/img/04.jpg'/>
            <img class="slide" src='@/assets/img/07.jpg'/>
            <img class="slide" src='@/assets/img/02.jpg'/>
            <img class="slide" src='@/assets/img/05.jpg'/>
            <img class="slide" src='@/assets/img/01.jpg'/>
            </agile>
            
        </div>

        <div align="center" style="margin-top: 50px; margin-bottom: 40px;">
            <p class="footerText">혹시 찾으시는 정보나 불편한 점이 있으신가요???</p>
            <p class="footerText" style="display: inline; margin-right: 10px;">여기에서 말씀해주세요. :)</p>
            <v-icon color="teal">email</v-icon>
        </div>

    </div>
</template>

<script>
import { VueAgile } from 'vue-agile'

export default {
    name: 'MainPageFooter',
    components: {
        agile: VueAgile
    },
    data() {
        return {
            btnColor: 0,

            firstTitle: '저희 MUSIC GHUETTO의 공연들은...',
            firstBox: '매일, 매주 업데이트됩니다! 저희 서비스를 통해 고객님의 취향에 맞는 공연과 뮤지션들을 추천해드려요. 꼭 놓치지말고 확인해보세요! :) ' + 
            '다양한 이벤트와 선물도 준비되어있습니다. 여러분들을 위한 공연을 지금 확인하세요!',

            secondTitle: '우리나라의 아티스트, 공연장과 함께합니다.',
            secondBox: '저희 MUSIC GHUETTO는 아티스트 그리고 장소를 제공하는 업체들과 함께, 공정하게 수익을 분배합니다. 우리나라의 인디음악의 미래와 환경을 위해 ' + 
            '앞장서는 MUSIC GHUETTO가 되고자합니다 :)',

            thirdTitle: '다양한 이벤트들을 지금 확인하세요!',
            thirdBox: '매주마다 가장 반응이 좋았던 아티스트와 공연을 확인하세요! 반응이 좋았던 공연들 중 관람 후기를 올려주시면 추첨을 통해 다양한 상품을 드립니다! ' + 
            '저번 주, 이번 주 그리고 다음 주의 핫한 공연은 무엇일까요???'
        }
    },
    methods: {
        changeBtn() {
            this.btnColor = 1
        },
        changeBtnBack() {
            this.btnColor = 0
        }
    }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Do+Hyeon&display=swap');

.boxTitle {
    font-family: 'Do Hyeon', sans-serif;
    margin-bottom: -30px;
}

.textBox {
    color: white; 
    font-size: 11px;
    line-height: 20px;
    height: 100px;
}

.first {
    /* border: 1px solid red; */
    float: left;
    width: 20%;
    box-sizing: border-box;
    margin-left: 10%;
}

.second {
    /* border: 1px solid green; */
    float: left;
    width: 20%;
    box-sizing: border-box;
    margin-left: 10%;
}

.third {
    /* border: 1px solid blue; */
    float: right;
    width: 20%;
    box-sizing: border-box;
    margin-right: 10%;
}

.footerText {
    font-family: 'Do Hyeon', sans-serif;
    color: white; 
    font-size: 15px;
}

</style>

<style lang="scss">

.agile {
	&__dots {
		bottom: 10px;
		flex-direction: column;
		right: 30px;
		position: absolute;
        margin-bottom: 40px;
    }
	
	&__dot {
		margin: 5px 0;
    
		button {
			background-color: transparent;
			border: 1px solid #fff;
			cursor: pointer;
			display: block;
			height: 10px;
			font-size: 0;
			line-height: 0;
			margin: 0;
			padding: 0;
			transition-duration: .3s;
			width: 10px;
        }

		&--current, 
		&:hover 
			button {
				background-color: #fff;
        }
    }
}
// Slides styles
.slide {
	display: block;
	height: 500px;
	object-fit: cover;
	width: 100%;
}
    
</style>
