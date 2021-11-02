<template>
    <div class="app">
        <div class="teal lighten-1 center-align">
            이것이 Materialize 닷!
        </div>
        <div class="white-text purple darken-5">
            우왕 굳!
        </div><br>
        <!-- 반응형 사진 -->
        <div class="row">
            <img class="responsive-img" src="@/assets/img/AMG_GT63S.jpg">
        </div>
        <!-- 아이콘 -->
        <div class="row">
            <i class="material-icons small teal-text">call</i>
            <i class="material-icons small teal-text">mail</i>
    </div>
    <!-- 비디오 플레이어 -->
    <div class="video-container">
        <iframe width="1280" height="720" src="https://www.youtube.com/embed/XXYlFuWEuKI" title="YouTube video player" frameborder="0" 
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
        allowfullscreen></iframe>
    </div>
    <!-- 화면 보여주기 옵션 -->
    <div class="row">
        <img class="circle responsive-img hide-on-small-only" src="@/assets/img/Porsche_Taycan.jpg">
    </div>
    <!-- Grid(깔 맞추기) -->
    <div class="container"> <!--container은 margin 70% 양옆 15%씩 여백이 있음 -->
        <div class="row">  <!-- row는 margin 100% 이므로 양옆에 여백이 없다. -->
            <div class="col s1 red">1</div>
            <div class="col s1 orange">2</div>
            <div class="col s1 yellow">3</div>
            <div class="col s1 green">4</div>
            <div class="col s1 blue">5</div>
            <div class="col s1 indigo">6</div>
            <div class="col s1 purple">7</div>
            <div class="col s1 white">8</div>
            <div class="col s1 black">9</div>
            <div class="col s1 grey">10</div>
            <div class="col s1 pink">11</div>
            <div class="col s1 brown">12</div>
        </div>
    </div>
        <div class="container"> <!--container은 margin 70% 양옆 15%씩 여백이 있음 -->
        <div class="row">  <!-- row는 margin 100% 이므로 양옆에 여백이 없다. -->
            <div class="col s12 red">
                <p>여름은 너무 덥다 제발 빨리 지나가라</p>
            </div>
            <div class="col s12 m4 12 x13 orange">
                <p>오진다</p>
            </div>
            <div class="col s12 m4 18 x16 yellow">
                <p>오진다</p>
                </div>
            <div class="col s12 m4 12 x13 green">
                <p>오진다</p>
            </div>
        </div>
    </div>
    </div>
</template>

<script>
export default {
    name: 'MaterializeTestPage'
}
</script>