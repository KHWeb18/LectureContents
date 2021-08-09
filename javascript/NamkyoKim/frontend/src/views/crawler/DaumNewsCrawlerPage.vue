<template>
    <Layout>
        <template #menubar>
            <v-btn @click="start('society')" text color="black"
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
                            <td style="color: gray">{{ list.newsNo }}</td>
                            <!-- <td><a @click="clickNews(list.newsNo)">{{ list.title }}</a></td> -->
                            <td>{{ list.title }}</td>
                        </tr>
                    </tbody>
                </template>
            </v-simple-table>
        </template>
    </Layout>
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