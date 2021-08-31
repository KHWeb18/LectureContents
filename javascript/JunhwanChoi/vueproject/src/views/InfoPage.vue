<template>
    <div>
        <template>
            <v-card class="overflow-hidden">
                <v-app-bar absolute color="white" white>
                        <template>
                            <v-tabs align-with-title>
                            <v-tab>코로나 19란?</v-tab>
                            <v-tab>코로나 행동수칙</v-tab>
                            <v-tab>코로나 뉴스</v-tab>
                            <v-tab>확진자 정보</v-tab>
                            </v-tabs>
                        </template>
                </v-app-bar>
                        
                <v-container style="height: 1000px;"><br><br><br><br>
                    <h1>코로나 행동수칙~~~~~~~~~~~~~~</h1>    
                </v-container>     
            </v-card>
        </template>

        <div>
        <v-btn @click="covidStart('totalNo')" text color="black"
                    style="padding: 10px; width: 90px;">코로나확진자 보기</v-btn>
        <v-simple-table>
        <thead>
            <tr>
                <th class="text-left">No.</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(covidlist,idx) in covidlists" :key="idx">
                    <!-- <td style="color: gray">{{ covidlist.totalNo }}</td>
                    <td>{{ covidlist.todayNo }}</td>
                    <td>{{ covidlist.negativeNo }}</td>
                    <td>{{ covidlist.deathNo }}</td> -->
            </tr>
        </tbody>
        </v-simple-table>
    </div>

        
    </div>
</template>
<script>
 // import { mapState } from 'vuex'
export default {
    
    // computed: {
    //     ...mapState ({
    //         covidlists: state => state.covidlists
    //     })
    // },
    // methods: {
    //     covidStart (sdcategory) {
    //         // action 수동 호출
    //         this.$store.dispatch('crawlCovidFind', sdcategory)
    //     }
    // }
}
</script>