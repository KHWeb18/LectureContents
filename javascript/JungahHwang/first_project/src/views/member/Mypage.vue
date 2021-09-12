<template>
  <v-card class="primary mt-8">
   
    <v-row>
      <v-col cols="12" md="6">
        <read-info></read-info>
      </v-col>
      <v-col cols="12" md="6">
        <recent-activity></recent-activity>

      </v-col>
    </v-row>
      
    
  </v-card>

</template>


<script>
import ReadInfo from '@/components/member/ReadInfo'
import RecentActivity from '@/components/member/RecentActivity'

export default {
  components: {
    ReadInfo,
    RecentActivity
  }
}
</script>