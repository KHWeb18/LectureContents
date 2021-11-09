<template>
    <div>
        <h3>몬스터 도감 수정</h3>
        <!--prevent를 넣은 이유는 실행순서를 보장해주기 때문에
            여기서 submit을하면 바로 처리를 하러 가는데 prevent가 걸려있으면, submit을 했을 때
            onSubmit으로 걸려서 views/monsterModifyPage.vue로 넘어가 submit이 작동하게 됨.
            즉, 여기(하위컴포넌트)에서 submit 하는것을 막고 상위컴포넌트에서 실행되게 한다. -->
        <form @submit.prevent="onSubmit">            
            <table>
                <tr>
                    <td>몬스터 번호</td>
                    <td><input type="text" :value="monster.monsterNo" disabled></td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td><input type="text" :value="monster.regDate" disabled></td>
                </tr>
                <tr>
                    <td>몬스터명</td>
                    <td><input type="text" v-model="name"></td>
                </tr>
                <tr>
                    <td>HP</td>
                    <td><input type="Number" v-model="hp"></td>
                </tr>
                <tr>
                    <td>경험치</td>
                    <td><input type="Number" v-model="exp"></td>
                </tr>
                <tr>
                    <td>드랍 머니</td>
                    <td><input type="Number" v-model="dropMoney"></td>
                </tr>
                <tr>
                    <td>드랍 아이템</td>
                    <td><input type="text" v-model="dropItem"></td>
                </tr>

                <tr>
                    <td>몬스터 세부사항</td>
                    <td><textarea cols="50" rows="20" v-model="description"></textarea></td>
                </tr>
            </table>

            <div>
                <button type="submit">수정 완료</button>
                <router-link :to="{ name: 'MonsterReadPage',params: { monsterNo: monster.monsterNo.toString() } }">
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
            name: '',
            hp: 0,
            exp: 0,
            dropMoney: 0,
            dropItem: '',
            description: ''
        }
    },
    methods: {
        onSubmit () {
            const { name, hp, exp, dropMoney, dropItem, description } = this
            this.$emit('submit', { name, hp, exp, dropMoney, dropItem, description })
        }
    },
    created () {
        this.name = this.monster.name    
        this.hp = this.monster.hp
        this.exp = this.monster.exp
        this.dropMoney = this.monster.dropMoney
        this.dropItem = this.monster.dropItem        
        this.description = this.monster.description        
    }
}
</script>