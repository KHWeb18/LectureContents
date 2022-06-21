<template>
    <div id="app">
        <child-comp :ran_car="randomCar">
            <div slot="best">
                <figure>
                    <img src="@/assets/imgs/spyder.png"/>
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
                {car_name: 'Tesla Model X', pic:require('@/assets/imgs/X.png')},
                {car_name: 'Spyder 918', pic:require('@/assets/imgs/spyder.png')},
                {car_name: 'Wrangler', pic:require('@/assets/imgs/Wrangler.png')}
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