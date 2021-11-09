<template>
  <div>
    <p>Child 컴포넌트</p>
    <!-- 부모 컴포넌트의 일부를 자녀 컴포넌트에서 쓸 수 있게 만듬 --> 
    <slot></slot>
    <slot></slot>
    <slot></slot>
    <slot></slot>
    <slot></slot>
    <slot></slot>
    <slot></slot>
    <slot></slot>
  </div>
</template>

<style scoped>
p {
  border: solid 3px teal;
  padding: 4px;
}


</style>