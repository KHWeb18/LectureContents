<template>
    <div id="triangle">
        <h2>삼각형의 넓이구하깅</h2>
        <triangle-area-form-spring @submit="onSubmit"/>
    </div>
</template>

<script>
import TriangleAreaFormSpring from '@/components/area/TriangleAreaFormSpring.vue'
import axios from 'axios'
export default {
    name: 'TriangleAreaPageSpring',
    components: {
        TriangleAreaFormSpring,
        
    },
    methods: {
        onSubmit (payload) {
            const { base, height, area } = payload
            axios.post('http://localhost:7777/vuetriangle/area', { base, height, area })
                    .then(res => {
                        alert('삼각형넓이구하기!!! - ' + res)
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script>