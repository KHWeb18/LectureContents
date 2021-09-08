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
            const { month, day, time, place } = payload
            axios.post('http://localhost:3647/book/register', { month, day, time, place })
                    .then(res => {
                        alert('등록 성공! - ' + res)
                       
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>