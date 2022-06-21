<template>
    <div align="center" class="grey darken-0.1" style="height: 850px;"> 
        <h3 class="topBar" style="margin-top: 0px; padding-top: 30px;">INDIE NEWS THIS WEEK</h3>
        <p class="description">오늘의 최신 인디음악 관련 블로그를 확인해보세요 :)</p>

        <v-container>
            <table>
                <tr>
                    <th class="text-left description" width="15%;">No.</th>
                    <th class="text-left description" width="50%;">제목</th>

                    <td width="15%;" class="footerText">
                        <p style="padding-top: 15px;">자주 찾는 키워드</p>
                    </td>

                    <td>
                        <v-btn :loading="disabled" class="ma-1" small color="teal" plain @click="update('인디밴드')">
                            인디밴드
                        </v-btn>
                    </td>

                    <td>
                        <v-btn :loading="disabled" class="ma-1" small color="teal" plain @click="update('홍대')">
                            홍대
                        </v-btn>
                    </td>

                    <td>
                        <v-btn :loading="disabled" class="ma-1" small color="teal" plain @click="update('공연')">
                            공연
                        </v-btn>
                    </td>

                    <td>
                        <v-btn :loading="disabled" class="ma-1" small color="teal" plain @click="update('콘서트')">
                            콘서트
                        </v-btn>
                    </td>

                    <td>
                        <v-btn :loading="disabled" class="ma-1" small color="teal" plain @click="update('래퍼')">
                            래퍼
                        </v-btn>
                    </td>

                    <td><v-text-field label="키워드 입력" type="text" required v-model="keyword" style="margin-bottom: -15px; width: 200px;"
                    @keydown.enter="update(keyword)"></v-text-field></td>

                    <!-- <td><v-btn @click="update(keyword)" text color="red"
                    style="margin-left: 20px;">UPDATE</v-btn></td> -->
                </tr>
                <tr v-for="news of newsList" :key="news.title">
                    <td style="color: pink">{{ news.newsNo }}</td>
                    <td colspan="8" class="description"><a v-bind:href="news.address" target='_blank'>{{ news.title }}</a></td>  <!--  target='_blank'는 a를 새 창에서 열리게함 -->
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

            this.keyword = ''
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
