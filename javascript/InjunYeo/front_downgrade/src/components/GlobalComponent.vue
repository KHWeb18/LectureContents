<!--
뷰 어디서든 접근이 가능함
-->  
<template>
    <button @click="addCounter">{{ counter }}</button>
</template>


<script>
export default {
    name: 'global-component',
    props: ['initialTest',],
    data () {
        return {
            counter: this.initialTest
        }
    },
    methods: {
        addCounter () {
            this.counter += 1
        }
    }
}
</script>