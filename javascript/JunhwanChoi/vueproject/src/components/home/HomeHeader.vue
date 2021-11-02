<template>
    <div>
        <div id="header">
            <nav id="navcolor">
                <ul>
                    <li><a href>HOME</a></li>
                    <li><a href="/login">로그인</a></li>
                    <li><router-link :to="{ name: 'RegisterPage' }">회원가입</router-link></li>
                    <!-- <li><router-link :to="{ name: 'MemberListPage' }">[관리자 회원 리스트]</router-link></li> -->

                </ul>
            </nav>


            <center>
                <div id="main">
                    <br><br>
                    <p><img src="../../assets/mainPageImg.jpg"></p>                    
                </div>
            </center> 
        </div>
    </div>

</template>

<script>
export default {
    name: 'HomeHeader',
}
</script>

<style>
ul{ list-style: none;}
    a{text-decoration: none;}

    body{
        background-color: white;
        color: white;
        margin: 0;
        padding: 0;
        font-size: 1.2em;
        font-family: 'Hack';
    }
    #navcolor{
        background: #C8D7FF;
    }
    #header{
        color:  black;
        background-color: #C8D7FF;
        padding: 15px;
    }

    #footer{
        color: black;
        background-color: #f1f1f1;
        padding: 10px;
    }


    ul{
        margin: 0;
        padding: 0;
        list-style-type: none;
        float: right;
    }

    li{
        display: inline;
        margin: 0 20px 0 0 ;
    }


    /* 전체 페이지가 가운데로 오도록 */
    #page{width: 820px; margin: 0px auto;}
    

</style>




