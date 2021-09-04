<template>
    <div class="member-box">
        <v-container>
            <v-container>
                <div style="margin-bottom:10%;">
                <v-text-field label="회원번호" :value="user.memberNo"
                    style="margin:3% 0% 3% 0%;" disabled type="member"></v-text-field>
                <v-text-field  label="가입날짜" :value="user.regDate" 
                    style="margin:3% 0% 3% 0%;" disabled type="dates"></v-text-field>
                <v-text-field  label="회원명" :value="user.userName" 
                     style="margin:3% 0% 3% 0%;" disabled type="userName"></v-text-field>
                <v-text-field  label="회원 아이디" :value="user.userId" 
                     style="margin:3% 0% 3% 0%;" disabled type="userId"></v-text-field>
                <v-text-field  label="전화번호" :value="user.userPhone" 
                     style="margin:3% 0% 3% 0%;" disabled type="phone"></v-text-field>

             
                <v-btn outlined class="ma-2 edit" route :to="{ name: 'UserModifyPage', params: { memberNo: user.memberNo.toString() } }">
                    수정하기</v-btn> 

                </div>

                <div>
                    <v-row class="justify-center">
                <v-btn color="blue" outlined class="ma-2 white--text" route :to="{ name: 'UserList' }">
                    이전으로</v-btn> 
                    </v-row>
                </div>
            </v-container>
        </v-container>
    </div>
    
</template>

<script>

export default {
    name: 'UserReadPage',
    props: {
        user: {
            // type: Object,
            authList: Array,
            password:String,
            userId: String,
            userName: String,
            userPhone: String,
            memberNo: String,
            // required: true
        }
    } 
}
</script>

<style scoped>
h4 {
    margin-top: 0px;
    font-family: 'Nanum Myeongjo';
    font-size: 18px;
    margin-left: 40%;
}

.member-box {
    margin-top: 2%;
}

.edit{
    position: absolute;
    top: 70%;
    left: 65%;
    width: 5px;
    font-size: 6px;
    color: rgb(102, 101, 101);
    
}
</style>