<template>
    <div id="app">
        <child-comp :ran_car="randomCar">
            <div slot="best">
                <figure>
                    <img src="@/assets/imgs/spyder.jpg"/>
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
import ChildComp from '@/components/slot/ChildComp';
export default {
    name: 'NameSlotTestPage',
    components:{
        'child-comp' :  ChildComp
    },
    data()
    {
        return{
            cars:[
                {car_name:'Lamborghini', pic: require('@/assets/imgs/lambo.jpg')},
                {car_name:'Spyder 918', pic: require('@/assets/imgs/spyder.jpg')},
                {car_name:'genesis', pic: require('@/assets/imgs/genesis.jpg')},
            ]
        }
    },
    computed:{
        randomCar(){
            return this.cars[Math.floor(Math.random()*this.cars.length)]
        }
    }
    
}
</script>