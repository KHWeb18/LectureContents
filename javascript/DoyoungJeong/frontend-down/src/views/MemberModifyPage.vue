<template>
    <div align="center">
        <member-modify-form v-if="member" :member="member" v-on:submit="onSubmit"/>
        <p v-else>해당 회원의 정보를 불러오는 중입니다..</p>

        <router-link :to="{ name: 'MemberReadPage', params: { memberNo } }">수정 취소</router-link>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import axios from 'axios'
import MemberModifyForm from '../components/member/MemberModifyForm.vue'

export default {
    name: 'MemberModifyPage',
    components: {
        MemberModifyForm
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
    created() {
        this.fetchMember(this.memberNo)
            .catch(err => {
                    alert(err.response.data.message)
                    this.$router.back()
                })
    },
    methods: {
        ...mapActions(['fetchMember']),

        onSubmit(payload) {
            const { id, pw, name, birthDay, address, party, comment } = payload
            axios.put(`http://localhost:7777/vuemember`, { id, pw, name, birthDay, address, party, comment })
                .then(res => {
                    alert('수정 성공! ' + res)

                    this.$router.push({
                        name: 'MemberReadPage',
                        params: this.memberNo
                    })
                })
                .catch(err => {
                    alert(err.response.data.message)
                })

        }
    }
}
</script>
