<template>
    <div>
      <v-container>
            <div style="display: flex">
                <div class="section" >
                        <img class="activeimg" src="@/assets/vaccinebefore.jpg" width="600px" height="700px">
                </div>
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
                            
                                <v-card-title><b>백신 후기</b></v-card-title>
                            
                                <v-card-text>
                                    <v-row
                                    align="center"
                                    class="mx-0"
                                    >
                                    </v-row>
                
                                    백신 종류 
                                    <td><input type="text" :value="board.vaccine" readonly flat solo></td>

                                    나이  
                                    <td><input type="text" :value="board.age" readonly flat solo></td>

                                    성별
                                    <td><input type="text" :value="board.gender" readonly flat solo></td>

                                    후기  
                                    <td><textarea cols="50" rows="20" :value="board.content" readonly></textarea></td>

                                
                                    </v-card-text>
                                

                        </v-card>
                    </v-app>
                    </div>
                
            </div>
        </v-container>  
    </div>
</template>

<script>
export default {
    name: 'BoardRead',
    props: {
        board: {
            type: Object,
            required: true
        }
    }    
}
</script>

<style >
    .section{
    margin-right: 20px;
    margin-top: 40px;
}
    
</style>

