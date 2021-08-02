<template>
    <div class="app">
        <div class="blue lighten-1 center-align">
            This is what materialization is!
        </div>
        <div class="white-text teal darken-5">
            Gone
        </div>
        <br>
        <div class="row">
            <img class="responsive-img" src="@/assets/img/liam.jpeg">
        </div>
        <div class="row">
            <i class="material-icons small teal-text">audiotrack</i>
            <i class="material-icons small teal-text">mail</i>
        </div>
        <div class="video-container">
                <iframe width="853" height="480" src="https://www.youtube.com/embed/9buEq8-ZpGs" title="YouTube video player" 
                frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
            </iframe>
        </div>
        <!-- hide-on-small-only는 일정 크기 이상 작아지면 안나옴 -->
        <div class="row">
            <img class="circle responsive-img hide-on-small-only" src="@/assets/img/theQuiett.jpg">
        </div>
        <div class="container">
            <div class="row">
                <div class="col s2 blue">1</div>
                <div class="col s2 cyan">2</div>
                <div class="col s2 red">3</div>
                <div class="col s2 purple">4</div>
                <div class="col s2 teal">5</div>
            </div>
        </div>
    </div>
</template>

<script>

export default {
    name: 'MaterializeTestPage'
}
</script>

