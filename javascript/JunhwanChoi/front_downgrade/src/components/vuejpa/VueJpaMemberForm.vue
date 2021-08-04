<template>
    <form @submit.prevent="onSubmit">
          <div id="app">
            <v-app id="inspire">
                <v-app id="inspire">
                <v-main>
                    <v-container
                    class="fill-height"
                    fluid
                    >
                    <v-row
                        align="center"
                        justify="center"
                    >
                        <v-col
                        cols="12"
                        sm="8"
                        md="4"
                        >
                        <v-card class="elevation-12">
                            <v-toolbar
                            color="primary"
                            dark
                            flat
                            >
                            <v-toolbar-title>Sign Up</v-toolbar-title>
                            <v-spacer></v-spacer>
                            <v-tooltip bottom>
                            </v-tooltip>
                            </v-toolbar>
                            <v-card-text>
                            <v-form>
                                <v-text-field
                                label="ID"
                                name="id"
                                prepend-icon="mdi-account"
                                type="text"
                                v-model="id"
                                flat solo></v-text-field>
            
                                <v-text-field
                                id="pw"
                                label="Password"
                                name="pw"
                                prepend-icon="mdi-lock"
                                type="password"
                                v-model="pw"
                                flat solo></v-text-field>
                            </v-form>
                            </v-card-text>
                            <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn type="submit" color="primary">SignUp</v-btn>
                            </v-card-actions>
                        </v-card>
                        </v-col>
                    </v-row>
                    </v-container>
                </v-main>
                </v-app>
            </v-app>
            </div>   
    </form>
</template>

<script>
export default {
    name: 'VueJpaMemberForm',
   
   //v-model 지정해준 id, pw는 데이터 설정
    data () {
        return {
            id: '',
            pw: '',
        }
    },
    //v-model을 사용한 id, pw는 emit으로 전달
    methods: {
        onSubmit () {
            const { id, pw } = this
            this.$emit('submit', { id, pw })
        }
    }
}
</script>

<style scoped>

</style>

