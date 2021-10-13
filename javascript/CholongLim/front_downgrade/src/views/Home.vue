<template>
    <div class="home">
        <div id="header">
            <router-link :to="{ name: 'Login' }"
                    class="nav-link"
                    active-class="active">
                login
            </router-link>
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
            <router-link :to="{ name: 'Todo' }"
                    class="nav-link"
                    active-class="active">
                Todo
            </router-link>
            <router-link :to="{ name: 'Homework' }"
                    class="nav-link"
                    active-class="active">
                Homework
            </router-link>
            <router-link :to="{ name: 'BoardListPage' }"
                    class="nav-link"
                    active-class="active">
                BoardListPage
            </router-link>
            <router-link :to="{ name: 'ProductListPage' }"
                    class="nav-link"
                    active-class="active">
                ProductListPage
            </router-link>
            <router-link :to="{ name: 'GameMemberRegisterPage' }"
                    class="nav-link"
                    active-class="active">
                GameMemberRegisterPage
            </router-link>
            <router-link :to="{ name: 'Concave' }"
                    class="nav-link"
                    active-class="active">
                Concave
            </router-link>
            <router-link :to="{ name: 'MonsterListPage' }"
                    class="nav-link"
                    active-class="active">
                MonsterListPage
            </router-link>
            <router-link :to="{ name: 'EventBusTestPage' }"
                    class="nav-link"
                    active-class="active">
                EventBusTestPage
            </router-link>
            <router-link :to="{ name: 'DungeonListPage' }"
                    class="nav-link"
                    active-class="active">
                DungeonListPage
            </router-link>
            <router-link :to="{ name: 'ScoreManagerPage' }"
                    class="nav-link"
                    active-class="active">
                학생 성적 관리
            </router-link>
            <router-link :to="{ name: 'TrianglePage' }"
                    class="nav-link"
                    active-class="active">
                삼각형 넓이 계산
            </router-link>
            <router-link :to="{ name: 'OnlyVuePage' }"
                    class="nav-link"
                    active-class="active">
                Only 뷰 페이지
            </router-link>
            <router-link :to="{ name: 'SpringInterconnectionPage' }"
                    class="nav-link"
                    active-class="active">
                Sping 연동 삼각형 넓이 구하기
            </router-link>
            <router-link :to="{ name: 'DaumNewsCrawlerPage' }"
                    class="nav-link"
                    active-class="active">
                다음 뉴스 크롤러
            </router-link>
            <router-link :to="{ name: 'UnNamedSlotTestPage' }"
                    class="nav-link"
                    active-class="active">
                UnNamedSlot 활용
            </router-link>
            <router-link :to="{ name: 'NamedSlotTestPage' }"
                    class="nav-link"
                    active-class="active">
                NamedSlot 활용
            </router-link>
            <!-- 기존 slot이 p, div 등의 HTML 태그를 전달하고
                  자녀 컴포넌트에서 부모 컴포넌트를 사용했음
                  이 녀석은 탬플릿을 이용하며 부모 컴포넌트로 
                  자녀 컴포넌트의 데이터를 전달할 수 있음
                  기존 : 부모 >> 자식
                  Scoped : 부모 << 자식 -->
            <router-link :to="{ name: 'ScopedSlotTestPage' }"
                    class="nav-link"
                    active-class="active">
                ScopedSlot 활용
            </router-link>
            <!-- 슬롯을 하나로 통일하자 v-slot -->
            <router-link :to="{ name: 'RecentSlotTestPage' }"
                    class="nav-link"
                    active-class="active">
                V-Slot 활용
            </router-link>
            <router-link :to="{ name: 'MaterializeTestPage' }"
                    class="nav-link"
                    active-class="active">
                Materialize 활용
            </router-link>
            <router-link :to="{ name: 'MaterializeGridTestPage' }"
                    class="nav-link"
                    active-class="active">
                Materialize Grid 활용
            </router-link>
            <router-link :to="{ name: 'VuetifyAllInOneTestPage' }"
                    class="nav-link"
                    active-class="active">
                Vuetify 활용
            </router-link>
            <router-link :to="{ name: 'VuetifySignUpTestPage' }"
                    class="nav-link"
                    active-class="active">
                Vuetify 회원가입
            </router-link>
            <router-link :to="{ name: 'VuetifyMemberRegisterPage' }"
                    class="nav-link"
                    active-class="active">
                수업 회원가입
            </router-link>
            <router-link :to="{ name: 'CoverFlowTestPage' }"
                    class="nav-link"
                    active-class="active">
                coverflow
            </router-link>
            <router-link :to="{ name: 'AwesomeSwiperTestPage' }"
                    class="nav-link"
                    active-class="active">
                awesomeSwiper
            </router-link>
            <router-link :to="{ name: 'ImageGalleryPage' }"
                    class="nav-link"
                    active-class="active">
                ImageGallery
            </router-link>
            <router-link :to="{ name: 'CalendarTestPage' }"
                    class="nav-link"
                    active-class="active">
                calendar
            </router-link>
            <router-link :to="{ name: 'MemberJoinColumnTestPage' }"
                    class="nav-link"
                    active-class="active">
                Member Join Column
            </router-link>
            <router-link :to="{ name: 'VuetifyMemberLoginPage' }"
                    class="nav-link"
                    active-class="active">
                로그인
            </router-link>
            <router-link :to="{ name: 'FileUploadPage' }"
                    class="nav-link"
                    active-class="active">
                파일업로드 test
            </router-link><br/>



            <!-- Python Test -->
            <router-link :to="{ name: 'PythonLoginTestPage' }"
                    class="nav-link"
                    active-class="active">
                Python Login test
            </router-link>

            <!-- Kakao Login Test -->
            <router-link :to="{ name: 'KakaoLoginPage' }"
                    class="nav-link"
                    active-class="active">
                Kakao Login 
            </router-link><br/>

            <!-- Order Test -->
            <router-link :to="{ name: 'OrderTestPage' }"
                    class="nav-link"
                    active-class="active">
                Order Test 
            </router-link><br/>

            <!-- Python Crawl Test -->
            <router-link :to="{ name: 'PythonCrawlTestPage' }"
                    class="nav-link"
                    active-class="active">
                PythonCrawlTestPage
            </router-link><br/>
        </div>
    </div>
</template>

<script>

  export default {
    name: 'Home'
  }

</script>