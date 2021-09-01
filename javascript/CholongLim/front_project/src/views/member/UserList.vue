<template>
    <div id="member">
        <div class="container">
            <div>
                <v-card height="480">
                    <v-row justify="center" style="margin:3%;">
                        <h4 style="margin-top:5%;">회원정보</h4>
                    </v-row>

                    <user-list-form :members="members"/>
                </v-card>

            </div>
        </div>  
    </div>
</template>

<script>
import UserListForm from '@/components/member/UserListForm.vue'
// import { mapState, mapActions } from 'vuex'
import axios from 'axios'
import { mapState } from 'vuex'
import { FETCH_MEMBER_LIST } from '@/store/mutation-types'


export default {
    name: 'MemberListPage',
    components: {
        UserListForm
    },
    data() {
        return {
            userId: this.$cookies.get('user')
          
        }
    },
    computed: {
        ...mapState(['members'])
    },
    mounted () {
        this.fetchMemberList()
    },
    methods: {
        // ...mapActions(['fetchUserList'])
    //     fetchUserList() {
    //     // const { userId } = this
    //     return axios.get('http://localhost:8888/jpamember/lists')
    //             .then((res) => {
    //                 this.$store.commit(FETCH_MEMBER_LIST, res.data)
    //             })
    //   },
      fetchMemberList () {
          let user = this.$cookies.get('user')
          const { userId } = user

      return axios.get('http://localhost:8888/jpamember/lists', { userId })
              .then((res) => {
                  this.$store.commit(FETCH_MEMBER_LIST, res.data)
              })
    },
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');
@import url('https://fonts.googleapis.com/css2?family=MonteCarlo&display=swap');




.search-box{
    margin: 0;
    margin-top: -10%;
    position: relative;
    left:35%;
    width: 80%;
}


.btn-locate{
    position: relative;
    left: 75%;
    margin-top: 2%;
    margin-bottom: 1%;
    
}

.board-box {
    padding-bottom: 15%;
}
.container{
    position: relative;
    text-align: center;
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