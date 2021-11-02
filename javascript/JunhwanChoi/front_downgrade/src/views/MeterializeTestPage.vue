<template>
    <div class="app">
        <div class="teal lighten-1 center-align">
            이것이 Materialize닷!
        </div>
        <div class="white-text teal darken-5">
            우왕 굿
        </div><br>
        <div class="row">
            <img class="responsive-img" src="@/assets/imgs/lambo.jpg">
        </div>
        <!-- 아이콘기능 -->
        <div class="row">
            <i class="material-icons small teal-text">call</i>
            <i class="material-icons small teal-text">mail</i>
        </div>
        <!-- 비디오 플레이어 -->
        <div class="video-container">
            <iframe width="1280" height="720" src="https://www.youtube.com/embed/3AyCy1UUlpU" 
            frameborder="0" allow="accelerometer; autoplay; encrypted-midea; gyroscope; picture-in-picture" allowfullscreen>
            </iframe>
        </div>
        <!-- 화면 보여주기 옵셥 -->
        <div class="row">
            <img class="circle reponsive-img hide-on-small-only" src="@/assets/imgs/spyder.jpg">
        </div>
        <!-- Grid(깔맞추기) -->
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
        <!-- container를 사용할 경우 70%, row를 사용할 경우 100% -->
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
</template>

<script>
export default {
    name:'MaterializeTestPage'
}
</script>

<style>
.app {
    text-align: center;
    background-color: #CEDEBD;
}
    
</style>