<template>
    <div>
         <v-container class="reserve">
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
            </v-card-actions>
            <v-card-actions>
            <div  style="margin:3%;">
                <b>기준인원 :</b> {{ book.personNum }} 
            </div>
            <div  style="margin:3%;">
                <b>입금자명 :</b> {{ book.bankName }} 
            </div>
    
            <div  style="margin:3%;">
                <b>결제금액 :</b> {{ book.price }} 
            </div>
            </v-card-actions>

            
        </v-card>
      </v-container>

    </div>
</template>

<script>
export default {
    name: 'ReservationReadForm',
    props: {
        book: {
            type: Object,
            required: true
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