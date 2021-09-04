<template>
  <div>
    <v-container>
      <v-card elevation="10" outlined width="100%" class="mx-auto" style="margin: 150px auto 0;">
          
        <v-card-title>
          <span class="mr-2">상세 페이지</span>
        </v-card-title>
        <table>
          <v-card-text>
            <v-row>
              <v-col>
                <v-text-field label="No." readonly :value="board.boardNo" />
              </v-col>
            </v-row>
            <v-row>
              <v-col>
                <v-text-field
                  label="Title"
                  readonly
                  dense
                  :value="board.title"
                />
              </v-col>
            </v-row>
            <v-row>
              <v-col>
                <v-text-field
                  label="Writer"
                  readonly
                  dense
                  :value="board.writer"
                />
              </v-col>
              <v-col>
                <v-text-field
                  label="Register Time"
                  readonly
                  dense
                  :value="board.regDate"
                />
              </v-col>
              <v-col>
                <v-text-field label="View" readonly dense  />
              </v-col>
            </v-row>

            Content<br />
            <td>
              <textarea cols="200" :value="board.content" readonly>
</textarea
              >
            </td>
          </v-card-text>
        </table>
         
      </v-card>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "BoardRead",
  props: {
    board: {
      type: Object,
      required: true,
    },
  },
};
</script>