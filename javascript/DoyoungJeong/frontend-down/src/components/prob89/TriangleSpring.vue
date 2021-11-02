<template>
    <div>
        <form v-on:submit="onSubmit">
            <h3 style="margin-top: 20px">Triangle Area Calculator by Spring</h3>
            <div class="inputBox">    
                <h5>Enter the width</h5>
                <input type="text" v-model="widthSpring">
                <br>
                <h5>Enter the height</h5>
                <input type="text" v-model="heightSpring">
            </div>

            <div class="subButton">
                <button type="submit">Calculate!</button>
            </div>
        </form>
    </div>
</template>

<script>

export default {
    name: 'TriangleSpring',
    data() {
        return {
            widthSpring: 0,
            heightSpring: 0
        }
    },
    methods: {
        onSubmit() {
            const { widthSpring, heightSpring } = this
            this.$emit('submitSpring', { widthSpring, heightSpring })
        }
    }
}
</script>
