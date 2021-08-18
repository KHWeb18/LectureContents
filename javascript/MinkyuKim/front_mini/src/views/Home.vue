<template>
    <div class="home">
        <div id="header">
            <router-link :to="{ name: 'Home' }"
                    class="nav-link"
                    active-class="active">
                Home
            </router-link>
            <router-link :to="{ name: 'VuetifyMemberLoginPage' }"
                    class="nav-link"
                    active-class="active">
                Member 로그인 Test
            </router-link>
            <router-link :to="{ name: 'VuetifyMemberRegisterPage' }"
                    class="nav-link"
                    active-class="active">
                #로그인 테스트
            </router-link>
            <router-link :to="{ name: 'MemberRegisterPage' }"
                    class="nav-link"
                    active-class="active">
                #비밀번로 체크로직 확인
            </router-link>
            
        </div>
    </div>
</template>
<script>
  export default {
    name: 'Home',
    components: {
        
    }
  }
</script>