<template>
    <div>
        <template >
            <v-card>
                <v-simple-table>
                    <template>
                        <thead>
                            <tr>
                                <th class="text-left">No.</th>
                            </tr>
                        </thead>
                        <tbody >
                            <tr v-for="(list,idx) in lists" :key="idx" width="50px">
                                <div v-show="(idx<5)">
                                    <td style="color: gray">{{ list.newsNo }}</td>
                                    <!-- <td><a @click="clickNews(list.newsNo)">{{ list.title }}</a></td> -->
                                    <td>{{ list.title }}</td>
                                </div>
                            </tr> 
                        </tbody>
                    </template>
                </v-simple-table>
            </v-card>
        </template>
    </div>
</template>

<script>
//import Layout from '@/components/layout/Layout'
import { mapState } from 'vuex'
export default {
    data(){
        return {
           
        }
    },

    components: {
       // Layout
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
        },
    
        
    }
}
</script>