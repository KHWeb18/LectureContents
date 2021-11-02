<template>
    <div id="member">
        <h2>Vue + Spring 회원가입 구현</h2>
        <router-link :to="{ name: 'MemberRegisterPage' }">
            회원가입
        </router-link>
       <!-- <member-list/> -->
    </div>
</template>

<script>

// import { mapState, mapActions } from 'vuex'

export default {
    name: 'MemberListPage',
    components: {
    },
    computed: {
    }
}

</script>