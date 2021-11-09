<template>
    <div id="member">
        <h2>회원 가입</h2>
        <router-link :to="{ name: 'MemberRegisterPage' }">
            가입 양식 작성
        </router-link>
        <!-- <board-list/> -->
    </div>
</template>

<script>
// import { mapState, mapActions } from 'vuex'
export default {
    name: 'MemberSignUpPage',
    components: {
    },
    computed: {
    }
}
</script>
