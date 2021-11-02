<template>
    <div>
        <form id="board"  class="loginForm">
            <h2>Login</h2>
            <div class="idForm">
                <input type="text" class="id" placeholder="ID" name="id" >
            </div>

            <div class="passForm">
                <input type="password" class="pw" placeholder="PW" name="password " >
            </div>

            <button type="submit" class="btn" id="btnRegister" onclick="button()">
                LOG IN
            </button>

            <div class="bottomText">
                Don't you have ID? <router-link :to="{ name: 'RegisterPage' }"
                    class="nav-link"
                    active-class="active">
                sign up
            </router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name: 'LoginPageForm',
    
}
</script>

<style>
    *{
  margin: 0px;
  padding: 0px;
  text-decoration: none;
  font-family:sans-serif;

}

body {
  background-color: #34495e;
  width: 100%;
  height: 100%;
}

.loginForm {
  position:absolute;
  width:300px;
  height:400px;
  padding: 30px, 20px;
  background-color:#34495e23;
  text-align:center;
  top:50%;
  left:50%;
  transform: translate(-50%,-50%);
  border-radius: 15px;
}

.loginForm h2{
  text-align: center;
  margin: 30px;
}

.idForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}

.passForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}

.id {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.pw {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.btn {
  position:relative;
  left:40%;
  transform: translateX(-50%);
  margin-bottom: 40px;
  width:80%;
  height:40px;
  background: linear-gradient(125deg,#81ecec,#6c5ce7,#81ecec);
  background-position: left;
  background-size: 200%;
  color:white;
  font-weight: bold;
  border:none;
  cursor:pointer;
  transition: 0.4s;
  display:inline;
}

.btn:hover {
  background-position: right;
}

.bottomText {
  text-align: center;
}
</style>