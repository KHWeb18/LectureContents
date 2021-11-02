<template>
    <div class="home">
        <div id="header">
            <router-link :to="{ name: 'Home' }"
                    class="nav-link"
                    active-class="active">
                Home
            </router-link><br><br>
            <router-link :to="{ name: 'Test' }"
                    class="nav-link"
                    active-class="active">
                Test
            </router-link><br><br>
            <router-link :to="{ name: 'Todo' }"
                    class="nav-link"
                    active-class="active">
                Todo
            </router-link><br><br>
            <router-link :to="{ name: 'Homework' }"
                    class="nav-link"
                    active-class="active">
                Homework
            </router-link><br><br>
            <router-link :to="{ name: 'BoardListPage' }"
                    class="nav-link"
                    active-class="active">
                BoardListPage
            </router-link><br><br>
            <router-link :to="{ name: 'GameMemberRegisterPage' }"
                    class="nav-link"
                    active-class="active">
                GameMemberRegisterPage
            </router-link><br><br>
            <router-link :to="{ name: 'Concave' }"
                    class="nav-link"
                    active-class="active">
                Concave
            </router-link><br><br>
            <router-link :to="{ name: 'MonsterListPage' }"
                    class="nav-link"
                    active-class="active">
                몬스터 도감
            </router-link><br><br>
            <router-link :to="{ name: 'EventBusTestPage' }"
                    class="nav-link"
                    active-class="active">
                EventBusTestPage
            </router-link><br><br>
              <router-link :to="{ name: 'DungeonListPage' }"
                    class="nav-link"
                    active-class="active">
                Dungeon 테스트
            </router-link><br><br>
         
            <router-link :to="{ name: 'OnlyVuePage' }"
                    class="nav-link"
                    active-class="active">
                OnlyVuePage
            </router-link><br><br>
            <router-link :to="{ name: 'SpringInterconnectionPage' }"
                    class="nav-link"
                    active-class="active">
                SpringInterconnectionPage
            </router-link><br><br>
             <router-link :to="{ name: 'ScoreManagerPage' }"
                    class="nav-link"
                    active-class="active">
                ScoreManagerPage
            </router-link><br><br>
             <router-link :to="{ name: 'DaumNewsCrawlerPage' }"
                    class="nav-link"
                    active-class="active">
                다음 뉴스 크롤러
            </router-link><br><br>
              <router-link :to="{ name: 'UnNameSlotTestPage' }"
                    class="nav-link"
                    active-class="active">
                UnNameSlotTestPage
            </router-link><br><br>
               <router-link :to="{ name: 'NameSlotTestPage' }"
                    class="nav-link"
                    active-class="active">
                NameSlotTestPage
            </router-link><br><br>
            <!-- 기존 slot이 p, div등 html요소를 전달 (부모 -> 자녀)
            하지만 이녀석은 템플릿을 이용하여 자식 -> 부모 -->
               <router-link :to="{ name: 'ScopedSlotTestPage' }"
                    class="nav-link"
                    active-class="active">
                ScopedSlotTestPage
            </router-link><br><br>
              <router-link :to="{ name: 'RecentSlotTestPage' }"
                    class="nav-link"
                    active-class="active">
                RecentSlotTestPage
            </router-link><br><br>
            <router-link :to="{ name: 'MeterializeTestPage' }"
                    class="nav-link"
                    active-class="active">
                MeterializeTestPage
            </router-link><br><br>
            <router-link :to="{ name: 'MeterializeGridTestPage' }"
                    class="nav-link"
                    active-class="active">
                MeterializeGridTestPage
            </router-link><br><br>
            <router-link :to="{ name: 'VuetifyAllInOneTestPage' }"
                    class="nav-link"
                    active-class="active">
                VuetifyAllInOneTestPage
            </router-link><br><br>








            

            
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