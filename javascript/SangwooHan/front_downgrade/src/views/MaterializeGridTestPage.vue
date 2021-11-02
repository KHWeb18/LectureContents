<template>
  
  <div class="container">
        <!--
             s는 핸드폰 설정
             m은 태블릿 설정
             l은 pc 설정
             xl은 모니터 큰 pc 설정
         -->
            <div class="row flex">
                <div class="col s2 m2 l2 xl2 red ">
                <p> column 2</p>
                </div>
                <div class="col s4 m4 14 x14 blue">
                <p> column 4</p>
                </div>
                <div class="col s6 m6 16 x16 green">
                <p> column 6</p>
                </div>
                <div class="col s12 m12 112 xl12 teal">
                <p> column 12</p>
                </div>
            </div>
            <!--
            <div class="row flex">
                <div class="col s12 blue white-text">
                    <span class="flow-text">12</span>
                </div>
               <div class="col s6 blue white-text">
                    <span class="flow-text">6</span>
                </div>
        </div>
        -->

    <div class="row">
        <a class="btn waves-effect waves-red blue" @click="showMessage()">
             Wi-Fi ON..
        </a>
        <a class="btn-flat waves-effect waves-teal" @click="showCloud()">
              <i class="material-icons left">cloud</i>
        </a>
        <a class="btn-floating waves-effect waves-yellow" @click="showMessage()">
            Wi-Fi
        </a>
    </div>
  </div>
  
</template>

<script>

export default {
    name: 'MaterializeGridTestpage',
    methods:{
        showMessage () {
            alert('와이파이가 켜졋습니다 code: 234953-534944-23394!!')
        },
        showCloud() {
            alert('구름두둥실')
        } 
    }
}
</script>