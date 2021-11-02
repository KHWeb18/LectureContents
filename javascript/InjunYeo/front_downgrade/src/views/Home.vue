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

            <router-link :to="{ name: 'Game' }"
                    class="nav-link"
                    active-class="active">
                Game
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
                MonsterListPage
            </router-link>
            <router-link :to="{ name: 'EventBusTestPage' }"
                    class="nav-link"
                    active-class="active">
                EventBus테스트
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
                Spring 삼각형
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
            <!-- 기존 slot이 p,div 등의 HTML 태그를 전달하고
                자녀 컴포넌트에서 부모 컴포넌트를 사용했음
                scopedsloct은 템플릿을 이용하며 부모컴포넌트로 자녀 컴포넌트의 데이터를 전달할 수 있다.
                즉 기존슬롯과 방향이 반대-->
            <router-link :to="{ name: 'ScopedSlotTestPage' }"
                    class="nav-link"
                    active-class="active">
                ScopedSlot 활용
            </router-link>
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
                Materialize Grid활용
            </router-link>
            <router-link :to="{ name: 'VuetifyAllInOneTestPage' }"
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
        