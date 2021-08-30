<template>
  <v-card flat>
    <v-card>
      <v-toolbar flat>
        <v-toolbar-title>
          {{ recommend.title }}
        </v-toolbar-title>
        <v-spacer></v-spacer>
        <v-menu offset-y>
          <template v-slot:activator="{ on, attrs }">
            <v-btn v-bind="attrs" v-on="on" icon>
              <v-icon>mdi-dots-vertical</v-icon>
            </v-btn>
          </template>
          <v-list>
            <v-list-item>
              <v-btn @click="modifyRecommend(recommend.no)" text>수정</v-btn>
            </v-list-item>
            <v-list-item>
              <v-btn @click="removeRecommend" text>삭제</v-btn>
            </v-list-item>
          </v-list>
        </v-menu>
      </v-toolbar>

      <v-divider></v-divider>
      <v-card-text>
        {{ recommend.content }}
      </v-card-text>
      <v-card-text class="caption">
        작성자 {{ recommend.id }} / 
        {{ recommend.regDate }}
      </v-card-text>
    </v-card>
    <v-btn class="float-right ma-3">목록</v-btn>
  </v-card>
</template>


<script>
import { mapState } from 'vuex'

export default {
  computed: {
    ...mapState([ 'recommend' ])
  },
  methods: {
    modifyRecommend(boardNo) {
      this.$router.push(
        { name: 'ModifyRecommend', params: {boardNo: boardNo} }
      )
    },
    removeRecommend () {

    }
  }
}
</script>