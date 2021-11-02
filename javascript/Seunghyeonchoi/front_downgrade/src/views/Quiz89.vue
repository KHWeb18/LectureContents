<template>
    <div align="center">
        <h2>삼각형 넓이 계산</h2>
        <quiz89-register-form @submit="onSubmit"/>
         <tr>
             <td>넓이</td>
             <td>{{  }}</td>
             </tr>
             </div>
</template>

<script>

import Quiz89RegisterForm from '@/components/quiz/Quiz89RegisterForm.vue'

export default {
    name: 'Quiz89',
    components: {
        Quiz89RegisterForm
    },
    methods: {
        clacArea () {
            this.area = this.width * this.height
        }
    }
}

</script>