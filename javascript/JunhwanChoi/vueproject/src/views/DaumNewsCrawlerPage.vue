<template>
    <div>
        <v-btn @click="start('society')" text color="black"
                    style="padding: 10px; width: 90px;">뉴스보기</v-btn>
        <v-simple-table>
        <thead>
            <tr>
                <th class="text-left">No.</th>
                <th class="text-left">제목</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(list,idx) in lists" :key="idx">
                <div v-show="(idx<5)">
                    <td style="color: gray">{{ list.newsNo }}</td>
                    <!-- <td><a @click="clickNews(list.newsNo)">{{ list.title }}</a></td> -->
                    <td>{{ list.title }}</td>
                </div>
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