<template>
  <div>
    <ul>
        <li>
            <label for="bottomSide">밑변의 길이 : </label>
            <input type="number" v-model="bottomSide">cm
        </li>
        <li>
            <label for="triangleHeight">삼각형의 높이 : </label>
            <input type="number" v-model="triangleHeight">cm
        </li>
        <li>
            삼각형의 넓이는? {{ triangleArea }}
        </li>
    </ul>
    <div id="showResult"></div>
  </div>
</template>

<script>

export default {
  data () {
        return {
            bottomSide: 0,
            triangleHeight: 0
        }
    },
    computed: {
        triangleArea () {
            return this.bottomSide * this.triangleHeight / 2.0;
        }
    }
}


</script>