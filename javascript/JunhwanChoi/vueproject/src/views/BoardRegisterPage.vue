<template>
    <div >
        
        <board-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import BoardRegisterForm from '@/components/board/BoardRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'BoardRegisterPage',
    components: {
        BoardRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { age, gender, vaccine, content } = payload
            axios.post('http://localhost:3647/vueboard/register', { age, gender, vaccine, content })
                    .then(res => {
                        alert('등록 성공! - ' + res)
                        
                        this.$router.push({
                            name: 'BoardListPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })                       
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>