<template>
    <div id="app">
        <child-comp :ran_dog="randomDog">
            <div slot="best">
                <figure>
                    <img src="@/assets/img/Malamute.jpg"/>
                    <figcaption>Malamute</figcaption>
                </figure>
            </div>
            <div slot="footer">
                <footer>
                    <p>&copy; All right reserved</p>
                </footer>
            </div>
        </child-comp>
    </div>
</template>

<script>

import ChildComp from '@/components/slot/ChildComp'

export default {
    name: 'NamedSlotTestPage',
    components: {
        'child-comp': ChildComp
    },
    data () {
        return {
            dogs: [
                { dog_name: 'Alaskan Malamute', pic:require('@/assets/img/Malamute.jpg')},
                { dog_name: 'Dobermann Pinscher', pic:require('@/assets/img/Dobermann.jpg')},
                { dog_name: 'German Shepherd', pic:require('@/assets/img/Shepherd.jpg')}
            ]
        }
    },
    computed: {
        randomDog () {
            return this.dogs[Math.floor(Math.random() * this.dogs.length)]
        }
    }
}
</script>