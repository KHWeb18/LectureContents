<template>
  <div class="home">
    <div id="header">
      <!-- router-link는 어디로 갈지 URL맵핑해주는 Spring의 Cnotroller같은 역할
           to: Home은 이 녀석을 맵핑했을 때 router/index.js에 등록된 Home으로 가게 만듬
           class: non-link의 경우 Navigation Bar같은 역할을 해줄 수 있게 구성함을 의미
           active-class: 링크가 활성화 되었었을때 적용된 CSS를 의미함 -->
      <router-link
        :to="{ name: 'Home' }"
        class="nav-link"
        active-class="active"
      >
        Home
      </router-link>
            <router-link
        :to="{ name: 'MainHome' }"
        class="nav-link"
        active-class="active"
      >
        Main Home
      </router-link>
                  <router-link
        :to="{ name: 'VuetifyAllInOne' }"
        class="nav-link"
        active-class="active"
      >
        VuetifyAllInOne
      </router-link>
 <router-link
        :to="{ name: 'Banner' }"
        class="nav-link"
        active-class="active"
      >
        Banner
      </router-link>
       <router-link
        :to="{ name: 'MemberRegister' }"
        class="nav-link"
        active-class="active"
      >
        회원가입
      </router-link>
             <router-link
        :to="{ name: 'MemberLogin' }"
        class="nav-link"
        active-class="active"
      >
        로그인
      </router-link>
      
            <router-link
        :to="{ name: 'BoardListPage' }"
        class="nav-link"
        active-class="active"
      >
        BoardListPage
      </router-link>
                  <router-link
        :to="{ name: 'membertest' }"
        class="nav-link"
        active-class="active"
      >
        membertest
      </router-link>
                        <router-link
        :to="{ name: 'Taxi' }"
        class="nav-link"
        active-class="active"
      >
        Taxi
      </router-link>
      <!-- 로그인 세션 테스트 -->
                              <router-link
        :to="{ name: 'Login' }"
        class="nav-link"
        active-class="active"
      >
        로그인 세션 테스트
      </router-link>
            <router-link
        :to="{ name: 'DaumNewsCrawlerPage' }"
        class="nav-link"
        active-class="active"
      >
        다음 뉴스 크롤러
      </router-link>
          <!-- 좋아요 싫어요 -->
            <router-link
        :to="{ name: '' }"
        class="nav-link"
        active-class="active"
      >
        좋아요 싫어요 
      </router-link>
                  <router-link
        :to="{ name: 'ReviewListPage' }"
        class="nav-link"
        active-class="active"
      >
        리뷰페이지 테스트
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "Home",
  components: {},
};
</script>

<style scoped>
.home{
     margin: 100px auto 0;
}
</style>