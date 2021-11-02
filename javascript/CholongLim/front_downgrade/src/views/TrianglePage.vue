<template>
    <div>
        <h2>삼각형 넓이 계산</h2>
        <triangle-form></triangle-form>
    </div>
</template>

<script>
import TriangleForm from '../components/triangle/TriangleForm.vue'

export default {
    name: 'TrianglePage',
    components: {
    'triangle-form' : TriangleForm
    }
}

</script>