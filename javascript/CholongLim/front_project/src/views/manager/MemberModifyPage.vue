<!--<template>
<div id="member" class="img-cover">
        <div class="container" style="margin-bottom:2%">
            <div>
                <v-card class="reserve">
                <v-row justify="center" style="margin:3%;">
                    <h4 style="margin-top:5%;">회원정보수정</h4>
                </v-row>
                    <member-modify-form v-if="member" :member="member" :memberAuth="memberAuth" @submit="onSubmit"/>
                    <p v-else>로딩중 ......</p>
                </v-card>
            </div>
        </div>  
    </div>
</template>

<script>

import MemberModifyForm from '@/components/manager/MemberModifyForm.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'MemberModifyPage',
    components: {
        MemberModifyForm
    },
    props: {
        memberNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['member','memberAuth'])
    },
    methods: {
        ...mapActions(['fetchMember']),
        onSubmit (payload) {
            const { auth } = payload
            axios.put(`http://localhost:8888/memberManage/manager/${this.memberNo}`, { auth })
                    .then(res => {
                        alert('회원 정보를 수정하였습니다.')
                        this.$router.push({
                            name: 'MemberReadPage',
                            params: { memberNo: res.data.memberNo.toString() }
                        })
                    })
                     .catch(err => {
                        alert(err.response.data.message)
                    })
        }
    },
    // created () {
    //     this.fetchBoard(this.boardNo)
    //             .catch(err => {
    //                 alert(err.response.data.message)
    //                 this.$router.back()
    //             })
    // }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Gowun+Batang&display=swap');
@import url('https://fonts.googleapis.com/css2?family=MonteCarlo&display=swap');

.img-cover{
     position: relative;
     height: 100%;
     width: 100%;
     /* background-image: url('https://images.pexels.com/photos/1764702/pexels-photo-1764702.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940'); */
     background-size: cover;                                                            
     z-index:1;
}


h4 {
    margin-top: 0px;
    font-family: 'Gowun Batang';
    font-size: 25px;
}
</style>-->

<template>
  <div id="member" class="img">
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
              <v-list-item-subtitle>관리자님, 환영합니다.</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
        </v-list>

        <v-divider></v-divider>

        <v-list
          nav
          dense
        >
          <v-list-item route :to="{ name: 'MemberListPage'}">
            <v-list-item-icon>
              <v-icon>people</v-icon>
            </v-list-item-icon>
            <v-list-item-title>회원목록관리</v-list-item-title>
          </v-list-item>
          <v-list-item route :to="{ name: 'BookingListPage'}">
            <v-list-item-icon>
              <v-icon>room_service</v-icon>
            </v-list-item-icon>
            <v-list-item-title>예약내역관리</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-navigation-drawer>

      <div class="user-info">
             <v-row justify="center">
                    <h4 style="margin-top:4%;">회원정보수정</h4>
                </v-row>
                    <member-modify-form v-if="member" :member="member" :memberAuth="memberAuth" @submit="onSubmit"/>
                    <p v-else>로딩중 ......</p>
             </div>
             </v-card>
      </div>
</template>

<script>
import MenuBar from '@/views/MenuBar.vue'
import MemberModifyForm from '@/components/manager/MemberModifyForm.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'MemberModifyPage',
    props: {
        memberNo: {
            type: String,
            required: true
        }
    },
    components: {
        MemberModifyForm,
        MenuBar
    },
    data() {
        return {
            cookie: this.$cookies.isKey('user'),
            userId: this.$cookies.get('user'),
            dialog: false,
        }
    },
    computed: {
        ...mapState(['member','memberAuth'])
    },
    methods: {
        ...mapActions(['fetchMember']),
        onSubmit (payload) {
            const { auth } = payload
            axios.put(`http://localhost:8888/memberManage/manager/${this.memberNo}`, { auth })
                    .then(res => {
                        alert('회원 정보를 수정하였습니다.')
                        this.$router.push({
                            name: 'MemberReadPage',
                            params: { memberNo: res.data.memberNo.toString() }
                        })
                    })
                     .catch(err => {
                        alert(err.response.data.message)
                    })
        }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');


.btn1{
    position: relative;
    left: 30%;
    /* margin-top:0%; */
}

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
  width: 78.9%;
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
    background-image: url('https://images.pexels.com/photos/7130477/pexels-photo-7130477.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940');
    height: 100vh;
    background-size: cover;
  }
</style>