<template>
    <div>
        <info-bar></info-bar><br>
        <v-container>
            <h4>코로나 확진자 정보</h4>
            <hr><br>

            <v-card class="card"><br>
                <!-- {{coviditems.createDt.substring(0,13)}} -->

                <div class="text">
                    <span class="head">위기 경보</span>
                    <span class="state">심각</span>
                    <p class="covidtitle">코로나바이러스감염증-19</p><br>
                    <p class="covidtitle">{{dong}}</p><br>

                    <v-card
                        class="mx-auto"
                        max-width="400"
                    >
                        <v-list-item two-line>
                        <v-list-item-content>
                            <v-list-item-title class="text-h5">
                            </v-list-item-title>
                            <v-list-item-subtitle>! {{currentCreatDt}}:00 기준</v-list-item-subtitle>
                        </v-list-item-content>
                        </v-list-item>

                        <v-card-text v-show="time==0">
                        <v-row align="center">
                            <v-col
                            class="text-h5"
                            cols="12"
                            >
                            <span>누적 확진자 :</span>
                            <span> {{todayDecideString}}명</span>
                            </v-col>
                            
                            <v-col cols="12"
                            class="text-h5"
                            ><br>
                            <span class="plusicon"> +</span>
                            <span> {{todayDecideCnt - yesterdayDecideCnt}}명</span>
                            </v-col>
                        </v-row>
                        </v-card-text>

                         <v-card-text v-show="time==1">
                        <v-row align="center">
                            <v-col
                            class="text-h5"
                            cols="12"
                            >
                            <span>검사 중 :</span>
                            <span> {{todayExamString}}명</span>
                            </v-col>
                            
                            <v-col cols="12"
                            class="text-h5"
                            ><br>
                            
                            <span class="plusicon" v-if="(todayExamCnt - yesterdayExamCnt)>0"> +</span>
                            <span class="plusicon" v-if="(todayExamCnt - yesterdayExamCnt)<0"> </span>
                            <span> {{todayExamCnt - yesterdayExamCnt}}명</span>
                            </v-col>
                        </v-row>
                        </v-card-text>

                        <v-card-text v-show="time==2">
                        <v-row align="center">
                            <v-col
                            class="text-h5"
                            cols="12"
                            >
                            <span>누적 검사 수 :</span>
                            <span> {{todayAccExamString}}명</span>
                            </v-col>
                            
                            <v-col cols="12"
                            class="text-h5"
                            ><br>
                            <span class="plusicon"> +</span>
                            <span> {{todayAccExamCnt - yesterdayAccExamCnt}}명</span>
                            </v-col>
                        </v-row>
                        </v-card-text>

                         <v-card-text v-show="time==3">
                        <v-row align="center">
                            <v-col
                            class="text-h5"
                            cols="12"
                            >
                            <span>격리 해제 :</span>
                            <span> {{todayClearString}}명</span>
                            </v-col>
                            
                            <v-col cols="12"
                            class="text-h5"
                            ><br>
                            <span class="plusicon"> +</span>
                            <span> {{todayClearCnt - yesterdayClearCnt}}명</span>
                            </v-col>
                        </v-row>
                        </v-card-text>

                        <v-card-text v-show="time==4">
                        <v-row align="center">
                            <v-col
                            class="text-h5"
                            cols="12"
                            >
                            <span>치료 중 :</span>
                            <span> {{todayCareString}}명</span>
                            </v-col>
                            
                            <v-col cols="12"
                            class="text-h5"
                            ><br>
                            <span class="plusicon"> </span>
                            <span> {{todayCareCnt - yesterdayCareCnt}}명</span>
                            </v-col>
                        </v-row>
                        </v-card-text>

                         <v-card-text v-show="time==5">
                        <v-row align="center">
                            <v-col
                            class="text-h5"
                            cols="12"
                            >
                            <span>사망자 수  :</span>
                            <span> {{todayDeathString}}명</span>
                            </v-col>
                            
                            <v-col cols="12"
                            class="text-h5"
                            ><br>
                            <span class="plusicon"> +</span>
                            <span> {{todayDeathCnt - yesterdayDeathCnt}}명</span>
                            </v-col>
                        </v-row>
                        </v-card-text>

                       

                        <v-slider
                        v-model="time"
                        :max="5"
                        :tick-labels="labels"
                        class="mx-4"
                        ticks
                        ></v-slider>

                       
                        <v-divider></v-divider>

                        <v-card-actions>
                            <v-list-item-title class="text-h7">
                            스크롤을 넘기며 다양한 정보를 확인하세요.
                            </v-list-item-title>
                        </v-card-actions>
                </v-card>
                </div>
                
                <br>
            </v-card>
        </v-container>
    </div>
