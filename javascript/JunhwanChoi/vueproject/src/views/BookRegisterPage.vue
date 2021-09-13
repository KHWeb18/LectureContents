<template>
    <div>
       
        <book-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import BookRegisterForm from '@/components/book/BookRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'BookRegisterPage',
    components: {
        BookRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { start, time, title, name } = payload
            axios.post('http://localhost:3647/book/register', { start, time, title, name })
                    .then(res => {
                        
                        alert('예약 완료! - ' + res)
                        this.$router.push({name:'Home' })    
                       
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
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