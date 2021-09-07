<template>
    <div>
        <v-flex xs12 sm12 md12>
        <div>
            <v-img class="about-img-top" src="https://images.pexels.com/photos/2507007/pexels-photo-2507007.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
            </v-img>
        </div>
        <div class="section">
            <h5>" Once a year, go somewhere you have never been before. "</h5>
        </div>
        <v-container class="about-top">
            <p>WELCOME TO CINZEL</p>
            <h1>CINZEL ABOUT</h1>
            <p>| 소개 |</p>
        </v-container>
        <v-divider></v-divider>

 
        <div class="colorbox">
            <h1 style="font-size:15px;">Cinzel Movie Story</h1>
            <v-row align="center" justify="center">
            <iframe width="900" height="506" src="https://www.youtube.com/embed/mJ4PLtLIs_A" 
            title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; 
            clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            </v-row>
        </div>
    
    
        <v-container style="margin-top:5%;">
            <p>바다와 숲이 어우러진 천혜의 휴양지 제주도 서귀포에 위치한 Cinzel은 <br>
            고객의 편의와 프라이빗을 소중하게 여기는 펜션으로 품격있는 서비스를 만나보실 수 있습니다.<br>
            머무시는 동안 편안한 휴식공간이 될 수 있도록 노력하는 서비스로 모시겠습니다.</p>
        </v-container>

        <div>
            <div>
                <div style="padding-left:5%; padding-top:5%; float:left; width:50%;">
                    <h2>Blue Ocean</h2>
                    <p>자연과 조화된 Cinzel에서 산들바람과 바다내음을 맡으며<br>
                        가족 연인과 즐거운 추억을 만들어보세요.</p>
                </div>
                <div style="float:left; width:50%;">
                    <v-img style="overflow: visible" contain
                            src="https://images.pexels.com/photos/843633/pexels-photo-843633.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
                            </v-img>
                </div>
            </div>

            <div style="display: block;">
                <div style="float:left; width:60%; margin-left:0%;">
                    <v-img style="overflow: visible" contain
                    src="https://images.pexels.com/photos/3511543/pexels-photo-3511543.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
                    </v-img> 
                    </div>
                <div style="float:left; padding:5% 0% 0% 5%; width:40%;">
                    <h2>Beautiful <br>Nature</h2>
                </div>
            </div>
            
        </div>

        
            <!-- <div style="display: block;">
                <div style="float:left; width:60%;">
                    <v-img style="overflow: visible" contain
                    src="https://images.pexels.com/photos/3417701/pexels-photo-3417701.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
                    </v-img> 
                    </div>
                <div style="float:left; padding:5% 0% 0% 5%; width:40%;">
                    <h2>Beautiful <br>Nature</h2>
                </div>
            </div> -->
        

        <!-- <div class="container">
            <div class="overlay">
                <h2>Blue Ocean</h2>
                <p>자연과 조화된 Cinzel에서 산들바람과 바다내음을 맡으며<br>
                     가족 또는 연인과 즐거운 추억을 만들어보세요.</p>
            </div>
            <div style="width:100%;">
                <v-img class="about-img-01" style="overflow: visible" contain
                        src="https://images.pexels.com/photos/5231749/pexels-photo-5231749.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"></v-img>
            </div>
        </div> -->

        <!-- <div class="container">
            <div class="overlay2">
                <h2>Beautiful <br>Nature</h2>
            </div>
            <div>
                <v-img class="about-img-02" style="overflow: visible" contain
                src="https://images.pexels.com/photos/3417701/pexels-photo-3417701.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
                </v-img> 
                </div>
        </div>

        <v-container class="middle">
            <h5>" All travel has its advantages. If the passenger visit better countries,<br>
                he may learn to improve his own. and if fortune carries him to worse,
                he may learn to enjoy it. "</h5>
        </v-container> -->
<!-- 
        <v-col sm12>
        <div class="container"> -->
            <!-- <div class="overlay3">
                <h3>CINZEL</h3>
            </div> -->
            <!-- <div>
                <v-img class="about-img-03" 
                src="https://images.unsplash.com/photo-1558006297-a916366218d1?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80">
            </v-img>
                </div>
        </div> -->
        <!-- </v-col> -->
        </v-flex>
    </div>    
</template>

<script>
export default {
    
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');
@import url('https://fonts.googleapis.com/css2?family=MonteCarlo&display=swap');


.colorbox{
    padding: 6% 0% 5% 0%;
    background-color: #ececec;
}
.container{
    position: relative;
}

.overlay{
    position: absolute;
    z-index: 9;
    margin-top: 9%;
    left: -8%;
}

.overlay2{
    position: absolute;
    z-index: 9;
    margin-top: 1%;
    left: 70%;
}

.overlay3{
    position: absolute;
    z-index: 9;
    margin-top: 37.5%;
    left: 5%;
}

.test3{
    margin-left: 50vw;
    position: relative;
    bottom: 25vh;
}

.middle {
    margin-top: 45px;
    margin-bottom: 15px;
}

.intro-top {
    text-align: left;
}

.about-img-top {
    max-height: 70vh;
}
.about-img-01 {
    position: relative;
    left: 20vw;
    height: 60vh;

}
.about-img-02 {
    position: relative;
    right: 20vw;
    height: 50vh;
    margin-top: -5vh;
}
.about-img-03 {
    position: relative;
    left: 20vw;
    height: 60vh;
    margin-top: 5vh;
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

h2 {
    font-family: 'MonteCarlo';
    font-size: 150px;
    color:darkgrey
}

h3 {
    font-family: "Cinzel";
    font-size: 80px;
    margin-top: 10px;
    color:darkgrey;
}

h4 {
    margin-top: 0px;
    font-family: 'Nanum Myeongjo';
    font-size: 35px;
}

h5 {
    font-family: 'Nanum Myeongjo';
    font-size: 20px;
    text-align: center;
}
</style>