<template>
    <coverflow :coverList="coverList" :coverWidth="260" :index="2"></coverflow>
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
                    cover: require('@/assets/img/Ferrari.jpg'),
                    title: 'Ferrari'
                }, {
                    cover: require('@/assets/img/modelX.jpg'),
                    title: 'modelX'
                }, {
                    cover: 'https://lh3.googleusercontent.com/proxy/6I0dtCPUpBZCBtBA_7siJw8JHWwS5KqHlnyvR50Jve9b3Qyd9mLBqoHIjVKSaB6LLdUiLbikgKzTqX2IMmyU5MRCjXLnwNLnfkdzIlXsjOn4JFwYXN4GyoRAr9k7YFokF4YWcSSre14l-u3eKYMFwyDsgkxr7CZhdZ5_yw',
                    title: 'maserati'
                }, {
                    cover: 'https://d2.naver.com/content/images/2020/12/1228.png',
                    title: 'Webpack'
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