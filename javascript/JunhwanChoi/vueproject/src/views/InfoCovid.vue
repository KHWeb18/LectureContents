<template>
    <div>
        <info-bar></info-bar><br>
        <v-container>
            <h4>코로나19란?</h4>
            <hr><br>

        <v-card class="card">
            <h5 class="h5class">정의</h5>
            <div class="section">
                <div class="imgsection">
                    <img src="@/assets/info-covid1.png" width="300px" height="200px">
                </div>
                <div class="contsection">
                    <p>
                        중국 우한에서 발생한 폐렴은 신종 코로나 바이러스인 ‘2019-nCoV' 가 원인으로 알려졌습니다. 
                        이 신종 바이러스는 2019년 말 처음 인체 감염이 확인됐다는 의미에서 '코로나-19'로 명명되었습니다. 
                        지금까지 코로나 바이러스는 단 여섯 종만이 사람에게 감염되는 것으로 알려져 있었으나 
                        이번 중국 우한에서 발생한 바이러스는 알려진 코로나 바이러스와는 성질이 달라 신종 코로나 바이러스로 분류됐습니다.
                    </p>
                </div>
            </div>
        </v-card>
        <v-card class="card">
            <h5 class="h5class">원인</h5>
            <div class="section">
                <div class="imgsection">
                    <img src="@/assets/info-covid2.png" width="300px" height="200px">
                </div>
                <div class="contsection">
                    <p>
                        국제보건기구(WHO)에 따르면 우한에서 발생한 새로운 코로나 바이러스의 확산은 동물에서 비롯된 것으로 보고 있습니다. 
                        일반적인 코로나 바이러스는 환자의 침방울 등의 분비물을 통하여 감염되지만, 
                        신종 코로나 바이러스는 새로운 바이러스이기 때문에 감염 경로는 아직 명확하게 밝혀지지 않은 상태입니다. 
                     </p>
                </div>
            </div>
        </v-card>
        <v-card class="card">
            <h5 class="h5class">증상</h5>
            <div class="section">
                <div class="imgsection">
                    <img src="@/assets/info-covid3.png" width="300px" height="200px">
                </div>
                <div class="contsection">
                    <p>
                        코로나-19에 감염되면 2~3일에서 최장 2주 정도 잠복기를 거쳤다가 다양한 증상이 나타납니다. 
                        주로 무기력감, 37.5도 이상의 고열, 기침, 인후통, 가래, 근육통, 두통, 호흡곤란, 폐렴 등의 증상이 발생합니다. 
                        폐 손상에 따른 호흡부전으로 심하면 사망에 이를 수도 있습니다.
                    </p>
                </div>
            </div>
            
        </v-card>
        <v-card class="card">
            <h5 class="h5class">확진환자 치료 및 지원</h5>
            <div class="section">
                <div class="imgsection">
                    <img src="@/assets/info-covid5.png" width="300px" height="200px">
                </div>
                <div class="contsection">
                    <p>
                        한국 정부는 환자를 중증도에 따라 분류하고 중증환자는 입원 치료를 우선 제공하고, 
                        입원이 필요하지 않은 확진자에 대해서는 생활치료센터에서 의료서비스 지원 및 증상 모니터링 등을 진행하고 있습니다.
                        먼저, 보건소에서 확진자를 확인하고, 시도별로 구성된 환자관리반에서 확진자 중증도를 3가지(경증·중등증·중증)로 분류합니다.
                        입원 치료가 필요한 중등증ㆍ중증 환자는 환자 상태에 따라 감염병전담병원 병상, 중증환자 전담치료병상 등을 배정받아 치료를 받게 됩니다.
                        생활치료센터는 경증 혹은 의료적 조치의 필요성이 낮은 감염병 환자가 입소하는 시설입니다. 
                        이 시설에서는 환자 모니터링과 진료가 이루어지며, 기준에 따라 전원 또는 퇴소하게 됩니다.
                        정부는 감염병의 확산을 방지하기 위하여 확진자에 대하여 격리입원치료 시작 일부터 해제한 날까지 입원·치료비를 지원하고 있으며 
                        확진 전에라도 격리입원치료가 필요한 의사환자 및 조사대상유증상자, 자가격리대상자에 대하여 격리실 입원료(병실료) 및 코로나19 진단검사비를 지원합니다.
                    </p>
                </div>
                
            </div>
        </v-card>

        </v-container>
    </div>
</template>
<script>

import InfoBar from '@/components/bar/InfoBar.vue'

export default {
    name: 'InfoPage',
    components: {
        InfoBar,
        
    },
}
</script>

<style scoped>
p{
    font-weight: 500;
}
hr{
    background-color: black;
    height:1.5px;
}
.card{
    padding: 20px;
}
 
.h5class{

    color:#7E6ECD;
}
.redfont{
    color:red;
}
.contsection{
    margin-left:10%;
    margin-right:10%;
    display:inline;
    font-size:16px;
}

.section{
    display:flex;

}
.imgsection{
    width:300px;
    
}


</style>