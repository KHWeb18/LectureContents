<template>
    <div align="center" class="grey darken-0.1" style="height: 100%; padding-top: 60px;">
        <p class="memberListTitle">Requested Concert List</p>
        <p class="description">아티스트들이 요청한 콘서트의 목록입니다! 수락 또는 불가를 선택해주세요.
            <br/>
            <br/>
            내용을 자세히 확인하려면 요청자 이름을 클릭하세요.
        </p>

        <div style="width: 75%; margin-top: 40px;">
            <v-data-table :headers="headerTitle"
                            :items="concertRequestList"
                            :items-per-page="5"
                            :search="searchRequest"
                            class="elevation-1">

                        <template v-slot:item="{ item, index }"> <!-- v-data-table에서 index뽑는 법 * item * 얘는 고정된 이름 -->
                            <tr>
                                <td>{{ index + 1 }}</td>
                                <td @click="handleClick(item.concertRequestNo)" class="footerText">{{ item.regName }}</td> 
                                <td>{{ item.artistName }}</td>
                                <td>{{ item.venueName }}</td>
                                <td>{{ item.concertName }}</td>
                                <td>{{ item.dateOfConcert }} {{ item.timeOfConcert }}</td>
                    
                                <td v-if="item.approvedOrNot == null || item.approvedOrNot == 'A'">승인 대기
                                    <v-tooltip bottom>
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn class="ma-2" text icon color="teal lighten-1" v-bind="attrs" v-on="on" @click="approveOrNotConcert(item.concertRequestNo, index, 1)">
                                                <v-icon>done</v-icon></v-btn>
                                        </template>
                                        <span>게시 요청 수락</span>    
                                    </v-tooltip>

                                    <v-tooltip bottom>
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn class="ma-2" text icon color="red lighten-1" v-bind="attrs" v-on="on" @click="approveOrNotConcert(item.concertRequestNo, index, 2)">
                                                <v-icon>remove</v-icon></v-btn>
                                        </template>
                                        <span>게시 요청 거부</span>    
                                    </v-tooltip>
                                    
                                    <v-tooltip bottom>
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn class="ma-2" text icon color="primary lighten-1" v-bind="attrs" v-on="on" disabled>
                                                <v-icon>crop_square</v-icon></v-btn>
                                        </template>
                                        <span>게시 요청 보류</span>    
                                    </v-tooltip>
                                </td>

                                <td v-else-if="item.approvedOrNot == 'N'">게시 불가
                                    <v-tooltip bottom>
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn class="ma-2" text icon color="teal lighten-1" v-bind="attrs" v-on="on" @click="approveOrNotConcert(item.concertRequestNo, index, 1)">
                                                <v-icon>done</v-icon></v-btn>
                                        </template>
                                        <span>게시 요청 수락</span>    
                                    </v-tooltip>

                                    <v-tooltip bottom>
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn class="ma-2" text icon color="red lighten-1" v-bind="attrs" v-on="on" disabled>
                                                <v-icon>remove</v-icon></v-btn>
                                        </template>
                                        <span>게시 요청 거절</span>    
                                    </v-tooltip>

                                    <v-tooltip bottom>
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn class="ma-2" text icon color="primary lighten-1" v-bind="attrs" v-on="on" @click="approveOrNotConcert(item.concertRequestNo, index, 3)">
                                                <v-icon>crop_square</v-icon></v-btn>
                                        </template>
                                        <span>게시 요청 보류</span>    
                                    </v-tooltip>
                                </td>

                                <td v-else-if="item.approvedOrNot == 'Y'">승인 완료 <!-- 순서 버그 있음 -> 해결 같이 툴팁에 다 넣어야됨 -->
                                    <v-tooltip bottom>
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn class="ma-2" text icon color="teal lighten-1" v-bind="attrs" v-on="on" disabled>
                                                <v-icon>done</v-icon></v-btn>
                                        </template>
                                        <span>게시 요청 수락</span>    
                                    </v-tooltip>

                                    <v-tooltip bottom>
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn class="ma-2" text icon color="red lighten-1" v-bind="attrs" v-on="on" @click="approveOrNotConcert(item.concertRequestNo, index, 2)">
                                                <v-icon>remove</v-icon></v-btn>
                                        </template>
                                        <span>게시 요청 거절</span>    
                                    </v-tooltip>

                                    <v-tooltip bottom>
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn class="ma-2" text icon color="primary lighten-1" v-bind="attrs" v-on="on" @click="approveOrNotConcert(item.concertRequestNo, index, 3)">
                                                <v-icon>crop_square</v-icon></v-btn>
                                        </template>
                                        <span>게시 요청 보류</span>    
                                    </v-tooltip>
                                </td>

                                <td v-if="item.approvedOrNot == 'R'">수정된 요청
                                    <v-tooltip bottom>
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-btn class="ma-2" text icon color="orange lighten-1" v-bind="attrs" v-on="on" @click="approveOrNotConcert(item.concertRequestNo, index, 1)">
                                                <v-icon>replay</v-icon></v-btn>
                                        </template>
                                        <span>게시 요청 수락</span>    
                                    </v-tooltip>
                                </td>

                                <td>{{ item.regDate }}</td>
                            </tr>
                        </template>
            </v-data-table>
       
            <v-text-field v-model="searchRequest" style="width: 300px; float: right;" label="공연 요청 검색" class="footerText"/>
           
        </div>
        
    </div>
    
