<template>
    <div id="app">
        <child-comp :ran_car="randomCar">
            <div slot="best">
                <figure>
                    <img src="@/assets/img/tesla01.jpg"/>
                    <figcaption>테슬라 1번 차량</figcaption>
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
                { car_name: 'Tesla Model 01', pic:require('@/assets/img/tesla01.jpg')},
                { car_name: 'Tesla Model 02', pic:require('@/assets/img/tesla02.jpg')},
                { car_name: 'Tesla Model 03', pic:require('@/assets/img/tesla03.jpg')}
                
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