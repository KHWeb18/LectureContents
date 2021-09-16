<template>
  <div id="user" class="img">
      <menu-bar/>
    <v-card class="card-box">
      <v-navigation-drawer
        permanent
        style="float:left;">
        <v-list>
          <v-list-item class="px-2">
            <v-list-item-avatar>
              <v-icon color="pink lighten-2">favorite</v-icon>
            </v-list-item-avatar>
          </v-list-item>

          <v-list-item link>
            <v-list-item-content>
              <v-list-item-title class="text-h6">
                {{ this.userId }}
              </v-list-item-title>
              <v-list-item-subtitle>회원님, 환영합니다.</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
        </v-list>

        <v-divider></v-divider>

        <v-list nav dense>
          <v-list-item route :to="{ name: 'UserList'}">
            <v-list-item-icon>
              <v-icon>edit</v-icon>
            </v-list-item-icon>
            <v-list-item-title>회원정보</v-list-item-title>
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
            <v-row justify="center" style="margin:3%;">
              <h4 style="margin-top:3%;">회원정보</h4>
            </v-row>
            <user-read-form v-if="user" :user="user"/>
            <p v-else>로딩중 ...... </p>
          </div>
    </v-card>
  </div>
</template>

<script>
import UserReadForm from '@/components/member/UserReadForm.vue'
import { mapState, mapActions } from 'vuex'
import MenuBar from '@/views/MenuBar.vue'

export default {
    name: 'UserReadPage',
    components: {
        UserReadForm,
        MenuBar
    },
    props: {
        memberNo: {
            type: Number,
            required: true
        }
    },
    data() {
        return {
            userId: this.$cookies.get('user')
        }
    },
    computed: {
        ...mapState(['user'])
    },
    created () {
        this.fetchUser(this.memberNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchUser'])

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

.user-info {
  float: left;
  width: 75%;
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
    background-image: url('https://images.pexels.com/photos/7130503/pexels-photo-7130503.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940'); 
    height: 100vh;
    background-size: cover;
  }
</style>
