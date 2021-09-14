<template>
  <v-card flat>
   
    <v-file-input class="mx-10" v-model="files" @change="select" label="사진 찾기"
      color="secondary" prepend-icon="insert_photo" chips multiple ></v-file-input>

    <v-card class="mx-10" flat>
      <v-img class="ml-10" :src="url" width="80%"/>
    </v-card>

  </v-card>
</template>


<script>

export default {
  data () {
    return {
      files: [],
      url: null
    }
  },
  methods: {
    select () {
      console.log(this.files)

      try {
        this.url = URL.createObjectURL(this.files[0])
      }catch(e) {
        this.url = null
      }

      this.$emit('selectFile', this.files)
    }
  }
}
</script>