<template>
  <div align="center">

      <v-card dark>
        <v-card-title >
          리뷰
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
          :items="reviews"
          :loading="loading"
          loading-text="현재 등록된 게시물이 없습니다!"
          :items-per-page="10"
          :search="search"
          @click:row="goToRead"
          class="elevation-1"
        >
          <template >
            <tr v-for="review in reviews" :key="review.reviewNo">
              <td @click="goToRead(item.reviewNo)"></td>
              <td align="center">{{ review.reviewNo }}</td>
              <td align="left">
                <router-link
                  :to="{
                    name: 'ReviewReadPage',
                    params: { reviewNo: review.reviewNo.toString() },
                  }"
                >
{{ review.writer }}
                </router-link>
              </td>
              <td align="center">{{ review.regDate }}</td>
            </tr>
          </template>

          <v-alert slot="no-results" :value="true" color="error" icon="warning">
            "{{ search }}" 검색 결과가 없습니다.
          </v-alert> </v-data-table
        >

      </v-card>
        
  </div>
</template>

<script>
export default {
  name: "ReviewList",
  data() {
    return {
      search: "",
      loading: false,
      headerTitle: [
        { text: "번호", value: "reviewNo", width: "10px" },
        { text: "작성자", value: "writer", width: "30px" },
        { text: "내용", value: "content", width: "500px" },
      ],
    };
  },
  methods: {
    goToRead(item) {
      this.$router.push(`/Review/${item.reviewNo}`);
    },
  },
  props: {
    reviews: {
      type: Array,
    },
  },
};
</script>

<style scoped>

.reviewRegister{
    color: black;
    font-size: 1.1rem;
}

</style>

