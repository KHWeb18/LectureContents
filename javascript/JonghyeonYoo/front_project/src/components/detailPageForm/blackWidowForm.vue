<template>
  <form @submit.prevent="onSubmit">
    <v-container>
      <div class="content-area">
        <div class="img">
          <img src="@/assets/img/블랙위도우배너.jpg" />
          <div class="gradient"></div>
        </div>
        <div class="movie-header-area">
          <div class="movie-title">
            <h3 class="title-kr">블랙 위도우</h3>
            <h4 class="title-en">Black-Widow</h4>
            <p class="metadata">
              <span class="matadata-item">액션 / 2020</span>
            </p>
          </div>
          <div class="poster">
            <img
              src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/movie_poster_images/280x400/movie_76398_1625102495.jpg"
              lazy="loaded"
            />
          </div>
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
        <h3 class="title">영화관 상영중</h3>
        <div class="image" style="text-align: center">
          <img
            src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/common/cinema_ticket.png"
          />
        </div>
        <div class="streaming">
          <div class="box">
            <a
              href="http://www.cgv.co.kr/movies/detail-view/?midx=82986"
              target="blank"
              rel="noopener noreferrer"
              class="movie-price-link"
            >
              <i class="icon CGV-icon"></i>
              <span class="streaming-name">CGV</span>
              <span class="streaming-price">예매하기</span>
            </a>
          </div>

          <h3 class="title">지금 여기서 감상</h3>
          <p style="color: #fff">구매</p>
          <div class="box">
            <a
              href="https://www.wavve.com/player/movie?movieid=MV_CA01_DY0000011555"
              target="blank"
              rel="noopener noreferrer"
              class="movie-price-link"
            >
              <i class="icon wavve-icon"></i>
              <span class="streaming-name">웨이브</span>
              <span class="streaming-price">20,790원</span>
            </a>
          </div>

          <div class="box">
            <a
              href="https://serieson.naver.com/movie/detail.nhn?viewSeq=454587&prodNo=6485086&isWebtoonAgreePopUp=true"
              target="blank"
              rel="noopener noreferrer"
              class="movie-price-link"
            >
              <i class="icon naver-icon"></i>
              <span class="streaming-name">네이버 시리즈</span>
              <span class="streaming-price">20,790원</span>
            </a>
          </div>

          <div class="box">
            <a
              href="https://www.tving.com/movie/player/M000362639?utm_source=kinolights&utm_campaign=kinolights&utm_medium=organic&utm_content=title_provider"
              target="blank"
              rel="noopener noreferrer"
              class="movie-price-link"
            >
              <i class="icon tving-icon"></i>
              <span class="streaming-name">티빙</span>
              <span class="streaming-price">20,790원</span>
            </a>
          </div>

          <div class="box">
            <a
              href="https://play.google.com/store/movies/details/Black_Widow?id=1FkZsgeYL-c.P&utm_source=kinolights&utm_campaign=kinolights&utm_medium=organic&utm_content=title_provider"
              target="blank"
              rel="noopener noreferrer"
              class="movie-price-link"
            >
              <i class="icon google-play-movie-icon"></i>
              <span class="streaming-name">Google Play 무비</span>
              <span class="streaming-price">20,900원</span>
            </a>
          </div>
        </div>
        <hr class="new-divider" color="#212529" style="display: block" />
        <div class="information">
          <h3 class="title">작품 정보</h3>
          <p class="synopsis">
            어벤져스의 히어로 블랙 위도우, ‘나타샤 로마노프’ (스칼렛 요한슨)는
            자신의 과거와 연결된 레드룸의 거대한 음모와 실체를 깨닫게 된다.
            상대의 능력을 복제하는 빌런 ‘태스크마스터’와 새로운 위도우들의
            위협에 맞서 목숨을 건 반격을 시작하는 ‘나타샤’는 스파이로 활약했던
            자신의 과거 뿐 아니라, 어벤져스가 되기 전 함께했던 동료들을
            마주해야만 하는데… 폭발하는 리얼 액션 카타르시스! MCU의 새로운
            시대를 시작할 첫 액션 블록버스터를 만끽하라!
          </p>
        </div>
        <hr class="new-divider" color="#212529" style="display: block" />
        <div class="preview">
          <h3 class="title">예고편</h3>
          <iframe
            width="100%"
            height="450"
            src="https://www.youtube.com/embed/rmR7xefwjWs"
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
            <!-- 감독 -->
            <div class="person">
              <div class="photo">
                <img
                  alt="케이트 쇼트랜드"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/director_profile_images/director_53345_1562142638.jpg"
                />
              </div>
              <div class="name">케이트 쇼트랜드</div>
              <div class="character">감독</div>
            </div>

            <!--스칼릿 요한슨 -->
            <div class="person">
              <div class="photo">
                <img
                  alt="스칼릿 요한슨"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_390_1557934425.png"
                />
              </div>
              <div class="name">스칼릿 요한슨</div>
              <div class="character">나타샤 로마노프<br />/블랙 위도우</div>
            </div>
            <!--데이빗 하버-->
            <div class="person">
              <div class="photo">
                <img
                  alt="데이빗 하버"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_11231_1532313324.jpg"
                />
              </div>
              <div class="name">데이빗 하버</div>
              <div class="character">알렉세이 쇼스타코프<br />/레드 가디언</div>
            </div>
            <!--플로렌스 퓨 -->
            <div class="person">
              <div class="photo">
                <img
                  alt="플로렌스 퓨"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/person_profile_images/person_7940_1626026204.jpg"
                />
              </div>
              <div class="name">플로렌스 퓨</div>
              <div class="character">옐레나 벨로바</div>
            </div>
            <!--O. T. 패그벤늘 -->
            <div class="person">
              <div class="photo">
                <img
                  alt="O. T. 패그벤늘"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_33721_1583825376.jpg"
                />
              </div>
              <div class="name">O. T. 패그벤늘</div>
              <div class="character">맨슨</div>
            </div>
            <!--레이첼 와이즈-->
            <div class="person">
              <div class="photo">
                <img
                  alt="레이첼 와이즈"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/person_profile_images/person_1536_1626159788.jpg"
                />
              </div>
              <div class="name">레이첼 와이즈</div>
              <div class="character">멜리나 보스토코프</div>
            </div>
            <!--윌리엄 허트 -->
            <div class="person">
              <div class="photo">
                <img
                  alt="윌리엄 허트"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_2782_1510902954.jpg"
                />
              </div>
              <div class="name">윌리엄 허트</div>
              <div class="character">테디어스 로스</div>
            </div>

            <!--레이 윈스턴-->
            <div class="person">
              <div class="photo">
                <img
                  alt="레이 윈스턴"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_849_1510228142.jpg"
                />
              </div>
              <div class="name">레이 윈스턴</div>
            </div>
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

