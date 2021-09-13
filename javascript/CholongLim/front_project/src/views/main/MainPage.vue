<template>
  <div>
    <div class="hero">
            <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer"
            class="main-bar"></v-app-bar-nav-icon>
                <v-toolbar-items class="login-locate">
                    <v-btn plain text v-if="this.cookie === false " router :to="'/login'">
                    <v-icon>input</v-icon>
                    </v-btn>

                    <v-menu offset-y v-if="(this.cookie === true) && (this.individual == '개인')">
                        <template v-slot:activator="{ on, attrs }">
                            <v-btn text v-bind="attrs" v-on="on">
                                <v-icon>account_circle</v-icon>
                            </v-btn>
                        </template>
                        <v-list>
                            <v-list-item router :to="{name: 'UserList'}">
                                <v-list-item-title>마이페이지</v-list-item-title>
                            </v-list-item>
                            <v-list-item @click="logout">
                                <v-list-item-title>로그아웃</v-list-item-title>
                            </v-list-item>
                        </v-list>
                    </v-menu>

                    <v-menu offset-y v-if="(this.cookie === true) && (this.individual != '개인')">
                        <template v-slot:activator="{ on, attrs }">
                            <v-btn text v-bind="attrs" v-on="on">
                                <v-icon>account_circle</v-icon>
                            </v-btn>
                        </template>
                        <v-list>
                            <v-list-item router :to="{name: 'MemberListPage'}">
                                <v-list-item-title >관리자페이지</v-list-item-title>
                            </v-list-item>
                            <!-- <v-list-item  router :to="{name: 'BookingListPage'}">
                                <v-list-item-title>예약숙소관리</v-list-item-title>
                            </v-list-item> -->
                            <v-list-item @click="logout">
                                <v-list-item-title>로그아웃</v-list-item-title>
                            </v-list-item>
                        </v-list>
                    </v-menu>
            </v-toolbar-items>
 


        <v-navigation-drawer app v-model="nav_drawer" temporary>
            <v-list nav dense  class="menubar">
                <v-list-item-group v-model="group" active-class="deep-blue--text text--accent-4">
                    <v-list-item v-for="link in links" :key="link.name" router :to="link.route">
                        <v-list-item-content>
                            <v-list-item-title>{{ link.text }}</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-list-item-group>
            </v-list>
        </v-navigation-drawer>
   
	
    <section class="container">
      <h1 class="title">
        <span>This is</span>
        <span>a place</span>
        <span style="font-size:150px;">for you</span>
      </h1>
      
      <h2 class="title">
        <span>Always</span>
        <span>welcome to you</span>
        <span style="font-size:150px;">Cinzel</span>
      </h2>
    </section>
	
    <a class="scroll-link" href="#content">
      <svg class="mouse" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 76 130" preserveAspectRatio="xMidYMid meet">
      <g fill="none" fill-rule="evenodd">
        <rect width="70" height="118" x="1.5" y="1.5" stroke="#FFF" stroke-width="3" rx="36"/>
        <circle class="scroll" cx="36.5" cy="31.5" r="4.5" fill="#FFF"/>
      </g>
    </svg>
    </a>
    
    </div>

