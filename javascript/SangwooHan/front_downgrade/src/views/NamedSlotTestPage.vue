<template>
    <div id="app" class="blue">
        <child-comp :ran_car="randomCar">
            <div slot="best">
                <figure>
                    <img src="@/assets/img/카이엔.jpg"/>
                    <figcaption>페라리 </figcaption>
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
        name: 'NameSlotTestPage',
        components: {
            'child-comp': ChildComp
        },
        data() {
            return {
                cars: [
                    { car_name: '람보르기니' , pic:require('@/assets/img/람보르기니.jpg')},
                    { car_name: '페라리 카이엔' , pic:require('@/assets/img/카이엔.jpg')},
                    { car_name: '페라리 슈퍼카' , pic:require('@/assets/img/페라리빨간차.jpg')},
                    { car_name: '제네시스' , pic:require('@/assets/img/제네시스.jpg')},

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