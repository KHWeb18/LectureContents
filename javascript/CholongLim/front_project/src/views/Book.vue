<template>
    <div>
    <div class="intro-top">
      <div class="container">
         

    
          <!-- <reservation-form @submit="onSubmit"/> -->
     <test @submit="onSubmit"/>


        </div>
    </div>
  </div>
</template>


<script>
// import ReservationForm from '@/components/reservation/ReservationForm.vue'
import test from '@/views/test.vue'
  export default {
    name: 'Book',
    components: {
        test

    },
    data() {
        return {
          // date: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
          // landscape : false,
            attrs: [
        {
          key: 'today',
          dates: new Date(2018, 0, 1),
          highlight: {
            backgroundColor: '#ff8080',
          },
          // Just use a normal style
          contentStyle: {
            color: '#fafafa',
          },
          // Our new popover here
          popover: {
            label: 'You just hovered over today\'s date!',
          }
        },
      ],
        }
    },
    methods: {
      onSubmit() {

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