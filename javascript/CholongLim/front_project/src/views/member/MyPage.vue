<template>
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
        <div v-if="cookie == false">
                로그인 시간이 초과되었습니다.
        </div>
    </div>
</template>

<script>


export default {
    name: 'MyPage',
    data() {
        return {
            cookie: this.$cookies.isKey('user'),
            userId : this.$cookies.get('user')
        }
    },
    methods: {
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');

.intro-top {
    background: #f6f7f7;
}



.img-cover{
     position: relative;
     height: 100%;
     width: 100%;
     background-color:rgba(23, 155, 160, 0.144);                                                             
     z-index:1;
  }

.container {
    position: relative;
    text-align: center; 
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
</style>
