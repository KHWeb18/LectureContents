<template>
  <div>
    <form @submit.prevent="onSubmit">
       <v-container>
      <v-card elevation="10" outlined width="100%" class="mx-auto" style="margin: 150px auto 0;">
        <v-card-title>
          <span class="mr-2">리뷰 작성</span>
        </v-card-title>
        <table>
           <v-card-text>
            <v-row>
              <v-col>
                <v-text-field label="No." dense :value="review.reviewNo" disabled />
              </v-col>
            </v-row>
            <v-row>
              <v-col>
                <v-text-field label="Register Time" dense :value="review.regDate" disabled />
              </v-col>
            </v-row>
            <v-row>
              <v-col>
                <v-text-field label="Writer" dense  :value="review.writer" disabled/>
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
          <router-link class="cancle" :to="{ name: 'ReviewReadPage', 
          params: { reviewNo: review.reviewNo.toString() }}">
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
  name: "ReviewModifyForm",
  props: {
    review: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {

      content: "",
    };
  },
  methods: {
    onSubmit() {
      const {  content } = this;
      this.$emit("submit", { content });
    },
  },
  created() {

    this.content = this.review.content;
  },
};
</script>

<style scoped>
.button .v-btn{margin-left: 15px; padding: 5px; top: 50px;}

.cancle{
    color: black;
}

</style>

