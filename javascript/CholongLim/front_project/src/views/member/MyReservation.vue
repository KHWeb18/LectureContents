<template>
    <div id="book" class="img-cover">
        <div class="container" style="margin-bottom:2%">
            <div>
                <v-card class="reserve">
                    <v-row justify="center" style="margin:3%;">
                        <h4 style="margin-top:5%;">예약정보</h4>
                    </v-row>

                    <my-reservation-form :books="books"/>
                </v-card>

            </div>
        </div>  
    </div>
</template>

<script>
import MyReservationForm from '@/components/member/MyReservationForm.vue'
import axios from 'axios'
import { mapState } from 'vuex'
import { FETCH_BOOK_LIST} from '@/store/mutation-types'
// import { FETCH_BOOK_LIST, FETCH_DATES_LIST } from '@/store/mutation-types'

export default {
    name: 'MyReservation',
    components: {
        MyReservationForm
    },
    data() {
        return {
            userId: this.$cookies.get('user')
          
        }
    },
    computed: {
        ...mapState(['books'])
    },
    mounted () {
        this.fetchBookList()
    },
    methods: {
      fetchBookList () {
      return axios.get('http://localhost:8888/room/lists', { params: { userId : this.userId} })
              .then((res) => {
                  this.$store.commit(FETCH_BOOK_LIST, res.data)
                  console.log(res)
                  console.log(res.data)
                // this.$store.commit(FETCH_DATES_LIST, res.data.dateList[0])
                //   console.log(res.data.dateList[0])
                //   console.log(this.$store.state.books)
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