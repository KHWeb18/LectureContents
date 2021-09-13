<template >
    <div>
        <v-container>
            <div class="bookalign">
                <h4 class>선별진료 예약</h4>
                <h6><i><span style="color: blue;">시간을 선택해 주세요.</span></i></h6>
                <hr><br>
            </div>
        </v-container>

        <v-container center>
            <v-card xs12>
                
                <v-time-picker
                format="ampm"
                v-model="time"
                full-width
                scrollable
                :minute="10"
                ></v-time-picker>

                
                <div class="text-center mt-3 ">
                        <v-card >
                            <br><br>
                           <h6> 날짜: {{start}}</h6><br>
                           <h6> 장소: {{title}}</h6><br>
                           <h6> 시간: {{time}}</h6><br><br>
                            <v-btn @click="timeCheck()" color="blue lighten-3">예약완료</v-btn>

                        </v-card>
                </div>

                
            </v-card>

           
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
    .testcard{
        align-items: center;
    }
</style>