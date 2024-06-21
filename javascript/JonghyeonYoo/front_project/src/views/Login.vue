<template>
    <v-container fill-height style="max-width: 450px;">
        <v-layout align-center row wrap >
            <v-flex xs12>
                <v-card>
             <v-toolbar flat>
                    <v-toolbar-title>로그인</v-toolbar-title>
             </v-toolbar>
             <div class="pa-3">
                <v-text-field
                v-model="email"
                label="Email">
                </v-text-field>
                <v-text-field
                v-model="password"
                type="password"
                label="Password">
               
                </v-text-field> 
                  <v-btn
                  color="blue"
                  block
                  large
                  @click="login()"
                  >
                  로그인
                  </v-btn>
             </div>
          
                </v-card>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
export default {
    data() {
        return {
            email: null,
            password: null
        }
    },
    methods: {
        login() {
            console.log(this.email, this.password)
        }
    },
}
</script>