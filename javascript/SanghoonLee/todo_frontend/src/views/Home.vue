<template>
    <div class="home">
        <div id="header">
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
            <router-link :to="{ name: 'ProductListPage' }"
                    class="nav-link"
                    active-class="active">
                ProductListPage
            </router-link>
            <router-link :to="{ name: 'MonsterListPage' }"
                    class="nav-link"
                    active-class="active">
                몬스터 도감
            </router-link>
            <router-link :to="{ name: 'EventBusTestPage' }"
                    class="nav-link"
                    active-class="active">
                EventBus 테스트
            </router-link>
            <router-link :to="{ name: 'DungeonListPage' }"
                    class="nav-link"
                    active-class="active">
                Dungeon 테스트
            </router-link>
            <router-link :to="{ name: 'OnlyVuePage' }"
                    class="nav-link"
                    active-class="active">
                Only 뷰 페이지
            </router-link>
            <router-link :to="{ name: 'SpringInterconnectionPage' }"
                    class="nav-link"
                    active-class="active">
                Spring 연동 삼각형 넓이 구하기
            </router-link>
            <router-link :to="{ name: 'ScoreManagerPage' }"
                    class="nav-link"
                    active-class="active">
                성적 관리 페이지
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
                 자녀 컴포넌틍에서 부모 컴포넌트를 사용했음
                 이 녀석은 템플릿을 이용하며 부모 컴포넌트로 자녀 컴포넌트의 데이터를 전달할 수 있음 -->
            <router-link :to="{ name: 'ScopedSlotTestPage' }"
                    class="nav-link"
                    active-class="active">
                ScopedSlot 활용
            </router-link>
            <!-- 뭔놈의 slot이 이래 많냐 ? 하나로 통일하자 v-slot -->
            <router-link :to="{ name: 'RecentSlotTestPage' }"
                    class="nav-link"
                    active-class="active">
                v-slot 활용
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
            <router-link :to="{ name: 'VuetifyMemberRegisterPage' }"
                    class="nav-link"
                    active-class="active">
                Vuetify 회원 가입 활용
            </router-link>
            <router-link :to="{ name: 'CoverflowTestPage' }"
                    class="nav-link"
                    active-class="active">
                Coverflow Test
            </router-link>
            <router-link :to="{ name: 'AwesomeSwiperTestPage' }"
                    class="nav-link"
                    active-class="active">
                Awesome Swiper Test
            </router-link>
            <router-link :to="{ name: 'ImageGalleryTestPage' }"
                    class="nav-link"
                    active-class="active">
                Image Gallery Test
            </router-link>
            <router-link :to="{ name: 'CalendarTestPage' }"
                    class="nav-link"
                    active-class="active">
                Calendar Test
            </router-link>
            <router-link :to="{ name: 'MemberJoinColumnTestPage' }"
                    class="nav-link"
                    active-class="active">
                Member Join Column Test
            </router-link>
            <router-link :to="{ name: 'VuetifyMemberLoginPage' }"
                    class="nav-link"
                    active-class="active">
                Member 로그인 Test
            </router-link><br/>
            <router-link :to="{ name: 'FileUploadPage' }"
                    class="nav-link"
                    active-class="active">
                파일 업로드 Test
            </router-link><br/>
            <router-link :to="{ name: 'AccountRegisterPage' }"
                    class="nav-link"
                    active-class="active">
                Account 회원 가입
            </router-link>
            <router-link :to="{ name: 'SessionLoginPage' }"
                    class="nav-link"
                    active-class="active">
                Account 로그인 Test
            </router-link>
            <router-link :to="{ name: 'ImgTestPage' }"
                    class="nav-link"
                    active-class="active">
                Image Test
            </router-link><br/>

            <!-- Python Test -->
            <router-link :to="{ name: 'PythonLoginTestPage' }"
                    class="nav-link"
                    active-class="active">
                Python Login Test
            </router-link><br/>

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
                Python Crawl Test
            </router-link>
        </div>
    </div>
</template>

<script>

export default {
    name: 'Home'
}

</script>