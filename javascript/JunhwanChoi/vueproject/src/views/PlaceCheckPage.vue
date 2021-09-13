
<template>
    <div>
        <v-container>
            <div class="bookalign">
            <h4 class>선별진료 예약</h4>
            <h6><i><span style="color: blue;">진료할 장소를 선택해 주세요.</span></i></h6>
            <hr><br>
        </div>
        </v-container>
        
        <v-dialog v-model="PlaceCheckDialog"  max-width="500px">
                <v-card
                    class="mx-auto"
                    max-width="500"
                    >
                    <v-toolbar
                        color="teal"
                        dark
                    >
                        <v-icon>mdi-check</v-icon>                
                        <v-toolbar-title>선별진료소 선택</v-toolbar-title>
                        
                        <v-spacer></v-spacer>

                        <v-btn icon>
                        <v-icon>mdi-dots-vertical</v-icon>
                        </v-btn>
                    </v-toolbar>
                
                    <v-list>
                        <v-list-group
                        v-for="item in items"
                        :key="item.title"
                        v-model="item.active"
                        :prepend-icon="item.action"
                        no-action
                        >
                        <template v-slot:activator>
                            <v-list-item-content>
                            <v-list-item-title v-text="item.title"></v-list-item-title>
                            </v-list-item-content>
                        </template>
                
                        <v-list-item
                            v-for="child in item.items"
                            :key="child.title"
                        >
                            <v-list-item-content>
                            <v-list-item-title v-text="child.title"></v-list-item-title>
                            </v-list-item-content>
                            <v-list-item-content>
                            <v-btn @click="timeCheck(child.title)">시간선택</v-btn>
                            </v-list-item-content>
                            
                        </v-list-item>
                        </v-list-group>
                    </v-list>
                    </v-card>
    </v-dialog>
    </div>
</template>

<script>


export default {
    data()
    {
        return{
            PlaceCheckDialog: true,
            test:1,

            items: 
            [
                {
                    action: 'mdi-doctor',
                    items: [
                        { title: '강남구 보건소'},
                        { title: '강동구 보건소'},
                        { title: '강북구 보건소'},
                        { title: '관악구 보건소'},
                        { title: '광진구 보건소'},
                        { title: '구로구 보건소'},
                        { title: '노원구 보건소'},
                        { title: '도봉구 보건소'},
                        { title: '동대문구 보건소'},
                        { title: '마포구 보건소'},
                        ],
                    title: '서울',
                },
                {
                    action: 'mdi-doctor',
                    items: [
                        { title: '가평군 보건소'},
                        { title: '고양시 보건소'},
                        { title: '과천시 보건소'},
                        { title: '광명시 보건소'},
                        { title: '광주시 보건소'},
                        { title: '수원시 보건소'},
                        { title: '용인시 보건소'},
                        { title: '안산시 보건소'},
                        { title: '시흥시 보건소'},
                        { title: '여주시 보건소'},
                    ],
                    title: '경기',
                },
                {
                    action: 'mdi-doctor',
                    items: [
                        { title: '강화군 보건소'},
                        { title: '계양구 보건소'},
                        { title: '남동구 보건소'},
                        { title: '미추홀구 보건소'},
                        { title: '부평구 보건소'},
                        { title: '연수구 보건소'},
                        { title: '옹진군 보건소'},
                        { title: '인천광역시 동구 보건소'},
                        { title: '인천광역시 서구 보건소'},
                        { title: '인천광역시 중구 보건소'},
                    ],
                    title: '인천',
                },
                {
                    action: 'mdi-doctor',
                    items: [
                        { title: '강릉시 보건소'},
                        { title: '삼척시 보건소'},
                        { title: '원주시 보건소'},
                        { title: '속초시 보건소'},
                        
                    ],
                    title: '강원',
                },
              
            ],
        }
    },
    methods:{
        timeCheck(title){
            alert('예약일자 : ' + this.start + '\n\n선별진료소 : '+ title )
            this.$router.push({name:'TimeCheckPage' , query:{start:this.start, title:title}})

        }
    },
    created(){
        this.start=this.$route.query.start
    }
}
</script>

<style>
 
.trick{
    color:white;
}

</style>

