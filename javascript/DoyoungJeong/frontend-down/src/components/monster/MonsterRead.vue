<template>
    <div align="center">
        <table>
                <tr>
                    <td>Name</td>
                    <td><input type="text" :value="monster.name" disabled></td>     
                </tr>
                <tr>
                    <td>Level</td>
                    <td><input type="text" :value="monster.level" disabled></td>     
                </tr>
                <tr>
                    <td>Str</td>
                    <td><input type="text" :value="monster.strength" disabled></td>     
                </tr>
                <tr>
                    <td>HP</td>
                    <td><input type="text" :value="monster.hp" disabled></td>     
                </tr>
                <tr>
                    <td>Attr</td>
                    <td><input type="text" :value="monster.attribute" disabled></td>     
                </tr>
                <tr>
                    <td>Exp</td>
                    <td><input type="text" :value="monster.exp" disabled></td>     
                </tr>
        </table>
    </div>
</template>

<script>

export default {
    name: 'MonsterRead',
    props: {
        monster: {
            type: Object,
            required: true
        }
    }
 
}
</script>
