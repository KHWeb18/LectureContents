<template>
  <form @submit.prevent="onSubmit">
      <v-layout row justify-center>
          <v-dialog dark v-model="dialog" persistent max-width="500px">
            <template v-slot:activator="{ on }">
              <v-btn
                elevation="1"
                v-on="on"
                style="
                  background-color: #4263eb;
                  border-radius: 6px;
                  font-size: 15px;
                "
                >리뷰 작성하기</v-btn
              >
            </template>
            <v-card outlined width="100%">
              <v-card-title>
                <span class="mr-2">리뷰 작성</span>
              </v-card-title>
              <table>
                <v-card-text>
                  <v-container>
                    <v-row>
                      <v-col>
                        <v-text-field label="Writer" dense v-model="writer">
                        </v-text-field>
                      </v-col>
                    </v-row>
                    Content<br />
                    <td>
                      <textarea cols="200" v-model="content"></textarea>
                    </td>
                      <v-rating
          v-model="rating"
          color="yellow darken-3"
          background-color="grey darken-1"
          empty-icon="$ratingFull"
          half-increments
          hover
          large
        ></v-rating>
                  </v-container>
                </v-card-text>
              </table>

              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn elevation="2">
                  <v-btn @click="submit">등록</v-btn>
                </v-btn>
                <v-btn elevation="2" text @click.native="btn_click($event)">
                  취소
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-layout>
  </form>
</template>

<script>
export default {
  name: "ReviewRegisterForm",
  data() {
    return {
      dialog: false,
      writer: "",
      content: "본문을 작성하세요",
    };
  },
  methods: {
    submit() {
      const { writer, content } = this;
      this.$emit("submit", { writer, content }); 
        this.dialog = false
    },
        btn_click($event) {
      if ($event.target.innerHTML == " 취소 ") {
        this.dialog = false;
      }
    },
  },
};
</script>

<style scoped>
.button .v-btn{margin-left: 15px; padding: 5px; top: 50px;}

.cancle{
    color: black;
}
</style>