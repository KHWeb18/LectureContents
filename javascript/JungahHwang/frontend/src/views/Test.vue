<!-- HTML -->
<template>
  <div class="home">
    <div id="header">
      <!-- router-link: URL을 맵핑해주는 Spring의 Controller같은 역할 
           :to="{ name : 'Home' }": 클릭했을 때 router/index.js에 등록된 Home으로 감
           class="nav-link": Navigation Bar 같은 역할을 할 수 있게 구성 
           active-class: 링크가 활성화 되었을 때 적용된 CSS를 의미 -->
      <router-link :to="{ name: 'Home' }" 
        class="nav-link" 
        active-class="active">Home
      </router-link>
      <router-link :to="{ name: 'Test' }" 
        class="nav-link" 
        active-class="active">Test
      </router-link>
    </div>
    <h2>테스트 페이지</h2>
    <div id="app">
      <p>{{ msg }}</p>

      <global-component v-bind:initial-test="counter"></global-component>

      <local-component v-bind:num="value"></local-component>
      <button v-on:click="plus">클릭해보세요!</button>
    </div>
  </div>
</template>

<!-- javascript -->
<script>
import LocalComponent from '../components/LocalComponent.vue'
//import Vue from 'vue'
//import GlobalComponent from '../components/GlobalComponent.vue'

//Vue.component(GlobalComponent.name, GlobalComponent)

export default {
  components: {
    'local-component': LocalComponent
  },
  data () {
    return {
      msg: 'Vue 객체 데이터',
      counter: 0,
      value: 0
    }
  },
  methods: {
    plus () {
      this.value++
    }
  }
}
</script>
