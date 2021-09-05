<template>
    <div id="member" class="img-cover">
        <div class="container" style="margin-bottom:2%">
            <div>
                <v-card class="reserve">
                <v-row justify="center" style="margin:3%;">
                    <h4 style="margin-top:5%;">회원목록</h4>
                </v-row>
                <member-list :members="members" :memberAuths="memberAuths" class="table-box"/>
                </v-card>
            </div>
        </div>  
    </div>
</template>

<script>
import MemberList from '@/components/manager/MemberList.vue'
import { mapState, mapActions } from 'vuex'
export default {
    name: 'MemberListPage',
    components: {
        MemberList
    },
    computed: {
        ...mapState(['members','memberAuths'])
    },
    mounted () {
        this.fetchMemberList(),
        this.fetchMemberAuthList()
    },
    methods: {
        ...mapActions(['fetchMemberList','fetchMemberAuthList']),
        auth() {
            console.log(this.$store.state.memberAuths)
        }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Gowun+Batang&display=swap');
@import url('https://fonts.googleapis.com/css2?family=MonteCarlo&display=swap');


p {
    font-family: 'Nanum Myeongjo';
    font-size: 18px;
    text-align: center;
    padding: 18px 0px 18px 0px;
}


h4 {
    margin-top: 0px;
    font-family: 'Gowun Batang';
    font-size: 25px;
}

.img-cover{
     position: relative;
     height: 100%;
     width: 100%;
     background-image: url('https://images.pexels.com/photos/1764702/pexels-photo-1764702.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940');
     background-size: cover;                                                            
     z-index:1;
}

.table-box{
    margin-bottom: 10%;
}
</style> 