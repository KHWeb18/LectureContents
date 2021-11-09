import Vue from 'vue'
const EventBus = new Vue({
    methods: {
        sendscode(payload) {
            this.$emit('sendcode', payload)
        }
    }
})
export default EventBus