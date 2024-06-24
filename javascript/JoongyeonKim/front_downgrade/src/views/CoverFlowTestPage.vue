<template>
    <v-container>
        <coverflow :coverList="coverList" :coverWidth="260" :index='2'></coverflow>
    </v-container>
</template>

<script>

import coverflow  from 'vue-coverflow'

export default {
  name: 'CoverflowTestPage',
  data () {
    return {
        coverList: [
         {cover: 'https://search.pstatic.net/sunny/?src=https%3A%2F%2Fmiro.medium.com%2Fmax%2F1200%2F1*YaThnxIlm3UOG6kPJcFnYQ.jpeg&type=l340_165'
          , title: 'Vue'},
         {cover: require('@/assets/img/nissan_maxima.png'),
            title: 'nissan_maxima'},
         {cover: require('@/assets/img/Sea.jpg'),
            title: 'Sea'},
         {cover: require('@/assets/img/tesla_model_x.jpg'),
            title: 'tesla_model_x'},
         {cover: require('@/assets/img/Spyder.jpg'),
            title: 'Spyder 918'},
        ],
      }
  },
  components: {
    coverflow
  }
}
</script>