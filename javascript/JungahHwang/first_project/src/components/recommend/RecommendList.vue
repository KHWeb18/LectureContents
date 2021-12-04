<template>
  <v-card class="mb-10" color="primary">
    <v-data-iterator :items="recommends" :items-per-page="itemsPerPage"
      :page.sync="page" :search="search"  hide-default-footer 
      :sort-by="['boardNo']" :sort-desc="[true]">

      <template v-slot:header>
        <v-toolbar class="my-3 pt-3" color="primary" flat>
          <v-text-field v-model="search" label="Search" append-icon="mdi-magnify" 
            solo hide-details></v-text-field>
          <v-btn @click="addButton" class="float-right ml-2" color="secondary" icon>
            <v-icon>add</v-icon>
          </v-btn>
        </v-toolbar>
      </template>

      <template v-slot:default="props">
        <v-card class="pa-3" color="primary" flat>
          <v-row>
            <v-col v-for="item in props.items" :key="item.boardNo"
              cols="12" sm="6" md="4" lg="3">
              <v-hover v-slot="{hover}" close-delay="50">
                <v-card :elevation="hover ? 16:2" class="{ 'on-hover': hover }" 
                  @click="readRecommend(item.boardNo, item.id)" height="250px">
                  <v-toolbar flat>
                    <v-toolbar-title>
                      {{ item.title }}
                    </v-toolbar-title>
                  </v-toolbar>
                  <v-divider></v-divider>
                  <v-card-text>
                    {{ item.content.substr(0, 90) }}...
                  </v-card-text>
                  <v-card-text class="card-text-id caption">
                    {{ item.id }}
                  </v-card-text>
                  <v-card-text class="card-text-date caption">
                    {{new Date(item.regDate).toLocaleString("ko-KR", {tmeZone: "Asia/Seoul"}).toString().substr(0, 11)}}
                  </v-card-text>
                </v-card>
              </v-hover>
            </v-col>
          </v-row>
        </v-card>
      </template>

      <template v-slot:footer>
        <v-row class="mt-2 pa-3" align="center" justify="center">
          <v-spacer></v-spacer>

          <v-btn @click="formerPage" icon color="secondary">
            <v-icon>mdi-chevron-left</v-icon>
          </v-btn>
          <span class="secondary--text">
             {{ page }} / {{ numberOfPages }}
          </span>
          <v-btn @click="nextPage" icon color="secondary">
            <v-icon>mdi-chevron-right</v-icon>
          </v-btn>
        </v-row>
      </template>
      
    </v-data-iterator>
  </v-card>
</template>


<script>
import { mapState, mapActions } from 'vuex'

export default {
  data () {
    return {
      search: '',
      //sortDesc: false,
      page: 1,
      itemsPerPage: 12,
      //sortBy: 'title'
    }
  },
  mounted () {
    this.fetchRecommends()
    console.log(new Date())
  },
  computed: {
    ...mapState([ 'recommends', 'recommend' ]),
    numberOfPages () {
      return Math.ceil(this.recommends.length / this.itemsPerPage)
    },
    // date () {
    //   return 
    // }
  },
  methods: {
    ...mapActions([ 'fetchRecommends', 'fetchRecommend' ]),
    nextPage () {
      if (this.page + 1 <= this.numberOfPages) this.page += 1
    },
    formerPage () {
      if (this.page - 1 >= 1) this.page -= 1
    },
    readRecommend (boardNo, id) {

      this.$router.push(
        { name: 'ReadRecommend', query: { boardNo: boardNo, id: id } }
      )
    },
    addButton () {
      // recommend로 보냄
      this.$emit('addButton')
    }
  },
}
</script>


<style scoped>
.card-text-date {
  position: absolute;
  bottom: 0;
  text-align: right;
}
.card-text-id {
  position: absolute;
  bottom: 0;
}
</style>