<template>
    <div class="main">
        <div class="best">
            <h3>귀여운 강아지~~!!</h3>
            <!-- best, footer라는 이름의 named slot을 사용
                 부모 컴포넌트에 정의된 내용을 가져온다.
                 class 속성이 dog인 div 내의 이미지를 배치함
                 props를 활용해 부모 컴포넌트에서 해당 데이터를 전달 받음 
                 현재 slot은 best,footer 뿐이다.-->
            <slot name="best"></slot>
        </div>
        <!-- slot이 사용된 부분이 아님 -->
        <div class="dog">
            <h3>{{ ran_dog.dog_name }}</h3>
            <img :src="ran_dog.pic"/>
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
    border: 4px solid thistle;
}
.best {
    border: 4px solid yellowgreen;
    margin: 4px;
}
.dog {
    border: 4px solid steelblue;
    margin: 4px;
}
.figcaption, h3 {
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
    background-color:powderblue;
    width: 100%;
    text-align: center;
}
</style>