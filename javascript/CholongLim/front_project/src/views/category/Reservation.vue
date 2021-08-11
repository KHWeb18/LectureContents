<template>
    <div>
        <div>
            <v-img class="about-img-top" src="https://images.pexels.com/photos/4996961/pexels-photo-4996961.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
            </v-img>
        </div>
        <div class="section">
            <p>" We travel, some of us forever, to seek other places, other lives, other souls. "</p>
        </div>
        <v-container class="about-top">
            <p>WELCOME TO CINZEL</p>
            <h1>CINZEL RESERVATION</h1>
            <p>| 예약안내 |</p>
        </v-container>

        <v-divider></v-divider>

        <v-container>
            <v-container class="btn-box">
                <v-btn router :to="'/book'" color="text-white blue lighten-2" width="200px" height="50px">
                예약하기
                </v-btn>
            </v-container>
        </v-container>

        <v-divider></v-divider>

         <div class="back-box">
            <div class="container">
                  <v-container class="container2">
                      <h4>[ 요금안내 ]</h4>
                      <v-divider></v-divider>
                      
                      <v-container class="info-text">
                        예약전화 : 010-7751-8851 / 예약계좌 : 농협 1108-000112-0119 (예금주: 펜션)<br>
                        입금대기시간<br>
                        1. 예약신청 후 12시간 내로 전액을 입금하셔야 예약이 완료됩니다.<br>
                        2. 당일예약/하루 전 예약 시 1시간 내로 결제를 완료해 주셔야됩니다.<br>
                        * 입금 대기 시간이 경과되면 예약 신청이 자동 취소됩니다.<br>
                      </v-container>

                        <div>
                            <v-simple-table class="pay-box">
                                <template>
                                    <thead>
                                        <tr class="top-tr">
                                            <th>객실명</th>
                                            <th>형태</th>
                                            <th>기준/최대</th>
                                            <th>가격</th>
                                        </tr>
                                        <tr v-for="pay in pays" :key="pay">
                                            <th>{{ pay.name }}</th>
                                            <th>{{ pay.form }}</th>
                                            <th>{{ pay.num }}</th>
                                            <th>{{ pay.price }}</th>
                                        </tr>
                                    </thead>
                                </template>
                            </v-simple-table>
                        </div>
                      
                      <h4>[ 이용안내 & 유의사항 ]</h4>
                      <v-divider></v-divider>
                      <v-container class="info-text">
                       - 입실시간:오후 3시 /퇴실시간:오전 11시<br>
                       - 전 객실 및 펜션내부는 금연구역입니다. (절대금연)<br>
                       - 애완동물은 타 객실 손님을 위해 입실을 금하오니 이점 양해바랍니다. <br>
                       - 보호자를 동반하지 않은 미성년자는 어떠한 경우라도 입실 하실 수 없습니다.<br>
                       - 화재의 위험이 있는 촛불 및 폭죽사용, 부탄가스 사용을 금지합니다. <br>
                       - 퇴실 전 객실정리 후 퇴실점검 부탁드립니다.<br>
                      </v-container>

                       <h4>[ 환불규정 ]</h4>
                       <v-divider></v-divider>
                       <v-container class="info-text">
                       - 예약을 하실 경우에는 신중히 결정하여 주시길 부탁 드립니다.<br>
                       - 환불은 입금자 확인후 지정하신 계좌로 보내드립니다. (송금수수료제외)<br>
                       - 단, 예약 이용일 변경은 예약취소에 해당됩니다. 예약취소 후 다시 예약을 해 주십시오.<br>
                       <div>
                            <v-simple-table class="pay-box">
                                <template>
                                    <thead>
                                        <tr class="top-tr">
                                            <th>취소일기준</th>
                                            <th>취소수수료</th>
                                        </tr>
                                        <tr v-for="refund in refunds" :key="refund">
                                            <th>{{ refund.day }}</th>
                                            <th>{{ refund.percent }}</th>
                                        </tr>
                                    </thead>
                                </template>
                            </v-simple-table>
                        </div>
                       </v-container>
                  </v-container>
    
            </div>
         </div>

    <v-divider></v-divider>

  </div>
</template>


<script>
  export default {
    data() {
        return {
            pays: [
                {name: '301', form: '패밀리형', num: '4명/6명', price: '300,000원' },
                {name: '302', form: '패밀리형', num: '4명/6명', price: '300,000원' },
                {name: '201', form: '커플형', num: '2명/4명', price: '240,000원' },
                {name: '202', form: '커플형', num: '2명/4명', price: '240,000원' },
            ],
            refunds: [
                {day: '기본 취소 수수료', percent: '0%' },
                {day: '이용 9일 전', percent: '0%' },
                {day: '이용 8일 전', percent: '10%' },
                {day: '이용 7일 전', percent: '20%' },
                {day: '이용 6일 전', percent: '20%' },
                {day: '이용 5일 전', percent: '20%' },
                {day: '이용 4일 전', percent: '30%' },
                {day: '이용 3일 전', percent: '50%' },
                {day: '이용 2일 전', percent: '70%' },
                {day: '이용 1일 전', percent: '100%(환불불가)' },
                {day: '이용 당일', percent: '100%(환불불가)' },
            ]
        }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');
@import url('https://fonts.googleapis.com/css2?family=MonteCarlo&display=swap');

.container{
    position: relative;
}


.back-box {
    background: #f6f7f7;
}

.info-text {
    margin: 5% 10% 5% 0%;
}
.pay-box{
    margin: 5% 0% 5% 0%;
    position: relative;
}

.top-tr {
    background-color: #bbdefb;
}
/* 기타  페이지 내부*/
.btn-box{
    padding: 18px 10px 18px 10px;
    text-align: center;
}


.intro-top {
    text-align: left;
}

.about-img-top {
    max-height: 70vh;
}


.section {
    background: #dcdfdc;
    height: 10vh;
}

p {
    font-family: 'Nanum Myeongjo';
    font-size: 18px;
    text-align: center;
    padding: 18px 0px 18px 0px;
}

.about-top {
    padding-top: 10vh;
}

/* 폰트 */

h1 {
    font-family: "Cinzel";
    font-size: 40px;
    text-align: center;
    margin-top: 10px;
}

h2 {
    font-family: 'MonteCarlo';
    font-size: 150px;
    color:darkgrey
}

h3 {
    font-family: "Cinzel";
    font-size: 80px;
    margin-top: 10px;
    color:darkgrey;
}

h4 {
    margin-top: 10%;
    font-family: 'Nanum Myeongjo';
    font-size: 35px;
}
</style>