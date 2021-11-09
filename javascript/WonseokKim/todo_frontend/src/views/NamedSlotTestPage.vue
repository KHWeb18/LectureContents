<template>
    <div id="app">
        <child-comp :ran_car="randomCar">
            <div slot="best">
                <figure>
                    <img src="@/assets/img/Spyder.jpeg"/>
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
                { car_name: 'Tesla Model X', pic:require('@/assets/img/tesla_model_x.jpeg')},
                { car_name: 'Spyder 918', pic:require('@/assets/img/Spyder.jpeg')},
                { car_name: 'Jeep', pic:require('@/assets/img/jeep.jpeg')},
                { car_name: 'K8', pic:require('@/assets/img/k8.jpeg')}
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