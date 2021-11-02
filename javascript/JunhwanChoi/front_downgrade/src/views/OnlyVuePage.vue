<template>
    <div class="home">
        <h2>뷰만사용해서 삼각형 넓이 구하기</h2>
        밑변<input type="number" v-model="width"><br>
        높이<input type="number" v-model="height"><br>
        결과:{{results}}
    </div>
</template>

<script>

export default {
    name: 'OnlyVuePage',
 
    data () {
        return {
            width:0,
            height:0

        }
    },
    computed: {
        results(){
            return this.width + "*" + this.height+ " / 2.0" + "=" + this.width * this.height / 2.0;
        }
    }
}
</script>