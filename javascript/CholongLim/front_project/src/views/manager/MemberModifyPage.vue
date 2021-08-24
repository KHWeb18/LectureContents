<template>
    <div id="member">
        <v-divider></v-divider>

        <member-modify-form v-if="member" :member="member" @submit="onSubmit"/>
        <p v-else>로딩중 ......</p>
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
        ...mapState(['member'])
    },
    methods: {
        ...mapActions(['fetchMember']),
        onSubmit () {
            axios.put(`http://localhost:8888/memberManage/${this.memberNo}`)
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
@import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');
@import url('https://fonts.googleapis.com/css2?family=MonteCarlo&display=swap');


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