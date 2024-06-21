<template>

<div id="root">
  <main id="contents">
    <div class="greeting-wrap">
      <div class="header-top">
        <div class="background-scroll">
          ::before
          ::after
        </div>
      </div>
      <div class="gradient-wrap"></div>
      <div class="footer-btn-wrap">
        <button class="primary-btn"  onclick="location.href='MemberLogin'">로그인</button>
        <button class="transparent-btn"  onclick="location.href='MemberRegister'">회원가입</button>
      </div>
    </div>
  </main>
</div>
</template>

<script>

export default {

  name: "GoToLogin",
  components: {

  },
  data() {
    return {
    }
  }
}
</script>

<style scoped>
#contents, #root {
  position: relative; 
  background: #171717; 
  min-width: 320px; 
}
#contents {
    min-height: calc(100vh - env(safe-area-inset-bottom) - 56px);
    max-width: 700px;
    margin: 0 auto;
    padding-bottom: calc(env(safe-area-inset-bottom) + 56px);
    box-sizing: border-box;
    overflow: hidden;

}
.greeting-wrap {
    position: relative;
    width: 100%;
    max-width: 700px;
    height: calc(90vh - 56px);
}
.header-top {
    width: 100%; 
    height: 100%;
    position: relative;
    overflow: hidden;
}
.background-scroll:after, .background-scroll:before {
    content: "";
    background: url(https://nujhrcqkiwag1408085.cdn.ntruss.com/static/common/launch_screen_compress.png);
    background-position: 50%;
    background-size: 100% auto;
    background-repeat: repeat;
    background-attachment: scroll;
    position: absolute;
    top: 0;
    left: 0;
    z-index: 1;
    width: 100%;
    height: 4840px;
    max-width: 700px;
}
.background-scroll:before {
    animation: bg-data-v-2e70b2e4 100s linear infinite;
}
.background-scroll:after {
    animation: bg2-data-v-2e70b2e4 100s linear infinite;
}

.greeting-wrap .gradient-wrap {
    width: 100%;
    height: 325px;
    max-width: 700px;
    position: absolute;
    bottom: 0;
    z-index: 2;
    background: linear-gradient(rgba(23,23,33,0),#171721 80%);
}
.greeting-wrap .footer-btn-wrap {
    position: fixed;
    bottom: calc(constant(safe-area-inset-bottom) + 72px);
    bottom: calc(env(safe-area-inset-bottom) + 72px);
    z-index: 100;
    width: 100%;
    max-width: 700px;
    padding: 0 16px;
}
.greeting-wrap .footer-btn-wrap .primary-btn {
    font-weight: 600;
    margin-bottom: 10px;
}
.gray-btn, .primary-btn {
    padding: 14px 0;
    width: 100%;
    height: 48px;
    border-radius: 6px;
    cursor: pointer;
    font-weight: 600;
    letter-spacing: -.2px;
}
.primary-btn {
    background-color: #4263eb;
    color: #fff;
}
button {
    background: none;
    border: none;
    outline: 0;
}
.transparent-btn {
    background-color: transparent;
    font-weight: 600;
    color: #fff;
}
.dark-gray-btn, .transparent-btn {
    padding: 14px 0;
    width: 100%;
    height: 48px;
    letter-spacing: -.2px;
    border-radius: 6px;
    cursor: pointer;
}
</style>