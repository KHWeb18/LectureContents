<template>
    <div>
        <h3>Product Modified Form</h3>
        <form @submit.prevent="onSubmit">    
           <table>
           <tr>
                <td>번호</td>
                <td><input type="text" v-model="monster.monsterNo" disabled></td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td><input type="text" v-model="monster.regDate" disabled></td>
            </tr>
            <tr>
                <td>몬스터명</td>
                <td><input type="text" v-model="monsterName" ></td>
            </tr>
            <tr>
                <td>HP</td>
                <td><input type="number" v-model="monsterHp"></td>
            </tr>
            <tr>
                <td>EXP</td>
                <td><input type="number" v-model="monsterExp"></td>
            </tr>
            <tr>
                <td>Money</td>
                <td><input type="number" v-model="monsterMoney"></td>
            </tr>
        </table>
            <div>
                <button type="submit">수정 완료</button>
                <router-link :to="{ name: 'MonsterReadPage', params: { monsterNo: monster.monsterNo.toString() } }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name: 'MonsterModifyForm',
    props: {
        monster: {
            type: Object,
            required: true
        }
    },
     data () {
        return {
            monsterName: '',
            monsterHp: 0,
            monsterExp: 0,
            monsterMoney: 0
        }
    },
    methods: {
        onSubmit () {
            const { monsterName, monsterHp, monsterExp, monsterMoney } = this
            this.$emit('submit', { monsterName, monsterHp, monsterExp, monsterMoney })
        }
    },
    created () {
        this.monsterName = this.monster.monsterName
        this.monsterHp = this.monster.monsterHp
        this.monsterExp = this.monster.monsterExp
        this.monsterMoney = this.monster.monsterMoney
      
    }
}
</script>
