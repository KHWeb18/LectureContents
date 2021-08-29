<template>
    <div>
    <div>

        <v-container class="calendar">
            <v-row>
                <v-col cols="12" md="6" class="book-calendar">
                    <v-container>
                        <v-btn
                            fab="fab"
                            text="text"
                            small="small"
                            color="grey darken-2"
                            @click="prev"
                            class="btn-width-prev">
                            <v-icon small="small">
                                mdi-chevron-left
                            </v-icon>
                        </v-btn>
                        <h2 v-if="$refs.calendar" class="btn-between-month">
                            {{ $refs.calendar.title }}
                        </h2>
                        <v-btn
                            fab="fab"
                            text="text"
                            small="small"
                            color="grey darken-2"
                            @click="next"
                            class="btn-width-next">
                            <v-icon small="small">
                                mdi-chevron-right
                            </v-icon>
                        </v-btn>
                    </v-container>
                    <v-sheet height="400" width="600">
                        <v-calendar
                            ref="calendar"
                            v-model="date"
                            color="primary"
                            :events="events"
                            :event-color="getEventColor"
                            @input="menu1 = false"
                            :type="type"
                            @click:event="showEvent"
                            @click:more="viewDay"
                            @click:date="viewDay"
                            @change="updateRange"></v-calendar>
                    </v-sheet>
                </v-col>
            </v-row>
            <p>*2박 이상의 경우 1박씩 각각 예약 진행 하셔야 합니다.<br></p>

        </v-container>
    </div>

    <div class="container">
        <div class="overlay1">
          <v-col cols="12" md="12" xs="2" sm="12">
            <v-simple-table style="border: 2px solid #edeeee;">
                <h2>선택일</h2>
                <h3>
                    <strong>{{ date }}</strong>
                </h3>
                <v-divider></v-divider>
                <div class="text-box">
                  <h5><b>전화번호 : </b> 010-7751-8851</h5>
                  <h5><b>결제방법 : </b> 무통장</h5>
                  <h5><b>이용안내 : </b></h5>
                  <h5>- 달력에서 원하시는 날짜를 선택 하시면 예약 가능한 객실정보가 보여집니다.</h5>
                  <h5>- 예약 전 예약규정을 반드시 숙지하시고 예약을 하시기 바랍니다.</h5>
                  <h5>- 선택란의 체크박스를 체크 후 예약하기 버튼을 누르시면 예약이 진행 됩니다.</h5>
                  </div>
            </v-simple-table>
          </v-col>
        </div>
    </div>
    <div>
      <v-container>

            <p>객실선택</p>
            <v-divider></v-divider>

            <div>
                <div>
                    <v-col cols="12" sm="12">
                     <table>
                         <tr>
                          <td><v-checkbox v-model="roomId" id="301" value="301" required></v-checkbox></td>
                          <td><v-img width="200"
                                src="https://images.pexels.com/photos/7533766/pexels-photo-7533766.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
                                </v-img>
                          </td>
                          <td width="40%"><strong># Room 301</strong><br> 기준 4명/ 최대 4명<br>300,000원</td>
                          <td width="15%">기간<v-select :items="['1일']" v-model="period" label="1일" dense disabled flat solo outlined></v-select></td>
                          <td width="15%">인원<v-select label="4인" dense disabled flat solo outlined :items="['4인']" v-model="personNum"></v-select></td>
                          <td width="40%"><h6>즉시결제</h6><h1> 300,000원</h1></td>
                        </tr>
                         <tr>
                          <td><v-checkbox value="302" v-model="roomId" required id="302"></v-checkbox></td>
                          <td><v-img width="200"
                                src="https://images.pexels.com/photos/6782569/pexels-photo-6782569.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
                                </v-img>
                          </td>
                          <td width="40%"><strong># Room 302</strong><br> 기준 4명/ 최대 4명<br>300,000원</td>
                          <td width="15%">기간<v-select :items="['1일']" v-model="period" label="1일" dense disabled flat solo outlined></v-select></td>
                          <td width="15%">인원<v-select label="4인" dense disabled flat solo outlined :items="['4인']" v-model="personNum"></v-select></td>
                          <td width="40%"><h6>즉시결제</h6><h1> 300,000원</h1></td>
                        </tr>
                        <tr>
                          <td><v-checkbox v-model="roomId" id="201" value="201" required></v-checkbox></td>
                          <td><v-img width="200"
                                src="https://images.pexels.com/photos/7546712/pexels-photo-7546712.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
                                </v-img>
                          </td>
                          <td width="40%"><strong># Room 201</strong><br> 기준 2명/ 최대 2명<br>240,000원</td>
                          <td width="15%">기간<v-select :items="['1일']" v-model="period" label="1일" dense disabled flat solo outlined></v-select></td>
                          <td width="15%">인원<v-select label="2인" dense disabled flat solo outlined :items="['2인']" v-model="personNum"></v-select></td>
                          <td width="40%"><h6>즉시결제</h6><h1> 240,000원</h1></td>
                        </tr>
                        <tr>
                          <td><v-checkbox v-model="roomId" id="202" value="202" required></v-checkbox></td>
                          <td><v-img width="200"
                                src="https://images.pexels.com/photos/7546707/pexels-photo-7546707.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
                                </v-img>
                          </td>
                          <td width="40%"><strong># Room 202</strong><br> 기준 2명/ 최대 2명<br>240,000원</td>
                          <td width="15%">기간<v-select :items="['1일']" v-model="period" label="1일" dense disabled flat solo outlined></v-select></td>
                          <td width="15%">인원<v-select label="2인" dense disabled flat solo outlined :items="['2인']" v-model="personNum"></v-select></td>
                          <td width="40%"><h6>즉시결제</h6><h1> 240,000원</h1></td>
                        </tr>

                      </table> 
                            </v-col>
                        </div>
                    </div>
                </v-container>

              
                  <div class="justify-center">
              

