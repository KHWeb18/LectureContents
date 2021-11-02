<template>
    <div>
        <h3>Monster Upload</h3>

        <router-link :to="{ name: 'MonsterStoragePage' }">
            Back to MonsterStoragePage
        </router-link>

        <monster-upload-form v-on:submit="onSubmit"/>

    </div>
</template>

<script>

import MonsterUploadForm from '@/components/monster/MonsterUploadForm.vue'
import axios from 'axios'

export default {
    name: 'MonsterUploadPage',
    components: {
        'monster-upload-form': MonsterUploadForm
    },
    methods: {
        onSubmit(payload) {
            const { name, level, strength, hp, attribute, exp } = payload
            //그냥 payload를 const로 변환 안하고 그냥 보내면 안되나??
            axios.post('http://localhost:7777/vuemonster/upload', { name, level, strength, hp, attribute, exp })
            //계속 까먹지만 여기서 보내는 {} 속의 애들은 서버의 entity와 이름이 같아야함.
            //그래야 받아서 JSON으로 받아서 레퍼지토리를 통해 db로 집어넣는다.
            .then(res => {
                alert('upload completed! ' + JSON.stringify(res))
                this.$router.push({
                    name: 'MonsterStoragePage'
                })
            })
            .catch(res => {
                alert(res.response.data.message)
            })
        }
    }
}
</script>
