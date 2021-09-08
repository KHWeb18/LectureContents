<template>
        <v-container>
            <v-card>
                <form @submit.prevent="onSubmit">
                    <table border="1" flat solo >
                    <tr>
                        <td >백신종류</td>
                        <td><input type="text" v-model="vaccine"></td>
                    </tr>
                    <tr>
                        <td>나이</td>
                        <td><input type="text" v-model="age"></td>
                    </tr>
                    <tr>
                        <td>성별</td>
                        <td><input type="text" v-model="gender"></td>
                    </tr>
                    <tr>
                        <td>후기</td>
                        <td><textarea cols="50" rows="20" v-model="content"></textarea></td>
                    </tr>
                </table>

                <div>
                    <v-btn color="blue lighten-5">
                        <button type="submit">등록</button>
                    </v-btn>
                    <v-btn color="blue lighten-5">
                        <router-link :to="{ name: 'BoardListPage' }">
                            취소
                        </router-link>
                    </v-btn>
                </div>
    </form>
            </v-card>
           
        </v-container>
        
</template>

<script>
export default {
    name: 'BoardRegisterForm',
    data () {
        return {
            vaccine:'접종하신 백신 종류를 입력해 주세요.',
            age:'나이를 입력해 주세요.',
            gender:'성별을 입력해 주세요.',
            content: '소중한 후기를 공유해 주세요.'
        }
    },
    methods: {
        onSubmit () {
            const { age, gender, vaccine, content } = this
            this.$emit('submit', { age, gender, vaccine, content })
        }
    }
}
</script>

<style scoped>
p{
    color:white;
}

    
</style>