<template>
    <div>
    <h2>Only vue 삼각형 넓이 구하기</h2>
    밑변: <input type="number" v-model="width">
    높이: <input type="number" v-model="height">높이<br>
    결과: {{ results }}
    </div>
</template>

<script>

export default {
    name: 'OnlyVuePage',
    data () {
        return {
            width: 0,
            height: 0
        }
    },
    computed: {
        results () {
            return this.width * this.height / 2.0;
        }
    }
}
</script> 