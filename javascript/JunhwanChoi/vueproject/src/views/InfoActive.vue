<template>
    <div>
        <info-bar></info-bar><br>
        <v-container>
            <h4>코로나 행동수칙</h4>
            <hr><br>

            <v-card class="card">
                <div class="section">
                        <img class="activeimg" src="@/assets/info-active.png" width="1000px" height="900px">
                </div>
            </v-card>
        </v-container>
    </div>
</template>
<script>

import InfoBar from '@/components/bar/InfoBar.vue'

export default {
    components: {
        InfoBar,
        
    },
}
</script>

<style scoped>

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