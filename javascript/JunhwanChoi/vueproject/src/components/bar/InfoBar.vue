<template>
    <div>
        <v-container>
        <v-toolbar dense color="white">
                    <v-toolbar-items>
                        <v-btn  text class="text-center" 
                                    v-for="link in links" :key="link.icon" :to="link.route" >
                                    {{link.text}}
                        </v-btn>
                    </v-toolbar-items>
        </v-toolbar>
        </v-container>
        
    </div>
</template>

<script>
export default {
    data () {
        return {
        
            links:
                [
                    {
                        text: '코로나 19란?',
                        name: 'InfoCovid',
                        route:'/infoCovid'
                    },
                    {
                        text: '코로나 행동수칙',
                        name: 'InfoActive',
                        route:'/infoActive'
                    },
                    {
                        text: '관련 뉴스',
                        name: 'InfoNews',
                        route:'/infoNews'
                    },
                    {
                        text: '확진자 정보',
                        name: 'InfoCovidCnt',
                        route:'/infoCovidCnt'
                    }
                ],
           
        }
    },

}
</script>

<style scoped>
h1 {
    margin: 10px;
}
p {
    padding: 10px;
    margin: 5px 10px;
}
</style>


