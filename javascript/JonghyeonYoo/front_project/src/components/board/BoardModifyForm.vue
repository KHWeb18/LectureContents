<template>
  <div>
    <form @submit.prevent="onSubmit">
       <v-container>
      <v-card elevation="10" outlined width="100%" class="mx-auto" style="margin: 150px auto 0;">
        <v-card-title>
          <span class="mr-2">게시물 작성</span>
        </v-card-title>
        <table>
           <v-card-text>
            <v-row>
              <v-col>
                <v-text-field label="No." dense :value="board.boardNo" disabled />
              </v-col>
            </v-row>
            <v-row>
              <v-col>
                <v-text-field label="Register Time" dense :value="board.regDate" disabled />
              </v-col>
            </v-row>
            <v-row>
              <v-col>
                <v-text-field label="Title" dense  v-model="title"/>
              </v-col>
            </v-row>
            <v-row>
              <v-col>
                <v-text-field label="Writer" dense  :value="board.writer" disabled/>
              </v-col>
            </v-row>
 Content<br />
            <td>
              <textarea cols="200" v-model="content"></textarea>
            </td>
           </v-card-text>
      </table>

      <div class="button">
 <v-btn elevation="2">
          <button type="submit">수정 완료</button>
 </v-btn>

 <v-btn elevation="2">
          <router-link class="cancle" :to="{ name: 'BoardReadPage', 
          params: { boardNo: board.boardNo.toString() }}">
          취소 </router-link>
 </v-btn>
      </div>
      </v-card>
       </v-container>
      
    </form>
  </div>

</template>

<script>

export default {
  name: "BoardModifyForm",
  props: {
    board: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      title: "",
      content: "",
    };
  },
  methods: {
    onSubmit() {
      const { title, content } = this;
      this.$emit("submit", { title, content });
    },
  },
  created() {
    this.title = this.board.title;
    this.content = this.board.content;
  },
};
</script>

<style scoped>
.button .v-btn{margin-left: 15px; padding: 5px; top: 50px;}

.cancle{
    color: black;
}

</style>

