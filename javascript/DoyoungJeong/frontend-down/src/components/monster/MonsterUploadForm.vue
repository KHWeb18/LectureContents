<template>
    <div align="center">
        <form @submit.prevent="onSubmit">
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
            <button type="submit">Upload</button>
        </form>
    </div>
</template>

<script>

export default{
    name: 'MonsterUploadForm',
    data() {
        return {
            name: 'Input the Monster Name',
            level: 'Input the Monster Level',
            strength: 'Input the Monster Str',
            hp: 'Input the Monster HP',
            attribute: 'Input the Monster Attr',
            exp: 'Input the Monster Exp'
        }
    },
    methods: {
        onSubmit() {
            const { name, level, strength, hp, attribute, exp } = this
            this.$emit('submit', { name, level, strength, hp, attribute, exp })

            console.log(JSON.stringify({ name, level, strength, hp, attribute, exp }))
        }
    }
}
</script>
