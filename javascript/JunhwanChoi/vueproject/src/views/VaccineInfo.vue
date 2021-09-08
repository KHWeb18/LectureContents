<template>
    <div>
        <vaccine-page-bar></vaccine-page-bar>
        <v-container>
            <h4>백신 정보</h4>
            <hr><br>

            <v-card class="card">
                <div class="section">
                        <img class="activeimg" src="@/assets/vaccine.jpg" width="1000px" height="900px">
                </div>
            </v-card>
        </v-container>
        
    </div>
</template>
<script>
import VaccinePageBar from '@/components/bar/VaccinePageBar.vue'
export default {
    components: {
        VaccinePageBar
    },
    
    
}
</script>
<style>
    .section{
    display:flex;
    border-radius: 10px;

}
.activeimg{
    border-radius: 50px;
    display: block;
    margin-left: auto;
    margin-right: auto;
}
</style>