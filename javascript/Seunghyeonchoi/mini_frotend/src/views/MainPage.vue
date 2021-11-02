<template>
    <div id="main">
        <div class="main-page">
            <div class="main-page-bar">
                <header style="top: 0px; position: fixed;">
                    <div class="container">
                        <img src="@/assets/img/logo3.png" width="100">
                          <li>
                            <ul class="main-page-bar-menu" >
                                <li>
                                    <span>공지사항</span>
                                </li>
                                <li>
                                    <span>게시판모음02</span>
                                </li>
                                <li>
                                    <span>게시판모음03</span>
                                </li>
                                <li>
                                    <span>게시판모음04</span>
                                </li>
                            </ul>
                          </li>
                        </div>
                    </header>
            </div>
        <div id="main background image">
          <img src="@/assets/img/bg01.png">
        </div>
        </div>
    </div>
</template>

<script>

export default {
  data: () => ({
      links: [
        'Home',
        'About Us',
        'Team',
        'Services',
        'Blog',
        'Contact Us',
      ]
    }),
  methods: {
    noticeBtnClick () {
      
    }
  }
}
</script>

<style scoped>
.main-page
.main-page-bar header {
  width: 100%;
  min-width: 1184px;
  height: 96px;
  background-color: #000;
  color: #fff;
}
.main-page-bar img {
    float: left;
    cursor: pointer;
}
.main-page-bar-menu {
    float: left;
    margin-left: 34px;
    margin-top: 26px;
    display: block; 
    opacity: 1;
}
.main-page-bar-menu li {
    float: left;
    padding-left: 5px;
    padding-right: 5px;
    margin-right: 14px;
    font-size: 18px;
    line-height: 18px;
    cursor: pointer;
}

</style>
