<!-- HTML 요소 파트 작성 - Vue랑 연결 시킬 형식으로 작성해도 무방 -->
<template>
    <div class="home">
        <div id="header">
            <!-- router-link는 어디로 갈지 URL 맵핑해주는 Spring의 Controller 같은 역할
                 to: Home은 이 녀석을 클릭했을 때 router/index.js에 등록된 Home으로 가게 만듬 
                 class: nav-link의 경우 Navigation Bar 같은 역할을 해줄 수 있게 구성함을 의미
                 active-class: 링크가 활성화 되었을때 적용된 CSS를 의미함 -->
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
            <button v-on:click="plus">클릭해봐보이~</button>

            <local-Component v-model="monsters"></local-Component>
            <button v-on:click="summon">몬스터소환!(1마리)</button>
            <p>{{ monsters }}</p>
        </div>
    </div>
</template>

<!-- javascript 관련 파트 작성 -->
<script>
import LocalComponent from '../components/LocalComponent.vue'
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
        plus (){
            this.value++
        },
        summon (){
            this.monsters = '몽키'        }

    }
}
</script>