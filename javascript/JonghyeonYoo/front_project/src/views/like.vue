<template>
<div id="app">
  <button class="button" v-on:click="likecnt++">좋아요</button> <span>좋아요 : {{likecnt}}</span>
  <button class="button" @click="dislikecnt++">싫어요</button> <span>싫어요 : {{dislikecnt}}</span>
</div>
</template>


<script>
export default {
  name: 'App',
  data(){
    return {
      likecnt : 0,
      dislikecnt : 0
    }
  }
}
</script>

<style>
  .button{
    margin: 150px auto 0;
  }
</style>