<template>

<pro-test-page></pro-test-page>

</template>

<script>
import ProTestPage from '../components/Quiz/ProTestPage.vue'
import axios from 'vuex'

export default {
    name: 'prob89Page',
  components:  {
    ProTestPage

  },
   methods: {
       onSubmit (payload) { 
            const { rowss, height} = payload
            axios.post('http://localhost:9999/vueQuiz/register', { rowss, height})
                    .then(res => {
                        alert('계산완료.! - ' + res)
                     
                        this.$router.push({
                            name: 'prob89Page'
                        })
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
    
}
</script>