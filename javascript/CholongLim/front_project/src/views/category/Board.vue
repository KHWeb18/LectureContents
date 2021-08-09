<template>
    <div>
        <div>
            <v-img class="about-img-top" src="https://images.pexels.com/photos/7244366/pexels-photo-7244366.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
            </v-img>
        </div>
        <div class="section">
            <p class="intro-font">" We travel, some of us forever, to seek other places, other lives, other souls. "</p>
        </div>
        <v-container class="about-top">
            <p>WELCOME TO CINZEL</p>
            <h1>CINZEL BOARD</h1>
            <p>| 공지사항 |</p>
            <v-divider></v-divider>
        </v-container>

        <v-container>
            <v-data-table :headers="headerTitle"
                    :items="contents"
                    :items-per-page="10"
                    class="elevation-1">
            </v-data-table>
        </v-container>
    

    </div>    
</template>

<script>

export default {
    name: 'Board',
    data () {
        return {
            headerTitle: [
                { text: '번호', value: 'boardNo', width: "70px"},
                { text: '제목', value: 'title', width: "200px"},
                { text: '작성자', value: 'writer', width: "100px"},
                { text: '내용', value: 'content', width: "100px"}
            ],
            contents: [
                { boardNo: 1, title: '일', writer: 'first', content: '하나' },
                { boardNo: 2, title: '이', writer: 'second', content: '둘' },
                { boardNo: 3, title: '삼', writer: 'third', content: '셋' },
                { boardNo: 4, title: '사', writer: 'fourth', content: '넷' },
                { boardNo: 5, title: '오', writer: 'fifth', content: '다섯' },
                { boardNo: 6, title: '육', writer: 'sixth', content: '여섯' },
                { boardNo: 7, title: '칠', writer: 'seventh', content: '일곱' },
                { boardNo: 8, title: '팔', writer: 'eighth', content: '일곱' },
                { boardNo: 9, title: '구', writer: 'ninth', content: '여덟' },
                { boardNo: 10, title: '십', writer: 'tenth', content: '아홉' },
                { boardNo: 11, title: '십일', writer: 'eleventh', content: '열' },
                { boardNo: 12, title: '십이', writer: 'twelvth', content: '열하나' },
            ]
        }
    }
}

</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');
@import url('https://fonts.googleapis.com/css2?family=MonteCarlo&display=swap');

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
    margin-top: 43%;
    left: 7%;
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
</style>