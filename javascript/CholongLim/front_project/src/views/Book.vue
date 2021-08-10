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
            <p>| 실시간 예약 |</p>
        </v-container>
        <v-divider></v-divider>

         <!-- <div class="back-box">
            <div class="container">
              <v-row>
                <v-col cols="12" md="6" class="book-calendar">
                  <v-container class="month-box">
                    <v-btn fab text small color="grey darken-2" @click="prev">
                        <v-icon small="small">
                            mdi-chevron-left
                        </v-icon>
                    </v-btn>
                    <v-btn fab text small color="grey darken-2" @click="next">
                        <v-icon small="small">
                            mdi-chevron-right
                        </v-icon>
                    </v-btn>
                    <v-toolbar-title v-if="$refs.calendar">
                        {{ $refs.calendar.title }}
                    </v-toolbar-title>
                  </v-container>
                  <v-sheet height="350" width="500">
                      <v-calendar 
                      ref="calendar" v-model="date" color="primary"
                      :events="events" :event-color="getEventColor" @input="menu1 = false"
                      :type="type" @click:event="showEvent" @click:more="viewDay" 
                      @click:date="viewDay" @change="updateRange" ></v-calendar>
                  </v-sheet>
                  </v-col> -->
                  
 
            <div class="intro-top">
            <div class="container">
                <v-container class="calendar">
                <v-row>
                <v-col cols="12" md="6" class="book-calendar">
                  <v-container>
                    <v-btn fab text small color="grey darken-2" @click="prev" class="btn-width-prev">
                        <v-icon small="small">
                            mdi-chevron-left
                        </v-icon>
                    </v-btn>
                    <h2 v-if="$refs.calendar" class="btn-between-month">
                        {{ $refs.calendar.title }}
                    </h2>
                    <v-btn fab text small color="grey darken-2" @click="next" class="btn-width-next">
                        <v-icon small="small">
                            mdi-chevron-right
                        </v-icon>
                    </v-btn>
                  </v-container>
                  <v-sheet height="400" width="600">
                      <v-calendar 
                      ref="calendar" v-model="date" color="primary"
                      :events="events" :event-color="getEventColor" @input="menu1 = false"
                      :type="type" @click:event="showEvent" @click:more="viewDay" 
                      @click:date="viewDay" @change="updateRange" ></v-calendar>
                  </v-sheet>
                  </v-col>
                </v-row>
                <p>*2박 이상의 경우 1박씩 각각 예약 진행 하셔야 합니다.</p>
                </v-container>
                </div>

            <div class="container">
                <div class="overlay1">
                  <v-simple-table>
                  <h2>선택일</h2>
                    <h3>
                       <strong>{{ date }}</strong> 
                    </h3>
                  </v-simple-table>
                </div>
            </div>
            <div>
              <v-container>
                <p>객실선택</p>
                <v-divider></v-divider>
              </v-container>
              <v-container>
                <div>
                  <div>
                    <!-- <div></div> 체크박스-->
                    <!-- <div></div> 룸 번호 / 기준인원-->
                    <!-- <div></div> 기간 (Option)-->
                    <!-- <div></div> 성인/아동/유아 (Option)-->
                    <!-- <div></div> 결제금액-->
                  </div>
                </div>
              </v-container>
            </div>
            </div>

    <v-divider></v-divider>



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
    height: 150vh;
}

.container{
    position: relative;
}

.overlay1{
    position: absolute;
    z-index: 9;
    margin-top: -43%;
    left: 56%;
    width: 600px;
    height: 400px;
}

.back-box {
    background: #f6f7f7;
    height: 200vh;
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
    font-family: 'Nanum Myeongjo';
    font-size: 25px;
    overflow: visible;
}

h3 {
    font-family: "Cinzel";
    font-size: 50px;
    color: rgba(39, 140, 235, 0.829);
}

h4 {
    margin-top: 10%;
    font-family: 'Nanum Myeongjo';
    font-size: 35px;
}
</style>