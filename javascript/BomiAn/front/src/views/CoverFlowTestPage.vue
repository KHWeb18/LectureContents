<template>
    <coverflow :coverList="coverList" :coverWidth="260" :index="2" :coverShadow="true"></coverflow>
</template>

<script>
import coverflow from 'vue-coverflow'
export default {
    name: 'CoverFlowTestPage',
    data () {
        return {
            coverList: [
               {
                cover: require('@/assets/img/react.png'),
                title: 'React'
              }, {
                cover: require('@/assets/img/angular.png'),
                title: 'Angular'
              }, {
                cover: require('@/assets/img/vue.png'),
                title: 'Vue'
              }, {
                cover: require('@/assets/img/webpack.png'),
                title: 'Webpack'
              }, {
                cover: require('@/assets/img/golang.png'),
                title: 'Golang'
              }, {
                cover: require('@/assets/img/node.png'),
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
