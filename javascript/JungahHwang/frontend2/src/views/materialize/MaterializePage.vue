<template>
  <div class="app">
    <div class="teal lighten-1 center-align">
      Materialize
    </div>
    <div class="white-text teal darken-5">
      Wow
    </div>
    <router-link :to="{ name: 'MaterialGridPage' }" 
      class="nav-link" 
      active-class="active">Grid
    </router-link>
    <br>
    <br>

    <!-- 반응형 사진 -->
    <div class="row">
      <img class="responsive-img" src="@/assets/imgs/Maltese.jpg">
    </div>

    <!-- 아이콘 삽입 -->
    <div class="row">
      <i class="material-icons small teal-text">call</i>
      <i class="material-icons small teal-text">mail</i>
    </div>

    <!-- 동영상 삽입 -->
    <div class="video-container">
      <iframe width="956" height="538" src="https://www.youtube.com/embed/Ngafk-aOn4o" 
              title="YouTube video player" frameborder="0" 
              allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; 
              picture-in-picture" allowfullscreen></iframe>
    </div>

    <!-- 화면 보여주기 옵션 -->
    <div class="row">
      <!-- hide-on-small-only: 화면 창이 작아지면 사진 사라짐, 보통 모바일에서 안보이게 할 때 사용 -->
      <img class="circle responsive-img hide-on-small-only" src="@/assets/imgs/Poodle.jpeg">
    </div>
    
    <!-- 버튼&버튼효과 삽입 -->
    <div class="row">
      <a class="btn waves-effect waves-red blue" @click="showMessage($event)">Wi-Fi ON</a>
      <a class="btn-flat waves-effect waves-teal" @click="showMessage($event)">
        <i class="material-icons right">cloud</i>Cloud</a>
      <a class="btn-floating waves-effect waves-yellow" @click="showMessage($event)">
        <i class="material-icons right">wifi</i>Wi-Fi</a>
    </div>
  </div>
</template>


<script>

export default {
  name: 'MaterializePage',
  methods: {
    showMessage () {
      alert('버튼!')
    }
  }
}
</script>