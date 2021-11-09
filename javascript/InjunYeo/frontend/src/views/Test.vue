<!--HTML요소 팣트 작성 - Vue랑 연결시킬형식으로 작성해도 무방-->
<!-- 뷰눈 전부 템플릿안에서 사용해야한다-->
<template>
  <div class="home">

    <div id="header">
      <!-- router-link 는 어디로 갈지 URL 맵핑해주는 Spring의 Controller 같은역할
          to: Home은 클릭했을때 router/index.js에 등록된 Home으로 가게 만듬
          class:nav=link의 경우 Navigation Bar 같은 역할을 해줄수 있게 구성함을 의미
          active-class: 링크가 활성화 되었을때 적용된 CSS를 의미함-->
      <router-link
        :to="{ name: 'Home' }"
        class="nav-link"
        active-class="active"
      >
        Home
      </router-link>

      <router-link
        :to="{ name: 'Test' }"
        class="nav-link"
        active-class="active"
      >
        Test
      </router-link>

    </div>

    <h2>테스트 페이지</h2>
    <div id="app">
      <p> {{msg}} </p>
      <global-component v-bind:initial-test="counter">
      </global-component>

      <local-component v-bind:num="value"></local-component>
      <button v-on:click="plus">클릭</button>
    </div>
  </div>
</template>

<!--자바스크립트 관련 파트작성 -->
<script>
import LocalComponent from '../components/LocalComponent.vue'

export default {
  components: { 'local-component': LocalComponent

  },
  data() {
    return {
    
      counter: 0,
      value: 0,
      msg: "Vue 객체 데이터",
    };
  },
  methods: {
    plus(){
      this.value++
    }
  },
};
</script>