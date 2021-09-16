<template>
  <form @submit.prevent="onSubmit">
    <v-container>
      <div class="content-area">
        <div class="img">
          <img src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/movie_still_images/79900/thumbnail/575432f5a0cfa03ece5041d90f07c2ce.png" />
          <div class="gradient"></div>
        </div>

        <hr class="new-divider" color="#212529" style="display: block" />
        <div class="my-rating-area">
          <div class="index-rating-wrap">
            <button
              class="dark-gray-btn index-rating red-light"
              @click="likecnt++"
              style="width: calc(50% - 10px); margin-right: 20px"
            >
              <span class="text">좋아요 : {{ likecnt }}</span>
            </button>
            <button
              class="dark-gray-btn index-rating green-light"
              @click="dislikecnt++"
              style="width: calc(50% - 10px)"
            >
              <span class="text">별로에요 : {{ dislikecnt }}</span>
            </button>
          </div>
        </div>
        <hr class="new-divider" color="#212529" style="display: block" />

          <h3 class="title">지금 여기서 감상</h3>
          <p style="color: #fff">스트리밍</p>
          <div class="box">
            <a
              href="https://www.wavve.com/player/vod?programid=F3501_F35000000028&page=1&utm_source=kinolights&utm_campaign=kinolights&utm_medium=organic&utm_content=title_provider"
              target="blank"
              rel="noopener noreferrer"
              class="movie-price-link"
            >
              <i class="icon wavve-icon"></i>
              <span class="streaming-name">웨이브</span>
              <span class="streaming-price">정액제</span>
            </a>
          </div>

          <div class="box">
            <a
              href="https://watcha.com/contents/share/tPrAVxR?utm_source=kinolights&utm_campaign=kinolights&utm_medium=organic&utm_content=title_provider"
              target="blank"
              rel="noopener noreferrer"
              class="movie-price-link"
            >
              <i class="icon watcha-icon"></i>
              <span class="streaming-name">왓챠</span>
              <span class="streaming-price">정액제</span>
            </a>
          </div>
          <p style="color: #fff">대여</p>
          <div class="box">
            <a
              href="https://serieson.naver.com/broadcasting/detail.nhn?viewSeq=362742&isWebtoonAgreePopUp=true"
              target="blank"
              rel="noopener noreferrer"
              class="movie-price-link"
            >
              <i class="icon naver-icon"></i>
              <span class="streaming-name">네이버 시리즈온</span>
              <span class="streaming-price">800원</span>
            </a>
          </div>
          <p style="color: #fff">구매</p>
          <div class="box">
            <a
              href="https://serieson.naver.com/broadcasting/detail.nhn?viewSeq=362742&isWebtoonAgreePopUp=true"
              target="blank"
              rel="noopener noreferrer"
              class="movie-price-link"
            >
              <i class="icon naver-icon"></i>
              <span class="streaming-name">네이버 시리즈온</span>
              <span class="streaming-price">1,100원</span>
            </a>
          </div>
        </div>
        <hr class="new-divider" color="#212529" style="display: block" />
        <div class="information">
          <h3 class="title">작품 정보</h3>
          <p class="synopsis" style="color: #f8f9fa;">
