<template>
    <v-container>
        <form @submit.prevent="onSubmit">
            <div id="app">
            <v-app id="inspire">
                <v-card
                :loading="loading"
                class="mx-auto my-12"
                max-width="800"
                >
                <template slot="progress">
                    <v-progress-linear
                    color="deep-purple"
                    height="10"
                    indeterminate
                    ></v-progress-linear>
                </template>
            
                <v-img
                    height="200"
                    src="@/assets/main.png"
                ></v-img>
            
                <v-card-title><b>예약 정보 확인</b></v-card-title>
            
                <v-card-text>
                    <v-row
                    align="center"
                    class="mx-0"
                    >
                    </v-row>
  
                    예약 일자 : <v-text-field v-model="start" flat solo></v-text-field>
                    장소 : <v-text-field v-model="title" flat solo></v-text-field>
                    시간 : <v-text-field v-model="time" flat solo></v-text-field>
                
                    
                    예약자 이름 : <p><input type="text" v-model="name" :rules="nameRules" ></p>
                    <span class="spanfont">*이름을 입력하여 주세요.</span>


                    <div class="text-right">

                            <button type="submit">예약 완료</button>
                    </div>
      </v-card-text>
  

    </v-card>
  </v-app>
</div>
            
            
        </form>
    </v-container>
</template>

<script>
export default {
    name: 'BookRegisterForm',
    data () {
        return {
            start:'',
            time:'',
            title:'',
            name:'',
            nameRules:[
                 v => !!v || '이름을 입력해 주세요.',
                
            ]
        }
    },
    methods: {
        onSubmit () {
            const { start, time, title, name} = this
            this.$emit('submit', {start, time, title, name})
        },
       
    },
     created(){
        this.start=this.$route.query.start
        this.title=this.$route.query.title
        this.time=this.$route.query.time
        console.log(this.start)
    }
}
</script>

<style scoped>
hr{
    color:blue;
    
}
.text-right{
    color:blue;
}
.thcolor{
    color:blue;
}
.spanfont{
    color:red;
}

    
</style>