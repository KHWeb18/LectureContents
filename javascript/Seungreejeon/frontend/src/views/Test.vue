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
        <div id='app'>  
            <global-component v-bind:initial-test='counter'>
            </global-component>

            <local-component v-bind:num="value"></local-component>
            <button v-on:click="plus">클릭해봐!</button>
        </div>
    </div>
</template>

// javascript 관련 파트 작성
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
        plus() {
            this.value++
        }
    }
}
</script>