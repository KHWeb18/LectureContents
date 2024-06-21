<template>
  <form @submit.prevent="onSubmit">
    <v-container>
      <div class="content-area">
        <div class="img">
          <img src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/movie_still_images/79967/thumbnail/ebeb5205e97dd55065458022eebbc6de.jpg" />
          <div class="gradient"></div>
        </div>
        <div class="movie-header-area">
          <div class="movie-title">
            <h3 class="title-kr">왕좌의게임 시즌8</h3>
            <h4 class="title-en">Game Of Thrones 8</h4>
            <p class="metadata">
              <span class="matadata-item">드라마 / 2019</span>
            </p>
          </div>
          <div class="poster">
            <img
              src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/drama_poster_images/280x400/drama_79967_1584636951.jpg"
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

          <h3 class="title">지금 여기서 감상</h3>
          <p style="color: #fff">스트리밍</p>
          <div class="box">
            <a
              href="https://www.wavve.com/player/vod?programid=F3501_F35000000025&page=1&utm_source=kinolights&utm_campaign=kinolights&utm_medium=organic&utm_content=title_provider"
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
              href="https://watcha.com/contents/share/tPeyjNP?utm_source=kinolights&utm_campaign=kinolights&utm_medium=organic&utm_content=title_provider"
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
              href="https://serieson.naver.com/broadcasting/detail.nhn?viewSeq=359172&isWebtoonAgreePopUp=true"
              target="blank"
              rel="noopener noreferrer"
              class="movie-price-link"
            >
              <i class="icon naver-icon"></i>
              <span class="streaming-name">네이버 시리즈온</span>
              <span class="streaming-price">1,100원</span>
            </a>
          </div>
          <p style="color: #fff">구매</p>
          <div class="box">
            <a
              href="https://serieson.naver.com/broadcasting/detail.nhn?viewSeq=359172&isWebtoonAgreePopUp=true"
              target="blank"
              rel="noopener noreferrer"
              class="movie-price-link"
            >
              <i class="icon naver-icon"></i>
              <span class="streaming-name">네이버 시리즈온</span>
              <span class="streaming-price">1,650원</span>
            </a>
          </div>
        </div>
        <hr class="new-divider" color="#212529" style="display: block" />
        <div class="information">
          <h3 class="title">작품 정보</h3>
          <p class="synopsis" style="color: #f8f9fa;">
           웨스테로스 대륙의 연맹 국가인 칠 왕국이 통치권과 철 왕좌를 차지하기 위한 싸움을 벌이는 가운데, 
           장벽 너머에 전설 속의 적이 부활했다는 소문이 모두를 위협한다.
          </p>
        </div>
        <hr class="new-divider" color="#212529" style="display: block" />
        <div class="preview">
          <h3 class="title">예고편</h3>
          <iframe
            width="100%"
            height="450"
            src="https://www.youtube.com/embed/rlR4PJn8b8I"
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
            <!-- 감독/ 데이비드 너터 -->
            <div class="person">
              <div class="photo">
                <img
                  alt="데이비드 너터"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/director_profile_images/director_114164_1584637151.png"
                />
              </div>
              <div class="name">데이비드 너터</div>
              <div class="character">감독</div>
            </div>
             <!-- 감독/ 데이비드 너터 -->
            <div class="person">
              <div class="photo">
                <img
                  alt="미구엘 사포크닉"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/director_profile_images/director_91345_1584634643.jpg"
                />
              </div>
              <div class="name">미구엘 사포크닉</div>
              <div class="character">감독</div>
            </div>
            <!--키트 해링턴 -->
            <div class="person">
              <div class="photo">
                <img
                  alt="키트 해링턴"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_4401_1515605733.jpg"
                />
              </div>
              <div class="name">키트 해링턴</div>
              <div class="character">아에곤 타르가르옌</div>
            </div>
            <!--에밀리아 클라크-->
            <div class="person">
              <div class="photo">
                <img
                  alt="에밀리아 클라크"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_1827_1561010652.jpg"
                />
              </div>
              <div class="name">에밀리아 클라크</div>
              <div class="character">대너리스 타르가르옌</div>
            </div>
            <!--피터 딘클리지-->
            <div class="person">
              <div class="photo">
                <img
                  alt="피터 딘클리지"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_1086_1510338363.jpg"
                />
              </div>
              <div class="name">피터 딘클리지</div>
              <div class="character">티리온 라니스터</div>
            </div>
            <!--니콜라이 코스터-왈도 -->
            <div class="person">
              <div class="photo">
                <img
                  alt="니콜라이 코스터-왈도"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_2816_1510903987.jpg"
                />
              </div>
              <div class="name">니콜라이 코스터-왈도</div>
              <div class="character">제이미 라니스터</div>
            </div>
            <!--레나 헤디-->
            <div class="person">
              <div class="photo">
                <img
                  alt="레나 헤디"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_2933_1510909844.jpg"
                />
              </div>
              <div class="name">레나 헤디</div>
              <div class="character">세르세이 라니스터</div>
            </div>
            <!--이언 글렌-->
            <div class="person">
              <div class="photo">
                <img
                  alt="이언 글렌"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_5719_1519615082.jpg"
                />
              </div>
              <div class="name">이언 글렌</div>
              <div class="character">조라 모르몬트</div>
            </div>

            <!--존 브래들리-->
            <div class="person">
              <div class="photo">
                <img
                  alt="존 브래들리"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_20563_1540738443.jpg"
                />
              </div>
              <div class="name">존 브래들리</div>
              <div class="character">샘웰 탈리</div>
            </div>
            <!--리차드 매든-->
            <div class="person">
              <div class="photo">
                <img
                  alt="리차드 매든"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_7892_1521460857.jpg"
                />
              </div>
              <div class="name">리차드 매든</div>
              <div class="character">롭 스타크</div>
            </div>
            <!--메이지 윌리암스-->
            <div class="person">
              <div class="photo">
                <img
                  alt="메이지 윌리암스"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_8190_1521790850.jpg"
                />
              </div>
              <div class="name">메이지 윌리암스</div>
              <div class="character">아리아 스타크</div>
            </div>
            <!--소피 터너-->
            <div class="person">
              <div class="photo">
                <img
                  alt="소피 터너"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_2083_1510715871.jpg"
                />
              </div>
              <div class="name">소피 터너</div>
              <div class="character">산사 스타크</div>
            </div>
            <!--아이작 햄스터드 라이트-->
            <div class="person">
              <div class="photo">
                <img
                  alt="아이작 햄스터드 라이트"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_25241_1544975540.jpg"
                />
              </div>
              <div class="name">아이작 햄스터드 라이트</div>
              <div class="character">브랜 스타크</div>
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

