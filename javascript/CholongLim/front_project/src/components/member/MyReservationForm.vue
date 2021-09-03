<template>
    <div align="center" class="member-box">

        <v-container v-if="!books || (Array.isArray(books) && books.length === 0)">
                <div style="margin: 5% 0% 10% 0%; text-align: center;">
                    예약 내역이 존재하지 않습니다.
                </div>
        </v-container>



         <v-container v-else v-for="book in books" :key="book.bookNo" class="reserve">
        <v-card width="700" class="over">
            <v-card-title class="book-title">{{ book.regDate }}</v-card-title>
            <v-card-actions>
            <div style="margin:3%;">
                <b>예약번호 :</b>  {{ book.bookNo }}
            </div>
            <div  style="margin:3%;">
                <b>객실명 :</b> {{ book.roomId }}
            </div>
            <!-- <div style="margin:3%;">
                <b>예약일 :</b> {{ this.$store.state.dates.reservedDate }} 
            </div> -->
    
            <!-- <div  style="margin:3%;">
                <b>결제금액 :</b> {{ book.price }} 
            </div> -->
            </v-card-actions>

            <v-flex xs8 sm12 md12>
            <v-card-actions>
             <v-btn outlined color="blue lighten-1" style="margin-left:87%;"
             route :to="{ name: 'ReservationReadPage', params: { bookNo: book.bookNo.toString() } }">상세보기</v-btn>
            </v-card-actions>
            </v-flex>


        </v-card>
      </v-container>




<!-- 원래 쓰던 코드 : 하나의 예약만 볼 수 있음 -->
      <!-- <v-container v-else>
        <v-card width="700">
            <v-card-title class="book-title">{{ books.regDate }}</v-card-title>
            <v-card-actions>
            <div style="margin:3%;">
                <b>예약번호 :</b>  {{ books.bookNo }} 
            </div>
            <div  style="margin:3%;">
                <b>객실명 :</b> {{ books.roomId }} 
            </div>
            <div style="margin:3%;">
                <b>예약일 :</b> {{ this.$store.state.dates.reservedDate }} 
            </div>
    
            <div  style="margin:3%;">
                <b>결제금액 :</b> {{ books.price }} 
            </div>
            </v-card-actions>

            <v-card-actions>
                <v-layout justify-center>
                    <v-dialog v-model="dialog" persistent max-width="400px">
                        <template v-slot:activator="{ on }">
                            <v-btn text outlined color="blue lighten-1" v-on="on">예약취소</v-btn>        
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
            </v-card-actions>
        </v-card>
      </v-container> -->
      <br>
    </div>  
</template>

<script>


export default {
    name: 'MyReservationForm',
    props: {
        books: {
            type: Array,
        }
    }
}
</script>

<style scoped>

table{
    width: 55%;
    border: 1px solid #ebecec;
}

.top-tr {
    background-color: #f6f7f7;
}

.member-box {
    margin-top: 2%;
}

.book-title{
    background-color: #1565C0;
    color: white;
}

.exit{
 position: relative;
 left: 85%;
}

.reserve{
    margin: 5% 0% 5% 0%;
}
</style>