</template>

<script>
import { mapActions, mapState } from 'vuex'

import axios from 'axios'

export default {
    name: 'RequestStorePage',
    computed: {
        ...mapState(['userProfile', 'concertRequestList'])
    },
    data() {
        return {
            headerTitle: [
                { text: '순번', value: 'index', width: '8%' },
                { text: '요청자', value: 'regName', width: '8%'},
                { text: '아티스트', value: 'artistName', width: '12%'},
                { text: '공연 장소', value: 'venueName', width: '12%'},
                { text: '공연 이름', value: 'concertName', width: '12%'},
                { text: '일시', value: 'dateOfConcert', width: '20%'},
                { text: '승인 여부', value: 'approvedOrNot', width: '18%'},
                { text: '요청일자', value: 'regDate', width: '15%'}
            ],
            searchRequest: '',
            tmpArr: []
        }
    },
    methods: {
        ...mapActions(['fetchConcertRequestList']),

        approveOrNotConcert(concertRequestNo, index, tmpNum) {

            this.tmpArr.push(concertRequestNo)
            this.tmpArr.push(tmpNum)

            const numArr = this.tmpArr

            axios.post('http://localhost:8888/member/concertRegister/approveOrNotRequest', { numArr })
                .then(() => {

                    this.tmpArr = []

                    if(tmpNum == 1) {
                        this.$store.state.concertRequestList[index].approvedOrNot = 'Y'
                    } else if(tmpNum == 2) {
                        this.$store.state.concertRequestList[index].approvedOrNot = 'N'
                    } else if(tmpNum == 3) {
                        this.$store.state.concertRequestList[index].approvedOrNot = 'A'
                    }

                })
                .catch(() => {
                    alert('잠시 후에 다시 시도해주세요!')
                    this.tmpArr = []
                })
        },
        handleClick(concertRequestNo) {
            this.$router.push({
                name: 'RequestReadPage',
                params: { concertRequestNo: concertRequestNo }
            })
        }
    },
    mounted() {
        this.$store.state.userProfile = this.$cookies.get("currentUser")

        if(this.$store.state.userProfile.id != '') {

            this.$store.state.isLoggedIn = true
            this.$store.state.userIdentity = this.$store.state.userProfile.identity

            this.fetchConcertRequestList()
        }
    }
}
</script>

<style scoped>

.footerText:hover {
  color: teal;
  font-size: 15px;
}

</style>
