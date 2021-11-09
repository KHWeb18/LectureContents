<template>
    <div id="app">
        <child-comp :ran_car="randomCar">
            <div slot="best">
                <figure>
                    <img src="@/assets/img/testPhoto.jpg">
                    <figcaption>photo grapher</figcaption>
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
                { car_name: 'Tesla Model X', pic:require('@/assets/img/test1.jpg') },
                { car_name: 'Spyder 918', pic:require('@/assets/img/test2.jpg') },
                { car_name: 'Nissan Maxima', pic:require('@/assets/img/test3.jpg') }
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