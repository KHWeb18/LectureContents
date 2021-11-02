<template>
    <div align="center">
        <h3>Vue + Spring 몬스터정보 읽기</h3>
        <table>
            <tr>
                <td>몬스터번호</td>
                <td><input type="text" :value="monster.monsterNo" readonly></td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td><input type="text" :value="monster.regDate" readonly></td>
            </tr>
            <tr>
                <td>몬스터이름</td>
                <td><input type="text" :value="monster.name" readonly></td>
            </tr>
            <tr>
                <td>체력</td>
                <td><input type="number" :value="monster.hp" readonly></td>
            </tr>
            <tr>
                <td>공격력</td>
                <td><input type="number" :value="monster.atk" readonly></td>
            </tr>
        </table>
    </div>
</template>

<script>

export default {
    name: 'MonsterBookRead',
    props: {
        monster: {
            type: Object,
            required: true
        }
    }    
}

</script>