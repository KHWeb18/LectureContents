<template>
    <div align="center">
        <vue-jpa-member-form @submit="onSubmit"/>
    </div>
</template>

<script>
import VueJpaMemberForm from '@/components/vuejpa/VueJpaMemberForm.vue'
import axios from 'axios'
export default {
    name: 'VueJpaMemberPage',
    components: {
        VueJpaMemberForm
    },
    methods: {
        onSubmit (payload) {
            const { id, pw } = payload
            axios.post('http://localhost:7777/vuejpamember/register', { id, pw })
                    .then(res => {
                        alert('등록 성공! - ' + res)
                        
                        // this.$router.push({
                        //     name: 'BoardListPage',
                        //     params: { boardNo: res.data.boardNo.toString() }
                        // })                       
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>