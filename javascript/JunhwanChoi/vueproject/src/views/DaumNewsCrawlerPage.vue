<template>
    <div>
        <v-simple-table>
        <thead>
            <tr>
                <th class="text-left"><h5>코로나 뉴스</h5></th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(list,idx) in lists" :key="idx">
                    <td style="color: gray" width="200px" >{{ list.newsNo }}</td>
                    <td><a @click="clickNews(list.address)">{{ list.title }}</a></td>
            </tr>
        </tbody>
        </v-simple-table>
         {{lists}}

    </div>

</template>

<script>
import { mapState } from 'vuex'
export default {
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