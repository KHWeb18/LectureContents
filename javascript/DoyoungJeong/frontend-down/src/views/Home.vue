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
            <router-link :to="{ name: 'Prob82' }"
                    class="nav-link"
                    active-class="active">
                Prob82
            </router-link>
            <router-link :to="{ name: 'BoardListPage' }"
                    class="nav-link"
                    active-class="active">
                BoardListPage
            </router-link>
            <router-link :to="{ name: 'MemberListPage' }"
                    class="nav-link"
                    active-class="active">
                MemberListPage
            </router-link>
            <router-link :to="{ name: 'Concave' }"
                    class="nav-link"
                    active-class="active">
                Concave
            </router-link>
            <router-link :to="{ name: 'MonsterStoragePage' }"
                    class="nav-link"
                    active-class="active">
                MonsterStoragePage     
            </router-link>
            <router-link :to="{ name: 'EventBusTestPage' }"
                    class="nav-link"
                    active-class="active">
                EventBusTestPage   
            </router-link>
            <router-link :to="{ name: 'DungeonPage' }"
                    class="nav-link"
                    active-class="active">
                DungeonPage   
            </router-link>
            <router-link :to="{ name: 'StudentScoresPage' }"
                    class="nav-link"
                    active-class="active">
                StudentScoresPage   
            </router-link>
            <router-link :to="{ name: 'TriangleAreaCalc' }"
                    class="nav-link"
                    active-class="active">
                TriangleAreaCalc   
            </router-link>
            <router-link :to="{ name: 'DaumNewsCrawlerPage' }"
                    class="nav-link"
                    active-class="active">
                다음 뉴스 크롤러
            </router-link>
            <router-link :to="{ name: 'UnNamedSlotTestPage' }"
                    class="nav-link"
                    active-class="active">
                UnNamedSlotTestPage
            </router-link>
            <router-link :to="{ name: 'NamedSlotTestPage' }"
                    class="nav-link"
                    active-class="active">
                NamedSlotTestPage
            </router-link>
            <router-link :to="{ name: 'ScopedSlotTestPage' }"
                    class="nav-link"
                    active-class="active">
                ScopedSlotTestPage
            </router-link>
            <router-link :to="{ name: 'RecentSlotTestPage' }"
                    class="nav-link"
                    active-class="active">
                RecentSlotTestPage
            </router-link>
            <router-link :to="{ name: 'MaterializeTestPage' }"
                    class="nav-link"
                    active-class="active">
                MaterializeTestPage
            </router-link>
        </div>
        <div>
            <!-- <button v-on:click="addManyMonster">몬스터 100마리 리젠</button>-->
            <global-component v-bind:monsters="monsterArray">
            </global-component>
            <!-- 위 글로벌 컴퍼넌트가 먼저 나와줘야했다. 위에 글로벌 컴퍼넌트에서 알아서 컴퍼넌트 파일에 있는
            버튼을 생성해주니까 버튼을 지정할 필요가 없다. 그래서 위에 주석 처리를 해둠.-->
            <ul>
                <li v-for="(monster, index) in monsterArray" v-bind:key="index">
                    ID.{{ monster.id }} {{ monster.name }}
                </li>
            </ul>
        </div>
        <div>
            <local-component v-bind:aMonster="aMonster"></local-component>
            <!-- 요 부분 콘솔 에러 -->
            <button v-on:click="addOneMonster">몬스터 한마리 리젠</button>
            <ul>
                <li v-for="(aMonster, index) in monsterSingle" v-bind:key="index">
                    ID.{{ aMonster.id }} {{ aMonster.name }}
                </li>
            </ul>
        </div>
    </div>
</template>

<script>
import LocalComponent from '../components/LocalComponent.vue'

  export default {
    // components: {
    //      'local-component': LocalComponent
    // },
    name: 'Home',
    components: {
        LocalComponent
    },
    monsterNames: [
        { id: 1, name: "skeleton"},
        { id: 2, name: "zombie"},
        { id: 3, name: "Ghoul"},
        { id: 4, name: "troll"},
        { id: 5, name: "demon"}
    ],
    data() {
        return {
            monsterArray: [],
            //위 monsterArray는 글로벌 컴퍼넌트에있는 변수배열과 이름이 같아야한다.
            //여기서 미리 이러한 변수배열이 있다는 선언을 해두고 글로벌컴퍼넌트에서 전송되는 monsterArray를 받을 준비를 하는것이다. 그리고 props를 통해 그대로 받을 수 있다.
            monsterSingle: []
        }
    },
    methods: {
        addOneMonster() {
            var max = this.monsterSingle.reduce(function(a, b) {
                return a > b.id ? a : b.id 
            }, 0)

            //var ranNum = Math.floor(Math.random()*5)

            this.monsterSingle.push({               
                id: max + 1,
                // name: this.monsterNames[ranNum].name
                name: 'singleMonster'
            })
        }

    }
  }
</script>
       