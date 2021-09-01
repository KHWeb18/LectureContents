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
                    <!-- <v-btn text route :to="{name: 'UserList'}"> -->
                        <v-btn text route :to="{ name: 'UserList'}">

                    <b>내정보 관리</b><v-icon>chevron_right</v-icon></v-btn>
                    </v-container>
                    <v-container>
                    <v-btn text @click="what"><b>예약내역</b><v-icon>chevron_right</v-icon></v-btn>
                    </v-container>
                    </v-container>
               
            </v-card>
            
            <!-- <my-page-read v-if="member" :board="member"/> -->
            <!-- <p v-else>로딩중 ...... </p> -->
            <!-- <router-link :to="{ name: 'BoardModifyPage', params: { boardNo } }">
                게시물 수정
            </router-link> -->
        
    

            <!-- <v-dialog v-model="deleteId" persistent max-width="500px">
                <template v-slot:activator="{ on }">
                        <v-btn color="primary" dark v-on="on">계정 탈퇴</v-btn>
                </template>
                <v-card>
                    <v-toolbar flat color="grey lighten-3">
                            <v-toolbar-title>계정 탈퇴</v-toolbar-title>
                        </v-toolbar>
                        <div class="pa-3">
                            <v-text-field
                                v-model="password"
                                label="탈퇴하실 계정의 비밀번호를 입력하세요."
                            >
                            </v-text-field>
                            <button @click="onDelete">계정을 삭제합니다.</button>
                            <v-btn color="blue darken-1" text @click="deleteCheck($event)">
                            취소
                        </v-btn>
                        </div>
                </v-card>
            </v-dialog>  -->
        </div>
        <div v-if="cookie == false">
            잘못된 호출입니다.
        </div>
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
        what(payload) {
            const { userId } = payload
        // userId = this.$cookies.get('user')
        // this.$cookies.get('user')
        alert(userId)
        console.log(userId)
        console.log(this.userId)
        // return axios.get('http://localhost:8888/jpamember/lists', {userId})
        //         .then((res) => {
        //             this.$store.commit(FETCH_MEMBER_LIST, res.data)
        //         })
        }
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
     background-color:rgba(23, 126, 160, 0.048);                                                             
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
