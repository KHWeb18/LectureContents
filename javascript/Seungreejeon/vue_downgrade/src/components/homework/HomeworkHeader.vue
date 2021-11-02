<template>
    <dvi>
        <h2>Homework</h2>
        <p> {{ msg }} </p>
    </dvi>
</template>

<script>
export default {
    data() {
        return {
            msg: '판타지 온라인에 접속한 것을 환영합니다.'
        }
    }
}
</script>

<style scoped>
div {
    background-color: aqua;
}
</style>