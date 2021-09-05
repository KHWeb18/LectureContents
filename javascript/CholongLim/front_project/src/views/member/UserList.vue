<template>
    <div id="user" class="img-cover">
        <div class="container" style="margin-bottom:2%">
            <div>
                <v-card class="reserve">
                    <v-row justify="center" style="margin:3%;">
                        <h4 style="margin-top:5%;">회원정보</h4>
                    </v-row>

                    <user-list-form :users="users"/>
                </v-card>

            </div>
        </div>  
    </div>
</template>

<script>
import UserListForm from '@/components/member/UserListForm.vue'
import axios from 'axios'
import { mapState } from 'vuex'
import { FETCH_USER_LIST, FETCH_AUTH_LIST } from '@/store/mutation-types'


export default {
    name: 'UserList',
    components: {
        UserListForm
    },
    data() {
        return {
            userId: this.$cookies.get('user')
          
        }
    },
    computed: {
        ...mapState(['users'])
    },
    mounted () {
        this.fetchUserList()
    },
    methods: {
        // ...mapActions(['fetchUserList'])
      fetchUserList () {
      return axios.get('http://localhost:8888/jpamember/lists', { params: { userId : this.userId} })
              .then((res) => {
                this.$store.commit(FETCH_USER_LIST, res.data)
                this.$store.commit(FETCH_AUTH_LIST, res.data.authList[0])
              })
    },
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
     background-image: url('https://images.pexels.com/photos/287229/pexels-photo-287229.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940');
     background-size: cover;                                                            
     z-index:1;
}


  .reserve{
    position: relative;
    height: 100;
}
</style> 