<template>
<div class="container">
    <coverflow :coverList="coverList" :coverWidth="600" :index="2"></coverflow>
</div>
</template>

<script>
import coverflow from 'vue-coverflow'
export default {
    name: 'CoverflowTestPage',
    data () {
        return {
            coverList: [
                {
                    // cover: 'https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcVaw4d%2FbtqDURwZDoX%2Fq6XGmMMrktN33iW1v3gtMk%2Fimg.png',
                    cover: require('@/assets/img/AMG_GT63S.jpg'),
                    title: 'AMG_GT63S'
                }, {
                    cover:  require('@/assets/img/Ferrari_SF90.jpg'),
                    title: 'Ferrari_SF90'
                }, {
                    cover: require('@/assets/img/Porsche_Taycan.jpg'),
                    title: 'Porsche_Taycan'
                }
            ]
        }
    },
    components: {
        coverflow
    }
}
</script>

<style scoped>
.container{position: absolute; top: 50%; left: 50%;transform: translate(-50%, -50%);}
</style>