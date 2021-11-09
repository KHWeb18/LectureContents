<template>
  <div class="home">   
      <div>
        <router-link :to="{ name: 'Home' }"
            class="nav-link"
            active-class="active">
        Home
        </router-link>
        <router-link :to="{ name: 'Test' }"
            class="nav-link"
            active-class="active">
        Test
        </router-link>
    </div>
    <h2>테스트 페이지</h2>
    <div id="app">
        <p>{{ msg }}</p>

        <global-component v-bind:initial-test="counter">
        </global-component>

        <local-component v-bind="value"></local-component>
        <button v-on="plus">click here!</button>
    </div>
  </div>
</template>

<script>
import LocalComponent from '../components/LocalComponent.vue'
// import Vue from 'vue'
// import GlobalComponent from '../components/GlobalComponent.vue'

// Vue.component(GlobalComponent.name, GlobalComponent)
export default {
    // components: {
    // },
    components: {
        'local-component': LocalComponent
    },
    data() {
        return {
            counter: 0,
            msg: 'vue 객체 데이터~',
            value: 0
        }
    },
    methods: {
        plus() {
            this.value++
        }

    }
}

</script>