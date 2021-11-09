<template>
  <div class="container">
    <div class="row flex">
      <div class="col s2 m2 l2 xl2 red">
        column 2
      </div>
      <div class="col s4 m4 l4 xl4 blue">
        column 4
      </div>
      <div class="col s6 m6 l6 xl6 green">
        column 6
      </div>
      <div class="col s12 m12 l12 xl12 teal">
        column 12
      </div>
    </div>
    <!-- <div class="row">
      <div class="col s12 blue white-text">
        <span class="flow-text">12</span>
      </div>
    <div class="row">
      <div class="col s6 blue white-text">
        <span class="flow-text">12</span>
      </div>
    </div>
      </div>
    <div class="row">
      <div class="col m4 offset-m4 blue white-text">
        <span class="flow-text">12</span>
      </div>
    </div> -->
    <div class="row">
      <a class="btn waves-effect waves-red blue" @click="showMessage($event)" >
        Wi-Fi On!
      </a>
    <div class="row">
      <a class="btn waves-effect waves-red blue" @click="showMessage($event)" >
        <i class="material-iconst left">cloud</i>
        Cloud
      </a>
      <a class="btn-floating waves-effect waves-yellow" @click="showMessage($event)">
        <i class="material-icons right">wifi</i>
        Wi-fi
      </a>
    </div>
    </div>

  </div>
</template>

<script>
export default {
  methods: {
    showMessage() {
      alert("버튼이다")
    }
  }

}
</script>

<style>

</style>