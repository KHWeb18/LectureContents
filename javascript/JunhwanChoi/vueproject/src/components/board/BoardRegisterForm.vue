<template>
        <v-container>
            <div style="display: flex">
                <div class="section" >
                        <img class="activeimg" src="@/assets/vaccineafter.jpg" width="600px" height="700px">
                </div>
                    <form @submit.prevent="onSubmit">
                        <div id="app">
                            <v-app id="inspire">
                                <v-card
                                :loading="loading"
                                class="mx-auto my-12"
                                max-width="800"
                                >
                                <template slot="progress">
                                    <v-progress-linear
                                    color="deep-purple"
                                    height="10"
                                    indeterminate
                                    ></v-progress-linear>
                                </template>
                            
                                <v-img
                                    height="200"
                                    width="600"
                                    src="@/assets/vaccineimg.jpg"
                                ></v-img>
                            
                                <v-card-title><b>소중한 백신 후기를 공유해 주세요.</b></v-card-title>
                            
                                <v-card-text>
                                    <v-row
                                    align="center"
                                    class="mx-0"
                                    >
                                    </v-row>
                
                                    백신 종류  <v-text-field v-model="vaccine" flat solo></v-text-field>
                                    나이  <v-text-field v-model="age" flat solo></v-text-field>
                                    성별  <v-text-field v-model="gender" flat solo></v-text-field>
                                    후기  <v-text-field v-model="content" flat solo></v-text-field>
                                
                                
                                
                                        <div>
                                        <v-btn color="blue lighten-5" >
                                            <button type="submit">등록</button>
                                        </v-btn>
                                        <v-btn color="blue lighten-5">
                                            <router-link :to="{ name: 'BoardListPage' }">
                                                취소
                                            </router-link>
                                        </v-btn>
                                    </div>
                                    </v-card-text>
                                

                        </v-card>
                    </v-app>
                    </div>
                </form>
                
            </div>
        </v-container>  
</template>

<script>
export default {
    name: 'BoardRegisterForm',
    data () {
        return {
            vaccine:'',
            age:'',
            gender:'',
            content: ''
        }
    },
    methods: {
        onSubmit () {
            const { age, gender, vaccine, content } = this
            this.$emit('submit', { age, gender, vaccine, content })
        }
    }
}
</script>

<style scoped>
p{
    color:white;
}
.section{
    margin-right: 20px;
    margin-top: 40px;
}
    
</style>





