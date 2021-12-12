<template>
    <div>
        <info-bar></info-bar><br>
        <v-container>
            <h4>코로나 / 건강 관련 뉴스</h4>
            <hr><br>

            <v-card class="card">
                <div>
                    <v-simple-table>
                        <thead>
                            
                        </thead>
                        <tbody>
                            <tr v-for="(list,idx) in lists" :key="idx">
                                    <td style="color: gray" width="200px" >{{ list.newsNo }}</td>
                                    <td><a @click="clickNews(list.address)">{{ list.title }}</a></td>
                                    <!-- <td>{{ list.title }}</td> -->
                            </tr>
                        </tbody>
                    </v-simple-table>
                </div>
            </v-card>
        </v-container>
    </div>
</template>
<script>

import InfoBar from '@/components/bar/InfoBar.vue'
import { mapState } from 'vuex'

export default {
    components:{
        InfoBar,
    },
    created() {

        this.$store.dispatch('crawlFind', 'daumnews')
    },
    computed: {
        ...mapState ({
            lists: state => state.lists
        })
    },
    methods: {
        
        clickNews(address){
            window.open(address, 'newslink', 'width: 1000px, height: 800px')
        }
    }
}
</script>