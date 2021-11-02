<template>
    <div class="main">
        <div class="best">
            <h3>추천차량</h3>
            <!-- 
                best, footer 라는 이름의 named slot을 사용
                부모 컴포넌트에 정의된 내용을 가져온다.
                class 속성이 car인 div 내의 이미지를 배치함.
                props를 활용해 부모 컴포넌트에서 해당 데이터를 전달받음.
            -->
            <slot name="best"></slot>
        </div>
        <div class="car">
            <h3>이달의차:{{ ran_car.car_name}}</h3>
            <img :src="ran_car.pic"/>
        </div>
        <div class="footer">
            <slot name="footer"></slot>
        </div>
    </div>
</template>


<script>
export default {
    props: ['ran_car']
}
</script>


<style scoped>
/*
.main {
    border: 4px solid blue;

}
.best {
    border: 4px solid teal;
    margin: 4px;
}
.figcaption, h3{
    text-align: center;
    padding: 4px;
}
*/
</style>