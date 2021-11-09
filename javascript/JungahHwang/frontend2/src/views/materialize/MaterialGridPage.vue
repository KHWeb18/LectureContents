<template>
<!-- grid 현재 적용이 잘 안됨 -->
  <!-- s는 휴대폰 설정
       m은 태블릿 설정
       l은 pc 설정
       xl은 모니터 큰 pc 설정 -->
  <div class="container">
    <!-- container: 마진 있음(여백o) 화면의 70% 차지, row: 화면에 꽉 채움, 100% 차지 -->
    <div class="row flex">
      <div class="col s1 red">1</div>
      <div class="col s1 orange">2</div>
      <div class="col s1 yellow">3</div>
      <div class="col s1 green">4</div>
      <div class="col s1 blue">5</div>
      <div class="col s1 indigo">6</div>
      <div class="col s1 purple">7</div>
      <div class="col s1 cyan">8</div>
      <div class="col s1 teal">9</div>
      <div class="col s1 grey">10</div>
      <div class="col s1 white">11</div>
      <div class="col s1 pink">12</div>
    </div>
    <div class="row flex">
      <div class="col s12 m12 112 x112 red">안녕하세요!!!!!!!!</div>
      <div class="col s4 m4 14 x14 orange">안녕하세요!!!!!!!!</div>
      <div class="col s4 m4 14 x14 yellow">안녕하세요!!!!!!!!</div>
      <div class="col s4 m4 14 x14 green">안녕하세요!!!!!!!!</div>
    </div>
    <!--
    <div class="row flex">
      <div class="cls s12 blue white-text">
        <span class="flow-text">12</span>
      </div>
      <div class="cls s6 blue white-text">
        <span class="flow-text">12</span>
      </div>
      <div class="cls s3 m4 offset-m4 blue white-text">
        <span class="flow-text">12</span>
      </div>
      <div class="cls s3 m4 offset-m4 blue white-text">
        <span class="flow-text">12</span>
      </div>
    </div>
    -->
  </div>
</template>


<script>

export default {
  name: 'MaterialGridPage'
}
</script>