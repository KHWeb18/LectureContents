<template >
    <div>
        <v-container>
            <v-card>
                <v-time-picker
        v-model="time"
        format="ampm"
        landscape
        scrollable
        ></v-time-picker>

        <v-btn @click="timeCheck()">예약완료</v-btn>
            </v-card>

            <p><input type="text" v-model="time"></p>
            <p><input type="text" v-model="start"></p>
        </v-container>
        
    </div>
</template>
<script>
export default {
    data(){
        return{
            time:'',
        }
    },
    methods:{
        timeCheck(){
            alert('예약일자 : '+ this.start + '\n\n예약장소 : ' + this.title + '\n\n예약시간 : ' + this.time)
            this.$router.push({name:'BookRegisterPage', query:{start:this.start, title:this.title, time:this.time}})
            //this.$router.push({name:'BookSuccessPage' , query:{start:this.start}})    

        }
    },
    created(){
        this.start=this.$route.query.start
        this.title=this.$route.query.title
    }
}
</script>
<style >
    
</style>