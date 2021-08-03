<template>
<body>
<header>
    <h1><a href="Test">MOVIE</a></h1>
    <div class="lnb">
        <ul>
            <li><a href="Test">홈</a></li>
            <li><a href="#">TV프로그램</a> </li>
            <li><a href="#">영화</a></li>
            <li><a href="#">뉴스</a></li>
            <li><a href="#">게시판</a></li>
        </ul>
    </div>

    <div class="spot">
        <ul>
            <li><a href="Login">로그인</a> </li>
            <li><a href="SignUpRegister">회원가입</a> </li>
        </ul>
    </div>
</header>
<section class="signup-form">
    <h1>SIGN UP</h1>
      <div class="input-area">
        <input type="text" v-model="id" required>
        <label for="id">USER ID</label>
    </div>

    <div class="input-area">
        <input type="password" v-model="password" required>
        <label for="password">PASSWORD</label>
    </div>

    <div class="input-area">
        <input type="text"  v-model="name" required>
        <label for="name">NAME</label>
    </div>

    <div class="input-area">
        <input type="text"  v-model="phone" required>
        <label for="phone">PHONE NUMBER</label>
    </div>

    <div class="input-area">
        <input type="text"  v-model=birthday required>
        <label for="dateofbirth">Date Of Birth </label>
    </div>

    <div class="input-area">
        <input type="text"  v-model=email required>
        <label for="email">Email</label>
    </div>
    

<div class="btn-area">
    <button type="submit" id="btnSignup">SIGN UP</button>
    <button type="reset" id="btnReset">RESET</button>
</div>

</section>
</body>
</template>


<script>
export default {
    name: 'SignUpRegister',
    data() {
        return {
            id: '',
            password: '',
            name: '',
            phone: '',
            birthday: '',
            email: ''
        }
    }

}
</script>
<style scoped>
body{background-color: white;}
.signup-form {position: relative; z-index: 2;
    position: absolute;
    top: 20%; left: 50%;
    margin-left: -150px;
    margin-top: -80px;
    display: center;
    justify-content: center;
    align-items: center;
}
.signup-form h1{
margin-top: 100px;
    font-size: 32px; color: black;
    text-align: center;
    margin-bottom: 60px;
}
.input-area{
    width: 400px;
    text-align: center;
    position: relative;
    margin-top: 20px;
}
.input-area first-child{margin-top: 0;}
.input-area input{
    width: 100%;
    padding: 20px 10px 10px;
    background-color: transparent;
    border: none;
    border-bottom: 1px solid #999;
    font-size: 19px; color: black;
    outline: none;
}
.input-area label{
    position: absolute; left: 10px; top: 15px;
    font-size: 18px; color: #999;
    transition: top .5s ease;
}
.input-area input:focus + label,
.input-area input:valid + label{
    top: 0;
    font-size: 13px; color: #166cea;
}
.btn-area{margin-top: 30px;}

.btn-area button{
    width: 100%; height: 50px;
    background: #166cea;
    color: #fff;
    font-size: 20px;
    border: none;
    border-radius: 25px;
    margin-top: 10px;
    cursor: pointer;
    }
</style>