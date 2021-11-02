<template>
    <div class="app">
        <div class="orange lighten-1 center-align">
            Meterialize
        </div>
        <div class="white-text orange darken-5">
            우와~
        </div><br>
        <!-- 반응형 사진 -->
        <div class="row">
            <img class="responsive-img" src="@/assets/img/Shepherd.jpg">
        </div>
        <!-- 아이콘 기능 -->
        <div class="row">
            <i class="material-icons small blue-text">call</i>
            <i class="material-icons small red-text">mail</i>
            <i class="material-icons small black-text">account_circle</i>
            <i class="material-icons small green-text">location_on</i>
        </div>
        <!-- 비디오 플레이어 -->
        <div class="video-container">
            <iframe width="1280" height="720" src="https://www.youtube.com/embed/NAPVkBAoQT8"
                    frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture "
                    allowfullscreen>
            </iframe>
        </div>
        <!-- 화면 보여주기 옵션 
             화면 사이즈가 어느정도 이상일 경우 보이고, 그 이하일 경우 사라짐 (웹 <-> 앱) -->
        <div class="row">
            <img class="circle responsive-img hide-on-small-only" src="@/assets/img/Malamute.jpg">
        </div>
        <!-- Grid(깔 맞추기) -->
        <div class="container">
            <div class="row">
                <div class="col s1 red">1</div>
                <div class="col s1 orange">2</div>
                <div class="col s1 yellow">3</div>
                <div class="col s1 green">4</div>
                <div class="col s1 teal">5</div>
                <div class="col s1 cyan">6</div>
                <div class="col s1 blue">7</div>
                <div class="col s1 indigo">8</div>
                <div class="col s1 purple">9</div>
                <div class="col s1 pink">10</div>
                <div class="col s1 grey">11</div>
                <div class="col s1 white">12</div>
            </div>
        </div>
        <!-- container를 사용할 경우 70%, row는 100% -->
        <div class="row">
                <div class="col s1 red">1</div>
                <div class="col s1 orange">2</div>
                <div class="col s1 yellow">3</div>
                <div class="col s1 green">4</div>
                <div class="col s1 teal">5</div>
                <div class="col s1 cyan">6</div>
                <div class="col s1 blue">7</div>
                <div class="col s1 indigo">8</div>
                <div class="col s1 purple">9</div>
                <div class="col s1 pink">10</div>
                <div class="col s1 grey">11</div>
                <div class="col s1 white">12</div>
            </div>
        <div class="container">
            <div class="row">
                <div class="col s12 cyan">
                    <p>오늘은 금요일이다!</p>
                </div>
                <div class="col s12 m4 12 x13 brown">
                    <p>오늘은 금요일이다!</p>
                </div>
                <div class="col s12 m4 18 x16 white">
                    <p>오늘은 금요일이다!</p>
                    </div>
                <div class="col s12 m4 12 x13 green">
                    <p>오늘은 금요일이다!</p>
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