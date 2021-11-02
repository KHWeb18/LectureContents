<template>
    <div class="main">
        <div class="best">
            <h3>추천차량</h3>
            <slot name="best"></slot>
        </div>
        <div class="car">
            <h3>{{ran_car.car_name}}</h3>
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

<style >
    .main{
        border: 4px solid blue;

    }
    .best{
        border: 4px solid teal;
        margin: 4px;

    }
    .car{
        border: 4px solid lime;
        margin: 4px;
    }
    figcaption, h3{
        text-align: center;
        padding: 2px 0;
        width: 100%;
    }

</style>