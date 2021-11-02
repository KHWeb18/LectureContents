<template>
  <div id="app">
    <child-comp :ran_dog="randomDog">
      <div slot="best">
        <figure>
          <img src="@/assets/imgs/Pomeranian.jpeg">
          <figcaption>Pomeranian</figcaption>
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
  namd: 'NamedSlotPage',
  components: {
    'child-comp': ChildComp
  },
  data () {
    return {
      dogs: [
        { name: 'Maltese', pic: require('@/assets/imgs/Maltese.jpg') },
        { name: 'Retriever', pic: require('@/assets/imgs/Retriever.jpeg') },
        { name: 'Poodle', pic: require('@/assets/imgs/Poodle.jpeg') }
      ]
    }
  },
  computed: {
    randomDog () {
      return this.dogs[Math.floor(Math.random() * this.dogs.length)]
    }
  }
}
</script>