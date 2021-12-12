<template>
    <div class="footer">
        <v-footer app class="blue-grey lighten-4" fixed>
            <v-flex  xs10 md5></v-flex>
            <span class="mx-auto">
                Copyright © {{new Date() | moment('YYYY')}} All Rights Reserved.
            </span>
            <v-flex xs10 md5></v-flex>
            
            
        </v-footer>

    </div>
</template>
<script>
export default {
    
}
</script>
<style scoped>
    .footer{
        margin-top:200px;
    }
    .dddd{
        text-align: justify;
        display:flex;
        border-radius: 10px;
    }
   
    
    
</style>