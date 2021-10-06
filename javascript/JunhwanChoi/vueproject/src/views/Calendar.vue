<template>
    <div class="fill-height">
        <v-row align="center" class="fill-height" justify="center">
            <v-col cols="12" lg="8" md="10" sm="12" xl="7">
                <div class="bookalign">
                        <h4 class>선별진료 예약</h4>
                        <h6><i><span style="color: blue;">진료할 날짜를 선택해 주세요.</span></i></h6>
                        <hr><br>
                    
                    <div class="text-center mb-3">
                        <h4 class="mx-5 d-inline-block">{{start | moment('YYYY년 MM월')}}</h4>
                    </div>
                    <v-sheet height="500">
                        <v-calendar
                                
                                :event-color="getEventColor"
                                :event-overlap-threshold="30"
                                :start="start"
                                :type="type"
                                @click:date="open"
                                @click:event="showEvent"
                                @click:more="moreEvent"
                                dark
                                ref="calendar"

                                v-model="start"
                        ></v-calendar>
                    </v-sheet>
                    <div class="text-right mt-3 font-weight-bold ">
                        <v-card>
                           <h5><i> 선택날짜: {{start}}</i></h5>
                        </v-card>
                        <br>
                        <v-btn @click="DateCheck()" class="white--text" color="indigo"
                               large> 완료 
                        </v-btn>
                    </div>
                </div>
            </v-col>
        </v-row>
        <EventDialog :dialog="true"/>
        <EventDetail :dialog="true"/>
    </div>
</template>

<script>
    import EventDialog from "../components/EventDialog";
    import EventDetail from "../components/EventDetail";

    export default {
        data: () => ({
            dark: true,
            startMenu: false,
            start: '',
            type: 'month',
            typeOptions: [
                {text: 'Day', value: 'day'},
                {text: 'Week', value: 'week'},
                {text: 'Month', value: 'month'},
            ],
        }),
        components: {
            EventDetail,
            EventDialog
        },
        methods: {
            DateCheck(){
               if(this.$store.state.session==null){
                alert('로그인 후 이용해 주세요.')
                this.$router.push('sessionLogin')    
               }else{
                alert('예약일자 : ' + this.start + '\n\n다음 페이지로 이동합니다.')
                this.$router.push({name:'PlaceCheckPage' , query:{start:this.start}})    

               }
              
            },
            open(date) {
                console.log(date);
                this.$store.commit('OPEN_CALENDAR_DIALOG', date)
            },
            showIntervalLabel(interval) {
                return interval.minute === 0
            },
            showEvent({event}) {
                this.$store.dispatch('REQUEST_DETAIL_EVENT', event.id);
            },
            moreEvent({date}) {
                this.start = date;
                this.type = 'day';
            },
            getEventColor(event) {
                return event.color;
            }

        },
        
        created() {
            this.start = this.$moment().format('YYYY-MM-DD');
        },
        watch: {
            start(newDate, oldDate) {
                let newDateMonth = this.$moment(newDate).format('MM');
                let oldDateMonth = this.$moment(oldDate).format('MM');
                if (newDateMonth !== oldDateMonth && !!localStorage.getItem('access_token')) {
                    this.$store.dispatch('REQEUST_QUERY_EVENTS_BY_DATE', newDate);
                }
            }
        }
    }
</script>

<style>

    .controls {
        position: relative;
    }
    .bookalign{
       text-align: center;
    }
</style>