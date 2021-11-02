<template>
    <div id="member">
        <h3>Vue 회원가입 리스트</h3>
        <router-link :to ="{ name: 'MemberRegisterPage' }">
            <h4>회원가입하기</h4>
        </router-link>
        <!-- <member-list></member-list> -->
        <member-list v-bind:members="members"/>
    </div>
</template>

<script>

import MemberList from '@/components/member/MemberList.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'MemberListPage',
    components: {
        'member-list': MemberList
    },
    computed: {
        ...mapState(['members'])
    },
    mounted() {
        this.fetchMemberList()
        //끝에 ()를 해줘야한다. 안해서 계속 에러났었음..
    },
    methods: {
        ...mapActions(['fetchMemberList'])
    }
    
}
</script>
