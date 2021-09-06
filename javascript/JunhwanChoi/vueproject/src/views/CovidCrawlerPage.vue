<template>
    <div>
        <v-btn @click="start()" text color="black"
                    style="padding: 10px; width: 90px;">현황보기</v-btn>
        <v-simple-table>
        <thead>
            <tr>
                <th class="text-left"><h5>코로나 현황판</h5></th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(covidlist,idx) in covidlists" :key="idx">
                    <td style="color: gray" width="200px">{{ covidlist.covidNo }}</td>
                    <!-- <td><a @click="clickNews(list.newsNo)">{{ list.title }}</a></td> -->
                    <td>{{ covidlist.todayCnt }}</td>
            </tr>
        </tbody>
        </v-simple-table>

    </div>

</template>

<script>
import { mapState } from 'vuex'
export default {
    
    computed: {
        ...mapState ({
            covidlists: state => state.covidlists
        })
    },
    methods: {
        start (covidcategory) {
            // action 수동 호출
            this.$store.dispatch('covidCrawlFind', covidcategory)
        }
    }
}
</script>