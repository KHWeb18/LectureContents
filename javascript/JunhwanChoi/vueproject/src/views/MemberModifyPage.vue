<template>
    <div align="center">
        <h2>비밀번호 수정</h2>
        <member-modify-form v-if="member" :member="member" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
    </div>
</template>

<script>
import MemberModifyForm from '@/components/member/MemberModifyForm.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'
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
    methods: {
        ...mapActions(['fetchMember']),
        onSubmit (payload) {
            const { password } = payload
            axios.put(`http://localhost:3647/project/${this.memberNo}`, { password })
                    .then(res => {
                        alert('수정 성공!')
                        this.$router.push({
                            name: 'MemberReadPage',
                            params: { memberNo: res.data.memberNo.toString() }
                        })
                    })
                    .catch(err => {
                        alert(err.response.data.message)
                    })
        }
    },
    created () {
        this.fetchMember(this.memberNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.back()
                })
    }
}
</script>