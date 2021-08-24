<template>
    <div id="member">
        <v-row justify="center" style="margin:3%;">
            <h4>회원정보수정</h4>
        </v-row>

        <member-read v-if="member" :member="member"/>

        <p v-else>로딩중 ...... </p>

        <div class="btn-size">
            <v-row justify="center">
            <v-col cols="12" md="12"> 
            <v-btn color="blue" 
            class="ma-2 white--text" route :to="{ name: 'MemberListPage' }">
            목록보기
            </v-btn> 
            <v-btn type="submit" color="blue darken-2"
            class="ma-2 white--text" route :to="{ name: 'MemberModifyPage', params: { memberNo } }">
            회원정보수정
            </v-btn>

                <v-dialog v-model="dialog" persistent max-width="450">
                <template v-slot:activator="{ on, attrs }">
                    <v-btn color="blue darken-2" outlined v-bind="attrs"
                    v-on="on" class="ma-2 white--text">
                        회원 삭제</v-btn>
                </template>
                <v-card>
                    <v-card-title class="text-h5"> 회원 삭제</v-card-title>
                    <v-card-text class="text-h6">{{ member.userId}} 회원님을 삭제하시겠습니까?</v-card-text>
                    <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text @click="dialog = false">취소</v-btn>
                    <v-btn color="blue darken-1" text @click="onDelete">
                        삭제
                    </v-btn>
                    </v-card-actions>
                </v-card>
                </v-dialog>
            </v-col>    
            </v-row>
        </div>
    </div>
</template>

<script>
import MemberRead from '@/components/manager/MemberRead.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'MemberReadPage',
    props: {
        memberNo: {
            type: String,
            required: true
        }
    },
    data () {
      return {
        dialog: false,
      }
    },
    components: {
        MemberRead
    },
    computed: {
        ...mapState(['member'])
    },
    created () {
        this.fetchMember(this.memberNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchMember']),
        onDelete () {
            const { memberNo } = this.member
            axios.delete(`http://localhost:8888/memberManage/${memberNo}`)
                .then(() => {
                    this.dialog = false
                    alert('회원을 삭제했습니다.')
                    this.$router.push({ name: 'MemberListPage' })
                })
               .catch(res => {
                    alert(res.response.data.message)
                })
        }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');
@import url('https://fonts.googleapis.com/css2?family=MonteCarlo&display=swap');


.btn-size{
    margin: 0 auto;
    text-align: center;
    width: 50%;
    padding: 3% 0% 5% 0%;
}

h1{
    font-family: "Gowun Dodum";
    font-size: 30px;
    margin-top: 5%;
    text-align: center;

}
.board-box {
    padding-bottom: 15%;
}
.container{
    position: relative;
}

.overlay{
    position: absolute;
    z-index: 9;
    margin-top: 9%;
    left: -8%;
}

.overlay2{
    position: absolute;
    z-index: 9;
    margin-top: 1%;
    left: 70%;
}

.overlay3{
    position: absolute;
    z-index: 9;
    margin-top: 43%;
    left: 7%;
}

.test3{
    margin-left: 50vw;
    position: relative;
    bottom: 25vh;
}

.intro-top {
    text-align: left;
}

.about-img-top {
    max-height: 70vh;
}
.about-img-01 {
    position: relative;
    left: 20vw;
    height: 60vh;

}
.about-img-02 {
    position: relative;
    right: 20vw;
    height: 50vh;
    margin-top: -5vh;
}
.about-img-03 {
    position: relative;
    left: 20vw;
    height: 60vh;
    margin-top: 5vh;
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
    margin-top: 0px;
    font-family: 'Nanum Myeongjo';
    font-size: 35px;
}
</style>