<template>
    <div id="app"></div>
</template>

<script>

import * as THREE from 'three'

export default {
  name: 'WebGLTestPage',
  data () {
    return {
      // Windows - Direct3DX, OpenGL
      // Linux, Mac - OpenGL
      // 휴대폰 ARM - OpenGL(ARM 하위 호환이 안됨)
      // CPU 의존성이 높은 코드가 많음
      // 야 ? HTML5에 그냥 하드웨어 가속(GPU) 기능을 탑재해서 호환성 문제를 해결해볼래 ?
      // 그럼 HTML5 표준에다가 WebGL을 넣자!
      // Web에서 Graphics Library(GPU 제어 라이브러리)를 사용해보자!
      renderer: null,
      camera: null,
      scene: null,
      cube: null
    }
  },
  methods: {
    init () {
      // 그림을 그릴 화면을 만듬
      this.scene = new THREE.Scene()
      // View Frustum (시야각을 관장하는 객체) - 이것을 한국말로 절두체라고함
      // 사각뿔을 눕힌다.
      // 눕힌 사각뿔에서 뿔을 자릅니다 - 뿔 잘라서 버림
      // 절단면의 앞부분이 작고 뿔의 맨 아랫부분은 넓을것임
      // 75도는 시야각, width / height는 종횡비(aspect ratio),
      // 0.1(near plane), 1000(far plane)
      this.camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000)
      // 그래픽 카드(그림 그리는 화가)를 모셔옴
      this.renderer = new THREE.WebGLRenderer()

      document.getElementsByClassName("container")[0].lastElementChild.appendChild(this.renderer.domElement)

      const geometry = new THREE.BoxGeometry(1, 1, 1)
      const material = new THREE.MeshBasicMaterial({ color: 0xff0000 })

      this.cube = new THREE.Mesh(geometry, material)
      this.scene.add(this.cube)

      this.camera.position.z = 5

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