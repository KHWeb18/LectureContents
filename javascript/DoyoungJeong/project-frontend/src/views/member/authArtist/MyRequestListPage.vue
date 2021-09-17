<template>
    <div align="center" class="grey darken-0.1" style="height: 100%; padding-top: 60px;">
        <p class="memberListTitle">My Request List</p>
        <p class="description">회원님이 요청한 공연의 리스트 정보입니다. 요청자 이름을 눌러 상세정보를 확인하세요!</p>

        <div style="width: 70%; margin-top: 40px;"> 
            <v-data-table :headers="headerTitle"
                            :items="myRequestList"
                            :items-per-page="5"
                            :search="searchRequest"
                            class="elevation-1">

                        <template v-slot:item="{ item, index }"> 
                            <tr>
                                <td>{{ index + 1 }}</td>
                                <td @click="handleClick(item.concertRequestNo)" class="footerText">{{ item.regName }}</td> 
                                <td>{{ item.artistName }}</td>
                                <td>{{ item.venueName }}</td>
                                <td>{{ item.concertName }}</td>
                                <td>{{ item.dateOfConcert }} {{ item.timeOfConcert }}</td>

                                <td v-if="item.approvedOrNot == null || item.approvedOrNot == 'A' ">
                                    게시 요청 대기 중
                                    <v-btn class="ma-2" text icon color="primary lighten-1" v-bind="attrs" v-on="on">
                                        <v-icon>crop_square</v-icon>
                                    </v-btn>
                                </td>

                                <td v-else-if="item.approvedOrNot == 'Y'">
                                    게시 요청 수락됨
                                    <v-btn class="ma-2" text icon color="teal lighten-1" v-bind="attrs" v-on="on">
                                        <v-icon>done</v-icon>
                                    </v-btn>
                                </td>

                                <td v-else-if="item.approvedOrNot == 'N'">
                                    게시 요청 거부됨
                                    <v-btn class="ma-2" text icon color="error lighten-1" v-bind="attrs" v-on="on">
                                        <v-icon>remove</v-icon>
                                    </v-btn>
                                </td>

                                <td v-else-if="item.approvedOrNot == 'R'">
                                    수정된 요청 대기 중
                                    <v-btn class="ma-2" text icon color="orange lighten-1" v-bind="attrs" v-on="on">
                                        <v-icon>replay</v-icon>
                                    </v-btn>
                                </td>
                                <td>{{ item.regDate }}</td>
                            </tr>
                        </template>
            </v-data-table>
        </div>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'

export default {
    name: 'MyRequestListPage',
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
            ]
        }
    },
    methods: {
        ...mapActions(['fetchMyRequestList']),

        handleClick(concertRequestNo) {
            this.$router.push({
                name: 'MyRequestReadPage',
                params: { concertRequestNo: concertRequestNo }
            })
        }
    },
    mounted() {
        this.$store.state.userProfile = this.$cookies.get("currentUser")

        if(this.$store.state.userProfile.id != '') {

            this.$store.state.isLoggedIn = true
            this.$store.state.userIdentity = this.$store.state.userProfile.identity
        }

        if(this.$store.state.userIdentity == 'artist') {
            this.fetchMyRequestList(this.$store.state.userProfile.memberNo)
            //alert(this.$store.state.userProfile.memberNo)
            //alert(JSON.stringify(this.$store.state.myRequestList))
        }
    },
    computed: {
        ...mapState(['myRequestList'])
    }
}
</script>

<style scoped>

.footerText:hover {
  color: teal;
  font-size: 15px;
}

</style>
