<template>
    <div>
    <div class="intro-top">
    <div class="container">
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
            <p>*2박 이상의 경우 1박씩 각각 예약 진행 하셔야 합니다.<br>
            *인원 추가 시 인당 20,000원의 현장결제 요금이 발생합니다.</p>

        </v-container>
    </div>

    <div class="container">
        <div class="overlay1">
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
                  <h5>- 예약전에 예약안내(예약규정)를(을) 반드시 숙지하시고 예약을 하시기 바랍니다.</h5>
                  <h5>- 선택란의 체크박스를 체크하신 후 예약하기 버튼을 누르시면 예약이 진행 됩니다.</h5>
                  </div>
            </v-simple-table>
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
                          <td><v-checkbox v-model="checkbox" value="room301" required></v-checkbox></td>
                          <td><v-img width="200"
                                src="https://images.pexels.com/photos/7533766/pexels-photo-7533766.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
                                </v-img>
                          </td>
                          <td width="25%"><strong># Room 301</strong>
                            <br> 기준 4명/ 최대 6명<br>300,000원
                          </td>
                          <td width="8%">기간<v-select :items="days" label="기간" dense
                                        flat solo outlined></v-select>
                          </td>
                          <td width="8%">성인<v-select :items="anum" label="인원" dense
                                        flat solo outlined></v-select>
                          </td>
                          <td width="8%">아동<v-select :items="cnum" label="인원" dense
                                        flat solo outlined></v-select></td>
                          <td width="8%">유아<v-select :items="bnum" label="인원" dense
                                        flat solo outlined></v-select></td>
                          <td width="25%"><h6>즉시결제</h6><h1> 300,000원</h1></td>
                        </tr>

                        <tr>
                          <td><v-checkbox v-model="checkbox" value="room301" required></v-checkbox></td>
                          <td><v-img width="200"
                                src="https://images.pexels.com/photos/6782569/pexels-photo-6782569.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
                                </v-img>
                          </td>
                          <td width="25%"><strong># Room 302</strong>
                            <br> 기준 4명/ 최대 6명<br>300,000원
                          </td>
                          <td width="8%">기간<v-select :items="days" label="기간" dense
                                        flat solo outlined></v-select>
                          </td>
                          <td width="8%">성인<v-select :items="anum" label="인원" dense
                                        flat solo outlined></v-select>
                          </td>
                          <td width="8%">아동<v-select :items="cnum" label="인원" dense
                                        flat solo outlined></v-select></td>
                          <td width="8%">유아<v-select :items="bnum" label="인원" dense
                                        flat solo outlined></v-select></td>
                          <td width="25%"><h6>즉시결제</h6><h1> 300,000원</h1></td>
                        </tr>

                        <tr>
                          <td><v-checkbox v-model="checkbox" value="room301" required></v-checkbox></td>
                          <td><v-img width="200"
                                src="https://images.pexels.com/photos/7546712/pexels-photo-7546712.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
                                </v-img>
                          </td>
                          <td width="25%"><strong># Room 201</strong>
                            <br> 기준 2명/ 최대 4명<br>240,000원
                          </td>
                          <td width="8%">기간<v-select :items="days" label="기간" dense
                                        flat solo outlined></v-select>
                          </td>
                          <td width="8%">성인<v-select :items="anum" label="인원" dense
                                        flat solo outlined></v-select>
                          </td>
                          <td width="8%">아동<v-select :items="cnum" label="인원" dense
                                        flat solo outlined></v-select></td>
                          <td width="8%">유아<v-select :items="bnum" label="인원" dense
                                        flat solo outlined></v-select></td>
                          <td width="25%"><h6>즉시결제</h6><h1> 240,000원</h1></td>
                        </tr>

                        <tr>
                          <td><v-checkbox v-model="checkbox" value="room301" required></v-checkbox></td>
                          <td><v-img width="200"
                                src="https://images.pexels.com/photos/7546707/pexels-photo-7546707.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
                                </v-img>
                          </td>
                          <td width="25%"><strong># Room 202</strong>
                            <br> 기준 2명/ 최대 4명<br>240,000원
                          </td>
                          <td width="8%">기간<v-select :items="days" label="기간" dense
                                        flat solo outlined></v-select>
                          </td>
                          <td width="8%">성인<v-select :items="anum" label="인원" dense
                                        flat solo outlined></v-select>
                          </td>
                          <td width="8%">아동<v-select :items="cnum" label="인원" dense
                                        flat solo outlined></v-select></td>
                          <td width="8%">유아<v-select :items="bnum" label="인원" dense
                                        flat solo outlined></v-select></td>
                          <td width="25%"><h6>즉시결제</h6><h1> 240,000원</h1></td>
                        </tr>
                        <v-divider></v-divider>
                      </table>
                            </v-col>
                        </div>
                    </div>
                </v-container>

                <div class="pay-message" style="display: inline-block;">
                <v-simple-table style="border: 2px solid #edeeee; float:left;">
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
                  <h5>- 예약전에 예약안내(예약규정)를(을) 반드시 숙지하시고 예약을 하시기 바랍니다.</h5>
                  <h5>- 선택란의 체크박스를 체크하신 후 예약하기 버튼을 누르시면 예약이 진행 됩니다.</h5>
                  </div>
            </v-simple-table>
            
                  <div style="display: inline-block;">
                    <h1><b>총 결제금액 : </b></h1>
                  <h1><b>입실 시 현장 결제 금액 : </b></h1>
                  <h1><b>지금 즉시 결제 금액 : </b></h1>
                  </div>

                  <div class="pay-btn" style="display: inline-block;">
                      <v-btn color="blue" width="350px" height="50px" router :to="'/completePayment'">예약하기</v-btn>
                  </div>
                </div>

        </div>
    </div>
  </div>
</template>


<script>
  export default {
    data: vm => ({
      date: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
      dateFormatted: vm.formatDate((new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10)),
      menu1: false,
      picker: null,
      focus: '',
      type: 'month',
      days: ['1박', '2박', '3박', '4박'],
      anum: ['1명','2명','3명'],
      cnum: ['1명','2명','3명'],
      bnum: ['1명','2명','3명']
    }),
    computed: {
      computedDateFormatted () {
        return this.formatDate(this.date)
      },
    },
    watch: {
      date () {
        this.dateFormatted = this.formatDate(this.date)
      }
    },

    methods: {
        prev() {
            this.$refs.calendar.prev()
        },
        next() {
            this.$refs.calendar.next()
        },
        formatDate (date) {
        if (!date) return null

        const [year, month, day] = date.split('-')
        return `${month}/${day}/${year}`
        },
        parseDate (date) {
        if (!date) return null

        const [month, day, year] = date.split('/')
        return `${year}-${month.padStart(2, '0')}-${day.padStart(2, '0')}`
        }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');
@import url('https://fonts.googleapis.com/css2?family=MonteCarlo&display=swap');


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
</style>