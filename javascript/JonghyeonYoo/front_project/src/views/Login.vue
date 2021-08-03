<template>
    <body>
<header>
    <h1><a href="Test">WARNING</a></h1>
    <div class="lnb">
        <ul>
            <li><a href="Test">홈</a></li>
            <li><a href="2">TV프로그램</a> </li>
            <li><a href="2">영화</a></li>
            <li><a href="2">뉴스</a></li>
        </ul>
    </div>
    
    <div class="spot">
        <ul>
            <li><a href="Login">로그인</a> </li>
            <li><a href="SignUpRegister">회원가입</a> </li>
        </ul>
    </div>
</header>

    <section class="login-form">
        <h1>LOGIN</h1>
        <form action="">
            <div class="input-area">
                <input type="text" name="id" id="id" autocomplete="off" required>
                <label for="id">USER ID</label>
            </div>
            <div class="input-area">
                <input type="password" name="pw" id="pw" autocomplete="off" required>
                <label for="pw">PASSWORD</label>
            </div>
            <div class="btn-area">
                <button type="submit" id="btnLogin">LOGIN</button>
            </div>
        </form>
        <div class="caption">
        <a href="signupregister">SIGNUP</a>
        </div>
    </section>



</body>
</template>

<style>
section{background-color: white;}
.login-form {position: relative; z-index: 2;
    position: absolute;
    top: 25%; left: 50%;
    margin-left: -150px;
    margin-top: -80px;
    display: center;
    justify-content: center;
    align-items: center;
}
.login-form h1{
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
    font-size: 19px; color: #fff;
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
    cursor: pointer;
    }

.caption{
    margin-top: 20px;
    text-align: center;
}
.caption a{
    color: white;
}
</style>