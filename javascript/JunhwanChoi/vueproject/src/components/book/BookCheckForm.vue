<template>
    <v-container>
        <form @submit.prevent="onSubmit">
           <v-dialog v-model="Success"  max-width="500px">
            <v-card>
                <v-card-title>
                    <span class="headline">
                        예약 내용 확인
                    </span>
                </v-card-title>
                <v-card-text>
                    <v-container grid-list-md>
                        <v-layout wrap>
                            <br>
                            <v-flex xs12 >
                                <p>예약 날짜 : <input type="text" v-model="start"></p>
                            </v-flex>
                            <v-flex xs12>
                                <p>예약 시간 : <input type="text" v-model="time"></p>
                            </v-flex>
                            <v-flex xs12>
                                <p>예약 장소 : <input type="text" v-model="title"></p>
                            </v-flex>
                            <v-flex xs12>
                                <p>예약자 이름 : <input type="text" v-model="name"></p>
                            </v-flex>
                        </v-layout>
                    </v-container>
                </v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    
                    <router-link :to="{ name: 'Home' }" class="nav-link" active-class="active">
                        <v-btn color="blue lighten-5">확인</v-btn>
                    </router-link>      
                    <div>
                        <button type="submit">등록</button>
                        <router-link :to="{ name: 'Home' }">
                            취소
                        </router-link>
                    </div>              
                </v-card-actions>
            </v-card>
    </v-dialog>
        </form>
    </v-container>
</template>

<script>
export default {
    
    data () {
        return {
            dialog: true,
            Success: true,
            start: '',
            time: '',
            title: '',
            name: '',
        }
    },
    methods: {
        onSubmit () {
            const {  start, time, title, name } = this
            this.$emit('submit', {start, time, title, name })
        }
    }
}
</script>

<style scoped>
hr{
    color:blue;
    
}
    
</style>