<!--<template>
    <v-app id="inspire">

        <div>
        <v-flex xs4 sm6 md12>
        <div>
            <v-img class="about-img-top" src="https://images.pexels.com/photos/4254556/pexels-photo-4254556.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
            </v-img>
        </div>
        <div class="section">
            <h5>" Once a year, go somewhere you have never been before. "</h5>
        </div>
        <v-container class="about-top">
            <p>WELCOME TO CINZEL</p>
            <h1>CINZEL TOUR</h1>
            <p>| 관광 |</p>
        </v-container>
        <v-divider></v-divider>

        

        <v-row align="center" justify="center" style="margin-top:5%;">
        <div >
            <iframe width="900" height="506" src="https://www.youtube.com/embed/a8taNpbLV4Y" 
                    style="margin-top:5%; margin-bottom:5%; position: relative;"
                    title="YouTube video player" frameborder="0" 
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
                    allowfullscreen>
            </iframe>
   
        </div>
        </v-row>


        <slot name="tour"></slot>

        <v-container>
            <v-main id="content">
                <slot name="content" class="font">
                </slot>
            </v-main>
        </v-container>
        
        </v-flex>
        </div>
    </v-app>
</template>

<script>
// import router from '@/router'
export default {
    data () {
        return {
            drawer: false,
            left: false
        }
    },
    methods: {
        // home () {
        //     (window.location.pathname !== '/') ? router.push('/') : router.go(0)
        // },
        // category () {
        //     (window.location.pathname !== '/cinzel') ? router.push('/cinzel') : router.go(0)
        // }
    }
}
</script>

<style scoped>



.video-container{
    margin-top: 5%;
    margin-bottom: 5%;
    position: relative;
    width: 10%;
}
.about-img-top {
    max-height: 70vh;
}


.section {
    background: #dcdfdc;
    height: 10vh;
}

p {
    font-family: 'Nanum Myeongjo';
    font-size: 18px;
    text-align: center;
    padding: 18px 0px 18px 0px;
}

.about-top {
    padding-top: 10vh;
}

h1 {
    font-family: "Cinzel";
    font-size: 40px;
    text-align: center;
    margin-top: 10px;
}

h5 {
    font-family: 'Nanum Myeongjo';
    font-size: 20px;
    text-align: center;
}
</style>-->


<template>
    <v-app id="inspire" class="tour-back">
        <div>
        <v-flex xs4 sm6 md12>
            <div class="container">
                <h1 style="margin-top:0%">in  JEJU</h1>

                <div class="gallery-wrap">
                    <div class="item item-1"></div>
                    <div class="item item-2"></div>
                    <div class="item item-3"></div>
                    <div class="item item-4"></div>
                    <div class="item item-5"></div>
                </div>
            </div>

        <slot name="tour"></slot>

        <v-container style="margin-left:12%;">
            <v-row align="center" justify="center">
            <v-main id="content">
                <slot name="content">
                </slot>
            </v-main>
            </v-row>
        </v-container>
        </v-flex>
        </div>
    </v-app>
</template>

<script>

export default {
    data () {
        return {
            drawer: false,
            left: false
        }
    }
}
</script>

<style lang="scss" scoped>



.section {
    background: #dcdfdc;
    height: 10vh;
}

p {
    font-family: 'Nanum Myeongjo';
    font-size: 18px;
    text-align: center;
    padding: 18px 0px 18px 0px;
}

.about-top {
    padding-top: 10vh;
}

h1 {
    font-family: "Cinzel";
    font-size: 40px;
    text-align: center;
    margin-top: 10px;
}

h5 {
    font-family: 'Nanum Myeongjo';
    font-size: 20px;
    text-align: center;
}

/* .tour-back{
    background-color: rgba(0, 0, 0, 0.897);
} */

html,body{
  width: 100%;
  height: 100%;
}

.container{
//   padding: 75px 0;
  margin: 0 auto;
  width: 1140px;
}


.gallery-wrap {
  display: flex;
  flex-direction: row;
  width: 100%;
  height: 70vh;
}

.item {
  flex: 1;
  height: 100%;
  background-position: center;
  background-size: cover;
  background-repeat: none;
  transition: flex 0.8s ease;
  
  &:hover{
    flex: 7;
  }
}

.item-1 { 
  background-image: url('https://blog.kakaocdn.net/dn/o1KIw/btqu9mflPY6/rGk1mM3iugV1c6jj9Z3E80/img.jpg');
}
.item-2 { 
  background-image: url('https://blog.kakaocdn.net/dn/LxAwX/btqLNspkM4Z/Wf5VfdXahJMzhLEzHU18F0/img.jpg');
}

.item-3 { 
  background-image: url('https://kr.blog.kkday.com/wp-content/uploads/jeju_cafe_soem_aensseom_2.jpg');
}

.item-4 { 
  background-image: url('https://t1.daumcdn.net/cfile/tistory/991A3B505DE36B0014');
}

.item-5 { 
  background-image: url('https://mblogthumb-phinf.pstatic.net/MjAyMDA4MTBfMjQ4/MDAxNTk3MDI1NTc4ODYy.7S9-t-xXoRuXgbD51sSFZqRLsC2_msB2WXSP-LzY3Ogg.vOaerSQK78DxYru-yFRT1NCvubIKB3CMa7hkDWoBpoAg.JPEG.face8901/12.jpg?type=w800');
}


</style>