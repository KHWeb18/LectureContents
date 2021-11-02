<template>
    <div class="buttonBox">
        <button v-on:click="useSkill">스킬 사용</button>
    </div>
</template>

<script>

export default {
    name: 'attack-monster',
    data() {
        return {
            skill_damage: 4
        }
    },
    methods: {
        useSkill() {
            console.log('useSkill')
            this.$emit('useSkill', this.skill_damage)
            //emit하면 useSkill에 이 컴포넌트에 있는 skill_damage의 값이 함께 보내진다.
            //emit에 ''로 둘러쌓인 첫 번째 인자는 이 컴포넌트를 받는 컴포넌트의 v-on:''과 이름이 무조건 같아야,
            //값을 보낼 수 있다.
        }  
    }
 }

</script>

<style scoped>

.buttonBox {
    margin-top: 20px;
}

</style>
