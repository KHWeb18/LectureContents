<template>
    <div id="board">
        <h2>Only vue 삼각형 넓이 구하기</h2>
        밑변<input type="number" v-model="width">
        높이<input type="number" v-model="height"><br>
        결과: {{ results }}
    </div>
</template>

<script>
// import BoardList from '@/components/board/BoardList.vue'
// import { mapState, mapActions } from 'vuex'

export default {
    name: 'OnlyVuepage',
    data() {
        return {
            width: 0,
            height: 0

        }
    },

    components: {
    },
    computed: {
        results() {
            return this.width * this.height / 2.0;
        }
    },
  
    mounted () {
        // this.fetchBoardList()
    },
    methods: {
        // ...mapActions(['fetchBoardList'])
    }
}
</script>