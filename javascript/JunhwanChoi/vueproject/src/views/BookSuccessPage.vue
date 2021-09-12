
<template>
    <div>
        <v-dialog v-model="Success"  max-width="500px">
            <v-card>
                <v-card-title>
                    <span class="headline">
                        예약 내용 확인
                    </span>
                </v-card-title>
                <v-card-text>
                    <v-container grid-list-md>
                        <v-layout wrap>
                            <br>
                            <v-flex xs12 >
                                <p>예약 날짜 : <input type="text" v-model="start"></p>
                            </v-flex>
                            <v-flex xs12>
                                <p>예약 시간 : <input type="text" v-model="time"></p>
                            </v-flex>
                            <v-flex xs12>
                                <p>예약 장소 : <input type="text" v-model="title"></p>
                            </v-flex>
                        </v-layout>
                    </v-container>
                </v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    
                    <router-link :to="{ name: 'Home' }" class="nav-link" active-class="active">
                        <v-btn @click="logout" color="blue lighten-5">확인</v-btn>
                    </router-link>                    
                </v-card-actions>
            </v-card>
    </v-dialog>
    </div>
</template>

<script>
export default {
    

    data(){
      return{
            dialog: true,
            Success: true,
            
        
      }
    },
    created(){
        this.start=this.$route.query.start
        this.title=this.$route.query.title
        this.time=this.$route.query.time
        console.log(this.start)
    }
    
    
}
</script>

<style>
 

</style>

