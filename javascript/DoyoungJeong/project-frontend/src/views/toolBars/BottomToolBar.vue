<template>
    <div align="center">
        <v-toolbar dense dark height="90px;" class="d-flex justify-space-around"> <!-- 가운데 정렬 -->
            <div align="center"> 
                <v-toolbar-items>      
                    <p class="content" v-for="content in contents" :key="content.text">
                        {{ content.text }}
                    </p>
                </v-toolbar-items>
                <p class="sentence">{{ sentence }}</p>
            </div>
        </v-toolbar>
        <div>
            <P style="font-size: 12px; padding-top: 4px; margin-bottom: 4px;">&copy; MUSIC GHUETTO</P>
        </div>
    </div>
</template>

<script>

export default {
    name: 'BottomToolBar',
    data() {
        return {
            contents: [
                { text: '이용약관' },
                { text: '서비스 안내' },
                { text: '책임자: 정도영' },
                { text: '청소년 보호 약관' },
                { text: '개인정보처리방침' },
                { text: '책임의 한계와 법적고지' },
                { text: '고객센터' }
            ],
            sentence: '본 콘텐츠의 저작권은 제공처 또는 MUSIC GHUETTO에 있으며 이를 무단 이용하는 경우 저작권법 등에 따라 법적책임을 질 수 있습니다.'
        }
    }
}
</script>

<style>

.content {
    color: rgb(24, 24, 24);
    font-size: 9px;
    padding-top: 15px;
    text-align: center;
    float: center;
    margin: auto;
}

.sentence {
    color: rgb(24, 24, 24);
    font-size: 7px;
    text-align: center;
    float: center;
    margin: auto;
}

</style>