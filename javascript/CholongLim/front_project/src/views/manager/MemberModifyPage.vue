<template>
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
     background-image: url('https://images.pexels.com/photos/1764702/pexels-photo-1764702.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940');
     background-size: cover;                                                            
     z-index:1;
}


h4 {
    margin-top: 0px;
    font-family: 'Gowun Batang';
    font-size: 25px;
}
</style>