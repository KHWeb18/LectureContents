  
<template>
    <div class="home">
        <div id="header">
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

            <local-component v-bind:num="value"></local-component>
            <button v-on:click="plus">클릭해봐!</button>

            <b>random: {{ this.$store.getters.randomFromSpring }}</b><br>
            <!-- store안의 getters의 random을 보여주란 뜻 -->
            <input type="button" @click="randomNumber()" value="random"/><br>
        </div>
    </div>
</template>

<script>
import Vue from 'vue'
import GlobalComponent from '../components/GlobalComponent.vue'
import LocalComponent from '../components/LocalComponent.vue'

import { mapActions } from 'vuex'

Vue.component(GlobalComponent.name, GlobalComponent)

export default {
    components: {
        'local-component': LocalComponent
    },
    data () {
        return {
            counter: 0,
            value: 0,
            msg: 'Vue 객체 데이터'
        }
    },
    methods: {
        ...mapActions([
            'generateRandomNumber'
        ]),
        plus () {
            this.value++
        },
        randomNumber() {
            this.generateRandomNumber()
        }
    }
}
</script>
© 2021 GitHub, Inc.