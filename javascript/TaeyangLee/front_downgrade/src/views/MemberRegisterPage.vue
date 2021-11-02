<!-- <template>
    <div align="center">
        <h2>회원</h2>
        <member-register-form @submit="onMemberSubmit"/>
    </div>
</template>


<script>
import MemberRegisterForm from '@/components/member/MemberRegisterForm'
import axios from 'axios'


export default {
    name: 'MemberRegisterPage',
    components: {
        MemberRegisterForm
    },
    methods: {
        onMemberSubmit (payload) {
            const { id, pw } = payload
            axios.post('http://localhost:7777/VueMember/register',{ id, pw })
            .then(res => {
                alert('등록 성공!' + res)
               /* this.$router.push({
                    name: 'BoardReadPage',
                    params: {boardNo: res.data.boardNo.toString() }
                })
                */
            })
            .catch(res => {
                alert(res.response.data.message)
            })
        }
    }

}
</script> -->