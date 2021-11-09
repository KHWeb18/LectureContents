<template>
    <div>
        <h3>Monsters Storage</h3>
        <router-link :to="{ name: 'MonsterUploadPage' }">
            Click to Upload Monsters
        </router-link>
        
        <monster-storage :monsters="monsters"/>
        
    </div>
</template>

<script>
import MonsterStorage from '@/components/monster/MonsterStorage.vue'
import { mapActions, mapState } from 'vuex'

export default {
    name: 'MonsterStoragePage',
    components: {
        'monster-storage': MonsterStorage
    },
    computed: {
        ...mapState(['monsters'])
    },
    methods: {
        ...mapActions(['fetchMonsterStorage'])
    },
    mounted() {
        this.fetchMonsterStorage() //여기 ()써주는거 그만 까먹자!
    }

}
</script>
