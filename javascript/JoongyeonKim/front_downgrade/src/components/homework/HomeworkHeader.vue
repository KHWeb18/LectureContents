<template>
    <div>
        <h2>Homework 헤더</h2>
        <h2>{{ msg }}</h2>
    </div>
</template>

<script>

export default {
    data() {
        return {
            msg: "판타지온라인에 오신 것을 환영합니다!"
        }
    }
}

</script>

<style scoped>

div {
    background-color: aqua;
}

</style>
