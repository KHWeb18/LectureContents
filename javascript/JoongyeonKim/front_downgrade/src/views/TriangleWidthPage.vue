<template>
    <div align="center">
        <h2>삼각형 넓이 구하기</h2>
            밑면:<input type="number" v-model="bottomline">
            높이:<input type="number" v-model="height"><br>
            넓이:{{answer}}
    </div>
            
</template>

<script>

export default {
    name: 'TriangleWidthPage',
    data() {
            return {
                bottomline: 0,
                height: 0,   
            }
        },
        computed: {
            answer() {
                return this.bottomline * this.height / 2.0;
            }
        }
    }

</script>