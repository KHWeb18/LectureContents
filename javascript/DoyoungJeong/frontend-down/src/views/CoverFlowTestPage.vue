<template>
    <div align="center" style="margin-top: 200px;">
        <coverflow :coverList="coverList" :coverWidth="300" :index="2"></coverflow>
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
                    cover: require('@/assets/img/21guns.jpg'),
                    title: '21guns'
                }, {
                    cover: require('@/assets/img/liam.jpeg'),
                    title: '1iam'
                }, {
                    cover: require('@/assets/img/slash.jpg'),
                    title: 'slash'
                }, {
                    cover: require('@/assets/img/theQuiett.jpg'),
                    title: 'theQuiett'
                }, {
                    cover: 'https://flutter-kr.io/images/flutter-logo-sharing.png',
                    title: 'Yarn'
                }, {
                    cover: 'https://miro.medium.com/max/768/1*8nyFLuZUdtMqWyu7H8glOg.png',
                    title: 'Node'
                }
            ]
        }
    },
    components: {
        coverflow
    }
}
</script>