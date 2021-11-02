<template>
    <div align="center">
        <form v-on:submit="onSubmit">
            <table>
                <tr>
                    <td>Name</td>
                    <td><input type="text" v-model="name"></td>     
                </tr>
                <tr>
                    <td>Level</td>
                    <td><input type="text" v-model="level"></td>     
                </tr>
                <tr>
                    <td>Str</td>
                    <td><input type="text" v-model="strength"></td>     
                </tr>
                <tr>
                    <td>HP</td>
                    <td><input type="text" v-model="hp"></td>     
                </tr>
                <tr>
                    <td>Attr</td>
                    <td><input type="text" v-model="attribute"></td>     
                </tr>
                <tr>
                    <td>Exp</td>
                    <td><input type="text" v-model="exp"></td>     
                </tr>
        </table>
        <button type="submit">Modify Confirm</button>
        </form>
    </div>
</template>

<script>

export default {
    name: 'MonsterModify',
    props: {
        monster: {
            type: Object,
            requited: true
        }
    },
    data() {
        return {
            name: this.monster.name,
            level: this.monster.level,
            strength: this.monster.strength,
            hp: this.monster.hp,
            attribute: this.monster.attribute,
            exp: this.monster.exp,
        }
    },
    methods: {
        onSubmit() {
            const { name, level, strength, hp, attribute, exp } = this
            console.log(JSON.stringify({ name, level, strength, hp, attribute, exp }))

            this.$emit('submit', { name, level, strength, hp, attribute, exp })
        }
    }
}
</script>
