<template>
    <div class="app">
        <div class="teal lighten-1 center-align">
            이것이 Materialize 다~!
        </div>
        <div class="white-text red darken-5">
            와우~!
        </div><br>
        <!-- 반응형 사진 -->
        <div class="row">
            <img class="responsive-img" src="@/assets/imgs/Wrangler.png">
        </div>
        <!-- 아이콘 기능 -->
        <div class="row">
             <!--       고정적인것    아이콘크기  색상  -->
            <i class="material-icons small teal-text">call</i>
            <i class="material-icons small cyan-text">mail</i>
        </div>
        <!-- 비디오 플레이어 -->
        <div class="video-container">
            <iframe width="1019" height="582" src="https://www.youtube.com/embed/a9349pRiCRk"
             title="YouTube video player" frameborder="0"
             allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
             allowfullscreen>
             </iframe>
        </div>
        <!-- 화면 보여주기 옵션 -->
        <div class="row">
            <img class="circle responsive-img hide-on-small-only" src="@/assets/imgs/Wrangler.png">
        </div>
        <!-- Grid(깔 맞추기) -->
        <div class="container">
            <div class="row">
                <div class="col s1 blue">1</div>
                <div class="col s1 cyan">2</div>
                <div class="col s1 red">3</div>
                <div class="col s1 black">4</div>
                <div class="col s1 white">5</div>
                <div class="col s1 purple">6</div>
                <div class="col s1 teal">7</div>
                <div class="col s1 grey">8</div>
                <div class="col s1 green">9</div>
                <div class="col s1 orange">10</div>
                <div class="col s1 yellow">11</div>
                <div class="col s1 indigo">12</div>
            </div>
        </div>
        <!-- container를 사용할 경우 70%, row는 100% -->
            <div class="row">
                <div class="col s1 blue">1</div>
                <div class="col s1 cyan">2</div>
                <div class="col s1 red">3</div>
                <div class="col s1 black">4</div>
                <div class="col s1 white">5</div>
                <div class="col s1 purple">6</div>
                <div class="col s1 teal">7</div>
                <div class="col s1 grey">8</div>
                <div class="col s1 green">9</div>
                <div class="col s1 orange">10</div>
                <div class="col s1 yellow">11</div>
                <div class="col s1 indigo">12</div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col s12 teal">
                    <p>오진다!</p>
                </div>
               <div class="col s12 m4 12 x13 cyan">
                    <p>오진다!</p>
                </div>
                <div class="col s12 m4 18 x16 red">
                      <p>오진다!</p>
                </div>
                <div class="col s12 m4 12 x13 pink accent-1">
                     <p>오진다!</p>
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