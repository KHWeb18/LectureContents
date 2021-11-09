<template>
    <div class="container">
    <!-- s는 휴대폰 설정
            m은 태블릿 설정
            l은 pc 설정
            xl은 모니터 큰 pc 설정 -->
        <div class="row flex">
            <div class="col s2 m2 l2 x12 red">
                column 2
            </div>

            <div class="col s4 m4 l4 x14 blue">
                column 2
            </div>

            <div class="col s6 m6 l6 x16 green">
                column 2
            </div>

            <div class="col s12 m12 l12 x112 teal">
                column 2
            </div>
        </div>
        <!--
        <div class="row">
            <div class="col s12 blue white-text">
                <span class="flow-text">12</span>
            </div>
            <div class="col s6 blue white-text">
                <span class="flow-text">6</span>
            </div>
            <div class="col s3 offset-m4 blue white-text">
                <span class="flow-text">offset 4</span>
            </div>
            <div class="col s3 offset-m8 blue white-text">
                <span class="flow-text">offset 8</span>
            </div>
        </div>
        -->     
        <div class="row">
            <a class="btn waves-effect waves-red blue" @click="showMessage()">
                Wi-Fi ON!
            </a>
            <a class="btn-flat waves-effect waves-teal" @click="showMessage()">
                <i class="material-icons left">cloud</i>
                Cloud
            </a>
            <a class="btn-floating waves-effect waves-yellow" @click="showMessage()">
                <i class="metarial-icons right">wifi</i>
                Wi-Fi
            </a>
        </div>
    </div>
</template>

<script>

export default {
    name: 'materializeGridTestPage',
    methods: {
        showMessage() {
            alert('버튼이다!')
        }
    }
}

</script>