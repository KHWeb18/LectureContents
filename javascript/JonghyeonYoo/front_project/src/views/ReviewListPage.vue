<template>
    <div id="review">  
        <review-list :reviews="reviews"/> <!-- 여기서 : <-는 v-bind를 의미한다 --> 
        
    </div>
</template>

<script>

import ReviewList from '@/components/review/ReviewList.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'ReviewListPage',    
    components: {
        ReviewList,
 
    },
    computed: {
        ...mapState(['reviews'])
    },
    mounted () {
        this.fetchReviewList()
    },
    methods: {
        ...mapActions(['fetchReviewList'])
    },
    
}
</script>