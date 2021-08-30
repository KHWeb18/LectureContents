<template>
  <v-data-iterator :items="items" :items-per-page="itemsPerPage"
    :page.sync="page" :search="search" :sort-by="sortBy.toLowerCase()"
    :sort-desc="sortDesc" hide-default-footer>

    <template v-slot:default="props">
      <v-row>
        <v-col v-for="item in props.items" :key="item.title"
          cols="12" sm="6" md="4" lg="3">
          <v-hover v-slot="{hover}" close-delay="50">
            <v-card :elevation="hover ? 16:2" class="{ 'on-hover': hover }" 
              @click="readRecommend(item.no)">
              <v-card-title>
                {{ item.title }}
              </v-card-title>
              <v-divider></v-divider>
              <v-card-text>
                {{ item.content }}...
              </v-card-text>
              <v-card-text class="caption">
                {{ item.regDate }} {{ item.id }}
              </v-card-text>
            </v-card>
          </v-hover>
        </v-col>
      </v-row>
    </template>

    <template v-slot:footer>
      <v-row class="mt-2" align="center" justify="center">
        <span class="grey--text">Items per page</span>
        <v-menu offset-y>
          <template v-slot:activator="{ on, attrs }">
            <v-btn dark text color="primary" class="ml-2" v-bind="attrs" v-on="on">
              {{ itemsPerPage }}
              <v-icon>mdi-chevron-down</v-icon>
            </v-btn>
          </template>
          <v-list>
            <v-list-item v-for="(number, index) in itemsPerPageArray" :key="index" @click="updateItemsPerPage(number)">
              <v-list-item-title>{{ number }}</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>

        <v-spacer></v-spacer>

        <span class="mr-4 grey--text">
          Page {{ page }} of {{ numberOfPages }}
        </span>
        <v-btn fab dark color="blue darken-3" class="mr-1" @click="formerPage">
          <v-icon>mdi-chevron-left</v-icon>
        </v-btn>
        <v-btn fab dark color="blue darken-3" class="ml-1" @click="nextPage">
          <v-icon>mdi-chevron-right</v-icon>
        </v-btn>
      </v-row>
    </template>
    
  </v-data-iterator>
</template>


<script>
import { mapState, mapActions } from 'vuex'
export default {
  data () {
    return {
      itemsPerPageArray: [4, 8, 12],
      search: '',
      sortDesc: false,
      page: 1,
      itemsPerPage: 4,
      sortBy: 'title'
    }
  },
  mounted () {
    this.fetchRecommend()
  },
  computed: {
    ...mapState(['items']),
    numberOfPages () {
        return Math.ceil(this.items.length / this.itemsPerPage)
    },
  },
  methods: {
    ...mapActions([ 'fetchRecommend', 'fetchRecommendDetail' ]),
    nextPage () {
      if (this.page + 1 <= this.numberOfPages) this.page += 1
    },
    formerPage () {
      if (this.page - 1 >= 1) this.page -= 1
    },
    updateItemsPerPage (number) {
      this.itemsPerPage = number
    },
    readRecommend (boardNo) {
      this.$router.push(
        { name: 'ReadRecommend', params: { boardNo: boardNo} }
      )
      this.fetchRecommendDetail(boardNo)
    }
  },
}
</script>