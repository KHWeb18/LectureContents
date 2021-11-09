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
            <router-link :to="{ name: 'GameMemberRegister' }"
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
            <br>
            <br>
            <router-link :to="{ name: 'MonsterListPage' }"
                    class="nav-link"
                    active-class="active">
                MonsterListPage
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
            <br><br>
             <router-link :to="{ name: 'Quiz89' }"
                    class="nav-link"
                    active-class="active">
                Quiz89
            </router-link>
             <router-link :to="{ name: 'OnlyVuePage' }"
                    class="nav-link"
                    active-class="active">
                    삼각형 넓이 구하기!
            </router-link>
             <router-link :to="{ name: 'SpringinterconnectionPage' }"
                    class="nav-link"
                    active-class="active">
                Spring 연동 삼각형 넓이 구하기!
            </router-link>
            <router-link :to="{ name: 'ScoreManagerPage' }"
                    class="nav-link"
                    active-class="active">
                성적 관리 페이지
            </router-link>
            <router-link :to="{ name: 'DaumNewsCrawlerPage' }"
                    class="nav-link"
                    active-class="active">
                다음 뉴스 클로러
            </router-link>
            <router-link :to="{ name: 'UnNameSlotTestPage' }"
                    class="nav-link"
                    active-class="active">
                UnNameSlot 활용
            </router-link>
            <router-link :to="{ name: 'NamedSlotTestPage' }"
                    class="nav-link"
                    active-class="active">
                NamedSlot 활용
            </router-link>
            <!-- 기존과 방향이 반대임 -->
            <!-- 부모가 자식 걸 가져온다는 뜻 -->
            <router-link :to="{ name: 'ScopedSlotTestPage' }"
                    class="nav-link"
                    active-class="active">
                ScopedSlot 활용
            </router-link>
            <router-link :to="{ name: 'RecentSlotTestPage' }"
                    class="nav-link"
                    active-class="active">
                vSlot 활용
            </router-link>
            <br>
            <br>
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
            <router-link :to="{ name: 'VuetifyAllOneTestPage' }"
                    class="nav-link"
                    active-class="active">
                Vuetify 활용
            </router-link>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Home'
}

</script>