<template>
    <div align="center" class="grey darken-0.1" style="height: 850px;"> 
        <h3 class="topBar" style="margin-top: 0px; padding-top: 30px;">INDIE NEWS THIS WEEK</h3>
        <p class="description">오늘의 최신 인디음악 관련 뉴스를 확인해보세요 :)</p>

        <v-container>
            
            <table>
                <tr>
                    <th class="text-left description" width="15%;">No.</th>
                    <th class="text-left description" width="70%;">제목</th>

                    <v-btn @click="update('인디 밴드')" text color="red"
                    style="padding: 10px; width: 90px;">UPDATE</v-btn>
                </tr>
                <tr v-for="news of newsList" :key="news.title">
                    <td style="color: pink">{{ news.newsNo }}</td>
                    <td><a v-bind:href="news.address">{{ news.title }}</a></td>
                </tr>
            </table>
        </v-container>
    </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
    name: 'IndieNewsCrawlerPage',
    computed: {
        ...mapState({ newsList: state => state.newsList })
    },
    methods: {
        update(keyword) {
            this.$store.dispatch('crawlFind', keyword)
        }
    }
}
</script>
