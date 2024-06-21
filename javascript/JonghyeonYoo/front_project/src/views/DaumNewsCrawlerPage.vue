<template>
 <div class="crawl">
    <Layout>
        <template #menubar>
            <v-btn @click="start('movie')" text color="#fff"
                    style="padding: 10px; width: 90px; font-size: 20px;">영화</v-btn>
        </template>
        <template #content >
            <v-simple-table style="margin: 20px auto;" >
                <template v-slot:default>
                    <thead>
                        <tr>
                            <th class="text-left" style="font-size: 18px;" >No.</th>
                            <th class="text-left" style="font-size: 18px;">제목</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="list of lists" :key="list.title">
                            <td style="color: gray">{{ list.newsNo }}</td>
                            <td><a style="color: gray" @click="clickNews(list.title)">{{ list.title }}</a></td>
                            
                        </tr>
                    </tbody>
                </template>
            </v-simple-table>
        </template>
    </Layout>
 </div>
</template>

<script>
import Layout from '@/components/layout/Layout'
import { mapState } from 'vuex'
export default {
    components: {
        Layout
    },
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

<style scoped>
.crawl{background-color: #171717;
}
</style>