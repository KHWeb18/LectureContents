<template>
  <form @submit.prevent="onSubmit">
    <v-container>
      <div class="content-area">
        <div class="img">
          <img src="@/assets/img/모범택시 상세페이지2.jpg" />
        </div>
        <hr class="new-divider" color="#212529" style="display: block" />
        <div class="my-rating-area">
            <div class="index-rating-wrap">
                <button class="dark-gray-btn index-rating red-light" style="width: calc(50% - 10px); margin-right: 20px;">
                 <v-icon left>{{ icon }}</v-icon>
                 <span class="text">좋아요</span></button>
                <button class="dark-gray-btn index-rating green-light" style="width: calc(50% - 10px)">
                 <v-icon left>{{ icon }}</v-icon>
                 <span class="text">별로에요</span> </button>               
        </div>
        <div class="indicator-bar">
          <div class="bar">
            <span class="indicator-bar" style="width: 16%"></span>
            <span class="indicator-bar" style="width: 84%"></span>
          </div>
        </div>
        </div>
        <hr class="new-divider" color="#212529" style="display: block" />        
        <div class="streaming">
          <h3 class="title">지금 여기서 감상</h3>
          <p style="color: #fff">스트리밍</p>
          <div class="box">
            <a
              href="https://www.wavve.com/player/vod?programid=C9901_C99000000057&page=1"
              target="blank"
              rel="noopener noreferrer"
              class="movie-price-link"
            >
              <i class="icon wavve-icon"></i>
              <span class="streaming-name">웨이브</span>
              <span class="streaming-price">정액제</span>
            </a>
          </div>
          <p style="color: #fff">구매</p>
          <div class="box">
            <a
              href="https://serieson.naver.com/broadcasting/detail.nhn?viewSeq=438686&seasonViewSeq=438688#sale"
              target="blank"
              rel="noopener noreferrer"
              class="movie-price-link"
            >
              <i class="icon naver-icon"></i>
              <span class="streaming-name">네이버 시리즈</span>
              <span class="streaming-price">2,200원</span>
            </a>
          </div>
        </div>
        <hr class="new-divider" color="#212529" style="display: block" />
        <div class="information">
          <h3 class="title">작품 정보</h3>
          <p class="synopsis">
            줄거리 : 베일에 가려진 택시회사 무지개 운수. 이곳에서 택시 기사
            김도기는 억울한 피해자들을 대신해 복수를 완성시켜준다.
            <br>
            <br>
            1분 정보 : 웨이브 오리지널 드라마로 웨이브에서만 감상 가능하다.
            케이툰에서 2014년부터 연재된 동명의 웹툰이 원작이다. 현재는
            네이버에서 완결 형태로 볼 수 있다.
            <br />원작에서 '복수 대행 택시 회사'라는 설정만 가져오고 내용은 전혀
            다르다. 11화부터 작가와 연출 간의 견해 차이로 작가가 교체되었다.
          </p>
        </div>
        <hr class="new-divider" color="#212529" style="display: block" />
        <div class="preview">
          <h3 class="title">예고편</h3>
          <iframe
            width="1200"
            height="450"
            src="https://www.youtube.com/embed/yJCM77Krhpo"
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
            <div class="person">
              <!--감독 박준우-->
              <div class="photo">
                <div class="default-circle">
                  <span class="text">박</span>
                </div>
              </div>
              <div class="name">박준우</div>
              <div class="character">감독</div>
            </div>
            <!--이제훈-->
            <div class="person">
              <div class="photo">
                <img
                  alt="이제훈"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_49_1580453029.jpg"
                />
              </div>
              <div class="name">이제훈</div>
              <div class="character">김도기</div>
            </div>
            <!--이솜-->
            <div class="person">
              <div class="photo">
                <img
                  alt="이솜"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_4683_1534479559.jpg"
                />
              </div>
              <div class="name">이솜</div>
              <div class="character">강하나</div>
            </div>
            <!--김의성-->
            <div class="person">
              <div class="photo">
                <img
                  alt="김의성"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_375_1509886483.jpg"
                />
              </div>
              <div class="name">김의성</div>
              <div class="character">장성철</div>
            </div>
            <!--차지연-->
            <div class="person">
              <div class="photo">
                <img
                  alt="차지연"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_7491_1521034613.jpg"
                />
              </div>
              <div class="name">차지연</div>
              <div class="character">대모</div>
            </div>
            <!--장혁진-->
            <div class="person">
              <div class="photo">
                <img
                  alt="장혁진"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_8328_1522163574.jpg"
                />
              </div>
              <div class="name">장혁진</div>
              <div class="character">최경구</div>
            </div>
            <!--배유람-->
            <div class="person">
              <div class="photo">
                <img
                  alt="배유람"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_12021_1533179635.jpg"
                />
              </div>
              <div class="name">배유람</div>
              <div class="character">박진언</div>
            </div>
            <!--유승목-->
            <div class="person">
              <div class="photo">
                <img
                  alt="유승목"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_6101_1519968645.jpg"
                />
              </div>
              <div class="name">유승목</div>
              <div class="character">조진우</div>
            </div>
            <!--이유준-->
            <div class="person">
              <div class="photo">
                <img
                  alt="이유준"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_15028_1536216206.JPG"
                />
              </div>
              <div class="name">이유준</div>
              <div class="character">왕수사관</div>
            </div>
            <!--이호철-->
            <div class="person">
              <div class="photo">
                <img
                  alt="이호철"
                  src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/actor_profile_images/actor_10216_1531708704.jpg"
                />
              </div>
              <div class="name">이호철</div>
              <div class="character">구비서</div>
            </div>
          </div>
        </div>
        <hr class="new-divider" color="#212529" style="display: block" />
        <div class="review">
        <h3 class="title">리뷰</h3>
        </div>
        <hr class="new-divider" color="#212529" style="display: block" />
      </div>
    </v-container>
  </form>
</template>

<style scoped>
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
.my-rating-area{
        width: 100%;
    position: relative;
    padding: 0 16px;
}

.my-rating-area .index-rating{
    padding: 11px 0;
    text-align: center;
}
.dark-gray-btn, .transparent-btn {
    padding: 14px 0;
    width: 100%;
    height: 48px;
    letter-spacing: -.2px;
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
    letter-spacing: -.1px;
    color: #868e96;
    vertical-align: middle;
}
.my-rating-area span {
    display: inline-block;
}
.indicator-bar{
  position: relative;
  margin-top: 10px;
}
.indicator-bar .bar{
  width: 100%;
  height: 24px;
}
.indicator-bar .bar .indicator-bar{
  display: inline-block;
  height: 24px;
  position: relative;
}
.indicator-bar .bar .indicator-bar:first-child{
  border-radius: 6px 0 0 6px;
  background-color: #f03e3e;
}

.indicator-bar .bar .indicator-bar:last-child{
  border-radius: 0 6px 6px 0;
  background-color: #0ca678;
}
.review {
  padding: 16px;
  width: 100%;
  position: relative;
}
</style>

