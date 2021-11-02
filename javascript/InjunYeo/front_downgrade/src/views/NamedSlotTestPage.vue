<template>
    <div id="app">
        <child-comp :ran_car="randomCar">
            <div slot="best">
                <figure>
                    <img src="@/assets/imgs/desert.jpg"/>
                    <figcaption>우유니 사막</figcaption>
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
    data (){
        return {
            cars: [
                { car_name: 'Uyuni', pic:require('@/assets/imgs/desert.jpg') },
                { car_name: 'iceland', pic:require('@/assets/imgs/iceland.jpg') },
                { car_name: 'newzealand', pic:require('@/assets/imgs/ring.jpg') }
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