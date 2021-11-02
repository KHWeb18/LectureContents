<template>
    <button @click="addCounter">{{ counter }}</button>
</template>

<script>
// props: 에 배치해야만 컴포넌트간 데이터 전달이 가능함
export default {
    name: 'global-component',
    props: ['initialTest'],
    template: '<button @click="addCounter">{{ counter }}</button>',
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