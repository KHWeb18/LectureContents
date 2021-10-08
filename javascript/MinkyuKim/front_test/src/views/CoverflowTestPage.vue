<template>
    <coverflow :coverList="coverList" :coverWidth="260" :index="2"></coverflow>
</template>

<script>
// npm add vue-coverflow
import coverflow from 'vue-coverflow'
export default {
    name: 'CoverflowTestPage',
    data () {
        return {           
            coverList: [
                {cover: require('@/assets/img/test1.jpg'), 
                title: '갑' },
                {cover: require('@/assets/img/test2.jpg'), 
                title: '을' },
                {cover: require('@/assets/img/test3.jpg'), 
                title: '병' },
                {cover: require('@/assets/img/testPhoto.jpg'), 
                title: '정' },
                {cover: 'https://media.vlpt.us/images/devpark/post/3f691ef0-d5de-4fc2-81d0-951d8ed8a36d/Ekran-Resmi-2019-11-18-18.08.13.png',
                 title: 'Angular'},
            ]
        }
    },
    components: {
        coverflow
    }    
}
</script>