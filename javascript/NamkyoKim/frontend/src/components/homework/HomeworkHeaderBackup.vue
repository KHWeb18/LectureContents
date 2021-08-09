<template>
<div>
    <h2>Homework 헤더</h2>
    <p>{{ msg }}</p>
</div>
</template>

<script>
export default {
    data () {
        return{
            msg: '판타지 세계에 오신것을 환영합니다'
        }
    }
}
</script>

<style scoped>
h2{
    color: #42b983;
}

div{
    background: color #77cce1;
}
</style>