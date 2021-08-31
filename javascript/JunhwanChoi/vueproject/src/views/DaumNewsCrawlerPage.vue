<template>
    <div>
        <v-btn @click="start('daumnews')" text color="black"
                    style="padding: 10px; width: 90px;">뉴스보기</v-btn>
        <v-simple-table>
        <thead>
            <tr>
                <th class="text-left"><h5>코로나 뉴스</h5></th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(list,idx) in lists" :key="idx">
                    <td style="color: gray" width="200px">{{ list.newsNo }}</td>
                    <!-- <td><a @click="clickNews(list.newsNo)">{{ list.title }}</a></td> -->
                    <td>{{ list.title }}</td>
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
            lists: state => state.lists
        })
    },
    methods: {
        start (category) {
            // action 수동 호출
            this.$store.dispatch('crawlFind', category)
        }
    }
}
</script>