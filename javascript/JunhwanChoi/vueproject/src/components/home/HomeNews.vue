<template>
    <div>
        <template >
            
            <div class="tablemargin">
                 <v-card>
                <v-simple-table>
                    <template>
                        <thead>
                            <tr>
                                <th class="text-left">
                                    <h5>코로나 뉴스</h5>
                                    <router-link :to="{ name: 'InfoNews' }"
                                                                class="nav-link"
                                                                active-class="active">
                                        <div class="more">
                                            MORE
                                        </div>
                                    </router-link>
                                </th>
                            </tr>
                        </thead>
                        <tbody >
                            <tr v-for="(list,idx) in lists" :key="idx" width="50px">
                                <div v-show="(idx<5)">
                                    <td style="color: gray">{{ list.newsNo }}</td>
                                    <td><a @click="clickNews(list.address)">{{ list.title }}</a></td>
                                </div>
                            </tr> 
                        </tbody>
                    </template>
                </v-simple-table>
            </v-card>
            </div>
           
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
    created(){
        this.$store.dispatch('crawlFind', 'daumnews')

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
        clickNews(address){
            window.open(address, 'newslink', 'width: 200px, height: 200px')
        }
    }
    
}
</script>

<style>
    .tablemargin{
        margin-top: 50px;
        margin-left: 200px;
        width:600px;
    }
</style>