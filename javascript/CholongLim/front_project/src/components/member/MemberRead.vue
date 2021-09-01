<template>
    <form>
            <div class="member-box">
            <v-col cols="12" md="12" >

            <v-text-field label="회원번호" dense required height="5vh" style="margin-top:10px;" 
                            outlined readonly
                           :value="member.memberNo" type="memberNo">
            </v-text-field>

            <v-text-field label="이름" dense required height="5vh" style="margin-top:10px;" 
                            outlined readonly
                           :value="member.userName" type="userName">
            </v-text-field>

            <v-text-field label="아이디" dense required height="5vh" style="margin-top:10px;" 
                                outlined readonly
                           :value="member.userId" type="userId">
            </v-text-field>

            <v-textarea label="휴대전화"  auto-grow style="margin-top:10px;" counter maxlength="500"
                            full-width single-line outlined readonly
                       :value="member.userPhone" type="userPhone">
            </v-textarea>
            </v-col>
            </div>
    </form>
</template>

<script>
export default {
    name: 'MemberRead',
    props: {
        member: {
            type: Object,
            required: true
        }
    }    
}
</script>

<style scoped>

.member-box {
    text-align: center;
    width: 50%;
    margin: 0 auto;
}
.register-box{
    border: 1px solid #cccccc;
    background-color: white;
    float: left;
    width: 500px;
    height: 500px;
}

.btn-size{
    margin: 0 auto;
    text-align: center;
    width: 50%;
    padding: 3% 0% 5% 0%;
}

h1{
    font-family: "Gowun Dodum";
    font-size: 30px;
    margin-top: 5%;
    text-align: center;

}

</style>