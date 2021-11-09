<template>
    <div id="app"></div>
</template>

<script>

import * as THREE from 'three'

export default {
  name: 'WebGLScenePage',
  data () {
    return {
      renderer: null,
      camera: null,
      scene: null,
      cube: null,
      step: 0
    }
  },
  methods: {
    init () {
      this.scene = new THREE.Scene()
      this.camera = new THREE.PerspectiveCamera(45, window.innerWidth / window.innerHeight, 0.1, 1000)
      this.renderer = new THREE.WebGLRenderer()

      this.renderer.setClearColor(new THREE.Color(0xEEEEEE))
      this.renderer.setSize(window.innerWidth, window.innerHeight)

      var planeGeometry = new THREE.PlaneGeometry(60, 20)
      var planeMaterial = new THREE.MeshBasicMaterial({ color: 0x005533 })
      var plane = new THREE.Mesh(planeGeometry, planeMaterial)

      plane.rotation.x = -0.5 * Math.PI
      plane.position.x = 15
      plane.position.y = 0
      plane.position.z = 0

      this.scene.add(plane)

      var sphereGeometry = new THREE.SphereGeometry(4, 20, 20)
      var sphereMaterial = new THREE.MeshBasicMaterial({ color: 0x7777ff, wireframe: true })
      var sphere = new THREE.Mesh(sphereGeometry, sphereMaterial)

      sphere.position.x = -10
      sphere.position.y = 4
      sphere.position.z = 2

      this.scene.add(sphere)

      //const canvas = document.getElementsByClassName("container")[0].lastElementChild
      const canvas = document.getElementsByClassName("v-application--wrap")[0].lastElementChild
      canvas.appendChild(this.renderer.domElement)

      const geometry = new THREE.BoxGeometry(3, 3, 3)
      const material = new THREE.MeshBasicMaterial({ color: 0xff0000 })

      this.cube = new THREE.Mesh(geometry, material)
      this.scene.add(this.cube)

      // 전진(앞) -z
      // 위쪽 +y
      this.camera.position.z = 30
      this.camera.position.y = 40
      this.camera.position.x = -30
      this.camera.lookAt(this.scene.position)

      this.cube.position.y = 5

      const animate = function () {}
      console.log(animate)

      console.log('cos(x) = ', Math.cos(90))
      console.log('호도법: 라디안(radian) - 360도는 2파이 라디안')
      console.log('180도는 1파이 라디안')
      console.log('임의의 tmp 각도는 몇 라디안 ?')
      console.log('tmp도는 180 degree = pi rad')
      console.log('양변을 180으로 나눈다.')
      console.log('1 degree = (pi / 180) rad')
      console.log('tmp degree = tmp * (pi / 180) rad')
      console.log('cos(90 degree) = cos(pi / 2) = ', Math.cos(Math.PI / 2))
      console.log('cos(90 degree) = cos(pi / 2) = ', Math.cos(Math.PI / 2).toFixed(10))
      console.log('cos(30 degree) = cos(pi / 6) = ', Math.cos(Math.PI / 6))
      console.log('sqrt(3) / 2 = ', Math.sqrt(3) / 2.0)
    },
    animate () {
      requestAnimationFrame(this.animate)

      //this.cube.rotation.x += 0.01
      //this.cube.rotation.y += 0.01
      //this.cube.rotation.z += 0.01

      // 나선형으로 꼬면서 x축으로 날아가려면 어떻게 해야할까 ?
      // cos(wt) = cos(2 * pi * f * t)
      // w = 2 * pi * f

      // 먼저 탄환의 궤적이 sin 웨이브를 타게 만들려면 어떻게 해야할까 ?
      // y = sin(x), x = wt
      // T = 1/f, f = 1, w = 2 * pi * f = 2 * pi
      // 포트리스 구현에는 포물선 운동 <<<-- 공기저항이 들어간(미분 방정식)
      this.step += 0.02
      this.cube.position.x = 10 * this.step
      this.cube.position.y = 5 + 5 * Math.sin(2 * Math.PI * this.step)
      //console.log("y = ", this.cube.position.y)
      //this.cube.position.x += 0.1
      //this.cube.rotation.y += 0.1

      this.renderer.render(this.scene, this.camera)
    }
  },
  mounted () {
    this.init()
    this.animate()
  },
  beforeDestroy () {
    document.getElementsByClassName("container")[0].lastElementChild.removeChild(this.renderer.domElement)
  }
}
</script>

<style scoped>
</style>