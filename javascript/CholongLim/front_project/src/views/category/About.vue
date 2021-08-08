<template>
    <div>
        <div>
            <v-img class="about-img-top" src="https://images.pexels.com/photos/2507007/pexels-photo-2507007.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
            </v-img>
        </div>
        <div class="section">
            <p class="intro-font">" We travel, some of us forever, to seek other places, other lives, other souls. "</p>
        </div>
        <v-container class="about-top">
            <p>WELCOME TO CINZEL</p>
            <h1>CINZEL ABOUT</h1>
            <p>| 리조트 소개 |</p>
            <v-divider></v-divider>
        </v-container>
        <v-container>
            <p>바다와 숲이 어우러진 천혜의 휴양지 제주도 서귀포에 위치한 Cinzel Resort는 <br>
            고객의 편의와 프라이빗을 소중하게 여기는 리조트로 품격있는 서비스를 만나보실 수 있습니다.<br>
            머무시는 동안 편안한 휴식공간이 될 수 있도록 노력하는 서비스로 모시겠습니다.</p>
            <div>
                <!-- <v-container>
                <v-img class="about-img-01" style="overflow: visible"
                        src="https://images.pexels.com/photos/5231749/pexels-photo-5231749.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
                <v-img class="about-img-02" src="https://images.pexels.com/photos/3417701/pexels-photo-3417701.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
                </v-img>
                </v-img>
                </v-container> -->
                 <v-container class="test1">
                <v-img class="about-img-01" style="overflow: visible" contain
                        src="https://images.pexels.com/photos/5231749/pexels-photo-5231749.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"></v-img>
                 </v-container>
            </div>
            <div class="test2">
                <p>채워넣기</p>
            </div>
            <div>
                <v-container>
                <v-img class="about-img-02" src="https://images.pexels.com/photos/3417701/pexels-photo-3417701.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
                </v-img>
                </v-container>
            </div>
            <div class="test3">
                <p>채워넣기</p>
            </div>
        </v-container>
        <v-spacer></v-spacer>
        <v-container>
            <p>푸른 서귀포 바다와 함께 어우러진 다양한 부대시설을 즐겨보세요. <br>
            자연과 조화된 Cinzel Resort에서 산들바람과 바다내음을 맡으며 가족 또는 연인과 즐거운 추억을 만들어보세요.<br></p>
            <div>
                <v-container>
            <v-img class="about-img-03" src="https://images.unsplash.com/photo-1558006297-a916366218d1?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80">
            </v-img>
            </v-container>
            </div>
            <div>
                <v-container>
            <v-img scr="https://images.pexels.com/photos/7502450/pexels-photo-7502450.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"></v-img>
            </v-container>
            </div>
        </v-container>
        <v-container>
        <p>바닥글</p>
        </v-container>
    </div>
    
     
</template>

<script>
export default {
    
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');

.test{
    margin-left: 55vw;
    position: relative;
    bottom: 30vh;
}

.test2{
    margin-left: 55vw;
    position: relative;
    right: 50vw;
    bottom: 40vh;
}

.test3{
    margin-left: 50vw;
    position: relative;
    bottom: 25vh;
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
    margin-top: -20vh;
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
</style>