제2차 세계대전, 프랑스 노르망디에 상륙한 연합군 제101사단 506연대 2대대 '이지' 중대 대원들은 수많은 전투와 상실을 겪으며 전우가 되어간다.
          </p>
        </div>
        <hr class="new-divider" color="#212529" style="display: block" />
        <div class="preview">
          <h3 class="title">예고편</h3>
          <iframe
            width="100%"
            height="450"
            src="https://www.youtube.com/embed/aH06LWZs-Ys"
            title="YouTube video player"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowfullscreen
          ></iframe>
       
        </div>
        <hr class="new-divider" color="#212529" style="display: block" />
        <div class="actor">
          <h3 class="title">감독/출연</h3>
          <div class="container-person">
            <!-- 감독/ 토니 토 -->
            <div class="person">
              <div class="photo">
                <img
                  alt="토니 토"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/director_profile_images/director_78942_1584605933.png"
                />
              </div>
              <div class="name">토니 토</div>
              <div class="character">감독</div>
            </div>
             <!-- 감독/ 리차드 론크레인 -->
            <div class="person">
              <div class="photo">
                <img
                  alt="리차드 론크레인"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/director_profile_images/director_62471_1522040180.jpg"
                />
              </div>
              <div class="name">리차드 론크레인</div>
              <div class="character">감독</div>
            </div>
             <!-- 감독/ 미카엘 살로먼 -->
            <div class="person">
              <div class="photo">
                <img
                  alt="미카엘 살로먼"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/director_profile_images/director_60872_1547017289.jpg"
                />
              </div>
              <div class="name">미카엘 살로먼</div>
              <div class="character">감독</div>
            </div>           
            <!--데미안 루이스 -->
            <div class="person">
              <div class="photo">
                <img
                  alt="데미안 루이스"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_8318_1522139787.jpg"
                />
              </div>
              <div class="name">데미안 루이스</div>
              <div class="character">리차드 D.윈터스 소령</div>
            </div>
            <!--론 리빙스턴-->
            <div class="person">
              <div class="photo">
                <img
                  alt="론 리빙스턴"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_8245_1522072204.jpg"
                />
              </div>
              <div class="name">론 리빙스턴</div>
              <div class="character">루이스 닉슨 대위</div>
            </div>
            <!--매튜 세틀-->
            <div class="person">
              <div class="photo">
                <img
                  alt="매튜 세틀"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_7679_1521179528.jpg"
                />
              </div>
              <div class="name">매튜 세틀</div>
              <div class="character">로널드 스피어스 대위</div>
            </div>
            <!--커크 에이스베도 -->
            <div class="person">
              <div class="photo">
                <img
                  alt="커크 에이스베도"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_14239_1534491445.jpg"
                />
              </div>
              <div class="name">커크 에이스베도</div>
              <div class="character">조셉 토이 하사</div>
            </div>
            <!--에이온 바일리-->
            <div class="person">
              <div class="photo">
                <img
                  alt="에이온 바일리"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_9441_1584605772.jpg"
                />
              </div>
              <div class="name">에이온 바일리</div>
              <div class="character">데이빗 캐년 웹스터 일병</div>
            </div>            
        </div>
        <hr class="new-divider" color="#212529" style="display: block" />

        <!----------- 리뷰 작성 ----------------->
        <div class="review">
          <h3 class="title">리뷰</h3>
          <div class="review writer" style="text-align: center">
            <i class="review-icon"></i>
            <span
              class="text"
              style="
                display: block;
                text-align: center;
                font-size: 20px;
                color: #fff;
                line-height: 20px;
                font-weight: 500;
              "
              >작품에 대한 감상을 기록해보세요.</span
            >
          </div>
        </div>
        <br />
    <review-register-form @submit="onSubmit" />


        <br />
    <div id="review">  
        <review-list :reviews="reviews"/> 
    </div>
        <hr class="new-divider" color="#212529" style="display: block" />
      </div>
    </v-container>
  </form>
</template>


<script>
import ReviewList from '@/components/review/ReviewList.vue'
import { mapState, mapActions } from 'vuex'

import ReviewRegisterForm from '@/components/review/ReviewRegisterForm.vue'
import axios from "axios";

