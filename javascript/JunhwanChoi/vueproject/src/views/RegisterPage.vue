<template>
  <div>
      <register-page-form @submit="onSubmit"></register-page-form>
  </div>
</template>

<script>

import RegisterPageForm from '@/components/register/RegisterPageForm.vue'
import axios from 'axios'

export default {
    name: 'RegisterPage',
    components: {
        RegisterPageForm
    },
    methods: {
        onSubmit (payload) {
            const { id, password, username, birth } = payload
            axios.post('http://localhost:3647/project/register', { id, password, username, birth })
                    .then(res => {
                        alert('등록 성공! - ' + res)
                        /*
                        this.$router.push({
                            name: 'BoardReadPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                        */
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>
