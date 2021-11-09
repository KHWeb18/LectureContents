<template>
    <div>
        <p>Child 컴포넌트</p>
        <!-- 부모 컴포넌트의 일부를 자녀 컴포터는에서 사용할 수 있게 만듦 -->
        <!-- page에서 child-com으로 감싼 부분을 그대로 가져옴 -->
        <slot></slot>
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
    border: 3px solid teal;
    padding: 4px;    
}

</style>