<template>
  <div class="app">
      <div class="teal lighten-1 center-align">
          이것이 Materialize 닷!
      </div>
      <div class="white-text teal dartken-5">
           <v-icon>mdi-anchor</v-icon>
          우왕 굳!

      </div>
      <div class="row">
          <!-- class responsive-img가 단순 클래스명이아니라 반응형으로 이미지를 만들어준다. -->
          <img class="responsive-img" src="@/assets/img/nissan_maxima.png">
      </div>
      <div class="row">
          <i class="material-icons small teal-text">call</i>
          <i class="material-icons small teal-text">mail</i>
      </div>
      <div class="video-container">
          <iframe width="1280" heigth="720" src="https://www.youtube.com/embed/weeI1G46q0o" 
          frameborder="0"
          allow="accelerometer; autoplay; encrypted-media; gryroscope; picture-in-picture"
          allowfullscrenn></iframe>
      </div>
      <div>
        <img class="circle responsive-img hide-on-small-only" src="@/assets/img/Spyder.jpg">
      </div>

      <div class="row">
          <img class="circle responsive-img hide-on-small-only" src="@/assets/img/Spyder.jpg">\
      </div>

      <div class="container">
          <div class="row">
              <div class="col s1 blue">1</div>
              <div class="col s1 cyan">2</div>
              <div class="col s1 red">3</div>
              <div class="col s1 black">4</div>
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
      <!-- container를 사용할 경우 70%, row는 100% 마진을 사용한다 -->
      <div>
          <div class="row">
              <div class="col s1 blue">1</div>
              <div class="col s1 cyan">2</div>
              <div class="col s1 red">3</div>
              <div class="col s1 black">4</div>
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
   
      
      
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>