<template>
<!-- css를 만들지 않아도 class안에 집어넣으면 css가 적용이 된다 -->
    <div class="app">
        <div class="teal lighten-1 center-align">
            이것이 Materialize 닷!
        </div>
        <div class="white-text black darken-5">
            우왕 굳!
        </div><br>
        <!-- 반응형 사진 -->
        <div class="row">
            <img class="responsive-img " src="@/assets/img/test3.jpg">
        </div>
        <!-- 아이콘 기능 -->
        <div class="row">
            <i class="material-icons small teal-text">call</i>
            <i class="material-icons small teal-text">mail</i>
        </div>
        <!-- 비디오(영상) 플레이어-->
        <div class="video-container">
            <iframe width="1280" height="720" src="https://www.youtube.com/embed/RnkDLHJ49J8"
                    frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                    allowfullscreen>
            </iframe>
        </div>
        <!-- 화면 보여주기 옵션 (화면일 클때는 보이다가 작아지면 감춰짐 ex)모바일화면 등에서 자주 활용됨 ) -->
        <div class="row">
            <img class="circle responsive-img hide-on-small-only" src="@/assets/img/test2.jpg">
        </div>
        <!-- Grid(깔 맞추기) -->
        <div class="container">
            <div class="row">
                <div class="col s1 blue">1</div>
                <div class="col s1 cyan">2</div>
                <div class="col s1 red">3</div>
                <div class="col s1 pink accent-1">4</div>
                <div class="col s1 white">5</div>
                <div class="col s1 green">6</div>
                <div class="col s1 purple">7</div>
                <div class="col s1 teal">8</div>
                <div class="col s1 grey">9</div>
                <div class="col s1 orange">10</div>
                <div class="col s1 yellow">11</div>
                <div class="col s1 indigo">12</div>
            </div>
        </div>
        <!-- container를 사용할 경우 70%, row는 100%(여백/마진 없이) -->
        <div class="row">
            <div class="col s1 blue">1</div>
            <div class="col s1 cyan">2</div>
            <div class="col s1 red">3</div>
            <div class="col s1 pink accent-1">4</div>
            <div class="col s1 white">5</div>
            <div class="col s1 green">6</div>
            <div class="col s1 purple">7</div>
            <div class="col s1 teal">8</div>
            <div class="col s1 grey">9</div>
            <div class="col s1 orange">10</div>
            <div class="col s1 yellow">11</div>
            <div class="col s1 indigo">12</div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col s12 teal">
                    <p>오늘도 가고 내일도 가고</p>
                </div>
                <div class="col s12 m4 12 x13 cyan">
                    <p>오늘도 가고 내일도 가고</p>
                </div>
                <div class="col s12 mr 18 x16 red">
                    <p>오늘도 가고 내일도 가고</p>
                </div>
                <div class="col s12 m4 12 x13 pink accent-1">
                    <p>오늘도 가고 내일도 가고</p>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'MaterializeTestPAge'
}
</script>