<v-layout justify-center>
        <v-dialog v-model="dialog" persistent max-width="1000px">
        <template v-slot:activator="{ on }">
            <v-btn color="blue" width="150px" height="50px" 
            style="margin: 100px 0px 150px 0px;" v-on="on">예약하기</v-btn>  
            <v-btn color="blue lighten-3" width="150px" style="margin: 100px 0px 150px 30px;"
             height="50px" router :to="{name: 'Reservation'}">취소</v-btn>
                 
        </template>
        <v-card>
            <v-card-title primary-title class="justify-center">
                객실예약
            </v-card-title>
            <v-card-text>
                <v-container grid-list-md>
                    <v-layout wrap>
                        <v-flex>
                            <v-container>
                              <table border="1px solid black;">
                                <tr>
                                  <td>객실명</td>
                                  <td>이용일</td>
                                  <td>요금</td>
                                </tr>
                                <tr>
                                  <td><h5>{{ roomId }}</h5></td>
                                  <td><h5>{{ reservationDate }}</h5></td>
                                  <td><h5>{{ price }}</h5></td>
                                </tr>
                              </table>
                            </v-container>
                            <v-container>
                              <v-radio-group  mandatory="true">
                              <v-radio color="indigo" label="무통장입금"></v-radio>
                              </v-radio-group>
                              <h5>예약계좌 : <b>농협 1108-000112-0119 (예금주: 펜션)</b></h5>
                            
                             <v-text-field label="입금자명" 
                                        :rules="[v => !!v || '필수정보입니다.']" type="bankName"
                                        v-model="bankName" required flat  outlined value="bankName">
                                        <!-- type="name" 하면 미입력 시 다 빨갛게 변함 -->
                            </v-text-field>
                            </v-container>

                            <v-container>
                              <v-checkbox :rules="[v => !!v || '필수']"
                              label="이용약관 및 취소/환불규정 동의" required></v-checkbox>
                              <h5>예약금 입금 시 <b>12시간</b> 안에 입금완료 하셔야 합니다.<br>
                              <b>미입금 시 자동 예약취소됩니다.</b></h5>
                            </v-container>
                        </v-flex>
                    </v-layout>
                </v-container>
            </v-card-text>
            <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text @click="cancleClick($event)">
                    취소
                </v-btn>
                <v-btn color="blue darken-1" text submit="onSubmit">
                    예약하기
                </v-btn>
            </v-card-actions>
        </v-card>
        </v-dialog>
    </v-layout>
                  </div>
               

        </div>
  
  </div>