<div id="content" class="content">
	
	<!-- 수정 -->
  
  <div>
                <h3 style="font-size: 15px; margin-bottom:2%;">CINZEL ALL AROUND</h3>
                <p>자연속에서의 낭만같은 휴식이 있는 날들</p>
                <p style="margin: 0% 0% 5% 0%;">To travel hopefully is a better thing than to arrive.</p>
            </div>

            <v-divider></v-divider>

            <div class="main-colorbox">
            <v-row>
                <v-flex xs3 sm12 lg12>
                <div class="img-s">
                    <v-img style="overflow: visible" contain width="900px" height="600px"
                        src="https://images.pexels.com/photos/355580/pexels-photo-355580.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
                    </v-img>
                </div>
       
                <div style="float:left; width:600px; margin-top:8%;">
                    <h3 style="font-size: 45px; text-align:center; margin-bottom:0px;">SPECIAL DAY</h3>
                    <p style="margin-top:0%; font-size:12px;">break in time of life</p>
                    
                    <p style="margin-top:0%; font-size:14px;">파노라마같은 낭만적인 바다속에서 보내는 오늘은<br>
                        당신에게 특별한 선물을 가져다 주어요.<br></p>
                       <p> 당신이 원하던 삶 속 황홀한 휴식이 기다립니다.</p>
                       <div style="text-align:center;">
                       <v-btn text route :to="{name : 'Room301'}">
                            more<v-icon>navigate_next</v-icon></v-btn>
                            
                       </div>
                </div>
                </v-flex>
            </v-row>
            </div>

            <div>
                <p> 자연을 당신의 품 안에 한껏 담아드릴께요.<br>
                사랑하는 사람과 맑은 하늘 푸른 바다가 닿는 이곳에서 추억을 만들어 보세요.</p>
                 <p style="margin-top:0%; font-size:14px;">
                     I'll put nature in your arms...make memories from where you love, the clear skies and the blue sea.
                 </p>       
            </div>

            <!-- <div style="margin-top:5%;margin-bottom:10%;"> -->
              <div class="buttons">
                <v-row align="center" class="justify-center">
                    <v-btn outlined x-large class="btn2"
                    route :to="{name: 'Reservation'}">RESERVATION<v-icon>navigate_next</v-icon></v-btn>
                </v-row>
            </div>
            <div>

            </div>
  <!-- 수정 -->
	
</div>
  </div>
</template>


<script>

import { mapActions } from 'vuex'
import 'swiper/css/swiper.css'

export default {
    name: 'MainPage',
    data () {
        return {
          nav_drawer: false,
          group: false,
          cookie: this.$cookies.isKey('user'),
          individual: this.$cookies.get('auth'),
          userId: this.$cookies.get('user'),
            links: [
                { 
                    text: 'ABOUT', name:'ABOUT',  route: '/about'
                },
                { 
                    text: 'ROOMS', name:'ROOMS', route: '/rooms'
                },
                { 
                    text: 'TOUR', name:'TOUR', route: '/tourCrawler'
                },
                { 
                    text: 'RESERVATION', name:'RESERVATION', route: '/reservation'
                },
                { 
                    text: 'BOARD', name:'BOARD', route: '/board'
                }
            ]
        }
    },
    watch: {
        group () {
            this.nav_drawer = false
        }
    },
     methods: {
        ...mapActions(['logout'])
    }
}

</script>

<style lang="scss" scoped>

// 버튼
.btn2{
  margin: 5%;
}
.btn2:hover{
  color:#ffffff;
}
.btn2:hover::before{
  opacity: 1;
  background-color: #6098FF;
}

@import url('https://fonts.googleapis.com/css?family=Playfair+Display:700|Source+Sans+Pro');

$mouse-width: 2.5rem;

*,
*::before,
*::after {
	box-sizing: border-box;
}

body {
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	font-family: 'Source Sans Pro', sans-serif;
	font-size: 16px;
	line-height: 1.618;
}
.hero {
	position: relative;
	min-height: 100vh;
	display: flex;
	align-items: center;
	justify-content: center;
	padding: 12rem 2rem;
	color: white;
	background: {
    image: linear-gradient(to bottom,  rgba(172, 172, 172, 0.014) 0%,rgba(0, 0, 0, 0.75) 100%),
    url('https://images.pexels.com/photos/912108/pexels-photo-912108.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260');
    
		blend-mode: multiply;
		size: cover;
  
	}
}
.mouse {
	max-width: $mouse-width;
	width: 100%;
	height: auto;
}

.scroll {
	animation-name: scroll;
	animation-duration: 1.5s;
	animation-timing-function: cubic-bezier(0.650, -0.550, 0.250, 1.500);
	animation-iteration-count: infinite;
	transform-origin: 50% 20.5px;
	will-change: transform, opacity;
	opacity: 1;
}

