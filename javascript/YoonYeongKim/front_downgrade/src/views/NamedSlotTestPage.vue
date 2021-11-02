<template>
    <div id="app">
        <child-comp :ran_car="randomCar">
            <div slot="best">
                <figure>
                    <img src="@/assets/img/images.jpg"/>
                    <figcaption>Spyder 918</figcaption>
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
            cars: [
                { car_name: 'Tesla Model X', pic:require('@/assets/img/images.jpg/') },
                { car_name: 'Mercedes AMG G63', pic:require('@/assets/img/img2.jpg/') },
                { car_name: 'Jeep Wrangler', pic:require('@/assets/img/img3.jpg/') }
            ]
        }
    },
    computed: {
        randomCar () {
            return this.cars[Math.floor(Math.random() * this.cars.length)]
        }
    }
}

</script>