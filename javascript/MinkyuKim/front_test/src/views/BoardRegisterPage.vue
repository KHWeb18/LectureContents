<template>
    <div align="center">
        <h2>게시물 작성</h2>
        <!-- vue에서는 같은 형식(구성물)이라면 해당 코드만 붙여넣고, 디자인만 신경쓰면 된다 -->
        <!-- 명명법에 의하여 각 스펠링마다 -가 적용된다. board-register-form과 자바스크립트의 BoardRegisterForm은 같다 -->
        <board-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import BoardRegisterForm from '@/components/board/BoardRegisterForm.vue'
// emit보다는 axios가 더 효율적이지만, emit이 필요하면 경우가 있으므로 숙지해야한다.
import axios from 'axios'

export default {
    name: 'BoardRegisterPage',
    components: {
        BoardRegisterForm
    },
    methods: {
        onSubmit (payload) {
            // payload를 레지스터폼에서 emit으로 받았음.
            const { title, content, writer } = payload
            axios.post('http://localhost:7777/vueboard/register', { title, writer, content })
                    // 등록성공 후 BoardListPage로(name값으로) 넘어가게한다. (redirectfh BoardListPage로 보내버림)
                    .then(res => {
                        alert('등록 성공! - ' + res)                        
                        this.$router.push({
                            name: 'BoardListPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                        
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script> 