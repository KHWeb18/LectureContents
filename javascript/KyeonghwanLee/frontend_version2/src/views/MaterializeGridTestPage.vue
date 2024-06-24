<template>
           <div class="container">
               <!-- s는 휴대폰설정
                    m은 태블릿설정
                    l은 pc설정
                    xl은 모니터 큰 pc 설정-->
                <div class="row flex" >
                    <div class="col s2 m2 12 x12 blue">
                        column 2
                    </div>
                    <div class="col s4 m4 14 x13 yellow">
                        column 4
                    </div>
                    <div class="col s6 m6 16 x16 red">
                        column 6
                    </div>
                    <div class="col s12 m4 12 x112 green">
                        column 12
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
                    <div class="col s3 m4 offset-m4 blue white-text">
                        <span class="flow-text">offset 4</span>
                    </div>
                    <div class="col s8 blue offset-m8 white-text">
                        <span class="flow-text">offset 8</span>
                    </div>
                </div>
                -->
                <div class="row">
                    <a class="btn waves-effect waves-red blue" @click="showMessage($event)">
                        Wi-Fi ON!
                    </a>
                    <a class="btn waves-effect waves-green" @click="showMessage($event)">
                        <i class="material-icons left">cloud</i>
                        Cloud
                    </a>
                    <a class="btn-floating waves-effect waves-yellow" @click="showMessage($event)">
                        <i class="material-icons right">wifi</i>
                        Wi-Fi
                    </a>
                </div>
        </div>
</template>
<!-- 굳이 css를 안만들고 집어넣으면 된다-->

<script>
export default {
    name: 'MaterializeGridTestPage',
    methods:{
        showMessage($event){
            alert($event)
        }

    }
}
</script>