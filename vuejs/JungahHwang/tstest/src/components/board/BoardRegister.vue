<template>
  <form @submit.prevent="onSubmit">
    <table border="1">
      <tr>
        <td>제목</td>   
        <td><input type="text" v-model="title"/></td> 
      </tr>
      <tr>
        <td>작성자</td>
        <td><input type="text" v-model="writer"/></td>       
      </tr>
      <tr>
        <td>내용</td>
        <td><textarea v-model="content" rows="12"/></td>
      </tr>
    </table>

    <div>
      <button type="submit">등록</button>
      <router-link :to="{ name: 'BoardListPage' }">취소</router-link>
    </div>
  </form>
</template>


<script lang="ts">
  import { Component, Emit, Vue } from 'vue-property-decorator'

  @Component
  export default class BoardRegister extends Vue {
    /* eslint-disable @typescript-eslint/no-inferrable-types */
    title: string = ''
    writer: string = ''
    content: string = ''

    @Emit('submit')
    onSubmit () {
      const { title, writer, content } = this
      return { title, writer, content }
    }
  }
</script> 