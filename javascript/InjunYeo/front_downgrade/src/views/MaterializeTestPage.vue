<template>
    <div class="app">
        <div class="teal lighten-1 center-align">
            Materialize!
        </div>
        <div class="white-text teal darken-5">
            멋지다
        </div>
        <br>
        <!--반응형사진-->
        <div class="row">
            <img class="responsive-img" src="@/assets/imgs/iceland.jpg">
        </div>
        <!--아이콘기능-->
        <div class="row">
            <i class="material-icons small teal-text">call</i>
            <i class="material-icons small teal-text">mail</i>
            <i class="material-icons small teal-text">access_alarm</i>
        </div>
        <!--비디오플레이어-->
        <div class="video-container">
            <iframe width="1280" height="720" src="https://www.youtube.com/embed/Y3GQUz4HL20" 
            title="YouTube video player" 
            frameborder="0" 
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
            allowfullscreen>
            </iframe>
        </div>

        <!--화면 보여주기 옵션-->
        <div class="row">
            <img class="circle responsive-img hide-on-small-only" src="@/assets/imgs/desert.jpg">
        </div>

        <!--Grid(깔맞추기)-->
        <div class="container">
            <div class="row">
                <div class="col s1 blue">1</div>
                <div class="col s1 cyan">2</div>
                <div class="col s1 red">3</div>
                <div class="col s1 white">4</div>
                <div class="col s1 green">5</div>
                <div class="col s1 purple">6</div>
                <div class="col s1 teal">7</div>
                <div class="col s1 grey">8</div>
                <div class="col s1 orange">9</div>
                <div class="col s1 pink">10</div>
                <div class="col s1 yellow">11</div>
            </div>
            <!-- container를 사용할 경우 70%, row는 100% -->
        </div>
        <div class="row">
                <div class="col s1 blue">1</div>
                <div class="col s1 cyan">2</div>
                <div class="col s1 red">3</div>
                <div class="col s1 white">4</div>
                <div class="col s1 green">5</div>
                <div class="col s1 purple">6</div>
                <div class="col s1 teal">7</div>
                <div class="col s1 grey">8</div>
                <div class="col s1 orange">9</div>
                <div class="col s1 pink">10</div>
                <div class="col s1 yellow">11</div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col s12 blue">
                    <p>김피탕</p>
                </div>
                <div class="col s12 m4 12 x13 cyan">
                    <p>김치피자탕슉</p>
                </div>
                <div class="col s12 m4 18 x16 red">
                    <p>중국집 중국냉면 짬뽕 오히히히히히</p>
                </div>
                <div class="col s12 m4 18 x13 white accent-1">
                    <p>짜장면 짬뽕 탕수육 깐쇼새우 깐풍기</p>
                </div>

            </div>
        </div>
    </div>
</template>

<script>


export default {
    name: 'MaterializeGridTestPage'
}
</script>