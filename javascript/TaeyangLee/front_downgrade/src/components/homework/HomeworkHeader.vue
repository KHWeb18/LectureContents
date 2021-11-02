<template>
    <div>
        <h2>Homework 헤더</h2>
        <p>{{ msg }}</p>
    </div>
</template>

<script>
export default {
    data () {
        return {
            msg: '판타지 온라인에 접속한것을 환영합니다.'
        }
    }
}
</script>

<style scoped>
div {
    background-color: #77cce3;
}
</style>