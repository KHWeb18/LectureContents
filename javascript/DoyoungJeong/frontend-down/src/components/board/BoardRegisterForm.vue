<template>
    <form @submit.prevent="onSubmit">
    <!-- @submit.prevent은 무슨 뜻???? -->
        <h3>게시물 작성 폼</h3>
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
            <button type="submit">등록</button>
             <!-- 타입 submit이 위의 form @submit에 가서 onSubmit을 작동시키고 onSubmit 메소드가 실행된다? -->
            <router-link :to="{ name: 'BoardListPage' }">
                리스트 페이지로 돌아가기
            </router-link>
        </div>
    </form>
</template>

<script>

export default {
    name: 'BoardRegisterForm',
    data() {
        return {
            title: '제목을 입력하세요',
            writer: '',
            content: '본문을 입력하세요'
        }
    },
    methods: {
        onSubmit() {
            const { title, writer, content } = this
            //this는 자기 자신, 위에있는 date()의 title, writer, content가 들어간다.
            this.$emit('submit', { title, writer, content })
        }
    }
}
</script>
