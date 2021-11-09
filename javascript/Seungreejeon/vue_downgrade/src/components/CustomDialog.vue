<template>
  <div>
      <slot name="activator" :on="{ mouseover: showDialog}" >
        <!-- 항상 보여지는 부분 -->
      </slot>
      <slot v-if="show">
        <!-- show가 true일 경우에만 보여지는 부분 (default slot) -->
        <!-- <template>으로 싸여있지 않은 내용물들은 디폴트 슬롯에 해당되는 것으로 간주합니다. -->
      </slot>
  </div>
</template>

<script>
export default {
  data() {
    return {
      show: false,
    };
  },
  methods: {
    showDialog(){
        this.show = true
    }
  }
}
</script>

