<template>
    <Layout>
        <template #tour>
                 <v-btn @click="start('서귀포+관광')" text  color="blue lighten-2" class="crawler-btn"
                    style="padding: 0px; width: 200px;" large>서귀포 관광지 추천</v-btn>
        </template>
        <template #content>
             <v-simple-table class="crawler">
                <template v-slot:default>
                    <tbody>
                        <tr v-for="list of lists" :key="list.title">
                            <td style="color: gray">{{ list.tourNo }}</td>
                            <td><a v-bind:href="list.address">{{ list.title }}</a></td>
                            
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
            this.$store.dispatch('crawlFind', category)
        }
    }
}
</script>

<style scoped>


.crawler-btn{
    position: relative;
    left: 66%;
    border: 1px solid #64B5F6;
}
.crawler{
    width: 800px;
    text-align: center;
    position: relative;
    left:15%;
}

.crawler-color{
    background-color: rgb(233, 233, 233);
}
</style>
