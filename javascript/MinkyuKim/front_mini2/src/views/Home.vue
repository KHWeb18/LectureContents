<template>
    <div class="home">
        <div id="header">
            <router-link :to="{ name: 'Home' }"
                    class="nav-link"
                    active-class="active">
                Home
            </router-link>
            <router-link :to="{ name: 'VuetifyMemberRegisterPage' }"
                    class="nav-link"
                    active-class="active">
                RegisterTest
            </router-link>
            <router-link :to="{ name: 'VuetifyMemberLoginPage' }"
                    class="nav-link"
                    active-class="active">
                login Test
            </router-link>
            <router-link :to="{ name: 'MemberJoinColumnTestPage' }"
                    class="nav-link"
                    active-class="active">
                join Test
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