export default {
 
    components: {
        ReviewList,
 ReviewRegisterForm,
    },
    computed: {
        ...mapState(['reviews'])
    },
    mounted () {
        this.fetchReviewList()
    },
  data() {
    return {
      likecnt: 0,
      dislikecnt: 0,
      search: "",
      dialog: false,
      loading: false,
      headerTitle: [
        { text: "번호", value: "reviewNo", width: "30px" },
        { text: "작성자", value: "writer", width: "80px" },
        { text: "내용", value: "content", width: "400px" },
      ],
    };
  },
  methods: {
      onSubmit(payload) {
        const {content, writer} = payload
        axios.post('http://localhost:1111/review/register', { writer, content})
        .then(res => {
            alert('등록 성공~!' + res)
           console.log('게시물 번호: ', + res.data.reviewNo.toString())
           this.$router.push({
                name: 'ReviewListPage',
                // params: { reviewNo: res.data.boardNo.toString()}
            })
           
        })
        .catch(res => {
            alert(res.reponse.data.message)
        })
    },
            ...mapActions(['fetchReviewList']),

    goToRead(item) {
      this.$router.push(`/Review/${item.reviewNo}`);
    },
  },
  props: {
    reviews: {
      type: Array,
    },
  },
};
</script>

<style scoped>
.review-icon {
  width: 110px;
  height: 110px;
  background-image: url(https://m.kinolights.com/_nuxt/img/img_empty_review.bedc601.svg);
  display: inline-block;
  line-height: 16px;
  background-repeat: no-repeat;
  background-position: 50%;
  background-size: 90% 90%;
}
.new-divider {
  margin: 12px;
}
.title {
  margin-top: 10px;
  color: #f8f9fa;
}
.content-area .information .synopsis {
  margin-top: 10px;
  font-size: 15px;
  font-weight: 400;
  line-height: 30px;
  color: #f8f9fa;
  margin-bottom: 16px;
  word-break: keep-all;
}
.content-area .img img {
  width: 100%;
  height: 100%;
}
.movie-header-area .movie-title {
  vertical-align: middle;
  width: calc(100% - 107px);
}
.movie-header-area .movie-title .title-kr {
  font-size: 20px;
  margin-top: 6px;
  font-weight: 700;
  line-height: 28px;
  color: #fff;
  letter-spacing: -0.4px;
}
.movie-header-area .movie-title .title-en {
  font-size: 12px;
  font-weight: 400;
  color: #adb5bd;
  line-height: 20px;
  letter-spacing: -0.1px;
}
.movie-header-area .movie-title .metadata {
  font-size: 14px;
  color: #adb5bd;
  letter-spacing: -0.1px;
  line-height: 20px;
  font-weight: 400;
}
.movie-header-area .poster {
  width: 99px;
  height: 143px;
  z-index: 3;
  right: 16px;
  display: flex;
  align-items: center;
}
.movie-header-area .poster img {
  width: 100%;
  height: 143px;
  -o-object-fit: cover;
  object-fit: cover;
  border-radius: 6px;
  box-shadow: inset 0 0 0 1px #212529, 0 0 16px 0 rgb(0 0 0 / 58%);
}
img {
  border-style: none;
}
.streaming {
  padding: 16px;
  width: 100%;
  position: relative;
}
.movie-link {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  display: block;
  height: 56px;
  color: #fff;
  position: relative;
}
.box {
  font-size: 15px;
  color: #fff;
  height: 46px;
  position: relative;
  border-radius: 8px;
  margin-bottom: 8px;
  background: #212529;
}
a {
  -webkit-tap-highlight-color: transparent;
}
.icon {
  line-height: 1;
  -webkit-font-smoothing: antialiased;
  display: inline-block;
  width: 20px;
  height: 20px;
  line-height: 20px;
  background-repeat: no-repeat;
  background-position: 50%;
  background-size: 100% 100%;
  -o-object-fit: contain;
  object-fit: contain;
  vertical-align: middle;
}

.wavve-icon {
  background: url(https://nujhrcqkiwag1408085.cdn.ntruss.com/static/common/btn/btn_wavve_circle.png)
    50% no-repeat;
  background-size: 100% 100%;
}
.naver-icon {
  background: url(https://nujhrcqkiwag1408085.cdn.ntruss.com/static/common/btn/btn_naver_circle.png)
    50% no-repeat;
  background-size: 100% 100%;
}
.CGV-icon {
  background: url(https://m.kinolights.com/_nuxt/img/btn_cgv.88f80a8.png) 50%
    no-repeat;
  background-size: 100% 100%;
}
.tving-icon {
  background: url(https://nujhrcqkiwag1408085.cdn.ntruss.com/static/common/btn/btn_tving_circle.png)
    50% no-repeat;
  background-size: 100% 100%;
}
.google-play-movie-icon {
  background: url(https://nujhrcqkiwag1408085.cdn.ntruss.com/static/common/btn/btn_googleplay_circle.png)
    50% no-repeat;
  background-size: 100% 100%;
}
.watcha-icon {
  background: url(https://nujhrcqkiwag1408085.cdn.ntruss.com/static/common/btn/btn_watchaplay_circle.png?v=20210908)
    50% no-repeat;
  background-size: 100% 100%;
}
.streaming-name {
  color: #fff;
  position: relative;
  margin-left: 10px;
  vertical-align: middle;
  width: 50%;
  font-size: 15px;
}
.streaming-price {
  position: relative;
  opacity: 1;
  vertical-align: middle;
  float: right;
  opacity: 1 !important;
  font-size: 15px;
  color: #4263eb;
  padding-right: 24px;
}
.movie-price-link {
  display: block;
  white-space: nowrap;
  padding: 12px 8px;
}
.information {
  padding: 16px;
  width: 100%;
  position: relative;
}
.preview {
  padding: 16px;
  width: 100%;
  position: relative;
}
/* 감독/출연 */
.actor {
  padding: 16px;
  width: 100%;
  position: relative;
}
.container-person {
  display: flex;
  flex-wrap: wrap;
  padding-bottom: 16px;
}
.person {
  width: 14%;
}
.person {
  color: #fff;
  display: inline-block;
  margin-top: 10px;
  display: flex;
  flex-flow: column wrap;
  justify-content: space-around;
  align-items: center;
  vertical-align: top;
}
.person .photo {
  position: relative;
  width: 70px;
  height: 70px;
  margin: 0 auto;
}
.person .photo .default-circle {
  width: 100%;
  height: 100%;
  border-radius: 50%;
  background: #343a40;
  border: 1px solid #212529;
  text-align: center;
  position: relative;
}
.person .photo .default-circle .text {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  font-weight: 700;
  font-size: 24px;
  line-height: 34px;
  letter-spacing: -0.5px;
  color: #868e96;
}
.person .character {
  margin-top: 3px;
  width: 100%;
  text-align: center;
  font-size: 12px;
  font-weight: 400;
  color: #868e96;
}

.person .photo img {
  width: 100%;
  height: 100%;
  border-radius: 50%;
  -o-object-fit: cover;
  object-fit: cover;
  border: 1px solid #212529;
}

/* 좋아요/싫어요 rating */
.my-rating-area {
  width: 100%;
  position: relative;
  padding: 0 16px;
}

.my-rating-area .index-rating {
  padding: 11px 0;
  text-align: center;
}
.dark-gray-btn,
.transparent-btn {
  padding: 14px 0;
  width: 100%;
  height: 48px;
  letter-spacing: -0.2px;
  border-radius: 6px;
  cursor: pointer;
}
.dark-gray-btn {
  background-color: #212529;
}

button {
  background: none;
  border: none;
  outline: 0;
}
.my-rating-area .text {
  font-size: 15px;
  line-height: 21px;
  letter-spacing: -0.1px;
  color: #868e96;
  vertical-align: middle;
}
.my-rating-area span {
  display: inline-block;
}
.indicator-bar {
  position: relative;
  margin-top: 10px;
}
.indicator-bar .bar {
  width: 100%;
  height: 24px;
}
.indicator-bar .bar .indicator-bar {
  display: inline-block;
  height: 24px;
  position: relative;
}
.indicator-bar .bar .indicator-bar:first-child {
  border-radius: 6px 0 0 6px;
  background-color: #f03e3e;
}

.indicator-bar .bar .indicator-bar:last-child {
  border-radius: 0 6px 6px 0;
  background-color: #0ca678;
}
.review {
  padding: 16px;
  width: 100%;
  position: relative;
}
</style>

