<template>
  <div>
    <p>Child Component</p>
    <!-- 부모 컴포넌트의 일부를 자녀 컴포넌트에서 재활용 가능 -->
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
  border: 3px solid pink;
  padding: 4px;
  margin: 4px;
}
</style>