<template>
    <div>
        <book-check-form @submit="onSubmit"/>
    </div>
</template>

<script>
import BookCheckForm from '@/components/book/BookCheckForm.vue'
import axios from 'axios'
export default {
    name: 'BookCheckPage',
    components: {
        BookCheckForm
    },
    methods: {
        onSubmit (payload) {
            const { start, time, title } = payload
            axios.post('http://localhost:3647/book/register', {  start, time, title })
                    .then(res => {
                        alert('등록 성공! - ' + res)
                       
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