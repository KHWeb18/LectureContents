<template>
    <div id="app">
        <child-comp :ran_car="randomCar">
            <div slot="best">
                <figure>
                    <img src="@/assets/img/Ferrari_SF90.jpg"/>
                    <figcaption>Ferrari_SF90</figcaption>
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
                { car_name: 'Benz_AMG_GT63S', pic:require('@/assets/img/AMG_GT63S.jpg')},
                { car_name: 'Ferrari_SF90', pic:require('@/assets/img/Ferrari_SF90.jpg')},
                { car_name: 'Porsche_Taycan', pic:require('@/assets/img/Porsche_Taycan.jpg')}
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