</template>
<script>

import InfoBar from '@/components/bar/InfoBar.vue'
import axios from 'axios'

export default {
  components:{
      InfoBar,
  },
  data () {
    return {
    labels: ['1', '2', '3', '4', '5', '6'],
    time:0,
        

    // api 부분
      coviditems: [],
      yesterday:[],

      //누적확진자 / 금일확진자
      todayDecideCnt: 0,
      todayDecideString: 0,  //.locale사용
      yesterdayDecideCnt: 0,

      //검사중 
      todayExamCnt: 0,
      todayExamString: 0,
      yesterdayExamCnt: 0,

      //격리해제 
      todayClearCnt: 0,
      todayClearString: 0,
      yesterdayClearCnt: 0,

      //사망자
      todayDeathCnt: 0,
      todayDeathString: 0,
      yesterdayDeathCnt: 0,

      //누적검사 수
      todayAccExamCnt:0,
      todayAccExamString:0,
      yesterdayAccExamCnt:0,

      //치료중
      todayCareCnt:0,
      todayCareString:0,
      yesterdayCareCnt:0,
      
      //등록일자
      currentCreatDt:0,
      
      //부동산
      apitest:[],
      dong:'',
    
    }
  },
  created () {
    axios.get('/openapi/service/rest/Covid19/getCovid19InfStateJson?serviceKey=56N1oIB7JUQYnzCMOw7aPCWtyq2oQUUJ5bzS1Dak3Y49j7n93E7PjNlaORzNdbZuCNHpZ%2B5aSgGURTgHaajwIg%3D%3D&pageNo=1&numOfRows=10&startCreateDt=20210914&endCreateDt=20210914')

      .then((response) => {
        var xml = response.data.response.body.items.item
        this.coviditems=xml

        this.todayDecideCnt= response.data.response.body.items.item.decideCnt
        this.todayExamCnt= response.data.response.body.items.item.examCnt
        this.todayClearCnt= response.data.response.body.items.item.clearCnt
        this.todayDeathCnt= response.data.response.body.items.item.deathCnt
        this.todayAccExamCnt= response.data.response.body.items.item.accExamCnt
        this.todayCareCnt= response.data.response.body.items.item.careCnt

        this.todayDecideString= this.todayDecideCnt.toLocaleString('en-US')
        this.todayExamString= this.todayExamCnt.toLocaleString('en-US')
        this.todayClearString= this.todayClearCnt.toLocaleString('en-US')
        this.todayDeathString= this.todayDeathCnt.toLocaleString('en-US')
        this.todayAccExamString= this.todayAccExamCnt.toLocaleString('en-US')
        this.todayCareString= this.todayCareCnt.toLocaleString('en-US')

        this.currentCreatDt=response.data.response.body.items.item.createDt.split(':')[0]


      }),
      axios.get('/openapi/service/rest/Covid19/getCovid19InfStateJson?serviceKey=56N1oIB7JUQYnzCMOw7aPCWtyq2oQUUJ5bzS1Dak3Y49j7n93E7PjNlaORzNdbZuCNHpZ%2B5aSgGURTgHaajwIg%3D%3D&pageNo=1&numOfRows=10&startCreateDt=20210913&endCreateDt=20210913')

      .then((response) => {
        var yxml = response.data.response.body.items.item
        this.yesterday= yxml

        this.yesterdayDecideCnt= response.data.response.body.items.item.decideCnt
        this.yesterdayExamCnt= response.data.response.body.items.item.examCnt
        this.yesterdayClearCnt= response.data.response.body.items.item.clearCnt
        this.yesterdayDeathCnt= response.data.response.body.items.item.deathCnt
        this.yesterdayAccExamCnt= response.data.response.body.items.item.accExamCnt
        this.yesterdayCareCnt= response.data.response.body.items.item.careCnt

      

      })


  },
  

  
  
  
}
  

</script>
<style scoped>
.card{
    border-radius: 10px;
}
.text{
    text-align:center;
    background: #dcdcdc;
    margin-left: 10%;
    margin-right: 10%;
    padding-top: 15px;
    border-radius: 10px;
    height: 500px;

}
.head{
    font-size: 20px;
    display:inline;
    
}
.state{
    font-size: 20px;
    font-weight: bold;
    margin-left: 10px;
    background: red;
    color:white;
    vertical-align: top;
    padding: 0 6px;
    border-radius: 10px;

}

.covidtitle{
    font-size: 30px;
    font-weight: bold;

}
.plusicon{
    font-size:20px;
    font-weight: bold;
    color:red;

}



</style>