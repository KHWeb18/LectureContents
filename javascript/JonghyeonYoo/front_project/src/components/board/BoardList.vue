<template>
  <div align="center">
    <v-container>
      <v-card style="margin: 150px auto 0;">
        <v-card-title>
          게시판
          <v-spacer></v-spacer>
          <v-text-field
            v-model="search"
            append-icon="mdi-magnify"
            label="Search"
            single-line
            hide-details
          >
          </v-text-field>
        </v-card-title>

        <v-data-table
          :headers="headerTitle"
          :items="boards"
          :loading="loading"
          loading-text="현재 등록된 게시물이 없습니다!"
          :items-per-page="10"
          :search="search"
          @click:row="goToRead"
          class="elevation-1"
        >
          <template>
            <tr v-for="board in boards" :key="board.boardNo">
              <td @click="goToRead(item.boardNo)"></td>
              <td align="center">{{ board.boardNo }}</td>
              <td align="left">
                <router-link
                  :to="{
                    name: 'BoardReadPage',
                    params: { boardNo: board.boardNo.toString() },
                  }"
                >
                  {{ board.title }}
                </router-link>
              </td>
              <td align="right">{{ board.writer }}</td>
              <td align="center">{{ board.regDate }}</td>
            </tr>
          </template>

          <v-alert slot="no-results" :value="true" color="error" icon="warning">
            "{{ search }}" 검색 결과가 없습니다.
          </v-alert> </v-data-table
        >

        <div class="button">
        <v-btn elevation="2">
          <router-link class="boardRegister" :to="{ name: 'BoardRegisterPage' }">
            게시글 작성
          </router-link></v-btn
        >
        </div>
      </v-card>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "BoardList",
  data() {
    return {
      search: "",
      loading: false,
      headerTitle: [
        { text: "번호", value: "boardNo", width: "30px" },
        { text: "제목", value: "title", width: "200px" },
        { text: "작성자", value: "writer", width: "100px" },
        { text: "내용", value: "content", width: "200px" },
      ],
    };
  },
  methods: {
    goToRead(item) {
      this.$router.push(`/Board/${item.boardNo}`);
    },
  },
  props: {
    boards: {
      type: Array,
    },
  },
};
</script>

<style scoped>

.button .v-btn {
 padding: 10px; top: 50px;
}

.boardRegister{
    color: black;
    font-size: 1.1rem;
}

</style>

