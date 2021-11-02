<template>
    <div class="app">
        <div class="teal lighten-1 center-align">
            이것이 Materialize 닷!
        </div>
        <div class="white-text teal darken-5">
            우왕 굳!
        </div>
        <div class="row">
            <img class="responsive-img" src="@/assets/img/img2.jpg">
        </div>
        <!-- 아이콘 기능 -->
        <div class="row">
            <i class="material-icons large teal-text">call</i>
            <i class="material-icons small pink-text">mail</i>
        </div>
        <!-- 비디오 플레이어 -->
        <div class="video-container">
            <!-- 동영상 embed 링크만 걸 수 있음 -->
            <iframe width="1280" height="720" src="https://youtube.com/embed/DrUVMdkb4_k"
                    frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                    allowfullscreen>
            </iframe>
        </div>
        <!-- 화면 보여주기 옵션 -->
        <div class="row">
            <img class="circle responsive-img hide-on-small-only" src="@/assets/img/img3.jpg">
        </div>
        <!-- Grid(깔 맞추기) -->
        <!-- container = 70% / row = 100% 차이는 margin 유무 -->
        <div class="container">
            <div class="row">
                <div class="col s1 blue">1</div>
                <div class="col s1 cyan">2</div>
                <div class="col s1 red">3</div>
                <div class="col s1 white">4</div>
                <div class="col s1 pink accent-1">5</div>
                <div class="col s1 green">6</div>
                <div class="col s1 purple">7</div>
                <div class="col s1 teal">8</div>
                <div class="col s1 grey">9</div>
                <div class="col s1 orange">10</div>
                <div class="col s1 yellow">11</div>
                <div class="col s1 indigo">12</div>
            </div>
        </div>
        <div class="row">
            <div class="col s1 blue">1</div>
            <div class="col s1 cyan">2</div>
            <div class="col s1 red">3</div>
            <div class="col s1 white">4</div>
            <div class="col s1 pink accent-1">5</div>
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
                    <p>오늘도 가고 내일도 간다.</p>
                </div>
                <div class="col s12 m4 12 x13 cyan">
                    <p>오늘도 가고 내일도 간다.</p>
                </div>
                <div class="col s12 m4 12 x13 red">
                    <p>오늘도 가고 내일도 간다.</p>
                </div>
                <div class="col s12 m4 12 x13 pink accent-1">
                    <p>오늘도 가고 내일도 간다.</p>
                </div>                            
                <div class="col s12 blue">1</div>
                <div class="col s1 cyan">2</div>
                <div class="col s1 red">3</div>
                <div class="col s1 white">4</div>
                <div class="col s1 pink accent-1">5</div>
                <div class="col s1 green">6</div>
                <div class="col s1 purple">7</div>
                <div class="col s1 teal">8</div>
                <div class="col s1 grey">9</div>
                <div class="col s1 orange">10</div>
                <div class="col s1 yellow">11</div>
                <div class="col s1 indigo">12</div>
            </div>
        </div>                
    </div>
</template>

<script>

export default {
    name: 'MaterializeTestPage'
}

</script>