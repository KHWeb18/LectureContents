<template>
    <div id="user" class="img-cover">
        <div class="container" style="margin-bottom:2%">
            <div>
                <v-card class="reserve">
                    <v-row justify="center" style="margin:3%;">
                        <h4 style="margin-top:5%;">회원정보</h4>
                    </v-row>

                    <user-read-form v-if="user" :user="user"/>

                    <p v-else>로딩중 ...... </p>
                </v-card>

            </div>
        </div>  
    </div>

</template>

<script>
import UserReadForm from '@/components/member/UserReadForm.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'UserReadPage',
    props: {
        memberNo: {
            type: String,
            required: true
        }
    },
    components: {
        UserReadForm
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
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');
@import url('https://fonts.googleapis.com/css2?family=MonteCarlo&display=swap');


h4 {
    margin-top: 0px;
    font-family: 'Nanum Myeongjo';
    font-size: 25px;
}

.member-box {
    margin-top: 2%;
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