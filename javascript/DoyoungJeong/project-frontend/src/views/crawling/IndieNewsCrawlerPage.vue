<template>
    <div align="center" class="grey darken-0.1" style="height: 850px;"> 
        <h3 class="topBar" style="margin-top: 0px; padding-top: 30px;">INDIE NEWS THIS WEEK</h3>
        <p class="description">오늘의 최신 인디음악 관련 뉴스를 확인해보세요 :)</p>

        <v-container>
            <table>
                <tr>
                    <th class="text-left description" width="15%;">No.</th>
                    <th class="text-left description" width="50%;">제목</th>

                    <td><v-text-field label="키워드 입력" type="text" required v-model="keyword" style="margin-bottom: -15px;"></v-text-field></td>

                    <td><v-btn @click="update(keyword)" text color="red"
                    style="margin-left: 20px;">UPDATE</v-btn></td>              
                </tr>
                <tr v-for="news of newsList" :key="news.title">
                    <td style="color: pink">{{ news.newsNo }}</td>
                    <td><a v-bind:href="news.address" target='_blank'>{{ news.title }}</a></td>  <!--  target='_blank'는 a를 새 창에서 열리게함 -->
                </tr>
            </table>
        </v-container>
    </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
    name: 'IndieNewsCrawlerPage',
    data() {
        return {
            keyword: ''
        }
    },
    computed: {
        ...mapState({ newsList: state => state.newsList }, ['isLoggedIn'])
    },
    methods: {
        update(keyword) {
            this.$store.dispatch('crawlFind', keyword)
        }
    },
    mounted() {
        this.$store.state.userProfile = this.$cookies.get("currentUser")

        if(this.$store.state.userProfile.id != '') {

            this.$store.state.isLoggedIn = true
            this.$store.state.userIdentity = this.$store.state.userProfile.identity
        }
    }
}
</script>
