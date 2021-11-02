<template>
    <div id="board">
        <member-list-form :members="members"/>
    </div>
</template>

<script>
import MemberListForm from '@/components/member/MemberListForm.vue'
import { mapState, mapActions } from 'vuex'
export default {
    name: 'MemberListPage',
    components: {
        MemberListForm
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