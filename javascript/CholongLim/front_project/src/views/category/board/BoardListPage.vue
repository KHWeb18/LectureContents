<template>
    <div id="board">
        <div>
            <v-img class="about-img-top" src="https://images.pexels.com/photos/7244366/pexels-photo-7244366.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
            </v-img>
        </div>

        
        <div class="section">
            <p class="intro-font">" We travel, some of us forever, to seek other places, other lives, other souls. "</p>
        </div>
        
    
        <v-container class="about-top">
            <p>WELCOME TO CINZEL</p>
            <h1>CINZEL BOARD</h1>
            <p>| 공지사항 |</p>
        </v-container>
        <v-divider></v-divider>

        
        <v-btn color="text-white gray" class="btn-locate" route :to="'/board/create'">글쓰기</v-btn>

        <board-list :boards="boards"/>
        
    
        <!-- <v-container class="justify-center">
        <v-row align="center" justify="center">
        <nav aria-label="Page navigation example" class="page-num">
            <ul class="pagination">
                <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
                </li>
                <li class="page-item" th:each="i : ${#numbers.sequence(startPage, endPage)}">
                    <a class="page-link" href="#" th:text="${i}">1</a></li>
                <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
                </li>
            </ul>
        </nav>
        </v-row>
        </v-container> -->

    
<!-- 
            <v-container class="justify-center">
            <v-row align="center" justify="center">
                <div style="float: left; width: 165px;">
                    <v-text-field label="검색" required height="6.5vh" style=" width: 300px;" solo 
                            type="text">
                    </v-text-field></div>

                    <div style="float: left; padding:10px;">
                        <v-btn text style="float:left;" route :to="{name:'BoardSearchPage'}">
                            <v-icon middel>search</v-icon>
                        </v-btn>
                    </div>
    
            </v-row>
            </v-container> -->

            <!-- <v-container class="justify-center">
            <v-row align="center" justify="center"> -->
                <form class="form-inline d-flex justify-content-end">
                    <div>
                        <label for="searchText" class="sr-only">검색</label>
                        <input type="text" class="form-control" id="searchText" name="searchText" v-model="searchText">
                    </div>
                    <v-btn class="btn btn-outline-primary" @click="search({searchText})">검색</v-btn>
                </form>
            <!-- </v-row>
            </v-container> -->


    </div>  
</template>

<script>
import BoardList from '@/components/board/BoardList.vue'
import { mapActions,mapState } from 'vuex'


export default {
    name: 'BoardListPage',
    components: {
        BoardList
    },
    data() {
        return {
            searchText: ''
        }
    },
    computed: {
        ...mapState(['boards'])
    },
    mounted () {
        this.fetchBoardList()
    },
    methods: {
        ...mapActions(['fetchBoardList']),
        search (payload) {
        const { searchText } = payload
        this.fetchBoardList(searchText)
      }
    }

}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');
@import url('https://fonts.googleapis.com/css2?family=MonteCarlo&display=swap');



.pagination li a {
    padding: 0 15px;
}

.page-num {
    background-color:white;
    box-shadow: 0 0px 0px 0 rgb(0 0 0 / 0%),
                0 0px 0px -0px rgb(0 0 0 / 0%), 
                0 0px 0px 0 rgb(0 0 0 / 0%); 
    width: 16%;    
}


.search-box{
    margin: 0;
    margin-top: -10%;
    position: relative;
    left:35%;
    width: 80%;
}


.btn-locate{
    position: relative;
    left: 75%;
    margin-top: 2%;
    margin-bottom: 1%;
    
}

.board-box {
    padding-bottom: 5%;
}
.container{
    position: relative;
}

.overlay{
    position: absolute;
    z-index: 9;
    margin-top: 9%;
    left: -8%;
}

.overlay2{
    position: absolute;
    z-index: 9;
    margin-top: 1%;
    left: 70%;
}

.overlay3{
    position: absolute;
    z-index: 9;
    margin-top: 43%;
    left: 7%;
}

.test3{
    margin-left: 50vw;
    position: relative;
    bottom: 25vh;
}

.intro-top {
    text-align: left;
}

.about-img-top {
    max-height: 70vh;
}
.about-img-01 {
    position: relative;
    left: 20vw;
    height: 60vh;

}
.about-img-02 {
    position: relative;
    right: 20vw;
    height: 50vh;
    margin-top: -5vh;
}
.about-img-03 {
    position: relative;
    left: 20vw;
    height: 60vh;
    margin-top: 5vh;
}

.section {
    background: #dcdfdc;
    height: 10vh;
}

p {
    font-family: 'Nanum Myeongjo';
    font-size: 18px;
    text-align: center;
    padding: 18px 0px 18px 0px;
}

.about-top {
    padding-top: 10vh;
}

h1 {
    font-family: "Cinzel";
    font-size: 40px;
    text-align: center;
    margin-top: 10px;
}

h2 {
    font-family: 'MonteCarlo';
    font-size: 150px;
    color:darkgrey
}

h3 {
    font-family: "Cinzel";
    font-size: 80px;
    margin-top: 10px;
    color:darkgrey;
}

h4 {
    margin-top: 0px;
    font-family: 'Nanum Myeongjo';
    font-size: 35px;
}
</style>