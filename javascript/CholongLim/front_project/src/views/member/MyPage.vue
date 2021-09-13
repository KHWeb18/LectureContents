<!--<template>
    <div class="img-cover">
        <div class="container">   
            <div v-if="cookie == true">
                <v-card style="margin:5%;">
                        <v-container>
                            <h1>WELCOME TO CINZEL</h1>
                            <v-icon size="100" style="margin-top: 2%;">account_circle</v-icon>
                            <p><b>{{ userId }}</b></p>
                            <v-container style="left:1%;">
                                <v-btn text route :to="{ name: 'UserList'}">
                                <b>내정보 관리</b><v-icon>chevron_right</v-icon></v-btn>
                            </v-container>
                            <v-container>
                            <v-btn text route :to="{ name: 'MyReservation'}">
                                <b>예약내역</b><v-icon>chevron_right</v-icon></v-btn>
                            </v-container>
                        </v-container>
                </v-card>    
            </div>
        </div>
       <div class="container" style="margin-bottom:2%" v-if="cookie == false">
            <div>            
                <v-row justify="center" style="margin:10% auto;">
                <h4 style="margin-top:5%; color:white;">로그인 시간이 초과되었습니다.</h4>
                </v-row>
            </div>
        </div>  
        <div class="img-overlay"></div>
    </div>
</template>-->

<template>
  <div class="img">
      <menu-bar/>
    <v-card class="card-box">
      <v-navigation-drawer
        permanent
        style="float:left;"
      >
        <v-list>
          <v-list-item class="px-2">
            <v-list-item-avatar>
              <v-icon color="pink lighten-2">favorite</v-icon>
            </v-list-item-avatar>
          </v-list-item>

          <v-list-item link>
            <v-list-item-content>
              <v-list-item-title class="text-h6">
                {{ userId }}
              </v-list-item-title>
              <v-list-item-subtitle>회원님, 환영합니다.</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
        </v-list>

        <v-divider></v-divider>

        <v-list
          nav
          dense
        >
          <v-list-item route :to="{ name: 'UserList'}">
            <v-list-item-icon>
              <v-icon>edit</v-icon>
            </v-list-item-icon>
            <v-list-item-title>회원정보수정</v-list-item-title>
          </v-list-item>
          <v-list-item route :to="{ name: 'MyReservation'}">
            <v-list-item-icon>
              <v-icon>shopping_cart</v-icon>
            </v-list-item-icon>
            <v-list-item-title>예약내역</v-list-item-title>
          </v-list-item>
          <v-list-item route :to="{ name: 'Book2'}">
            <v-list-item-icon>
              <v-icon>card_travel</v-icon>
            </v-list-item-icon>
            <v-list-item-title>예약하기</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-navigation-drawer>

      <div class="user-info">
            How To Write Better Advertising Copy Heading
          </div>
    </v-card>
  </div>
</template>

<script>

import MenuBar from '@/views/MenuBar.vue'
  export default {
  components: { MenuBar },
    name: 'MyPage',
    data() {
        return {
            cookie: this.$cookies.isKey('user'),
            userId : this.$cookies.get('user')
        }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');



h1 {
    font-family: "Cinzel";
    font-size: 40px;
    text-align: center;
    margin-top: 5%;
    color: #fffffa;
    text-shadow: 4px 1px 8px #3b3b3b;
}

p {
    font-family: 'Nanum Myeongjo';
    font-size: 24px;
    text-align: center;
    padding: 2vh 0vh 2vh 0vh;
    margin-bottom: 0px;
}

h4 {
    margin-top: 0px;
    font-family: 'Gowun Batang';
    font-size: 25px;
}

/*  */
.user-info {
  float: left;
  margin: 10px 65px;
  /* margin-left: 0px; */
  line-height: 1.7;
  font-weight: 600;
}
.card-box {
    height: 80%;
    width: 80%;
    margin: 0 auto;
    justify-content: center;
    position: relative;
    top:5%;
}

.img{
    position: relative;
    /* background-image: url('https://images.pexels.com/photos/7130477/pexels-photo-7130477.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940');                                                             */
    background-image: url('https://images.pexels.com/photos/7130503/pexels-photo-7130503.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940'); 
    height: 100vh;
    background-size: cover;
  }
</style>
