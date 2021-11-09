<template>
    <Layout>
        <template #menubar>
            <v-btn @click="start('society')" text color="red"
                    style="padding: 10px; width: 90px;">사회</v-btn>
        </template>
        <template #content>
            <v-simple-table>
                <template v-slot:default>
                    <thead>
                        <tr>
                            <th class="text-left">No.</th>
                            <th class="text-left">제목</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="list of lists" :key="list.title">
                            <td style="color: pink">{{ list.newsNo }}</td>
                            <td>{{ list.title }}</td>
                        </tr>
                    </tbody>
                </template>
            </v-simple-table>
        </template>
    </Layout>
</template>

<script>
import { mapState } from "vuex"


import Layout from '@/components/crawling/Layout.vue'


export default {
    name: 'DaumNewsCrawlerPage',
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
            this.$store.dispatch('crawlFind', category)
        }
    }
}
</script>