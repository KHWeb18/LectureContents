<template>
    <div id="app"> 
        <div class="wrap">
            <div class="intro_bg">
                <img class="responsive-img" src="@/assets/mainPageImg.jpg">
            </div>
        </div> 

<!-- 
http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson?serviceKey=56N1oIB7JUQYnzCMOw7aPCWtyq2oQUUJ5bzS1Dak3Y49j7n93E7PjNlaORzNdbZuCNHpZ%2B5aSgGURTgHaajwIg%3D%3D&pageNo=1&numOfRows=10&startCreateDt=20200310&endCreateDt=20200315

-->

        <ul class="amount">
        <li>
          <div>
            <div class="contents1">누적 확진자</div>
            <div class="result">226,021</div>
          </div>
        </li>
        <li>
          <div>
            <div class="contents1">금일 확진자</div>
            <div class="result">1,064</div>
          </div>
        </li>
        <li>
          <div>
            <div class="contents1">격리 해제</div>
            <div class="result">27,011+</div>
          </div>
        </li>
        <li>
            <div>
              <div class="contents1">사망</div>
              <div class="result">2.773</div>
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
            <router-link :to="{ name: 'InfoPage' }"
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
            <router-link :to="{ name: 'DaumNewsCrawlerPage' }"
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
            <router-link :to="{ name: 'InfoPage' }"
                    class="nav-link"
                    active-class="active">
                    <div class="more">
                        MORE
                    </div>
            </router-link>
            <router-link :to="{ name: 'AccountRegisterPage' }"
                    class="nav-link"
                    active-class="active">
                Account 회원 가입
            </router-link>
            <router-link :to="{ name: 'SessionLoginPage' }"
                    class="nav-link"
                    active-class="active">
                Account 로그인 Test
            </router-link>
          </li>
        </ul>
    </div>
</template>

<script>


export default {
  
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
  width:1000px;
  background: white;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
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
  width:1280px;
  height: 302px;
 
  margin:auto;
}
.icons > li {
  flex: 1;
  background: white;
  margin-top:49px;
  height:302px;
  text-align: center;
}
.icons > li > .icon_img{
  margin-top:18px;
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