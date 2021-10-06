<template>
    <div id="app"> 
        <div class="wrap">
            <div class="intro_bg">
                <img class="responsive-img" src="@/assets/main.png">
            </div>
        </div> 

        <ul class="amount">
        <li>
          <div>
            <div class="contents1">누적 확진자</div>
            <font color="red">+</font>{{todayDecideCnt - yesterdayDecideCnt}}
            <div class="result">{{todayDecideString}}명</div>
          </div>
        </li>
        <li>
          <div>
            <div class="contents1">검사 중 </div>
            <font color="red"></font>{{todayExamCnt - yesterdayExamCnt}}
            
            <div class="result">{{todayExamString}}명</div>
            
          </div>
        </li>
        <li>
          <div>
            <div class="contents1">격리 해제</div>
            <font color="red">+</font>{{todayClearCnt - yesterdayClearCnt}}
            <div class="result">{{todayClearString}}명</div>
          </div>
        </li>
        <li>
            <div>
              <div class="contents1">사망</div>
              <font color="red">+</font>{{todayDeathCnt - yesterdayDeathCnt}}
              <div class="result">{{todayDeathString}}명</div>
            </div>
        </li>
      </ul>

      <ul class="icons">
          <li>
            <div class="icon_img">
              <img src="@/assets/icon-light.png" width="70px" height="70px">
            </div>
            <div class="contents1_bold">코로나 정보</div>
            <div class="contents2">
                예방수칙, 확진자 정보 등 코로나 관련 정보를 확인하세요.
            </div>
            <router-link :to="{ name: 'InfoCovid' }"
                    class="nav-link"
                    active-class="active">
                    <div class="more">
                        MORE
                    </div>
            </router-link>
            
          </li>

          <li>
            <div class="icon_img">
              <img src="@/assets/icon-board.png" width="70px" height="70px">
            </div>
            <div class="contents1_bold">백신 게시판</div>
            <div class="contents2">
                각종 백신 정보를 확인하고, 경험도 공유해 보세요.
            </div>
            <router-link :to="{ name: 'BoardListPage' }"
                    class="nav-link"
                    active-class="active">
                    <div class="more">
                        MORE
                    </div>
            </router-link>
          </li>

          <li>
            <div class="icon_img" >
              <img src="@/assets/icon-covid.png" width="70px" height="70px">
            </div>
            <div class="contents1_bold">선별진료 예약</div>
            <div class="contents2">
                온라인 예약으로 보다 안전하고 편리하게 진료 받으세요.
            </div>
            <router-link :to="{ name: 'Calendar' }"
                    class="nav-link"
                    active-class="active">
                    <div class="more">
                        MORE
                    </div>
            </router-link>
            
          </li>
        </ul>
    </div>
</template>

<script>

import axios from 'axios'

export default {
  data () {
    return {
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

        this.todayDecideString= this.todayDecideCnt.toLocaleString('en-US')
        this.todayExamString= this.todayExamCnt.toLocaleString('en-US')
        this.todayClearString= this.todayClearCnt.toLocaleString('en-US')
        this.todayDeathString= this.todayDeathCnt.toLocaleString('en-US')

      }),
      axios.get('/openapi/service/rest/Covid19/getCovid19InfStateJson?serviceKey=56N1oIB7JUQYnzCMOw7aPCWtyq2oQUUJ5bzS1Dak3Y49j7n93E7PjNlaORzNdbZuCNHpZ%2B5aSgGURTgHaajwIg%3D%3D&pageNo=1&numOfRows=10&startCreateDt=20210913&endCreateDt=20210913')

      .then((response) => {
        var yxml = response.data.response.body.items.item
        this.yesterday= yxml

        this.yesterdayDecideCnt= response.data.response.body.items.item.decideCnt
        this.yesterdayExamCnt= response.data.response.body.items.item.examCnt
        this.yesterdayClearCnt= response.data.response.body.items.item.clearCnt
        this.yesterdayDeathCnt= response.data.response.body.items.item.deathCnt

      

      })

  },
  
  
}
  

</script>

<style  scoped>


.intro_bg{
  width: 100%;
  height: 360px;
}
.responsive-img{
    width: 100%;
    height: 100%;
}  

.contents1{
  font-size: 20px;
  font-weight: lighter;
  margin-top:-13px;
}
.contents2{
  font-size: 18px;
}
.contents3 {
  font-size: 14px;
  font-weight: 100;
}
.contents1_bold{
  font-size: 18px;
  font-weight: bold;
}


.result{
  font-size: 24px;
}

.amount{
  position: relative;
  top:-60px;
  display: flex;
  width:1200px;
  background: white;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
  margin: 0px auto;
  text-align: center;

}
.amount > li {
  flex: 1;
  height: 130px;
}
.amount > li > div {
  margin-top:37px;
  height:57px;
}

.amount > li:not(:last-child) > div{
  border-right:1px solid #E1E1E1;
}


.icons{
  display: flex;
  width:1200px;
  height: 302px;
 
  margin:auto;
}
.icons > li {
  flex: 1;
  background: #dcdcdc;
  margin-top:20px;
  height:302px;
  text-align: center;
  border-radius: 10px;
}
.icons > li > .icon_img{
  margin-top:40px;
}

.icons > li:not(:last-child){
  margin-right: 20px;
}

.icons .contents2 {
  width:280px;
  margin:auto;
  letter-spacing: -1px;
}

.more{
  width:100px;
  height: 30px;
  background: #2F7AF4;
  color: #fff;
  font-size: 12px;
  line-height: 30px;
  margin:25px auto;
}


</style>