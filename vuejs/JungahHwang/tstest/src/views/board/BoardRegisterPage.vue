<template>
  <div align="center">
    <h2>게시물 등록</h2>
    <board-register @submit="onSubmit"/>
  </div>
</template>


<script lang="ts">
  import { Component, Vue } from 'vue-property-decorator'
  import BoardRegister from '@/components/board/BoardRegister.vue'
  import { Board } from '@/store'
  import AxiosService from '@/service'

  @Component({
    components: {
      BoardRegister
    }
  })

  export default class BoardRegisterPage extends Vue {
    onSubmit(payload: Board) {
      AxiosService.instance.post('/board/register', payload)
      .then(res => {
        alert('게시글이 등록되었습니다.')

        this.$router.push({
          name: 'BoardReadPage',
          params: { boardNo: res.data }
        })
      })
    }
  }
</script>

