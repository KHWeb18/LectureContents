<template>
  <div class="app">
    <div class="teal lighten-1 center-align">
      이것이 Materialize 닷!
    </div>
    <div class="white-text blue darken-5">
      우왕 굳!
    </div>
    <!-- 반응형 사진 -->
    <div class="row">
      <img class="responsive-img" src="@/assets/img/nissan-maxima.png">
    </div>
    <!-- 아이콘 -->
    <div class="row">
      <i class="material-icons small teal-text">call</i>
      <i class="material-icons small white-text pink">mail</i>
    </div>
    <!-- 비디오 -->
    <div class="video-container">
      <iframe width="695" height="391" 
      src="https://www.youtube.com/embed/yn32aDWUgZU" 
      title="YouTube video player" frameborder="0" 
      allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
      allowfullscreen>
      </iframe>
    </div>
    <div class="row">
      <img class="circle responsiv-img hide-on-small-only" src="@/assets/img/car.jpeg">
    </div>
    <!-- Gride 깔 맞추기-->
    <div class="container">
      <div class="row">
        <div class="col s1 blue">1</div>
        <div class="col s1 cyan">2</div>
        <div class="col s1 red">3</div>
        <div class="col s1 pink acent-1">4</div>
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
    <!-- container 를 사용할 경유 70% row 를 사용할 경우 100% -->
    <div class="row">
      <div class="col s1 blue">1</div>
      <div class="col s1 cyan">2</div>
      <div class="col s1 red">3</div>
      <div class="col s1 pink acent-1">4</div>
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
  name: 'MaterializeTestPage'
}
</script>