<template>
    <form @submit.prevent="onSubmit">
        <h3>게시물 작성 형태</h3>
        <table>
            <tr>
                <td>제목</td>
                <td><input type="text" v-model="title"></td>
            </tr>
            <tr>
                <td>작성자</td>
                <td><input type="text" v-model="writer"></td>
            </tr>
            <tr>
                <td>본문</td>
                <td><textarea cols="50" rows="20" v-model="content"></textarea></td>
            </tr>
        </table>

        <div>
            <button type="submit" >등록</button>
            <router-link :to="{ name: 'BoardListPage' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'BoardRegisterForm',
    data () {
        return {
            title: '제목을 작성하세요.',
            writer: '',
            content: '본문을 작성하면 됩니다.'
        }
    },
    methods: {
        onSubmit () {
            // this는 자기 자신, 자기사진은 위의 return되는 부분(data)인 title, writer, content이다.
            // 따라서 title만 받고 싶다면 this.title로 작성하면 된다.
            const { title, writer, content } = this
            this.$emit('submit', { title, writer, content })
        }
    }
}
</script> 