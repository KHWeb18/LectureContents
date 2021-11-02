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
                                ></v-text-field>
            
                                <v-text-field
                                id="password"
                                label="Password"
                                name="password"
                                prepend-icon="mdi-lock"
                                type="password"
                                v-model="pw"
                                ></v-text-field>
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
          <!-- <table>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" v-model="id"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" v-model="pw"></td>
                </tr>
            </table>

           <div>
            <button type="submit">등록</button>
            <router-link :to="{ name: 'Home' }">
                취소
            </router-link>
        </div>-->
    </form>
</template>

<script>
export default {
    name: 'GameMemberRegisterForm',
   
    data () {
        return {
            id: '',
            pw: '',
        }
    },
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