</template>

<script>

export default {
    name: 'ReservationForm',
    data () {
        return {
            date: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
            landscape : false,
            room: false,
            groupVal: [],
            checkId:[],
            // disabled: 0,
            roomId: '',
            personNum: '',
            roomCnt:1,
            period:1,
            kindsOfRoom: 
            ['301','302','201','202'],
            boxs: [
              {id: '301', value: '301', adultNum:'adult', image:'https://images.pexels.com/photos/7533766/pexels-photo-7533766.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260'},
              {id: '302', value: '302', adultNum:'adult', image: 'https://images.pexels.com/photos/6782569/pexels-photo-6782569.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260'},
              {id: '201', value: '201', adultNum:'adult', image: 'https://images.pexels.com/photos/7546712/pexels-photo-7546712.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260'},
              {id: '202', value: '202', adultNum:'adult', image: 'https://images.pexels.com/photos/7546707/pexels-photo-7546707.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260'}
            ]
        }
    },
    methods: {
    onSubmit () {
      if(this.roomId == '301' || this.roomId == '302') {
        this.personNum = '4'
        this.price = '300000'
      } else {
        this.personNum = '2'
        this.price = '240000'
      }
      const { roomId, personNum, period, price, roomCnt } = this
      this.$emit('submit', { roomId, personNum, period, price, roomCnt  })
    },
     cancleClick($event) {
          if($event.target.innerHTML == ' 취소 ') {
                this.dialog = false
        }
     }

    }    
    
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');
@import url('https://fonts.googleapis.com/css2?family=MonteCarlo&display=swap');

.payment{
  position: relative;
  left: 150px;
}

.select-num {
  position: relative;
  left: 80px;
}



.btn-width-prev {
  position: relative;
  margin-bottom: -40%;
  left: 10%;
}

.btn-between-month{
  position: relative;
  left: 62%;
}

.btn-width-next{
  position: relative;
  margin-top: -35%;
  left: 130%;
}

.calendar{
    /* position: relative; */
    /* right: 35%; */
    margin-top: 2%;
    left: -20%;
    position: absolute;
    z-index: 9;
}

.intro-top {
    background: #f6f7f7;
}

.container{
    position: relative;
}

.overlay1{
    position: absolute;
    z-index: 9;
    margin-top: -40.5%;
    left: 56%;
    width: 600px;
    height: 400px;
}

.pay-message{
  position: relative;
  left: 20%;
  margin: 3% 0% 5% 0%;
}

.pay-btn{
  position: relative;
  left: 10%;
}

.back-box {
    background: #f6f7f7;
    height: 200vh;
}

.text-box{
  margin: 4% 0% 5% 0%;
}

.book-calendar{
  position: relative;
  padding: 5% 0% 0% 0%;
  size: 100%;
}

.info-text {
    margin: 5% 0% 5% 0%;
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
    padding: 5px 0px 18px 0px;
}

.about-top {
    padding-top: 10vh;
}

/* 폰트 */

h1 {
    font-family: "Cinzel";
    font-size: 30px;
    text-align: center;
    margin-top: 10px;
}

h2 {
    font-family: 'Nanum Myeongjo';
    font-size: 25px;
    text-align: center;
    overflow: visible;
    margin-top: 15px;
}

h3 {
    font-family: "Cinzel";
    font-size: 50px;
    color:coral;
    text-align: center;
}

h4 {
    margin-top: 10%;
    font-family: 'Nanum Myeongjo';
    font-size: 35px;
}

h5 {
    font-size: 15px;
    padding: 0px 20px 3px 20px;

}

h6 {
    font-size: 20px;
    padding: 0px 20px 0px 20px;
    text-align: center;

}