<template>
    <div>
        <h2>Only Vue 삼각형 넓이 구하기</h2>
        <input type="number" v-model="width">밑변
        <input type="number" v-model="height">높이
        결과 {{results}}
    </div>
</template>

<script>


export default {
    name: 'OnlyVuePage',
    data() {
        return{
            width: 0,
            height: 0
        }
        
    },
    computed: {
        results(){
            return this.width * this.height / 2.0;
        }
    }
 
}
</script>