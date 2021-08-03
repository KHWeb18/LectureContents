<template>
    <div>
        <p>This is the Child Component</p>
        <!-- slot은 부모 컴포넌트에서 이 컴포넌트의 이름으로 감싸진것을 가져온다 -->
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