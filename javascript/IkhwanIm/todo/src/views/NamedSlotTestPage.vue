<template>
  <div id="app">
    <child-comp :ran_car="randomCar">
      <div slot="best">
        <figure>
          <img src="@/assets/spyder.jpg"/>
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
        { car_name: 'Tesla Model X', pic:require('@/assets/modelX.jpg') },
        { car_name: 'Spyder 918', pic:require('@/assets/spyder.jpg') },
        { car_name: 'Nissan Maxima', pic:require('@/assets/maxima.jpg') }
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