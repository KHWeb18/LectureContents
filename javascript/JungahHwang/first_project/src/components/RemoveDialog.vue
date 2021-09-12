<template>
  <v-dialog v-model="dialog" max-width="350">
    <template v-slot:activator="{ on }">
      <v-list-item v-on="on">
        삭제
      </v-list-item>
    </template>
    <v-card class="primary rounded-xl pa-4">
      <v-card-title class="secondary--text font-weight-bold">
        <p>정말 삭제하시겠습니까?</p>
      </v-card-title>
      <v-card-text></v-card-text>
      <v-card-actions>
        <v-btn @click="btnCancle" class="secondary--text font-weight-bold" text >
          Cancle
        </v-btn>
        <v-spacer></v-spacer>
        <v-btn @click="btnRemove" class="secondary--text font-weight-bold" text>
          Delete
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>


<script>
export default {
  data () {
    return {
      dialog: false,
    }
  },
  methods: {
    btnCancle () {
      this.dialog = false
    },
    btnRemove () {
      this.$emit('remove')
    }
    
  }
}
</script>