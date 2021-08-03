<template>
<header>
    <h1><a href="Test">WARNING</a></h1>
    <div class="lnb">
        <ul>
            <li><a href="Test">홈</a></li>
            <li><a href="#">TV프로그램</a> </li>
            <li><a href="#">영화</a></li>
            <li><a href="#">뉴스</a></li>
        </ul>
    </div>

    <div class="spot">
        <ul>
            <li><a href="Login">로그인</a> </li>
            <li><a href="SignUpRegister">회원가입</a> </li>
        </ul>
    </div>
</header>    
</template>

<style>
header{background-color: white;}

*{list-style: none;
text-decoration: none;
}

header{text-align: center;}
header h1 {position: absolute; left: 50px; top: 0;}
header h1 a {width: 110px; height: 81px; color: red;}
header .spot {position: absolute; right: 50px; top: 0;}
header .lnb li {display: inline-block;}
header .lnb li a{ display: block; height: 100px; padding: 0 35px; font-size: 35px; color: black;
line-height: 100px;}
header .spot {position: absolute; right: 50px; top: 0;}
header .spot li {float: left;}
header .spot li a{display: block; height: 81px; padding: 0 10px;
line-height: 100px; color: black;}
header .spot li:first-child:after {display: none;}
header .spot li:last-child a{padding-right: 0;}
</style>