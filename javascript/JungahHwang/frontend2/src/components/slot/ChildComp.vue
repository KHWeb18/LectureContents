<template>
  <div class="main">
    <div class="best">
      <h3>강아지 종류</h3>
      <!-- best, footer라는 이름의 slot을 사용, 부모 컴포넌트에 정의된 데이터를 가져옴
           class 속성이 dog인 div 내의 이미지를 배치함
           props를 활용해 부모 컴포넌트에서 해당 데이터를 전달 받음 -->
      <slot name="best"></slot>
    </div>
    <div class="dog">
      <h3>{{ ran_dog.name }}</h3>
      <img :src="ran_dog.pic">
    </div>
    <div class="footer">
      <slot name="footer"></slot>
    </div>
  </div>
</template>


<script>

export default {
  props: ['ran_dog']
}
</script>


<style scoped>

.main {
  border: 4px solid gray;
}
.best {
  border: 4px solid pink;
  margin: 4px;
}
.dog {
  border: 4px solid pink;
  margin: 4px;
}
figcaption {
  text-align: center;
  padding: 2px 0;
  width: 100%;
}
img {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 60%;
}
.footer {
  bottom: 0px;
  color: white;
  background-color: pink;
  width: 100%;
  text-align: center;
  font-size: 80%;
}

</style>