<template>
  <form @submit.prevent="onSubmit">
    <v-container>
      <div class="content-area">
        <div class="img">
          <img src="@/assets/img/해리포터.jpg" />
          <div class="gradient"></div>
        </div>
        <div class="movie-header-area">
          <div class="movie-title">
            <h3 class="title-kr">해리포터</h3>
            <h4 class="title-en">Harry-Potter</h4>
            <p class="metadata">
              <span class="matadata-item">액션 / 2001</span>
            </p>
          </div>
          <div class="poster">
            <img
              src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/movie_poster_images/280x400/movie_6051_1540186703.jpg"
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
        <div class="streaming">
          <h3 class="title">지금 여기서 감상</h3>
          <p style="color: #fff">스트리밍</p>
          <div class="box">
            <a
              href="https://www.wavve.com/player/movie.html?movieid=MV_CD01_WR0000011251&utm_source=kinolights&utm_campaign=kinolights&utm_medium=organic&utm_content=title_provider"
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
              href="https://watcha.com/contents/share/mmOb3kd?utm_source=kinolights&utm_campaign=kinolights&utm_medium=organic&utm_content=title_provider"
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
              href="https://play.google.com/store/movies/details/%ED%95%B4%EB%A6%AC%ED%8F%AC%ED%84%B0%EC%99%80_%EB%A7%88%EB%B2%95%EC%82%AC%EC%9D%98_%EB%8F%8C_%EC%9E%90%EB%A7%89%ED%8C%90?id=YOKoEl835jE&utm_source=kinolights&utm_campaign=kinolights&utm_medium=organic&utm_content=title_provider"
              target="blank"
              rel="noopener noreferrer"
              class="movie-price-link"
            >
              <i class="icon google-play-movie-icon"></i>
              <span class="streaming-name">Google Play 무비</span>
              <span class="streaming-price">1,200원</span>
            </a>
          </div>
          <p style="color: #fff">구매</p>
          <div class="box">
            <a
              href="https://play.google.com/store/movies/details/%ED%95%B4%EB%A6%AC%ED%8F%AC%ED%84%B0%EC%99%80_%EB%A7%88%EB%B2%95%EC%82%AC%EC%9D%98_%EB%8F%8C_%EC%9E%90%EB%A7%89%ED%8C%90?id=YOKoEl835jE&utm_source=kinolights&utm_campaign=kinolights&utm_medium=organic&utm_content=title_provider"
              target="blank"
              rel="noopener noreferrer"
              class="movie-price-link"
            >
              <i class="icon google-play-movie-icon"></i>
              <span class="streaming-name">Google Play 무비</span>
              <span class="streaming-price">4,500원</span>
            </a>
          </div>
        </div>
        <hr class="new-divider" color="#212529" style="display: block" />
        <div class="information">
          <h3 class="title">작품 정보</h3>
          <p class="synopsis">
            줄거리 : 이모네 식구의 구박을 받으며 살아가던 해리 포터는 11번째 생일날, 호그와트 마법학교에서 온 입학 초대장을 받게 된다. 
            이모의 집을 떠나 호그와트로 간 해리 포터는 볼드모트로부터 마법학교를 지키기 위해 친구들과 힘을 모은다.
            <br><br>
            1분 정보 : 해리포터 소설을 원작으로 하고 있는 영화다.
          (나 홀로 집에)의 크리스 콜럼버스 감독이 연출을 맡았다. 
            영상화를 하기 위해 조앤 롤링의 조언을 많이 들었다. 
            호그와트가 스크린으로 나왔을 때, 조앤 롤링이 감탄했을 정도.
          </p>
        </div>
        <hr class="new-divider" color="#212529" style="display: block" />
        <div class="preview">
          <h3 class="title">예고편</h3>
          <iframe
            width="100%"
            height="450"
            src="https://www.youtube.com/embed/vtJ6eZRanHc"
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
                  alt="크리스 콜럼버스"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/director_profile_images/director_58403_1510182657.jpg"
                />
              </div>
              <div class="name">크리스 콜럼버스</div>
              <div class="character">감독</div>
            </div>

            <!--다니엘 래드클리프 -->
            <div class="person">
              <div class="photo">
                <img
                  alt="다니엘 래드클리프"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_903_1510286077.jpg"
                />
              </div>
              <div class="name">다니엘 래드클리프</div>
              <div class="character">해리 포터</div>
            </div>
            <!--루퍼트 그린트-->
            <div class="person">
              <div class="photo">
                <img
                  alt="루퍼트 그린트"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_904_1510286169.jpg"
                />
              </div>
              <div class="name">루퍼트 그린트</div>
              <div class="character">론 위즐리</div>
            </div>
            <!--엠마 왓슨 -->
            <div class="person">
              <div class="photo">
                <img
                  alt="엠마 왓슨"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/person_profile_images/person_733_1610616467.jpeg"
                />
              </div>
              <div class="name">엠마 왓슨</div>
              <div class="character">헤르미온느</div>
            </div>
            <!--로비 콜트레인 -->
            <div class="person">
              <div class="photo">
                <img
                  alt="로비 콜트레인"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_908_1510286319.jpg"
                />
              </div>
              <div class="name">로비 콜트레인</div>
              <div class="character">해그리드</div>
            </div>
            <!--톰 펠튼-->
            <div class="person">
              <div class="photo">
                <img
                  alt="톰 펠튼"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_905_1510286207.jpg"
                />
              </div>
              <div class="name">톰 펠튼</div>
              <div class="character">드레이코 말포이</div>
            </div>
            <!--리처드 해리스 -->
            <div class="person">
              <div class="photo">
                <img
                  alt="리처드 해리스"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_2922_1510908833.jpg"
                />
              </div>
              <div class="name">리처드 해리스</div>
              <div class="character">알버스 덤블도어</div>
            </div>

            <!--앨런 릭먼-->
            <div class="person">
              <div class="photo">
                <img
                  alt="앨런 릭먼"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_1068_1510337113.jpg"
                />
              </div>
              <div class="name">앨런 릭먼</div>
              <div class="character">스네이프 교수</div>
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
  background: url(https://m.kinolights.com/_nuxt/img/btn_cgv.88f80a8.png) 
  50% no-repeat;
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

.review {
  padding: 16px;
  width: 100%;
  position: relative;
}
</style>

