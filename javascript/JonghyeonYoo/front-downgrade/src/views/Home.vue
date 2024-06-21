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
        :to="{ name: 'Test' }"
        class="nav-link"
        active-class="active"
      >
        Test
      </router-link>
      <router-link
        :to="{ name: 'Todo' }"
        class="nav-link"
        active-class="active"
      >
        Todo
      </router-link>
      <router-link
        :to="{ name: 'Homework' }"
        class="nav-link"
        active-class="active"
      >
        Homework
      </router-link>
      <router-link
        :to="{ name: 'BoardListPage' }"
        class="nav-link"
        active-class="active"
      >
        BoardListPage
      </router-link>
      <router-link
        :to="{ name: 'GameMemberRegisterPage' }"
        class="nav-link"
        active-class="active"
      >
        GameMemberRegisterPage
      </router-link>
      <router-link
        :to="{ name: 'Concave' }"
        class="nav-link"
        active-class="active"
      >
        Concave
      </router-link>
      <router-link
        :to="{ name: 'ProductListPage' }"
        class="nav-link"
        active-class="active"
      >
        ProductListPage
      </router-link>
      <router-link
        :to="{ name: 'MonsterListPage' }"
        class="nav-link"
        active-class="active"
      >
        몬스터 도감
      </router-link>
      <router-link
        :to="{ name: 'EventBusTestPage' }"
        class="nav-link"
        active-class="active"
      >
        EventBus 테스트
      </router-link>
      <router-link
        :to="{ name: 'DungeonListPage' }"
        class="nav-link"
        active-class="active"
      >
        Dungeon 테스트
      </router-link>
      <router-link
        :to="{ name: 'OnlyVuePage' }"
        class="nav-link"
        active-class="active"
      >
        Only 뷰 페이지(Quiz. 89)
      </router-link>
      <router-link
        :to="{ name: 'SpringInterconnectionPage' }"
        class="nav-link"
        active-class="active"
      >
        Spring + Vue 연동 페이지(Quiz. 89)
      </router-link>
      <router-link
        :to="{ name: 'ScoreManagerPage' }"
        class="nav-link"
        active-class="active"
      >
        성적 관리 페이지(Quiz. 88)
      </router-link>
      <router-link
        :to="{ name: 'DaumNewsCrawlerPage' }"
        class="nav-link"
        active-class="active"
      >
        다음 뉴스 크롤러
      </router-link>
      <router-link
        :to="{ name: 'UnNameSlotTestPage' }"
        class="nav-link"
        active-class="active"
      >
        UnNameSlot 활용
      </router-link>
      <router-link
        :to="{ name: 'NamedSlotTestPage' }"
        class="nav-link"
        active-class="active"
      >
        NamedSlot 활용
      </router-link>
      <!-- 기존 slot이 p, div 등의 HTML 태그를 전달하고
          자녀 컴포넌트에서 부모 컴퍼는트를 사용했음
          이 녀석은 템플릿을 이용하며 부모 컴포넌트로 
          자녀 컴포넌트의 데이터를 전달할 수 있음. -->
      <router-link
        :to="{ name: 'ScopedSlotTestPage' }"
        class="nav-link"
        active-class="active"
      >
        ScopedSlot 활용
      </router-link>
      <!-- slot이 엄청 많은데 아래의 v-slot으로 통일! -->
      <router-link
        :to="{ name: 'RecentSlotTestPage' }"
        class="nav-link"
        active-class="active"
      >
        v-slot 활용
      </router-link>
      <router-link
        :to="{ name: 'MaterializeTestPage' }"
        class="nav-link"
        active-class="active"
      >
        Materialize 활용
      </router-link>
      <router-link
        :to="{ name: 'MaterializeGridTestPage' }"
        class="nav-link"
        active-class="active"
      >
        Materialize Grid 활용
      </router-link>
      <router-link
        :to="{ name: 'VuetifyAllInOneTestPage' }"
        class="nav-link"
        active-class="active"
      >
        Vuetify 활용
      </router-link>
      <router-link
        :to="{ name: 'VuetifyMemberRegisterPage' }"
        class="nav-link"
        active-class="active"
      >
        Vuetify 회원 가입 활용
      </router-link>

      <router-link
        :to="{ name: 'CoverflowTestPage' }"
        class="nav-link"
        active-class="active"
      >
        Coverflow Test
      </router-link>

      <router-link
        :to="{ name: 'AwesomeSwiperTestPage' }"
        class="nav-link"
        active-class="active"
      >
        Awesome Swiper Test
      </router-link>
      <router-link
        :to="{ name: 'LikesFacebookPage' }"
        class="nav-link"
        active-class="active"
      >
        Likes Facebook
      </router-link>
      <router-link
        :to="{ name: 'ImageGalleryTestPage' }"
        class="nav-link"
        active-class="active"
      >
        Image Gallery
      </router-link>
      <router-link
        :to="{ name: 'CalendarTestPage' }"
        class="nav-link"
        active-class="active"
      >
        Calendar 달력
      </router-link>
      <router-link
        :to="{ name: 'MemberJoinColumnTestPage' }"
        class="nav-link"
        active-class="active"
      >
        Member Join Column
      </router-link>
      <router-link
        :to="{ name: 'VuetifyMemberLoginPage' }"
        class="nav-link"
        active-class="active"
      >
        VuetifyMemberLoginPage
      </router-link>
            <router-link
        :to="{ name: 'FileUploadPage' }"
        class="nav-link"
        active-class="active"
      >
        파일 업로드 Test
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