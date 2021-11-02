  
<template>
    <div class="container">
        <!-- s는 휴대폰 설정
                m은 태블릿 설정
                l은 pc 설정
                xl은 모니터 큰 pc 설정 -->
        <div class="row flex">
            <div class="col s2 m2 l2 xl2 red">
                column 2
            </div>

            <div class="col s4 m4 l4 xl4 blue">
                column 4
            </div>

            <div class="col s6 m6 l6 xl6 green">
                column 6
            </div>

            <div class="col s12 m12 l12 xl12 teal">
                column 12
            </div>
        </div>
        <div class="row">
            <a class="btn waves-effect waves-red blue" @click="showMessage($event)">
                Wi-Fi ON!
            </a>
            <a class="btn-flat waves-effect wave-blue" @click="showMessage($event)">
                cloud
            </a>
            <a class="btn-floating waves-effect wave-yellow" @click="showMessage($event)">
                <i class="material-icons right">wifi</i>
                WI-FI
            </a>
        </div>
    </div>
</template>

<script>
export default {
    name: 'MaterializeGridTestPage',
    methods: {
        showMessage(){
            alert('버튼이다')
        }
    }
}
</script>