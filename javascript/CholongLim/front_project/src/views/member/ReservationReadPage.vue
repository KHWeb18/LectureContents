<template>
    <div align="center" class="size">
        <div >
        <h4 style="margin-top:5%;">예약 상세정보</h4>
        <reservation-read-form v-if="book" :book="book"/>
        <p v-else>로딩중 ...... </p>
 
        <v-layout justify-center>
                    <v-dialog v-model="dialog" persistent max-width="400px">
                        <template v-slot:activator="{ on }">
                            <v-btn text outlined color="black lighten-1" v-on="on">예약취소</v-btn>  
                            <v-btn outlined route :to="{ name: 'MyReservation' }" 
                            color="blue lighten-1" style="margin-left:20px;">전체예약내역</v-btn>         
                        </template>
                        <v-card>
                            <v-toolbar color="white darken-3" flat height="50">
                                        <v-btn text x-large class="exit"
                                        @click="cancle()">
                                            <v-icon>clear</v-icon>
                                        </v-btn>
                            </v-toolbar>
                            <v-card-text>
                                예약을 취소하시겠습니까?<br>
                                취소 시 예약서비스를 통해 다시 예약하셔야 합니다.
                            </v-card-text>
                            <v-card-actions>
                                <v-spacer></v-spacer>
                                <v-btn text color="blue darken-1" @click="onDelete()" outlined>
                                    확인
                                </v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-dialog>
                </v-layout>
        </div>
    </div>
</template>

<script>
import ReservationReadForm from '@/components/member/ReservationReadForm.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'ReservationReadPage',
    props: {
        bookNo: {
            type: String,
            required: true
        }
    },
    components: {
        ReservationReadForm
    },
    computed: {
        ...mapState(['book'])
    },
    data() {
        return {
            dialog: false,
        }
    },   
    created () {
        this.fetchBook(this.bookNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
    methods: {
        cancle() {
            this.dialog = false
        },
        ...mapActions(['fetchBook']),
        onDelete () {
            const { bookNo } = this.book
            axios.delete(`http://localhost:8888/room/${bookNo}`)
                .then(() => {
                    alert('예약을 취소했습니다.')
                    this.dialog = false
                    this.$router.push({ name: 'MyReservation' })
                    this.$store.state.books = null
                })
               .catch(res => {
                    alert(res.response.data.message)
                })
        }
    }
}
</script>

<style scoped>


.size{
    margin:5% 0% 5% 0%;
}

h4 {
    margin-top: 0px;
    font-family: 'Nanum Myeongjo';
    font-size: 25px;
}

.exit{
 position: relative;
 left: 85%;
}

</style>