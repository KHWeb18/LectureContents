<template>
    <div align="center">
        <p class="memberListTitle" style="margin-top: 60px;">Member List</p>
        <member-list :members="members"/>
    </div>
</template>

<script>
import MemberList from '@/components/memberPage/MemberList'
import { mapActions, mapState } from 'vuex'

export default {
    name: 'MemberListPage',
    data() {
        return {
            testString: 'fire'
        }
    },
    components: {
        MemberList
    },
    computed: {
        ...mapState(['members', 'isLoggedIn'])
    },
    methods: {
        ...mapActions(['fetchMemberList'])
    },
    mounted() {
        this.$store.state.userProfile = this.$cookies.get("currentUser")

        if(this.$store.state.userProfile.id != '') {

            this.$store.state.isLoggedIn = true
            this.$store.state.userIdentity = this.$store.state.userProfile.identity

            this.fetchMemberList()
        }
    }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@1,900&display=swap');

.memberListTitle {
    color: #EAEAEA;
    font-family: 'Roboto', sans-serif;
    font-style: italic;
    font-size: 39px;
}

</style>