<template>
    <v-container>

        <form @submit.prevent="onSubmit">
            <h3>예약</h3>

            <v-card>
                <table>
                <tr>
                    <td>예약날짜:</td>
                    <td><input type="text" v-model="start" readonly></td>
                </tr> 
                <tr>
                    <td>예약시간:</td>
                    <td><input type="text" v-model="time" readonly></td>
                </tr>
                <tr>
                    <td>예약장소</td>
                    <td><input type="text" v-model="title" readonly></td>
                </tr>
                <tr>
                    <td>예약자 이름</td>
                    <td><input type="text" v-model="name"></td>
                </tr>
            </table>

            <div>
                <button type="submit">등록</button>
                <router-link :to="{ name: 'Home' }">
                    취소
                </router-link>
            </div>
            </v-card>
            
        </form>

        
    </v-container>
</template>

<script>
export default {
    name: 'BookRegisterForm',
    data () {
        return {
            start:'',
            time:'',
            title:'',
            name:'',
        }
    },
    methods: {
        onSubmit () {
            const { start, time, title, name} = this
            this.$emit('submit', {start, time, title, name})
        }
    },
     created(){
        this.start=this.$route.query.start
        this.title=this.$route.query.title
        this.time=this.$route.query.time
        console.log(this.start)
    }
}
</script>

<style scoped>
hr{
    color:blue;
    
}
    
</style>