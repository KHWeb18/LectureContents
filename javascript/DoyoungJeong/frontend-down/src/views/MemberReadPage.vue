<template>
    <div align="center">
        <h3>가입 회원 정보</h3>
        <member-read v-if="member" v-bind:member="member"/>
        <p v-else>해당 회원의 정보를 불러오는 중입니다...</p>

        <router-link :to="{ name: 'MemberListPage' }">
            회원 리스트로 돌아가기
        </router-link>

        <router-link :to="{ name: 'MemberModifyPage', params: { memberNo } }">
            회원 정보 수정
        </router-link>

        <button v-on:click="onDelete">회원 삭제</button>
    </div>
</template>

<script>

import MemberRead from '@/components/member/MemberRead.vue'
import axios from 'axios'

import { mapState, mapActions } from 'vuex'

export default {
    name: 'MemberReadPage',
    components: {
        MemberRead
    },
    props: {
        memberNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['member'])
    },
    methods: {
        ...mapActions(['fetchMember']),

        onDelete() {
            axios.delete(`http://localhost:7777/vuemember/${ this.memberNo }`)
                .then(() => {
                alert('delete completed')
                this.$router.push({ name: 'MemberListPage' })
            })
            .catch(err => {
                alert(err.response.data.message)
            })
        }
    },
    created() {
        this.fetchMember(this.memberNo)
            .catch(err => {
                alert(err.response.data.message + " sent!")
                this.$router.push()
            })              
    }
}

</script>
