<template>
    <div id="triangle">
        <h2>삼각형의 넓이구하깅</h2>
        
        <triangle-area-form>
        </triangle-area-form>
    </div>
</template>

<script>
import TriangleAreaForm from '@/components/area/TriangleAreaForm.vue'
export default {
    name: 'TriangleAreaPage',
    components: {
        TriangleAreaForm,
        
    }
}
</script>