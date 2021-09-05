<template>
    <div id="member" class="img-cover">
        <div class="container" style="margin-bottom:2%">
            <div>
                <v-card class="reserve">
                <v-row justify="center" style="margin:3%;">
                    <h4 style="margin-top:5%;">회원정보상세</h4>
                </v-row>
                    <member-read v-if="member" :member="member" :memberAuth="memberAuth"/>
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
                    <v-card-title> 회원 삭제</v-card-title>
                    <v-card-text>
                        <br>
                        <p style="font-size:15px">아이디 '{{ member.userId }}'님을 삭제하시겠습니까?</p>
                        </v-card-text>
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
                </v-card>
            </div>
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
        ...mapState(['member','memberAuth'])
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
@import url('https://fonts.googleapis.com/css2?family=Gowun+Batang&display=swap');
@import url('https://fonts.googleapis.com/css2?family=MonteCarlo&display=swap');

.img-cover{
     position: relative;
     height: 100%;
     width: 100%;
     background-image: url('https://images.pexels.com/photos/1764702/pexels-photo-1764702.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940');
     background-size: cover;                                                            
     z-index:1;
}

.btn-size{
    margin: 0 auto;
    text-align: center;
    width: 50%;
    padding: 3% 0% 5% 0%;
}

.board-box {
    padding-bottom: 15%;
}
.container{
    position: relative;
}


h4 {
    margin-top: 0px;
    font-family: 'Gowun Batang';
    font-size: 25px;
}
</style>