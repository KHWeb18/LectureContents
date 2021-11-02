<template>
    <div class="home">
        <div id="header">
            <!-- router-link는 어디로 갈지 URL 맵핑해주는 Spring의 Controller 같은 역할
                 to: Home은 이 녀석을 클릭했을 때 router/index.js에 등록된 Home으로 가게 만듬 
                 class: nav-link의 경우 Navigation Bar 같은 역할을 해줄 수 있게 구성함을 의미
                 active-class: 링크가 활성화 되었을때 적용된 CSS를 의미함 -->
            <router-link :to="{ name: 'Home' }"
                    class="nav-link"
                    active-class="active">
                Home
            </router-link>
            <router-link :to="{ name: 'Test' }"
                    class="nav-link"
                    active-class="active">
                Test
            </router-link>
        </div>
    </div>
</template>

<script>
  export default {
    name: 'Home',
    components: {
    },
  }
</script>
