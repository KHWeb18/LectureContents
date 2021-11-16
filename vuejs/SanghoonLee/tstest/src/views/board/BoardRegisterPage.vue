<template>
  <div align="center">
    <h2>게시물 등록</h2>
    <board-register-form @submit="onSubmit"/>
  </div>
</template>

<script lang="ts">
  import { Component, Vue } from 'vue-property-decorator'
  import BoardRegisterForm from '@/components/board/BoardRegisterForm.vue'
  import AxiosService from '@/service'
  import { Board } from '@/store'

  @Component({
    components: {
      BoardRegisterForm
    }
  })

  export default class BoardRegisterPage extends Vue {
    onSubmit(payload: Board) {
      const { title, writer, content } = payload

      AxiosService.instance.post('/board/register', { title, content, writer })
        .then ((res) => {
          alert('등록 완료!')

          this.$router.push({
            name: 'BoardReadPage',
            params: { boardNo: res.data }
          })
        })
        .catch ((err) => {
          alert(err.response.data.message)
        })
    }
  }
</script>