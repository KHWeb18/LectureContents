<template>
    <div>
        <p class="blue lighten-5 red--text">Test</p>
        <p class="blue white--text">Test</p>
        <p class="blue darken-3">Test</p>
    <v-btn class="teal" rounded @click="roundBtnClick">Round 버튼</v-btn>
    <v-btn class="indigo" white--text @click="roundBtnClick">Round 버튼</v-btn>
     <v-btn class="indigo" dark @click="roundBtnClick">
         <v-icon>bluetooth</v-icon>
         <span>bluetooth</span>
     </v-btn>
     <v-btn fab color="orange" dark @click="orangeBluetooth">
         <v-icon>bluetooth</v-icon>
     </v-btn>
     <v-btn color="blue" class="hidden-xs-only" @click="operation">Visibliliy -xs -only</v-btn>
      <v-btn color="red" class="hidden-sm-only" @click="operation">Visibliliy -sm -only</v-btn>
       <v-btn color="green" class="hidden-md-only" @click="operation">Visibliliy -md -only</v-btn>
       <v-btn color="green" class="hidden-l-only" @click="operation">Visibliliy -l -only</v-btn>


       <!--
           앞서서 살펴봤던 conatainer의 역할을 수행하며

       -->
       <v-container fluid>
           <!-- Grid 시스템의 한행을 정의함-->
           <v-layout row wrap>
               <!-- 12개의 컬럼으로 이뤄져 한행에서 제일작은것을이 12개가 만들어지면 다음으로 자동넘김 처리-->
               <v-flex xs12 md6 class="primary white--text">
                   <div>{{ message}}</div>
               </v-flex>
                <v-flex xs4 md2 class="green white--text">
                   <div>{{ message}}</div>
               </v-flex>
                <v-flex xs4 md2 class="green white--text">
                   <div>{{ message}}</div>
               </v-flex>
                <v-flex xs4 md2 class="green white--text">
                   <div>{{ message}}</div>
               </v-flex>
           </v-layout>
            <v-layout row wrap>
               <!-- 12개의 컬럼으로 이뤄져 한행에서 제일작은것을이 12개가 만들어지면 다음으로 자동넘김 처리-->
               <v-flex xs6 md6 class="primary white--text">
                   <div>{{ message}}</div>
               </v-flex>
                <v-flex xs6 md6 class="green white--text">
                   <div>{{ message}}</div>
               </v-flex>
              
           </v-layout>
       </v-container>

       <v-layout row justify-center>
           <!--사용자에게 알림을 제공하거나 중요 정보를 포함해 의사 결정을 하도록 유도하는데 활용
           대화상자가 뜨면서 결제할것인지 아닌지 등등 활용하기가 좋음-->
           <v-dialog v-model="dialog" persistent max-width="400">
               <template v-slot:activator="{ on }">
               <v-btn color="primary" dark v-on="on">결제</v-btn>
               </template>
               <v-card>
               <v-card-title class="headline">
                   {{ service.name }}
               </v-card-title>
               <v-card-text>
                   5성급 호텔이 30% 할인! {{service.name}} 결제 하시겠습니까?
               </v-card-text>
               <v-card-actions>
                   <v-spacer></v-spacer>
                   <v-btn color="teal darken-1" text @click.native="btn_click($event)">
                       취소
                   </v-btn>
                    <v-btn color="teal darken-1" text @click.native="btn_click($event)">
                     결제승인
                   </v-btn>
               </v-card-actions>
               </v-card>
           </v-dialog>
       </v-layout>
    </div>
    
</template>

<script>
export default {
    methods: {

        btn_click ($event){
                if($event.target.innerHTML == " 결제승인 ") {
                    alert('결제가 완료되었습니다')
                    this.dialog = false;
                }else{
                    alert('그럼 꺼져 ㅋ')
                    this.dialog = false;
                }
        },
        roundBtnClick(){
            alert('데헷?')
        },
        operation(){
            alert('데헷데헷~~')
        },
        orangeBluetooth(){
            alert('오렌지 파란이빨 작동..')
        }
    },
    data(){
        return{
            message: '환장',
            dialog: false,
            service: {
                name: '7박8일 여행코스~'
            }
        }
    }
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