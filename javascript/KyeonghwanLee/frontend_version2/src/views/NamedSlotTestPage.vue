<template>
    <div id="app">
        <child-comp :ran_car="randomCar">
            <div slot="best">
                <figure>
                    <img src='@/assets/img/Ferrari.jpg'/>
                    <figcaption>Ferrari</figcaption>
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
    name:'NmaedSlotTestPage',
    components:{
        'child-comp':ChildComp
    },
    data (){
        return{
            cars:[
                { car_name: 'Tesla Model X', pic:require('@/assets/img/modelX.jpg') },
                { car_name: 'Spyder 918', pic:require('@/assets/img/Spyder.jpg') },
                { car_name: 'Ferrari ', pic:require('@/assets/img/Ferrari.jpg') }
            ]
        }
    },
    computed:{
        randomCar(){
            return this.cars[Math.floor(Math.random() * this.cars.length)]
        }
    }
    
}
</script>