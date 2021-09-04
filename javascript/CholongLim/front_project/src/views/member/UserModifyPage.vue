<template>
        <div class="img-cover">
        <div class="container" style="margin-bottom:2%">
            <div>
                <v-card class="reserve">
                    <v-row justify="center" style="margin:3%;">
                        <h4 style="margin-top:5%;">회원 정보 수정</h4>
                    </v-row>
                    <user-modify-form v-if="user" :user="user" @submit="onSubmit"/>
                    <p v-else>로딩중 ......</p>
                </v-card>

            </div>
        </div>  
    </div>
</template>

<script>

import UserModifyForm from '@/components/member/UserModifyForm.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'UserModifyPage',
    components: {
        UserModifyForm
    },
    props: {
        memberNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['user'])
    },
    methods: {
        ...mapActions(['fetchUser']),
        onSubmit (payload) {
            const { userPhone } = payload
            axios.put(`http://localhost:8888/jpamember/${this.memberNo}`, { userPhone })
                    .then(res => {
                        alert('수정하였습니다.')
                        console.log(res)
                        this.$router.push({
                            name: 'UserReadPage',
                            params: { memberNo: res.data.memberNo.toString() }
                        })
                    })
                    .catch(err => {
                        alert(err.response.data.message)
                    })
        }
    },
    created () {
        this.fetchUser(this.memberNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.back()
                })
    }
}
</script>


<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');
@import url('https://fonts.googleapis.com/css2?family=MonteCarlo&display=swap');


p {
    font-family: 'Nanum Myeongjo';
    font-size: 18px;
    text-align: center;
    padding: 18px 0px 18px 0px;
}


h4 {
    margin-top: 0px;
    font-family: 'Nanum Myeongjo';
    font-size: 25px;
}

.img-cover{
     position: relative;
     height: 100%;
     width: 100%;
     background-color:rgba(23, 155, 160, 0.144);                                                             
     z-index:1;
  }

  .reserve{
    position: relative;
    height: 100;
}
</style> 