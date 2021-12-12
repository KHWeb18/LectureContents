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
                        text: '백신 후기',
                        name: 'BoardListPage',
                        route:'/board'
                    },
                    {
                        text: '백신 정보',
                        name: 'VaccineInfo',
                        route:'/vaccineInfo'
                    },
                    
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


