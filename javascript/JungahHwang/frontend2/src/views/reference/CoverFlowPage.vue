<template>
  <coverflow :coverList="coverList" :coverWidth="260" :index="2"></coverflow>
</template>


<script>
import coverflow from 'vue-coverflow'

export default {
  name: 'CoverFlowPage',
  data () {
    return {
      coverList: [
        { cover: require('@/assets/imgs/Maltese.jpg'), title: '말티즈' },
        { cover: require('@/assets/imgs/Pomeranian.jpeg'), title: '포메라니안' },
        { cover: require('@/assets/imgs/Poodle.jpeg'), title: '푸들'},
        { cover: require('@/assets/imgs/Retriever.jpeg'), title: '리트리버' },
      ],
    }
  },
  components: {
    coverflow
  }
}
</script>