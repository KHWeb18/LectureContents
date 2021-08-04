<template>
    <div id="member">
        <h2>JPA 회원가입 구현</h2>
        <router-link :to="{ name: 'VuetifyMemberRegisterPage' }">
            회원 등록
        </router-link>
        <vuetify-member-list :members="members"/>
    </div>
</template>

<script>

import VuetifyMemberList from '@/components/member/VuetifyMemberList.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'VuetifyMemberListPage',
    components: {
        VuetifyMemberList
    },
    computed: {
        ...mapState(['members'])
    },
    mounted () {
        this.fetchMemberList()
    },
    methods: {
        ...mapActions(['fetchMemberList'])
    }
}

</script>