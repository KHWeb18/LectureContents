<template>
  <div>
    <h3>Monster Attack!</h3>
    <p id="target">name: {{ monster.name }} hp: {{ monster.hp }}</p>
    <button v-on:click="attackMonster">공격 -10</button> <br><br>
  </div>
</template>

<script>
export default {
  data() {
    return {
      monster: {
        name: 'gogomon',
        hp: 200
      },
    }
  },
  methods: {
    attackMonster() {
      if(this.monster.hp > 0) {
        this.monster.hp -= 10;
      } else {
        alert('몬스터를 잡았습니다.');
        const target = document.querySelector('#target');
        target.classList.add('clear');
      }
    },
  },
}
</script>

<style>
  /* .clear {
   text-decoration: line-through; 
  } */
</style>