.scroll-link {
	position: absolute;
	bottom: 1rem;
	left: 50%;
	transform: translateX(-50%);
}

@keyframes scroll {

	0%, 20% {
		transform: translateY(0) scaleY(1);
	}

	100% {
		transform: translateY(36px) scaleY(2);
		opacity: 0;
	}

}

.main-bar{
  position: absolute;
  top: 1%;
  left:1%;
}

.login-locate {
    padding: 10px 0px 10px 0px;
    position: absolute;
    right: 0.5%;
}

.img-s{
    float: left;
}

.menubar {
    padding-top: 100px;
    padding-left: 40px;
}

.main-colorbox{
    margin: 3% 0% 3% 0%;
    background-color: #ececec;
}

.overlay{
    position: absolute;
    z-index:0;
    margin: 0 auto;
    left: 30%;
}

.account {
    padding-left: 40vw;
}
.login-locate {
    padding: 10px 0px 10px 0px;
    position: absolute;
    top:1%;
}

h3 {
    font-family: "Cinzel";
    text-align: center;
    margin: 5% 0% 5% 0%;
}


p {
    font-family: 'Nanum Myeongjo';
    font-size: 18px;
    text-align: center;
    padding: 5px 0px 5px 0px;
    margin: 5px 10px;
}


@import 'https://fonts.googleapis.com/css?family=Baloo+Paaji';

$primary-color: #87b3e4da ;
$secondary-color: #ffe221;
$tertiary-color: #ffffff;
  
.container{
  width: 100%;
  position: absolute;
  bottom: 20%;
}


h1{
  text-transform: uppercase;
  span{
    width: 100%;
    float: left;
    padding: 5% 0% 5% 0%;
    opacity: 0;
    animation-name: titleAnimation;
    animation-timing-function:ease;
    animation-duration: 10s;
  }
}

h2{
  text-transform: uppercase;
  span{
    width: 100%;
    float: left;
    padding: 5% 0% 5% 0%;
    opacity: 0;
    animation-name: title2Animation;
    animation-fill-mode: forwards;
    animation-timing-function:ease;
    animation-duration: 10s;
  }
}

h1 span{
  font-family: 'Playfair Display';
  font-size: 100px;
  animation-delay: 1s;
  &:first-child{
    animation-delay: 1s;
  }
  &:last-child{
    color: $primary-color;
    animation-delay: 2s;
  }
}

h2{ 
  top: 0;
  position: absolute;
  margin-left:1%;
  span{
    position: relative;
    font-family: 'Playfair Display';
    font-size: 100px;
    animation-delay: 13s;

  &:first-child{
    animation-delay: 11s;
  }
  &:last-child{
    color: $primary-color;
    animation-delay: 14s;
  }
  }
}


@keyframes titleAnimation {
    0% {
      transform: translateY(-50px);
      opacity: 0;
      -webkit-clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 80%);
      clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 80%);
  }
  20% {
      transform: translateY(0);
      opacity: 1;
      -webkit-clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 15%);
      clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 15%);
  }
  80% {
       transform: translateY(0);
       opacity: 1;
      -webkit-clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 15%);
      clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 15%);
  }
  100% {
       transform: translateY(50px);
       opacity: 0;
      -webkit-clip-path: polygon(100% 0, 100% -0%, 0 100%, 0 100%);
      clip-path: polygon(100% 0, 100% -0%, 0 100%, 0 100%);
    
  }
}

@keyframes title2Animation {
    0% {
      transform: translateY(-50px);
      opacity: 0;
      -webkit-clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 80%);
      clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 80%);
  }
  20% {
      transform: translateY(0);
      opacity: 1;
      -webkit-clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 15%);
      clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 15%);
  }
  80% {
       transform: translateY(0);
       opacity: 1;
      -webkit-clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 15%);
      clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 15%);
  }
  100% {
       transform: translateY(0px);
       opacity: 1;
      -webkit-clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 15%);
      clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 15%);
    
  }
}
</style>